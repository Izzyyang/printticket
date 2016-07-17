/**
 * Created by izzy on 16-7-17.
 */
public class MainClass {
    public static void main(String[] args){
        //1-1 单个商品结算：没有折扣
        String cartType = "nodiscount_single";
        System.out.println(Print.printGoodInfo(cartType));

        //2-1 多个商品结算：没有折扣+多个同样商品
        cartType = "nodiscount_same";
        System.out.println(Print.printGoodInfo(cartType));

        //2-2 多个商品结算：没有折扣+多个不同商品
        cartType = "nodiscount_multiple";
        System.out.println(Print.printGoodInfo(cartType));

        //3-1 单个商品结算: 只满足买二赠一
        cartType = "discount_twofreeone";
        System.out.println(Print.printGoodInfo(cartType));

        //4-1  单个商品结算: 只满足95折
        cartType = "discount_fivepercent";
        System.out.println(Print.printGoodInfo(cartType));

        //5-1  多个商品: 同时满足满2减1
        cartType = "discount_twofreeone_fivepercent";
        System.out.println(Print.printGoodInfo(cartType));
    }

}
