package tree;

import dataStruct.TreeNode;

import java.util.Arrays;

/**
 * @Description
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @Author Kai
 * @Date 2021/5/25 19:40
 */
public class Solution0105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        for (int j = 0; j < inorder.length; j++) {
            if (inorder[j] == root.val) {
                i = j;
            }
        }

        // copyOfRange() 左闭右开
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));

        return root;
    }
}
