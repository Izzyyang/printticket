import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestGetDiscountGoodBarcodes {
    @Test
    public void should_return_discountgoodbarcodes_when_readiscountjsonstrfromfile() throws Exception {
        assertEquals("[\"ITEM000003\",\"ITEM000001\"]",DiscountGood.getDiscountGoods("BUY_ONE_SEND_ONE_DISCOUNT").toString());
    }

    @Test
    public void should_return_null_when_nodiscountgood() throws Exception {
        assertEquals(null,DiscountGood.getDiscountGoods("NO_DISCOUNT"));
    }

    @Test
    public void should_return_cartgoodandnum_when_readcartjsonstrfromfile() throws Exception {
        assertEquals("{Coocla=5, Apple=3, Badminton=2}",new Cart().getGoods().toString());
    }

    @Test
    public void should_return_null_when_cartisnull() throws Exception {
        assertEquals(null,new Cart());
    }
}
