import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Print {

    public static final String SPLITLINE = "----------------------\n";
    public static final String SPLITSTART = "**********************\n\n";
    public static  final DecimalFormat df = new DecimalFormat("#.00");

    public static String printGoodInfo(String cartType){
        Cart cart = new Cart(cartType);
        //折扣价格计算；
        double totalFee = 0.00;
        StringBuffer sb = new StringBuffer();
        sb.append("***<没钱赚商店>购物清单***\n");
        for(Map.Entry<Good, Integer> item:cart.getGoods().entrySet()){
            double discountFee = 0.00;
            totalFee = item.getKey().getPrice() * item.getValue();
            discountFee = cart.countGoodDiscount(item.getKey(), item.getValue());
            sb.append("名称："+item.getKey().getName())
            .append("，数量："+item.getValue()+item.getKey().getUnit())
            .append("，单价："+df.format(item.getKey().getPrice())+"（元）")
            .append("，小计："+df.format((totalFee - discountFee))+"（元）");
            //有折扣商品打印折扣信息；
            if(discountFee > 0) {
                sb.append("，节省"+df.format(discountFee)+"(元)");
            }
            sb.append("\n");
        }
        sb.append(SPLITLINE);
        //买二赠一商品信息打印；
        sb.append(getBuyTwoFreeOneStr(cart));
        //总计打印；
        sb.append("总计："+ df.format(cart.countAll() - cart.countDiscount()) +"（元）\n");
        if(cart.countDiscount() > 0) {
           sb.append("节省："+ df.format(cart.countDiscount()) +"（元）\n");
        }
        sb.append(SPLITSTART);
        return sb.toString();
    }

    public static String getBuyTwoFreeOneStr(Cart cart) {
        if (null == cart)
            return  "";
        StringBuffer sb = new StringBuffer();
        sb.append("买二赠一商品：\n");
        List buyTwoSendOneGoods = DiscountGood.getDiscountGoods(DiscountGood.buy_two_free_one_discount);
        if (null == buyTwoSendOneGoods || buyTwoSendOneGoods.size() <= 0)
            return "";
        int goodCount = 0;
        for (Map.Entry<Good, Integer> item:cart.getGoods().entrySet()) {
            if (null != buyTwoSendOneGoods && buyTwoSendOneGoods.contains(item.getKey().getBarcode()) && (item.getValue()/3) >= 1) {
                sb.append("名称："+item.getKey().getName()).
                append("，数量："+(item.getValue()/3)+item.getKey().getUnit() + "\n");
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
