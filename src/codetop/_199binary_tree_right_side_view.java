package codetop;

import dataStruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * @Author Kai
 * @Date 2022/3/9 10:31
 */
public class _199binary_tree_right_side_view {
    // 方法一：DFS 根-右-左 深度
    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView1(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        // 如果当前节点所在深度 等于 结果列表的大小，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入ans中。
        if (depth == ans.size()) {
            ans.add(node.val);
        }
        depth++;
        dfs(node.right, depth);
        dfs(node.left, depth);
    }

    // 方法二：BFS 层次遍历 每层最后一个元素
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 二叉树层次遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                // 如果是当前层最后一个节点
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }

        return res;
    }
}
