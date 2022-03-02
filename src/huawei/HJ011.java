package huawei;

import java.util.Scanner;

/**
 * @Description 数字颠倒
 * @Author Kai
 * @Date 2022/3/2 10:38
 */
public class HJ011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        if (num == 0) {
            System.out.println(0);
        }

        while (num > 0) {
            // 个位
            int ele = num % 10;
            System.out.print(ele);
            num /= 10;
        }
    }
}
