package huawei;

import java.util.Scanner;

/**
 * @Description 取近似值
 * @Author Kai
 * @Date 2022/3/1 23:14
 */
public class HJ007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        System.out.println((long) (num + 0.5));
    }
}
