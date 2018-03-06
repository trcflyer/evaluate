package www.evaluate.manage.utils;

import java.security.MessageDigest;

/**
 * 类描述
 * 
 * @author trc
 * @version 1.0 2018年1月7日 改订
 * @since 1.0
 */
public class EncrypUtil {
    /**
     * md5 加密
     * @return
     */
    public static String getMd5Encrypt(String message,String salt){
        String md5 = "";  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  // 创建一个md5算法对象
            message  += salt;
            byte[] messageByte = message.getBytes("UTF-8");  
            byte[] md5Byte = md.digest(messageByte);              // 获得MD5字节数组,16*8=128位  
            md5 = bytesToHex(md5Byte);                            // 转换为16进制字符串  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return md5;  
    }
    /**
     * 二进制转十六进制  
     * @param bytes
     * @return
     */
    private static String bytesToHex(byte[] bytes) {  
        StringBuffer hexStr = new StringBuffer();  
        int num;  
        for (int i = 0; i < bytes.length; i++) {  
            num = bytes[i];  
             if(num < 0) {  
                 num += 256;  
            }  
            if(num < 16){  
                hexStr.append("0");  
            }  
            hexStr.append(Integer.toHexString(num));  
        }  
        return hexStr.toString().toUpperCase();  
    }  

}
