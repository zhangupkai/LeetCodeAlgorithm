package codetop;

import dataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 二叉树的前序遍历
 * @Author Kai
 * @Date 2022/3/11 14:30
 */
public class _144binary_tree_preorder_traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                // 第一次访问根节点时就打印
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 情况1：右子节点为空，下一轮循环直接出栈栈顶元素
            // 情况2：右子节点不为空，下一轮循环打印右子节点并入栈
            root = root.right;
        }

//        stack.push(root);
//        while (!stack.empty()) {
//            TreeNode node = stack.pop();
//            res.add(node.val);
//            if (node.right != null) {
//                stack.push(node.right);
//            }
//            if (node.left != null) {
//                stack.push(node.left);
//            }
//        }

        return res;
    }
}
