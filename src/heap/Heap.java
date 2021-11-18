package heap;

import java.util.Arrays;

/**
 * @Description
 * 完全二叉树构建 堆（小顶堆）
 * 数组下标起点 1
 * 子节点为 i << 1 和 i << 1 + 1
 * @Author Kai
 * @Date 2021/11/18 10:50
 */
public class Heap {

    int size = 0;
    int[] data;

    public Heap(int initialCapacity) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException();
        }
        this.data = new int[initialCapacity];
    }

    public Heap(int[] arr) {
        this.size = arr.length;
        // + 1 是因为我们的数组下标是从1开始的
        this.data = new int[arr.length + 1];
        int i = 1;
        for (int var : arr) {
            this.data[i++] = var;
        }
    }

    /**
     * 交换下沉
     * @param i 需要下沉的元素下标
     */
    public void shiftDown(int i) {
        // 从根节点开始下沉，根节点的值存到temp中，每次下沉都会与temp进行比较
        int temp = data[i];

        while (2 * i <= size) {
            // child 此时为左子节点下标
            int child = 2 * i;
            // child 指向的左子节点不是最后一个节点 且 右子节点的只小于左子节点的值
            if (child < size && data[child + 1] < data[child]) {
                // child 此时为右子节点下标
                child++;
            }
            // 子节点（左子节点或右子节点）的值小于temp
            if (data[child] < temp) {
                data[i] = data[child];
                i = child;
            }
            else {
                break;
            }
        }
        // 下沉停止的位置
        data[i] = temp;
    }

    /**
     * 交换上浮
     * @param i 需要上浮的元素下标
     */
    public void shiftUp(int i) {

        int temp = data[i];

        while (i / 2 >= 1) {
            int parent = i / 2;
            if (data[parent] > temp) {
                data[i] = data[parent];
                i = parent;
            }
            else {
                break;
            }
        }

        data[i] = temp;
    }

    /**
     *
     * @return 堆顶元素
     */
    public int peek() {
        return this.data[1];
    }

    /**
     * 出堆
     * @return 堆顶元素
     */
    public int pop() {
        int res = this.data[1];
        // 出堆后，将最后一个节点与根节点交换
        data[1] = data[size--];
        shiftDown(1);
        return res;
    }

    /**
     * 入堆
     * @param val 入堆的元素
     */
    public void push(int val) {
        if (size == data.length - 1) {
            data = Arrays.copyOf(data, size * 2 + 1);
        }
        data[++size] = val;
        shiftUp(size);
    }

    /**
     * 构建堆：从最后一个非叶子节点开始构建
     * 完全二叉树中，size / 2 为最后一个非叶子节点的下标
     */
    public void buildHeap() {
        for (int i = size / 2; i > 0; i--) {
            shiftDown(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,4,1,8,1};
        Heap heap = new Heap(arr);
        heap.buildHeap();
        System.out.println(heap.peek());
        heap.push(5);
        while (heap.size > 0) {
            int num = heap.pop();
            System.out.print(num + " ");
        }
    }

}
