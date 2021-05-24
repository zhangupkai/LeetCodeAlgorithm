package tree;

import dataStruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 * @Author Kai
 * @Date 2021/5/24 16:27
 */
public class Solution0513FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {

        /*
        通常BFS遍历都是从上到下，从左到右。然而根据题目意思，是要取到最下面，最左边的元素。
        故只需要对BFS遍历稍作改进即可。具体思路为从上到下保持不变, 但水平遍历方向改为从右到左即可。如此一来，先上后下，先右后左，
        此策略走下去，最后一个元素必然是最下方最左边的元素，最后返回该节点node.val即可
         */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode node = root;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
        }
        return node.val;
    }
}
