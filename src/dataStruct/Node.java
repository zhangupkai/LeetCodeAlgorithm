package dataStruct;

import java.util.Objects;

/**
 * @Description 带随机指针的链表节点
 * @Author Kai
 * @Date 2021/3/25 15:53
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val == node.val && Objects.equals(next, node.next) && Objects.equals(random, node.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next, random);
    }
}
