import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestGetDiscountGoodBarcodes {
    @Test
    public void should_return_discountgoodbarcodes_when_readiscountjsonstrfromfile() throws Exception {
        assertEquals("[\"ITEM000001\",\"ITEM000003\"]",DiscountGood.getDiscountGoods("BUY_TWO_FREE_ONE_DISCOUNT").toString());
    }

    @Test
    public void should_return_null_when_nodiscountgood() throws Exception {
        assertEquals(null,DiscountGood.getDiscountGoods("NO_DISCOUNT"));
    }

    @Test
    public void should_return_cartsinglegood_when_readcartjsonstrfromsinglefile() throws Exception {
        String type = "nodiscount_single";
        assertEquals("{Rice=1}",new Cart(type).getGoods().toString());
    }

    @Test
    public void should_return_null_when_cartisnull() throws Exception {
        assertEquals(null,new Cart(null).getGoods());
    }
}
