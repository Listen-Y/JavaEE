package com.employee.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {


    private static String md5(String text) throws Exception {
        //加密后的字符串
        return DigestUtils.md5Hex(text);
    }

    public static boolean verify(String text, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(text);
        return md5Text.equalsIgnoreCase(md5);
    }
}