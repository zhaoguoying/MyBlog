package com.Blog.component;

/*
 * 作者：赵国应
 * 时间：2019-1-13
 * 描述：
 */

public class JavaScriptCheck {

    public static String javaScriptCheck(String comment){
        int begin,end,theEnd;
        String newStr = "";
        begin = comment.indexOf("<script");
        end = comment.indexOf("</script>");
        while (begin != -1){
            theEnd = comment.indexOf(">");
            newStr += comment.substring(0, begin);
            newStr += "[removed]" + comment.substring(theEnd+1,end) + "[removed]";

            comment = comment.substring(end+9);

            begin = comment.indexOf("<script");
            end = comment.indexOf("</script>");
        }
        return newStr;
    }

}
