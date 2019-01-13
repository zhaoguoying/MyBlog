package com.Blog.utils;

/*
 * 作者：赵国应
 * 时间：2019-1-12
 * 描述：转码工具
 */

public class TransCodingUtil {

    /**
     * unicode编码转中文
     * @param dataStr unicode编码
     * @return 中文
     */
    public static String unicodeToString(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            // 16进制parse整形字符串。
            char letter = (char) Integer.parseInt(charStr, 16);
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }
}
