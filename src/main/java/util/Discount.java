package util;

import DiscountTypes.*;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by zhuhaihao on 16-7-20.
 */
public class Discount {
    private static Map<String, DiscountBasic> allDiscountTypes = new HashMap<String, DiscountBasic>();

    static {
        allDiscountTypes.put("discountTwoFreeOne", new DiscountTwoFreeOne());
        allDiscountTypes.put("discountFivePercent", new DiscountFivePercent());
    }

    public static Map getAllDiscountTypes(){
        return allDiscountTypes;
    }

    public static double getDiscountFea(Good good, int num, String discountType){
        DiscountBasic discount = allDiscountTypes.get(discountType);
        return discount.getDiscountFee(Good good, int num);
    }
    public static void addDiscountType(DiscountBasic newType){
        allDiscountTypes.put(newType.getClass().getName(), newType);
    }
}
