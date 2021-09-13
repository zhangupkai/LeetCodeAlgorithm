package tree;

import dataStruct.TreeNode;

/**
 * @Description
 * 给定一个二叉树，计算 整个树 的坡度 。
 * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 * 整个树 的坡度就是其所有节点的坡度之和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2021/9/13 19:43
 */
public class Solution0563BinaryTreeTilt {

    int tilt = 0;

    // 当前节点下方（包括自身）的节点和
    public int sumOneNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOneNode(root.left);
        int rightSum = sumOneNode(root.right);
        // 左子树节点之和与右子树节点之和的差值即为坡度
        tilt += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }

    public int findTilt(TreeNode root) {
        sumOneNode(root);
        return tilt;
    }

}
