package huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Description 字符个数统计
 * @Author Kai
 * @Date 2022/3/2 10:24
 */
public class HJ010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Set<Character> set = new HashSet<>();

        for (char c : str.toCharArray()) {
            set.add(c);
        }
        System.out.println(set.size());
    }
}
