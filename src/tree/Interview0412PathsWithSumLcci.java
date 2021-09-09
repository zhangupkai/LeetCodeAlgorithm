package tree;

import dataStruct.TreeNode;

/**
 * @Description
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
 * 注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2021/9/9 10:12
 */
public class Interview0412PathsWithSumLcci {

    // 内部递归函数：从当前节点出发的符合路径的路径数量
    public int pathForOneNode(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int count;
        if (root.val == sum) {
            count = 1;
        }
        else {
            count = 0;
        }

        sum -= root.val;
        return pathForOneNode(root.left, sum) + pathForOneNode(root.right, sum) + count;
    }


    // 主递归函数：不同的节点为起点出发
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathForOneNode(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }


}
