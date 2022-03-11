package codetop;

import dataStruct.TreeNode;

/**
 * @Description 从前序与中序遍历序列构造二叉树
 * 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2022/3/10 9:12
 */
public class _105construct_binary_tree_from_preorder_and_inorder_traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    // 起始和终止索引都是闭区间
    private TreeNode dfs(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        // TODO Note: 条件不能是!(preEnd - preStart > 0) 不能缺少等号
        if (!(preEnd - preStart >= 0)) {
            return null;
        }
        // 前序序列的第一个元素是树的根节点
        TreeNode root = new TreeNode(preorder[preStart]);
        // 找到根节点在中序序列中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        // TODO Note: 这里index是中序序列中索引，不能用于前序序列，所以下面代码中 preStart 和 preEnd 的定义是错误的
        // root.left = dfs(preorder, inorder, preStart + 1, index, inStart, index - 1);
        // root.right = dfs(preorder, inorder, index + 1, preEnd, index + 1, inEnd);

        // 左子树中元素个数
        int leftNum = index - inStart;
        root.left = dfs(preorder, inorder, preStart + 1, preStart + leftNum, inStart, index - 1);
        root.right = dfs(preorder, inorder, preStart + leftNum + 1, preEnd, index + 1, inEnd);

        return root;
    }
}
