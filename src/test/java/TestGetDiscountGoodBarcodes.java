import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by izzy on 16-7-17.
 */
public class TestGetDiscountGoodBarcodes {

    @Test
    public void should_return_discountgoodbarcodes_when_readjsonstrfromfile() throws Exception {
        assertEquals("[\"ITEM000003\",\"ITEM000001\"]",DiscountGood.getDiscountGoods("BUY_ONE_SEND_ONE_DISCOUNT").toString());
    }
    @Test
    public void should_return_null_when_nodiscountgood() throws Exception {
        assertEquals(null,DiscountGood.getDiscountGoods("NO_DISCOUNT"));
    }

}
