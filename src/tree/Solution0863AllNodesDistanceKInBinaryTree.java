package tree;

import dataStruct.TreeNode;

import java.util.*;

/**
 * @Description
 * 给定一个二叉树（具有根结点 root），一个目标结点 target ，和一个整数值 K 。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * @Author Kai
 * @Date 2021/6/1 10:57
 */
//TODO
public class Solution0863AllNodesDistanceKInBinaryTree {

    Map<TreeNode, TreeNode> parentNode = new HashMap<>();

    public void constructParent(TreeNode node, TreeNode parent) {
        if (node != null) {
            parentNode.put(node, parent);
            constructParent(node.left, node);
            constructParent(node.right, node);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 构建父指针
        constructParent(root, null);
        // 节点是否被访问
        Set<TreeNode> visited = new HashSet<>();
        // 结果列表
        List<Integer> ans = new ArrayList<>();
        // 层次遍历队列
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(target);
        while (!queue.isEmpty()) {
            if (k == 0) {
                while (!queue.isEmpty()) {
                    ans.add(queue.poll().val);
                }
                break;
            }
            k--;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                visited.add(node);
                assert node != null;
                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                }
                TreeNode parent = parentNode.get(node);
                if (parent != null && !visited.contains(parent)) {
                    queue.add(parent);
                }
            }
        }

        return ans;
    }
}
