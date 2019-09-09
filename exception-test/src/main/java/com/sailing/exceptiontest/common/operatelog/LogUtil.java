package com.sailing.exceptiontest.common.operatelog;

import com.sailing.exceptiontest.common.result.ResponseResult;
import com.sailing.exceptiontest.common.result.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: Administrator
 * @Date: 2019/9/9 21:45
 * @Description:日志帮助类
 */
public class LogUtil {

    private static final String REGX = "!|！|@|◎|#|＃|(\\$)|￥|%|％|(\\^)|……|(\\&)|※|(\\*)|×|(\\()|（|(\\))|）|_|——|(\\+)|＋|(\\|)|§ ";

    /**
     * 对常见的sql注入攻击进行验证
     * @param inputParam
     * @return
     * true:表示参数不存在sql注入风险
     * false:表示参数存在sql注入风险
     */
    public static Boolean sqlStrFilter(String inputParam){

        if(null==inputParam || inputParam.trim().length()==0){
            return false;
        }

        if (inputParam.indexOf("DELETE") >= 0 || inputParam.indexOf("ASCII") >= 0 || inputParam.indexOf("UPDATE") >= 0 || inputParam.indexOf("SELECT") >= 0
                || inputParam.indexOf("'") >= 0 || inputParam.indexOf("SUBSTR(") >= 0 || inputParam.indexOf("COUNT(") >= 0 || inputParam.indexOf(" OR ") >= 0
                || inputParam.indexOf(" AND ") >= 0 || inputParam.indexOf("DROP") >= 0 || inputParam.indexOf("EXECUTE") >= 0 || inputParam.indexOf("EXEC") >= 0
                || inputParam.indexOf("TRUNCATE") >= 0 || inputParam.indexOf("INTO") >= 0 || inputParam.indexOf("DECLARE") >= 0 || inputParam.indexOf("MASTER") >= 0) {
            System.out.println("该参数怎么SQL注入风险：sInput=" + inputParam);
            return false;
        }
        System.out.println("通过sql验证");
        return true;
    }

    /**
     * 对非法字符进行验证
     *
     * @param inputParam
     * @return
     * true:表示参数不包含非法字符
     * false:表示参数包含非法字符
     */
    public static Boolean isIllegalStr(String inputParam){
        if(null==inputParam || inputParam.trim().length()==0){
            return false;
        }
        inputParam = inputParam.trim();
        Pattern compile = Pattern.compile(REGX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = compile.matcher(inputParam);
        System.out.println("字符串验证");
        return matcher.find();
    }

    /**
     * 按字节截取字符串方法
     * @param str 要截取的字符串
     * @param len 要截取的长度
     * @param elide 省略号 一般传递""
     * @return
     */
    public static String splitString(String str, int len, String elide) {
        if (str == null || len < 3) {
            return "";
        }
        byte[] strByte = str.getBytes();
        int strLen = strByte.length;
        if (len >= strLen || len < 1) {
            return str;
        }
        int count = 0;
        int index = 0;
        boolean flag = false;
        for (int i = len - 1; i > len - 4; i--) {
            int value = (int) strByte[i];
            if (i == len - 1 && value > 0) {
                flag = true;
                break;
            }
            index++;
            if (value < 0) {
                count++;
            }
            if (index == 3) {
                if (index == count) {
                    flag = true;
                }
                break;
            }
        }
        len = flag ? len : len - count % 3;
        return new String(strByte, 0, len) + elide.trim();
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 返回结果
     * @param result
     * @return
     */
    public String getResultStr(Object result){
        String resultStr="";
        if(result instanceof ResponseResult){
            resultStr = ((ResponseResult)result).getMsg();
        }
        return splitString(resultStr,1300,"...");
    }

    public static void main(String[] args) {
        String str = splitString("按字节截取字符串方法",4,"...");
        System.out.println(str);
    }
}
