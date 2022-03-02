package huawei;

import java.util.Scanner;

/**
 * @Description 进制转换
 * @Author Kai
 * @Date 2022/3/1 14:34
 */
public class HJ005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            String prefix = str.substring(0, 2);
            if (!prefix.equals("0x")) {
                throw new RuntimeException("Illegal Input");
            }

            // 去除十六进制字符串前两位的0x
            str = str.substring(2).toUpperCase();

            int res = 0;
            for (char character : str.toCharArray()) {
                if (character >= '0' && character <= '9') {
                    res = res * 16 + (character - '0');
                }
                else if (character >= 'A' && character <= 'F') {
                    res = res * 16 + (character - 'A' + 10);
                }
            }
            System.out.println(res);

        }
    }

}
