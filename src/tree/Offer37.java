package tree;

import dataStruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 * @Author Kai
 * @Date 2021/5/27 15:04
 */
public class Offer37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        StringBuilder res = new StringBuilder("[");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;

        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node != null) {
                res.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
            else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        // 序列化列表 val
        String[] val = data.substring(1, data.length() - 1).split(",");

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        queue.offer(root);

        int index = 1;
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();

            if (!val[index].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(val[index]));
                queue.offer(node.left);
            }
            index++;

            if (!val[index].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(val[index]));
                queue.offer(node.right);
            }
            index++;
        }

        return root;
    }
}
