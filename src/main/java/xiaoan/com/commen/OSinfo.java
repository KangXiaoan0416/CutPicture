package xiaoan.com.commen;

/**
 * 功能描述: TODO
 * 操作系统信息类
 * @author: 康小安
 * @createDate: 18-9-13 下午3:51
 */
public class OSinfo {

    private static String OS = System.getProperty("os.name").toLowerCase();

    private static OSinfo _instance = new OSinfo();

    private EPlatForm platform;

    private OSinfo(){

    }

    public static boolean isLinux(){
        return OS.indexOf("linux")>=0;
    }

    public static boolean isMacOS(){
        return OS.indexOf("mac")>=0&&OS.indexOf("os")>0&&OS.indexOf("x")<0;
    }

    public static boolean isMacOSX(){
        return OS.indexOf("mac")>=0&&OS.indexOf("os")>0&&OS.indexOf("x")>0;
    }

    public static boolean isWindows(){
        return OS.indexOf("windows")>=0;
    }

    public static boolean isOS2(){
        return OS.indexOf("os/2")>=0;
    }

    public static boolean isSolaris(){
        return OS.indexOf("solaris")>=0;
    }

    public static boolean isSunOS(){
        return OS.indexOf("sunos")>=0;
    }

    public static boolean isMPEiX(){
        return OS.indexOf("mpe/ix")>=0;
    }

    public static boolean isHPUX(){
        return OS.indexOf("hp-ux")>=0;
    }

    public static boolean isAix(){
        return OS.indexOf("aix")>=0;
    }

    public static boolean isOS390(){
        return OS.indexOf("os/390")>=0;
    }

    public static boolean isFreeBSD(){
        return OS.indexOf("freebsd")>=0;
    }

    public static boolean isIrix(){
        return OS.indexOf("irix")>=0;
    }

    public static boolean isDigitalUnix(){
        return OS.indexOf("digital")>=0&&OS.indexOf("unix")>0;
    }

    public static boolean isNetWare(){
        return OS.indexOf("netware")>=0;
    }

    public static boolean isOSF1(){
        return OS.indexOf("osf1")>=0;
    }

    public static boolean isOpenVMS(){
        return OS.indexOf("openvms")>=0;
    }

    /**
     * 获取操作系统名字
     * @return 操作系统名
     */
    public static EPlatForm getOSname(){
        if(isAix()){
            _instance.platform = EPlatForm.AIX;
        }else if (isDigitalUnix()) {
            _instance.platform = EPlatForm.Digital_Unix;
        }else if (isFreeBSD()) {
            _instance.platform = EPlatForm.FreeBSD;
        }else if (isHPUX()) {
            _instance.platform = EPlatForm.HP_UX;
        }else if (isIrix()) {
            _instance.platform = EPlatForm.Irix;
        }else if (isLinux()) {
            _instance.platform = EPlatForm.Linux;
        }else if (isMacOS()) {
            _instance.platform = EPlatForm.Mac_OS;
        }else if (isMacOSX()) {
            _instance.platform = EPlatForm.Mac_OS_X;
        }else if (isMPEiX()) {
            _instance.platform = EPlatForm.MPEiX;
        }else if (isNetWare()) {
            _instance.platform = EPlatForm.NetWare_411;
        }else if (isOpenVMS()) {
            _instance.platform = EPlatForm.OpenVMS;
        }else if (isOS2()) {
            _instance.platform = EPlatForm.OS2;
        }else if (isOS390()) {
            _instance.platform = EPlatForm.OS390;
        }else if (isOSF1()) {
            _instance.platform = EPlatForm.OSF1;
        }else if (isSolaris()) {
            _instance.platform = EPlatForm.Solaris;
        }else if (isSunOS()) {
            _instance.platform = EPlatForm.SunOS;
        }else if (isWindows()) {
            _instance.platform = EPlatForm.Windows;
        }else{
            _instance.platform = EPlatForm.Others;
        }
        return _instance.platform;
    }


}
