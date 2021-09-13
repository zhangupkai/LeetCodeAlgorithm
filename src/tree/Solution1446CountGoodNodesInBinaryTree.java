package tree;

import dataStruct.TreeNode;

/**
 * @Description
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 * @Author Kai
 * @Date 2021/9/13 20:37
 */
public class Solution1446CountGoodNodesInBinaryTree {

    int goodSum = 0;

    // 前序遍历（自定向下）, 参数扩展
    public void goodOneNode(TreeNode root, int curMax) {
        if (root == null) {
            return;
        }
        if (root.val >= curMax) {
            goodSum++;
            curMax = root.val;
        }
        goodOneNode(root.left, curMax);
        goodOneNode(root.right, curMax);
    }


    public int goodNodes(TreeNode root) {
        goodOneNode(root, root.val);
        return goodSum;
    }
}
