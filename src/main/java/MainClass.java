/**
 * Created by izzy on 16-7-17.
 */
public class MainClass {
    public static void main(String[] args){
        //1.0单个商品结算：没有折扣
        String cartType = "nodiscount_single";
        System.out.println(Print.printGoodInfo(cartType));

        //2.0多个商品结算：没有折扣+多个同样商品
        cartType = "nodiscount_same";
        System.out.println(Print.printGoodInfo(cartType));
    }

}
