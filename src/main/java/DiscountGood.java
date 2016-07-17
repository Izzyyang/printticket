import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountGood {
    public static  String discountGoodFilePath = "src/main/resources/discount_info.json";

    public static List getDiscountGoods(String type){
        return GetDiscountGood.getDisCountBarCodesByType(type);
    }

    //使用静态内部类实现单例；
    static class GetDiscountGood{
        /**
         * 根据打折类型返回打折商品barcodes
         * eg:discountType = “FIVE_PERCENT_DISCOUNT”return:"barcodes": ["ITEM000001"]
         * @param discountType
         * @return
         */
       public static List getDisCountBarCodesByType(String discountType){
           if( null == discountType || "".equals(discountType))
               return null;

           String discontStr = getDiscountGood(discountGoodFilePath);
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

        /**
         * 从文件中读取打折商品信息，返回打折信息json字符串；
         * @param filePath
         * @return
         */
       public static String getDiscountGood(String filePath){
           if (null == filePath || "".equals(filePath))
               return null;

           StringBuffer sbuffer = new StringBuffer();
           File file = new File(filePath);
           BufferedReader reader = null;
           try {
               if (!file.exists()) {
                   return null;
               }
               reader = new BufferedReader(new FileReader(file));
               String readLine = "";
               while((readLine =reader.readLine()) != null){
                   sbuffer.append(readLine.trim());
               }
           } catch(Exception e){
               e.printStackTrace();
           } finally {
               if(null != reader){
                   try {
                       reader.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           }
           return  sbuffer.toString();
       }

    }
}
