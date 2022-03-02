package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description 字符串反转
 * @Author Kai
 * @Date 2022/3/2 10:50
 */
public class HJ012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(reverseStr(str));
    }

    public static String reverseStr(String str) {
        // String 转换成 char 数组，首尾字母依次互换
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length / 2; i++) {
            char temp = charArr[i];
            charArr[i] = charArr[charArr.length - 1 - i];
            charArr[charArr.length - 1 - i] = temp;
        }
        return new String(charArr);
    }

    public static String reverseStr1(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }
}
