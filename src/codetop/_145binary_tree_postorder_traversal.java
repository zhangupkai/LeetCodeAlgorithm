package codetop;

import dataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 二叉树后序遍历
 * @Author Kai
 * @Date 2022/3/11 10:54
 */
public class _145binary_tree_postorder_traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 上一个后序遍历输出的节点
        TreeNode prev = null;

        while (root != null || !stack.empty()) {
            // 遍历到最左子节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            // 如果节点是叶子节点 或 其右子节点是上次访问输出的节点，则输出该节点
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            }
            else {
                stack.push(root);
                root = root.right;
            }
        }

        return res;
    }
}
