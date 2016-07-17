import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestSingleGoodAccount {
    @Test
    public void should_return_4_0_when_getcarts_nodiscount_singletotalmoney() throws Exception {
        String type = "nodiscount_single";
        assertEquals(4.0, new Cart(type).countAll(), 0.001);
    }

}
