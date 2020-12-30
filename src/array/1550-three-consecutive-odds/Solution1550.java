/**
 * @Description
 * @Author Kai
 * @Date 2020/11/24 21:35
 */
// https://leetcode-cn.com/problems/three-consecutive-odds/
// 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
public class Solution1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i + 2 < arr.length; i++) {
//            if (isOdd(arr[i]) * isOdd(arr[i + 1]) * isOdd(arr[i + 2]) == 1) {
//            if (((arr[i] & 1) != 0) && ((arr[i + 1] & 1) != 0) && ((arr[i + 2] & 1) != 0)) { // 位运算
            if ((arr[i] % 2 == 1) && (arr[i + 1] % 2 == 1) && (arr[i + 2] % 2 == 1)) { // 不另外声明函数，可以省内存
                return true;
            }
        }
        return false;
    }

    public int isOdd(int n) {
        if (n % 2 == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    // 位运算
}
