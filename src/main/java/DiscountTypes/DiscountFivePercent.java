package DiscountTypes;

import code.DiscountGood;
import code.Good;
import java.math.BigDecimal;
import java.util.List;

public class DiscountFivePercent extends DiscountBasic {
    public double getDiscountFee(Good good, int num) {
        double discountFee = 0.00;
        List barcodes = DiscountGood.getDiscountGoods(DiscountGood.five_percent_discount);
        //如果没有直接返回
        if(null == barcodes || barcodes.size() <= 0) {
            return discountFee;
        }

        if (barcodes.contains(good.getBarcode())){
            discountFee += 0.05 * num * good.getPrice();
        }

        BigDecimal bg =  new BigDecimal(discountFee);
        discountFee = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        return discountFee;
    }
}
