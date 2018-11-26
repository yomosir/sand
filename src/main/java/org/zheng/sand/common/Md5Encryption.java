package org.zheng.sand.common;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Encryption implements Serializable {

    private static final String SALTCODE            =    "uajmclstierlgndsllt";
    private static final long serialVersionUID      =    -3857777354940380183L;

    public static String encryptPassword(String plaintext){
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        String encryted_code = "";
        String current_code = plaintext + SALTCODE;
        byte [] code_bytes = current_code.getBytes();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(code_bytes);
            byte[] newBytes = md.digest();
            char newStr[] = new char[32];
            // 循环进行处理
            for (int i = 0; i < 16; i++) {
                byte tmp = newBytes[i];
                newStr[2*i] = hexDigits[tmp >>> 4 & 0xf];
                newStr[2*i+1] = hexDigits[tmp & 0xf];
            }
            encryted_code = new String(newStr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryted_code;
    }
}
