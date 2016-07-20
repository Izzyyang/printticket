package code;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import util.ReadFileHelper;
import java.util.HashMap;
import java.util.Map;

public class Good {


    static  Map<String, Good> goodMap = new HashMap<String, Good>();
    static  String goodAddress = "src/main/resources/good_info.json";
    static {
        String jsonStr = ReadFileHelper.getJsonString(goodAddress);
        Map<String, JSONObject> goodMapTemp = JSON.parseObject(jsonStr,HashMap.class);
        for (Map.Entry<String, JSONObject> goodEntry:goodMapTemp.entrySet()) {
            goodMap.put(goodEntry.getKey(), JSON.parseObject(goodEntry.getValue().toString(), Good.class));
        }

    };

    private String barcode;
    private String name;
    private String unit;
    private String category;
    private String suCategory;
    private double price;

    public Good() {
    }

    public Good(String barcode, String name, String unit, String category, String suCategory, double price) {
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.category = category;
        this.suCategory = suCategory;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSuCategory() {
        return suCategory;
    }

    public void setSuCategory(String suCategory) {
        this.suCategory = suCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static Map<String, Good> getGoodMap() {
        return goodMap;
    }

    public static void setGoodMap(Map<String, Good> goodMap) {
        Good.goodMap = goodMap;
    }

    public String toString(){
        return name;
    }
}
