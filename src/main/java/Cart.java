import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Good, Integer> goods = new HashMap<Good, Integer>();

    public double account() {
        double  result = 0.0;
        for (Good good: this.goods.keySet()){
            result += good.getPrice() * this.goods.get(good);
        }
        return result;
    }

    public void addToCart(Good good, int count) {
        this.goods.put(good, count);
    }

    public Map<Good, Integer> getGoods() {
        return goods;
    }
}
