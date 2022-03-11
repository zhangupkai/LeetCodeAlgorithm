package codetop;

import dataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 二叉树的中序遍历
 * @Author Kai
 * @Date 2022/3/11 14:52
 */
public class _94binary_tree_inorder_traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            // 一直遍历到最左子节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            /*
            // 没有右子节点（也没有左子节点），则该节点是叶子节点，打印该节点
            if (root.right == null) {
                res.add(root.val);
                root = null;
            }
            // 有右子节点，也要先打印该节点，因为中序遍历是 左-中-右
            else {
                res.add(root.val);
                root = root.right;
            }

             */
            // 上面的 if-else可以简化如下：
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
