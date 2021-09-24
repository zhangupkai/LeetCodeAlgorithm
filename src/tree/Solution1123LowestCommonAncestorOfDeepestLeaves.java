package tree;

import dataStruct.TreeNode;

/**
 * @Description
 * 给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。
 *
 * 回想一下：
 *
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的深度为0，如果某一节点的深度为d，那它的子节点的深度就是d+1
 * 如果我们假定 A 是一组节点S的 最近公共祖先，S中的每个节点都在以 A 为根节点的子树中，且 A的深度达到此条件下可能的最大值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Kai
 * @Date 2021/9/24 9:50
 */
public class Solution1123LowestCommonAncestorOfDeepestLeaves {

    // 最近公共祖先
    TreeNode res;
    // 上一次得到的最近公共祖先的深度
    int pre = -1;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    /*
    如果root为空，返回当前深度depth。
    如果不为空，则当前节点的逻辑为：
    分别求左子树和右子树的最大深度，leftDepth和rightDepth
        如果leftDepth == rightDepth，并且当前深度大于上一次的最大深度，说明当前节点为最新的最近公共祖先，上一次的没有当前这个深，将当前节点保存在结果中，并将深度pre更新。
        如果leftDepth != rightDepth，则直接返左右子树的最大深度
     */
    public int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int leftDepth = dfs(root.left, depth + 1);
        int rightDepth = dfs(root.right, depth + 1);
        // leftDepth >= pre 是 >= 不是 >
        if (leftDepth == rightDepth && leftDepth >= pre) {
            pre = leftDepth;
            res = root;
        }
        return Math.max(leftDepth, rightDepth);
    }
}
