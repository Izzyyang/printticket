import java.util.HashMap;
import java.util.Map;

public enum Good {
    Coocla("ITEM000001", "可口可乐", "瓶", "食品", "碳酸饮料", 3.00), //买二赠一 + 九五折
    Badminton("ITEM000003", "羽毛球", "个", "器材", "体育", 1.00), //买二赠一
    Apple("ITEM000005", "苹果", "个", "食品", "水果", 5.5),  //九五折
    Rice("ITEM000007", "大米", "斤", "食品", "主食", 4),  //没有任何活动的商品
    Water("ITEM000009", "水", "瓶", "食品", "饮料", 1);  //没有任何活动的商品

    static  Map<String, Good> goodMap = new HashMap<String, Good>();
    static {
        goodMap.put("ITEM000001",Coocla);
        goodMap.put("ITEM000003",Badminton);
        goodMap.put("ITEM000005",Apple);
        goodMap.put("ITEM000007",Rice);
        goodMap.put("ITEM000009",Water);
    };

    private String barcode;
    private String name;
    private String unit;
    private String category;
    private String suCategory;
    private double price;

    Good(String barcode, String name, String unit, String suCategory, String category, double price) {
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.suCategory = suCategory;
        this.category = suCategory;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public String getName() { return name;}
    public String getBarcode() { return barcode;}
    public String getSuCategory() { return suCategory;}
    public String getUnit(){
        return unit;
    }
}
