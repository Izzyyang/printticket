import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTwoGetOneFreeDiscount {
    @Test
    public void should_return_2_0_when_getcarts_two_getonefree() throws Exception {
        String testType = "discount_twofreeone";
        Cart c = new Cart(testType);
        System.out.println("all: " + c.countAll() + "discount" + c.countDiscount());
        assertEquals(3.0, c.countAll() - c.countDiscount(), 0.001);
    }

}