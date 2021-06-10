package tree;

import dataStruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * @Author Kai
 * @Date 2021/6/10 20:25
 */
public class Solution0662MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<CustomNode> queue = new LinkedList<>();
        queue.offer(new CustomNode(root, 1));

        // ans 结果， left 当前层最左节点下标
        int ans = 0, left = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 层次遍历
            for (int i = 0; i < size; i++) {
                CustomNode customNode = queue.poll();
                if (customNode.node != null) {
                    if (customNode.node.left != null) {
                        queue.offer(new CustomNode(customNode.node.left, customNode.pos * 2));
                    }
                    if (customNode.node.right != null) {
                        queue.offer(new CustomNode(customNode.node.right, customNode.pos * 2 + 1));
                    }
                    // 当前层第一个节点
                    if (i == 0) {
                        left = customNode.pos;
                    }
                    // 当前层最后一个节点
                    if (i == size - 1) {
                        ans = Math.max(ans, customNode.pos - left + 1);
                    }
                }
            }
        }

        return ans;
    }
}

class CustomNode {
    TreeNode node;
    int pos;

    public CustomNode(TreeNode node, int pos) {
        this.node = node;
        this.pos = pos;
    }
}