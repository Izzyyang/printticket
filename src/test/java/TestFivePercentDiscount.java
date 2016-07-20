import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestFivePercentDiscount {
    @Test
    public void should_reTestTwoGetOneFreeDiscountturn_10_dot_45_when_get_carts_fivepercent() throws Exception {
        String testType = "discount_fivepercent";
        Cart c = new Cart(testType);
        assertEquals(10.45, c.countAll() - c.countDiscount(), 0.001);
    }

}
