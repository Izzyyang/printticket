import com.alibaba.fastjson.JSON;
import util.ReadFileHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private static Map<Good, Integer> goods = new HashMap<Good, Integer>();
    public static  String cartGoodaddr = "src/main/resources/goodbarcode_num.json";

    static {
        goods = CartHelper.getGoodByFile();
    }

    public double account() {
        double  result = 0.0;
        for (Good good: this.goods.keySet()){
            result += good.getPrice() * this.goods.get(good);
        }
        return result;
    }

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

    //使用单例模式，每次只需获取一次即可；
    static class CartHelper{
        public static Map<Good, Integer> getGoodByFile(){
            Map<Good, Integer> goodNumMap = new HashMap<Good, Integer>();
            List<String> goodNums = null;
            String goodNumStr = null;
            try {
                goodNumStr = ReadFileHelper.getDiscountGood(cartGoodaddr);
                goodNums   = JSON.parseArray(goodNumStr, String.class);
                if (null == goodNumStr || "" == goodNumStr || null == goodNums || goodNums.size() <= 0) {
                    return null;
                }
                for(String goodNum:goodNums){
                    goodNum = goodNum.trim();
                    String barCode = goodNum.split("-")[0];
                    Integer num = goodNum != null && goodNum.split("-").length > 1 ? Integer.valueOf(goodNum.split("-")[1])  : 1;
                    num = goodNumMap.containsKey(Good.goodMap.get(barCode)) ? goodNumMap.get(Good.goodMap.get(barCode)) + 1 : num ;
                    if ( !Good.goodMap.containsKey(barCode)) {
                        System.out.println("商品不存在！");
                        return null;
                    }
                    goodNumMap.put(Good.goodMap.get(barCode),num);
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
