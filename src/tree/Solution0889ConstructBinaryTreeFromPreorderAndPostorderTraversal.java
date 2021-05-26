package tree;

import dataStruct.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * @Author Kai
 * @Date 2021/5/26 10:31
 */
public class Solution0889ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1) {
            return root;
        }

        int i = 0;
        for (int j = 0; j < post.length; j++) {
            if (post[j] == pre[1]) {
                i = j;
            }
        }

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, i + 2), Arrays.copyOfRange(post, 0, i + 1));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, i + 2, pre.length), Arrays.copyOfRange(post, i + 1, post.length - 1));

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] post = {4, 5, 2, 6, 7 ,3, 1};
        System.out.println(constructFromPrePost(pre, post));
    }
}
