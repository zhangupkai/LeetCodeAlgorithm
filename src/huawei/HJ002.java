package huawei;

import java.util.Scanner;

/**
 * @Description 计算某字符出现次数
 * @Author Kai
 * @Date 2022/2/27 19:53
 * https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 */
public class HJ002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toUpperCase();
        String letter = scanner.nextLine().toUpperCase();
        System.out.println(str.length() - str.replaceAll(letter, "").length());
    }
}
