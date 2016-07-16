public enum Good {
    Coocla("ITEM000001", "可口可乐", "瓶", "食品", "碳酸饮料", 3.00),
    Badminton("ITEM000003", "羽毛球", "个", "器材", "体育", 1.00),
    Apple("ITEM000005", "苹果", "个", "食品", "水果", 3.5);

    private String barcode;
    private String name;
    private String unit;
    private String category;
    private String suCategory;
    private double price;

    Good(String barcode, String name, String unit, String category, String suCategory, double price) {
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.category = category;
        this.suCategory = suCategory;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public String getName() { return name;}
}
