package tree;

import dataStruct.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @Author Kai
 * @Date 2021/4/10 16:19
 */
public class Offer34 {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return res;
    }

    public void recur(TreeNode root, int target) {
        if (root != null) {
            path.add(root.val);
            target -= root.val;
            if (root.left == null && root.right == null && target == 0) {
                res.add(new LinkedList<>(path));
            }
            recur(root.left, target);
            recur(root.right, target);
            // 向上回溯前，需要将当前节点从路径 path 中删除
            path.removeLast(); // 只有LinkedList才有removeLast()方法，List和ArrayList都没有
        }
    }
}
