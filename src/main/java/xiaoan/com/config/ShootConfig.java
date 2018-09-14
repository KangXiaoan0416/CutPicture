package xiaoan.com.config;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xiaoan.com.tool.PhantomTools;
import xiaoan.com.util.PropertyUtil;

import java.util.Properties;

/**
 * 功能描述: TODO
 * 网页截图配置类
 * @author: 康小安
 * @createDate: 18-9-13 下午2:08
 */
@Data
public class ShootConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShootConfig.class);

    private static Properties shootProp;
    private static final String PROP_PATH = "config.properties";

    private String savePath;
    private String binPath;
    private String jsFile;
    private int left;
    private int top;
    private int width;
    private int height;

    public static ShootConfig me() {
        return new ShootConfig();
    }

    public ShootConfig() {
        if(shootProp == null) {
            shootProp = PropertyUtil.getPropertyResults(PROP_PATH);
        }
        this.savePath = shootProp.getProperty("savePath");
        this.binPath = shootProp.getProperty("binPath");
        this.jsFile = shootProp.getProperty("jsFile");
        if(this.savePath == null || this.binPath == null) {
            LOGGER.error("必须配置文件保存路径和 脚本运行路径");
        }

        this.left = shootProp.getProperty("left") == null?0:Integer.parseInt(shootProp.getProperty("left"));
        this.top = shootProp.getProperty("top")==null?0:Integer.parseInt(shootProp.getProperty("top"));
        this.width = shootProp.getProperty("width")==null?0:Integer.parseInt(shootProp.getProperty("width"));
        this.height = shootProp.getProperty("height")==null?0:Integer.parseInt(shootProp.getProperty("height"));
    }
    
    /**
     * 根据key获取对应的属性值
     * @param key
     * @author 康小安
     * @createDate: 2018年09月13日 下午3:01
     * @return java.lang.String
     */
    public String getConfigValue(String key) {
        return shootProp.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(ShootConfig.me().getConfigValue("bottom"));
    }
}































