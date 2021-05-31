package tree;

import dataStruct.TreeNode;

/**
 * @Description
 * 返回与给定前序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，
 * 对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。
 * 此外，前序遍历首先显示节点 node 的值，然后遍历 node.left，接着遍历 node.right。）
 * 题目保证，对于给定的测试用例，总能找到满足要求的二叉搜索树。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2021/5/28 16:33
 */
public class Solution1008ConstructBinarySearchTreeFromPreorderTraversal {

    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }
        return dfs(preorder, 0, preorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[left]);
        if (left == right) {
            return root;
        }

        // 在 [left, right] 区间找到最后一个小于 preorder[left] 的下标
        // 采用二分法查找
        int l = left;
        int r = right;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            // 二叉搜索树前序遍历，第一个为根节点，然后后面分为两段，第一段一定都小于根节点，第二段一定都大于根节点
            // 如果 mid 处的值小于根节点值，则 最后一个小于根节点值的位置在 mid 及之后的位置
            if (preorder[mid] < preorder[left]) {
                l = mid;
            }
            // 如果 mid 处的值大于根节点值，则 最后一个小于根节点值的位置在 mid（不含）之前的位置
            else {
                r = mid - 1;
            }
        }

        root.left = dfs(preorder, left + 1, l);
        root.right = dfs(preorder, l + 1, right);

        return root;
    }
}
