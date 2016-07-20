package DiscountTypes;

import code.DiscountGood;
import code.Good;
import java.math.BigDecimal;
import java.util.List;

public class DiscountTwoFreeOne extends DiscountBasic {

    public double getDiscountFee(Good good, int num) {
        double discountFee = 0.00;
         List barcodes = DiscountGood.DiscountHelper.getDisCountBarCodesByType(DiscountGood.buy_two_free_one_discount);

        //异常情况或者没有折扣直接返回；
        if(null == barcodes || barcodes.size() <= 0) {
            return discountFee;
        }else if ( barcodes.contains(good.getBarcode()) && (num / 3) > 0 ){
            discountFee += (num / 3 ) * good.getPrice();
        }

        BigDecimal bg =  new BigDecimal(discountFee);
        discountFee = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

        return discountFee;
    }
}
