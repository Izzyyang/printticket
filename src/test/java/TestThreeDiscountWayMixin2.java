import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestThreeDiscountWayMixin2 {
    @Test
    public void should_returnTestThreeDiscountWayMixin1_21_65_when_getcarts_three_discount_way() throws Exception {
        String testType = "discount_twofreeone_fivepercent_nodiscount_2";
        Cart c = new Cart(testType);
        assertEquals(24.45, c.countAll() - c.countDiscount(), 0.001);
    }

}
