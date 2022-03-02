package huawei;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Description 提取不重复的整数
 * @Author Kai
 * @Date 2022/3/2 10:03
 */
public class HJ009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Set<Integer> set = new LinkedHashSet<>();

        while (num > 0) {
            // 个位数字
            int ele = num % 10;
            set.add(ele);
            num /= 10;
        }

        for (Integer elem : set) {
            System.out.print(elem);
        }
    }
}
