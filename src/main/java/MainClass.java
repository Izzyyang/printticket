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

        //5-1  单个商品: 同时满足满2减1和九五折
        cartType = "discount_twofreeone_fivepercent";
        System.out.println(Print.printGoodInfo(cartType));

        //6-1  多个商品混合测试1: 两种种打折方式和不打折商品同时存在
        cartType = "discount_twofreeone_fivepercent_nodiscount_1";
        System.out.println(Print.printGoodInfo(cartType));

        //6-2  多个商品混合测试2: 两种种打折方式和不打折商品同时存在
        cartType = "discount_twofreeone_fivepercent_nodiscount_2";
        System.out.println(Print.printGoodInfo(cartType));

        //6-3 多个商品混合测试3:两种买二增一商品，一个打折商品；
        cartType = "discount_two_twofreeone_fivepercent";
        System.out.println(Print.printGoodInfo(cartType));

    }

}
