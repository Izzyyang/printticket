import java.util.Map;

/**
 * Created by izzy on 16-7-17.
 */
public class Print {
    public static String printGoodInfo(String cartType){
        Cart cart = new Cart(cartType);
        //折扣价格计算；
        double totalFee = 0.0;
        double discountFee = 0.0;
        StringBuffer sb = new StringBuffer();
        sb.append("      ********<没钱赚商店>购物清单********\n");
        for(Map.Entry<Good, Integer> goodNum:cart.getGoods().entrySet()){
            totalFee = goodNum.getKey().getPrice() * goodNum.getValue();
            //折扣获取；
            //discountFee =
            sb.append("名称："+goodNum.getKey().getName())
            .append("，数量："+goodNum.getValue())
            .append("，单价："+goodNum.getKey().getPrice()+"（元）")
            .append("，小计："+(totalFee - discountFee)+"，（元）")
            .append("\n");
        }
        sb.append("----------------------------------------------\n");
          return sb.toString();
    }
}
