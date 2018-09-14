package xiaoan.com.util;

import java.io.File;

/**
 * 功能描述: TODO
 * 文件操作工具类
 * @author: 康小安
 * @createDate: 18-9-13 下午3:45
 */
public class FileUtil {
    
    /**
     * 判断文件是否存在
     * @param filePath
     * @author 康小安
     * @createDate: 2018年09月13日 下午3:47
     * @return boolean
     */
    public static boolean isFileExist(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
}
