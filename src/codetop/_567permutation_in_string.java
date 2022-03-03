package codetop;

import java.util.Arrays;

/**
 * @Description
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * s1, s2中只有小写字母
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2022/3/3 13:57
 */
public class _567permutation_in_string {
    // 字符串的排列：由于排列不会改变字符串中每个字符的个数，所以只有当两个字符串每个字符的个数均相等时，一个字符串才是另一个字符串的排列。
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 > l2) {
            return false;
        }
        // 题目说s1, s2中只有小写字母
        // 使用两个长度26的数组分别记录每个字符出现的次数, cnt1[0] = 1 表示 s1中字符a出现一次
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        // s2中前l1个字符的出现次数统计
        for (int i = 0; i < l1; i++) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }

        // 大小固定为l1的滑动窗口
        for (int i = l1; i < l2; i++) {
            // 窗口右移一位
            // 新进入窗口的字符
            ++cnt2[s2.charAt(i) - 'a'];
            // 离开窗口的字符
            --cnt2[s2.charAt(i - l1) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }

        return false;
    }
}
