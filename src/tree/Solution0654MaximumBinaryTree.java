package tree;

import dataStruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2021/5/27 19:22
 */
public class Solution0654MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructPartial(nums, 0, nums.length);
    }

    public TreeNode constructPartial(int[] nums, int beginIndex, int endIndex) {
        if (beginIndex >= endIndex) {
            return null;
        }

        int maxIndex = maxIndexInArray(nums, beginIndex, endIndex);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructPartial(nums, beginIndex, maxIndex);
        root.right = constructPartial(nums, maxIndex + 1, endIndex);

        return root;
    }

    /**
     * 数组中最大元素的下标
     * @param nums 数组
     * @param beginIndex 起始下标（含）
     * @param endIndex 终止下标（不含）
     * @return 数组中最大元素的下标
     */
    public int maxIndexInArray(int[] nums, int beginIndex, int endIndex) {
        int maxIndex = beginIndex;
        for (int i = beginIndex; i < endIndex; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
