package www.evaluate.manage.utils;

/**
 * 类描述
 * 
 * @author trc
 * @version 1.0 2018年1月7日 改订
 * @since 1.0
 */
public class StringUtil {
    public static boolean isEmpty(String str){
        if(null == str || str == "" || str.length() == 0)
            return true;
        return false;
    }

}
