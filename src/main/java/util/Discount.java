package util;

import DiscountTypes.DiscountBasic;
import DiscountTypes.*;
import code.Good;
import java.util.Map;
import java.util.HashMap;


public class Discount {
    private static Map<String, DiscountBasic> allDiscountTypes = new HashMap<String, DiscountBasic>();

    static {
        allDiscountTypes.put("BUY_TWO_FREE_ONE_DISCOUNT", new DiscountTwoFreeOne());
        allDiscountTypes.put("FIVE_PERCENT_DISCOUNT", new DiscountFivePercent());
    }

    public static Map getAllDiscountTypes(){
        return allDiscountTypes;
    }

    public static double getDiscountFea(Good good, int num, String discountType){
        DiscountBasic discount = allDiscountTypes.get(discountType);
        return discount.getDiscountFee(good,num);
    }
    public static void addDiscountType(DiscountBasic newType){
        allDiscountTypes.put(newType.getClass().getName(), newType);
    }
}
