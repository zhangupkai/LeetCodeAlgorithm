package tree;

import dataStruct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * @Description 二叉树迭代遍历-通用模板
 * @Author Kai
 * @Date 2021/4/27 15:54
 */
public class TreeTraverse {

    /**
     *  新节点为白色，已访问的节点为灰色
     *  WHITE 就表示的是递归中的第一次进入过程，Gray 则表示递归中的从叶子节点返回的过程。
     */
    private final int WHITE = 0;
    private final int GRAY = 1;

    private static class NodeAndColor {
        private TreeNode node;
        private int color;
        public NodeAndColor(TreeNode node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<NodeAndColor> stack = new Stack<>();
        stack.push(new NodeAndColor(root, WHITE));

        while (!stack.empty()) {
            NodeAndColor nodeAndColor = stack.pop();
            int color = nodeAndColor.color;
            TreeNode node = nodeAndColor.node;
            if (node == null) {
                continue;
            }
            /*
              实现前序、后序遍历，也只需要调整左右子节点的入栈顺序即可，其他部分是无需做任何变化
             */
            if (color == WHITE) {
                /*
                // 中序遍历
                if (node.right != null) {
                    stack.push(new NodeAndColor(node.right, WHITE));
                }
                stack.push(new NodeAndColor(node, GRAY));
                if (node.left != null) {
                    stack.push(new NodeAndColor(node.left, WHITE));
                }
                */

                // 前序遍历
//                if (node.right != null) {
//                    stack.push(new NodeAndColor(node.right, WHITE));
//                }
//                if (node.left != null) {
//                    stack.push(new NodeAndColor(node.left, WHITE));
//                }
//                stack.push(new NodeAndColor(node, GRAY));


                // 后序遍历
                stack.push(new NodeAndColor(node, GRAY));
                if (node.right != null) {
                    stack.push(new NodeAndColor(node.right, WHITE));
                }
                if (node.left != null) {
                    stack.push(new NodeAndColor(node.left, WHITE));
                }


            }
            else {
                res.add(node.val);
            }
        }
        return res;
    }

}
