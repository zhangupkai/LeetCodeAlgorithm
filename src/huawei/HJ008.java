package huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Description 合并表记录
 * @Author Kai
 * @Date 2022/3/2 9:36
 */
public class HJ008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums; i++) {
            int index = scanner.nextInt();
            int value = scanner.nextInt();
            map.put(index, map.getOrDefault(index, 0) + value);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
