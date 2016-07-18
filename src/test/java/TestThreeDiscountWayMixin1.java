import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestThreeDiscountWayMixin1 {
    @Test
    public void should_return_21_65_when_getcarts_three_discount_way() throws Exception {
        String testType = "discount_twofreeone_fivepercent_nodiscount_1";
        Cart c = new Cart(testType);
        assertEquals(25.45, c.countAll() - c.countDiscount(), 0.001);
    }

}
