package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileHelper {
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
