package com.jr.common.test;

import com.jr.common.util.EncryptionUtil;

/**
 *@Author feri
 *@Date Created in 2019/6/13 11:16
 */
public class AES_Test {
    public static void main(String[] args) {
        String key= EncryptionUtil.createAESKEY();
        System.out.println(key);
        String pass="123456";
        String mw=EncryptionUtil.AESEnc(key,pass);
        System.out.println("密文："+mw);
        System.out.println("解密："+EncryptionUtil.AESDec(key,mw));
    }
}
