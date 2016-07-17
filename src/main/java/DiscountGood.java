import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import util.ReadFileHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountGood {
    public static  String discountGoodFilePath = "src/main/resources/discount_info.json";

    public static List getDiscountGoods(String type){
        return DiscountHelper.getDisCountBarCodesByType(type);
    }

    //设计模式之单例：使用静态内部类实现单例；
    static class DiscountHelper {
        /**
         * 根据打折类型返回打折商品barcodes
         * eg:discountType = “FIVE_PERCENT_DISCOUNT”return:"barcodes": ["ITEM000001"]
         * @param discountType
         * @return
         */
       public static List getDisCountBarCodesByType(String discountType){
           if( null == discountType || "".equals(discountType))
           return null;

           String discontStr = ReadFileHelper.getDiscountGood(discountGoodFilePath);
           Map<String,List> discountMap = new HashMap<String, List>();
           try {
               JSONArray objs = JSON.parseArray(discontStr);
               for(Object obj:objs){
                   JSONObject object = JSON.parseObject(obj.toString());
                   discountMap.put(object.get("type").toString(),(List) object.get("barcodes"));
               }
           } catch (Exception e) {
               System.out.println("JSON 数据解析失败！");
               e.printStackTrace();
               return null;
           }

           return discountMap.get(discountType);
       }
    }
}
