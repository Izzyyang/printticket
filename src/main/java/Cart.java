import com.alibaba.fastjson.JSON;
import util.ReadFileHelper;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private  Map<Good, Integer> goods = new HashMap<Good, Integer>();

    private  static Map<String, String> cartTypeAddress = new HashMap<String, String>();
    static {
        cartTypeAddress.put("nodiscount_same","src/main/resources/cart_buy_nodiscount_same_goods.json");
        cartTypeAddress.put("nodiscount_multiple","src/main/resources/cart_buy_nodiscount_multiple_goods.json");
        cartTypeAddress.put("nodiscount_single","src/main/resources/cart_single_nodisocunt_good.json");
        cartTypeAddress.put("discount_twofreeone","src/main/resources/cart_buy_two_getonefree_goods.json");
        cartTypeAddress.put("discount_fivepercent","src/main/resources/cart_five_percent_discount_goods.json");
        cartTypeAddress.put("discount_twofreeone_fivepercent","src/main/resources/cart_get_two_dicountway_goods.json");
        cartTypeAddress.put("discount_twofreeone_fivepercent_nodiscount_1","src/main/resources/cart_get_three_discountway_goods_mixin_1.json");
        cartTypeAddress.put("discount_twofreeone_fivepercent_nodiscount_2","src/main/resources/cart_get_three_discountway_goods_mixin_2.json");
        cartTypeAddress.put("discount_two_twofreeone_fivepercent","src/main/resources/discount_two_twofreeone_fivepercent.json");
    }

    //单例模式使用：使用静态内部类初始化购物车；初始化只需一次；
    public Cart(String type){
        this.goods = CartHelper.getGoodByFile(type);
    }
    /**
     * 计算购物车内商品原始总价；
     * @return
     */
    public double countAll() {
        double  result = 0.0;
        for (Good good: this.goods.keySet()){
            result += good.getPrice() * this.goods.get(good);
        }
        BigDecimal bg =  new BigDecimal(result);
        result = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }

    /**
     * 单品折扣价计算
     * @param good
     * @param num
     * @return
     */
    public static double countGoodDiscount(Good good, int num){
        double discountFee = 0.0;
        boolean hasDiscounted = false;
        List barcodes = DiscountGood.DiscountHelper.getDisCountBarCodesByType(DiscountGood.buy_two_free_one_discount);

        //异常情况或者没有折扣直接返回；
        if(null == barcodes || barcodes.size() <= 0) {
            return discountFee;
        }

        for (int i =0; i < barcodes.size(); i++) {
            if ( barcodes.get(i).toString().equals(good.getBarcode()) && (num / 3) > 0 ){
                discountFee += (num / 3 ) * good.getPrice();
                hasDiscounted = true;
            }
        }
        if (!hasDiscounted){
            barcodes = DiscountGood.DiscountHelper.getDisCountBarCodesByType(DiscountGood.five_percent_discount);
            for (int i = 0; i < barcodes.size(); i++){
                if (barcodes.get(i).toString().equals(good.getBarcode())){
                    discountFee += 0.05 * num * good.getPrice();
                }
            }

        }
        BigDecimal bg =  new BigDecimal(discountFee);
        discountFee = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return discountFee;
    }

    /**
     * 计算总的折扣价
     * @return
     */
    public double countDiscount() {
        double allDiscountFee = 0.0;
        for (Good good: this.goods.keySet()){
            allDiscountFee += countGoodDiscount(good, this.goods.get(good));
       }

        return allDiscountFee;

    }
    /**
     * 加入购物车
     * @param good
     * @param count
     */
    public void addToCart(Good good, int count) {
        if (this.goods.containsKey(good)) {
            this.goods.put(good, this.goods.get(good) + count);
        }else {
            this.goods.put(good, count);
        }
    }

    public  Map<Good, Integer> getGoods() {
        return goods;
    }

    /***
     * 静态内部类，使用单例模式。帮助解析购物车数据；
     */
    static class CartHelper {
        public static Map<Good, Integer> getGoodByFile(String cartType) {
            Map<Good, Integer> goodNumMap = new HashMap<Good, Integer>();
            List<String> goodNums = null;
            String goodNumStr = null;
            try {
                goodNumStr = ReadFileHelper.getDiscountGood(cartTypeAddress.get(cartType));
                goodNums = JSON.parseArray(goodNumStr, String.class);
                if (null == goodNumStr || "" == goodNumStr || null == goodNums || goodNums.size() <= 0) {
                    return null;
                }
                for (String goodNum : goodNums) {
                    goodNum = goodNum.trim();
                    String barCode = goodNum.split("-")[0];
                    if (!Good.goodMap.containsKey(barCode)) {
                        System.out.println();
                        System.out.println("      ××"+barCode+"此商品不存在，请注意核对barcode，尚未计入结算清单！");
                        continue;
                    }
                    Integer numIncremental = goodNum != null && goodNum.split("-").length > 1 ? Integer.valueOf(goodNum.split("-")[1]) : 1;
                    Integer numOld = null != goodNumMap.get(Good.goodMap.get(barCode)) ? goodNumMap.get(Good.goodMap.get(barCode)) : 0;
                    goodNumMap.put(Good.goodMap.get(barCode), numOld + numIncremental);
                }
            } catch (Exception e) {
                System.out.println("JSON 数据解析失败！");
                e.printStackTrace();
                return null;
            }
            return goodNumMap;
        }
    }
}
