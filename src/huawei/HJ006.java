package huawei;

import java.util.Scanner;

/**
 * @Description 质数因子
 * @Author Kai
 * @Date 2022/3/1 22:55
 */
public class HJ006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        long sqrt = (long) Math.sqrt(num);

        for (long i = 2; i <= sqrt; i++) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }

        // 一个正整数最多只有一个质因子是大于其平方根的
        if (num != 1) {
            System.out.print(num + " ");
        }
    }
}
