package linkedList;

import dataStruct.Node;

import java.util.HashMap;

/**
 * @Description 复制带随机指针的链表
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * @Author Kai
 * @Date 2021/3/25 15:55
 */
public class Solution0138CopyListWithRandomPointer {
    /**
     * 旧节点到新节点的映射
     */
    private final HashMap<Node, Node> visited = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node originCur = head;
        Node copyCur = new Node(originCur.val);
        this.visited.put(originCur, copyCur);

        while (originCur != null) {
            copyCur.next = getCopyNode(originCur.next);
            copyCur.random = getCopyNode(originCur.random);

            originCur = originCur.next;
            copyCur = copyCur.next;
        }

        return this.visited.get(head);
    }

    public Node getCopyNode(Node node) {
        if (node == null) {
            return null;
        }
        if (!visited.containsKey(node)) {
            this.visited.put(node, new Node(node.val));
        }
        return this.visited.get(node);
    }
}
