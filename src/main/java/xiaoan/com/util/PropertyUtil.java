package xiaoan.com.util;


import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Map;
import java.util.Properties;

/**
 * 功能描述: TODO
 * 读取资源文件工具类
 * @author: 康小安
 * @createDate: 18-9-13 下午2:12
 */
public class PropertyUtil {

    private static String basePath;
    static {
        if(StringUtils.isBlank(basePath)) {
            basePath = PropertyUtil.class.getResource("").getFile();
            basePath = basePath.split("classes")[0] + "classes" + File.separator;
        }
    }
    
    /**
     * 读取资源文件
     * @param fileName
     * @author 康小安
     * @createDate: 2018年09月13日 下午2:27
     * @return java.util.Properties
     */
    public static Properties getPropertyResults(String fileName) {
        InputStream in;
        Properties p;
        String path = basePath + File.separator + fileName;
        try {
            in = new BufferedInputStream(new FileInputStream(path));
            p = new Properties();
            p.load(in);
            return p;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}























