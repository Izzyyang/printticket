import code.Cart;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestMultipleGoodNoDiscount {
    @Test
    public void should_return_40_when_buy_multiple_same_products() throws Exception {
        String type = "nodiscount_same";
        assertEquals(40.0, new Cart(type).countAll(), 0.001);
    }

    @Test
    public void should_return__when_buy_multiple_same_products() throws Exception {
        String type = "nodiscount_multiple";
        assertEquals(42.0, new Cart(type).countAll(), 0.001);
    }

}
