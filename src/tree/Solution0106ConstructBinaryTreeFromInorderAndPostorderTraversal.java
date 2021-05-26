package tree;

import dataStruct.TreeNode;

import java.util.Arrays;

/**
 * @Description
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @Author Kai
 * @Date 2021/5/26 9:21
 */
public class Solution0106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        // 可以构建一个val 到 index哈希表，省去每次循环的时间
        int i = 0;
        for (int j = 0; j < inorder.length; j++) {
            if (inorder[j] == root.val) {
                i = j;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length - 1));

        return root;
    }
}
