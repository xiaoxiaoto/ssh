package org.aoto.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

/**
 * @author AOTO
 *
 */
public class Util {
	
    /** 
     * ¶Ô×Ö·û´®½øÐÐMD5¼ÓÃÜ 
     */  
    public static String md5Encryption(String str) {  
        String md5String = null;  
        try {  
            MessageDigest md5 = MessageDigest.getInstance("MD5");  
            BASE64Encoder base = new BASE64Encoder();  
            md5String = base.encode(md5.digest(str.getBytes("UTF-8")));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return md5String;  
    }  
  
    /** 
     * ÅÐ¶Ï×Ö·û´®ÊÇ·ñÎª¿Õ 
     */  
    public static boolean isNull(String str) {  
        if (str != null && !str.trim().equals("")) {  
            return false;  
        } else {  
            return true;  
        }  
    }  

}
