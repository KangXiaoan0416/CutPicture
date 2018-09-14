package xiaoan.com.tool;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xiaoan.com.config.ShootConfig;

import java.io.*;

/**
 * 功能描述: TODO
 * 网页截图工具
 * @author: 康小安
 * @createDate: 18-9-13 上午11:32
 */
public class PhantomTools {
    private static final Logger LOGGER = LoggerFactory.getLogger(PhantomTools.class);
    /**截图配置*/
    private ShootConfig shootConfig;
    private final String CHARACTER_POINT;

    public PhantomTools() {
        shootConfig = new ShootConfig();
        CHARACTER_POINT = ".";
    }

    public static PhantomTools me() {
        return new PhantomTools();
    }

    /**
     * 获取调用js命令
     * @param imagePath 图片保存路径
     * @param url 请求地址
     * @author 康小安
     * @createDate: 2018年09月13日 上午11:31
     * @return java.lang.String
     */
    private String getCommend(String imagePath, String url) {
        String commend = shootConfig.getBinPath() + " " + shootConfig.getJsFile() + " " + url + " " + imagePath + " " + shootConfig.getWidth() + "*" + shootConfig.getHeight() + "px";

        LOGGER.info("获取截图命令结束,commend:" + commend);
        return commend;
    }
    /**
     * 
     * @param process 进程
     * @param bufferedReader 字符流
     * @author 康小安
     * @createDate: 2018年09月13日 上午11:31
     * @return void
     */
    private void close(Process process, BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                LOGGER.error("关闭进程异常", e);
            }
        }
        if (process != null) {
            process.destroy();
        }
    }
    
    /**
     * 关闭进程
     * @param process 进程对象
     * @author 康小安
     * @createDate: 2018年09月13日 下午3:19
     * @return java.lang.String
     */
    private String close(Process process) {
        try {
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder sb = new StringBuilder();
            String tmp;
            while ((tmp=reader.readLine()) != null) {
                sb.append(tmp);
            }
            close(process, reader);
            LOGGER.info("关闭进程，返回结果:" + sb.toString());
            return sb.toString();
        }catch(Exception e) {
            LOGGER.error("关闭进程异常", e);
        }
        return "";
    }
    
    /**
     * 根据Url获取网页截图
     * @param url 请求地址
     * @param imageName 图片名称
     * @author 康小安
     * @createDate: 2018年09月13日 下午2:53
     * @return void
     */
    private void printUrlScreen2jpg(String url, String imageName) throws IOException{
        //获取截图保存路径
        String imagePath = getImagePath(shootConfig.getSavePath(), imageName, url);
        //Java中使用Runtime和Process类运行外部程序
        if(StringUtils.isBlank(imagePath)) {
            LOGGER.error("截图保存路径为空，请检查");
        }else {
            long t1 = System.currentTimeMillis();
            Process process = Runtime.getRuntime().exec(getCommend(imagePath, url));
            String result = close(process);
            long t2 = System.currentTimeMillis();
            if(StringUtils.isNotBlank(result)) {
                LOGGER.info("获取网页截图完成,耗时:" + (t2 - t1)/1000 + "s");
            }
        }
    }

    /**
     * 获取图片保存路径
     * @param savePath 文件保存路径
     * @param fileName 文件名称
     * @param url 链接
     * @author 康小安
     * @createDate: 2018年09月13日 下午3:14
     * @return java.lang.String
     */
    private String getImagePath(String savePath, String fileName, String url) {
        StringBuilder sb = new StringBuilder();
        sb.append(savePath);
        if(!savePath.endsWith(File.separator)) {
            sb.append(File.separator);
        }
        if(StringUtils.isBlank(fileName)) {
            fileName = System.currentTimeMillis() + "";
        }
        sb.append(fileName);
        if(!fileName.contains(CHARACTER_POINT)) {
            sb.append(".png");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String url = "http://www.xinmin.cn/";
        PhantomTools.me().printUrlScreen2jpg(url, "");
    }
}
