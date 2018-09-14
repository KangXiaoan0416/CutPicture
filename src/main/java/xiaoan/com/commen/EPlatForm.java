package xiaoan.com.commen;
/**
 * 功能描述: TODO
 * 操作系统枚举类
 * @author: 康小安
 * @createDate: 18-9-13 下午3:48
 */
public enum EPlatForm {
    Any("any"),
    Linux("Linux"),
    Mac_OS("Mac OS"),
    Mac_OS_X("Mac OS X"),
    Windows("Windows"),
    OS2("OS/2"),
    Solaris("Solaris"),
    SunOS("SunOS"),
    MPEiX("MPE/iX"),
    HP_UX("HP-UX"),
    AIX("AIX"),
    OS390("OS/390"),
    FreeBSD("FreeBSD"),
    Irix("Irix"),
    Digital_Unix("Digital Unix"),
    NetWare_411("NetWare"),
    OSF1("OSF1"),
    OpenVMS("OpenVMS"),
    Others("Others");

    private EPlatForm(String desc){
        this.description = desc;
    }

    @Override
    public String toString(){
        return description;
    }

    private String description;
}
