package huawei;

import java.util.Scanner;

/**
 * @Description 字符串分离
 * @Author Kai
 * @Date 2022/2/27 20:49
 * https://www.nowcoder.com/practice/d9162298cb5a437aad722fccccaae8a7?tpId=37&tqId=21227&rp=1&ru=/ta/huawei&qru=/ta/huawei&difficulty=&judgeStatus=&tags=/question-ranking
 */
public class HJ004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            while (str.length() >= 8) {
                System.out.println(str.substring(0, 8));
                // 从index=8截取到末尾
                str = str.substring(8);
            }

            // str长度小于8，补0
            if (str.length() > 0 && str.length() < 8) {
                int zeroCount = 8 - str.length();
                while (zeroCount > 0) {
                    str += "0";
                    zeroCount--;
                }
                System.out.println(str);
            }
        }
    }
}
