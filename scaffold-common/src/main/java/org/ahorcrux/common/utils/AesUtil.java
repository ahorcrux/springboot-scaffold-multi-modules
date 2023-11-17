package org.ahorcrux.common.utils;

import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.AES;

/**
 *
 */
public class AesUtil {

    /**
     * base64 加密：aes 直接加密明文可能出现编码问题，通常结合base64使用；
     */
    public static String encBase64(String key, String data) {
        String ciphertext = "";
        try{
            AES aes = new AES(Mode.ECB, Padding.PKCS5Padding, key.getBytes());
            ciphertext = aes.encryptBase64(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ciphertext;
    }

    /**
     * base64 解密
     * @return
     */
    public static String dec(String key, String ciphertext){
        String data = "";
        try{
            AES aes = new AES(Mode.ECB, Padding.PKCS5Padding, key.getBytes());
            data = aes.decryptStr(ciphertext);
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

}
