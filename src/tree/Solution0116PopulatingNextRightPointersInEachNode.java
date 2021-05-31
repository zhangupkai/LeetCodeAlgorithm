package tree;

import dataStruct.solution0116.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2021/5/31 16:41
 */
public class Solution0116PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        // 层次遍历，并非BFS
        while (!queue.isEmpty()) {
            // 二叉树这一层的节点数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                // 不是这一层最后一个节点
                if (i < size - 1) {
                    // next 指向队列中下一个节点
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }
}
