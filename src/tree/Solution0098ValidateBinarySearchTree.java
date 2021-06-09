package tree;

import dataStruct.TreeNode;

/**
 * @Description
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * @Author Kai
 * @Date 2021/6/9 10:13
 */
public class Solution0098ValidateBinarySearchTree {
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点，若当前节点值小于等于前一个节点值，则不满足BST
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
//        if (!isValidBST(root.right)) {
//            return false;
//        }
//        else {
//            return true;
//        }
    }

}
