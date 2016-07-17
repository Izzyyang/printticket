import java.util.List;
import java.util.Map;

/**
 * Created by izzy on 16-7-17.
 */
public class Print {
    public static final String SPLITLINE = "----------------------------------------------\n";
    public static String printGoodInfo(String cartType){
        Cart cart = new Cart(cartType);
        //折扣价格计算；
        double totalFee = 0.0;
        double discountFee = 0.0;
        double totalDiscountFee = 0.0;
        StringBuffer sb = new StringBuffer();
        sb.append("      ********<没钱赚商店>购物清单********\n");
        for(Map.Entry<Good, Integer> goodNum:cart.getGoods().entrySet()){
            totalFee = goodNum.getKey().getPrice() * goodNum.getValue();
            // TODO 折扣获取；
            //discountFee =
            sb.append("名称："+goodNum.getKey().getName())
            .append("，数量："+goodNum.getValue())
            .append("，单价："+goodNum.getKey().getPrice()+"（元）")
            .append("，小计："+(totalFee - discountFee)+"（元）");
            //有折扣商品打印折扣信息；
            if(discountFee > 0) {
                sb.append("，节省"+discountFee+"(元)");
                totalDiscountFee += discountFee;
            }
            sb.append("\n");
        }
        //买二赠一商品信息打印；
        sb.append(getBuyOneSendOneStr(cart));
        //总计打印；
        sb.append(SPLITLINE);
        sb.append("总计："+cart.account()+"（元）\n");
        if(totalDiscountFee > 0) {
           sb.append("节省："+totalDiscountFee+"（元）");
        }
        sb.append("****************************************************\n\n");
        return sb.toString();
    }

    public static String getBuyOneSendOneStr(Cart cart) {
        if (null == cart)
            return  "";
        StringBuffer sb = new StringBuffer();
        sb.append(SPLITLINE).append("买二赠一商品：\n");
        List buyTwoSendOneGoods = DiscountGood.getDiscountGoods(DiscountGood.buy_one_send_one);
        if (null == buyTwoSendOneGoods || buyTwoSendOneGoods.size() <= 0)
            return "";
        int goodCount = 0;
        for (Map.Entry<Good, Integer> goodNum:cart.getGoods().entrySet()) {
            if (null != buyTwoSendOneGoods && buyTwoSendOneGoods.contains(goodNum.getKey().getBarcode())) {
                sb.append("名称："+goodNum.getKey().getName()).
                append("，数量："+(goodNum.getValue()/3)+goodNum.getKey().getSuCategory());
                ++goodCount;
            }
        }
        if (goodCount <= 0) {
            return "";
        }
        sb.append(SPLITLINE);
        return sb.toString();
    }
}
