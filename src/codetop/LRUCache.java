package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。
 *                                          如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 *
 Your LRUCache object will be instantiated and called as such:
    LRUCache obj = new LRUCache(capacity);
    int param_1 = obj.get(key);
    obj.put(key,value);
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2022/2/1 16:57
 */
public class LRUCache {

    // 自定义双向链表，双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的。
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {}

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // 通过缓存数据的键key映射到其在双向链表中的位置。
    private Map<Integer, DLinkedNode> map = new HashMap<>();
    // 当前缓存中的数量
    private int size;
    // 缓存容量
    private int capacity;
    // 双链表的虚拟头结点 虚拟尾结点
    private DLinkedNode dummyHead, dummyTail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 虚拟头结点和尾结点
        this.dummyHead = new DLinkedNode();
        this.dummyTail = new DLinkedNode();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    /*
    对于 get 操作，首先判断 key 是否存在：
        如果 key 不存在，则返回 -1；
        如果 key 存在，则 key 对应的节点是最近被使用的节点。通过哈希表定位到该节点在双向链表中的位置，并将其移动到双向链表的头部，最后返回该节点的值。
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        else {
            DLinkedNode node = map.get(key);
            moveToHead(node);
            return node.value;
        }
    }

    /*
    对于 put 操作，首先判断 key 是否存在：
        如果 key 不存在，使用 key 和 value 创建一个新的节点，在双向链表的头部添加该节点，并将 key 和该节点添加进哈希表中。
            然后判断双向链表的节点数是否超出容量，如果超出容量，则删除双向链表的尾部节点，并删除哈希表中对应的项.
        如果 key 存在，则与 get 操作类似，先通过哈希表定位，再将对应的节点的值更新为 value，并将该节点移到双向链表的头部。
     */
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            DLinkedNode node = new DLinkedNode(key, value);
            addToHead(node);
            ++size;
            map.put(key, node);

            if (size > capacity) {
                DLinkedNode tail = removeTail();
                --size;
                map.remove(tail.key);
            }
        }
        else {
            DLinkedNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        }

    }

    // 在双链表头部添加结点
    public void addToHead(DLinkedNode node) {
        node.prev = dummyHead;
        node.next = dummyHead.next;
        node.next.prev = node;
        dummyHead.next = node;
    }

    // 删除指定结点
    public void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 结点移动到双链表头部 = 删除该结点 + 在头部添加该结点
    public void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    // 删除双链表尾部结点并返回
    public DLinkedNode removeTail() {
        // 真正的尾结点（dummyTail是虚拟尾结点）
        DLinkedNode tail = dummyTail.prev;
        removeNode(tail);
        return tail;
    }
}
