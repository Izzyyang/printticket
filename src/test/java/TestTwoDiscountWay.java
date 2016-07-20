import code.Cart;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestTwoDiscountWay {
    @Test
    public void should_return_2_0_when_getcarts_two_discount_way() throws Exception {
        String testType = "discount_twofreeone_fivepercent";
        Cart c = new Cart(testType);
        assertEquals(6.0, c.countAll() - c.countDiscount(), 0.001);
    }

}
