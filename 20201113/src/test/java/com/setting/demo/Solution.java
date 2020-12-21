package com.setting.demo;


public class Solution {
    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */

    public static void main(String[] args) {
        System.out.println(LCS("1AB2345CD", "12345EF"));
    }

    private static String result = "";

    public static String LCS (String str1, String str2) {
        // write code here
        if (str1 == null || str2 == null) return "-1";

        LACSHealer(new StringBuilder().append(str1.charAt(0)), str1, str2, 1, 1);

        return result;
    }

    private static void LACSHealer(StringBuilder tmpStr, String str1, String str2,
                                   int str1Index, int beginIndex) {


        if (tmpStr.length() > result.length()) {
            result = tmpStr.toString();
        }
        if (str1Index >= str1.length() || beginIndex >= str1.length()) return;

        tmpStr.append(str1.charAt(str1Index));
        if (str2.contains(tmpStr.toString())) {
            LACSHealer(tmpStr, str1, str2, str1Index + 1, beginIndex);
        } else {
            LACSHealer(new StringBuilder().append(str1.charAt(beginIndex)),
                    str1, str2, beginIndex + 1, beginIndex +1);
        }

    }

}