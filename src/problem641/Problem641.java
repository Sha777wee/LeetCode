package problem641;

/**
 * @Author Shawee
 * @Date 2023/5/6
 */
public class Problem641 {
    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));     // 返回 true
        System.out.println(circularDeque.insertLast(2));     // 返回 true
        System.out.println(circularDeque.insertFront(3));    // 返回 true
        System.out.println(circularDeque.insertFront(4));    // 已经满了，返回 false
        System.out.println(circularDeque.getRear());               // 返回 2
        System.out.println(circularDeque.isFull());                // 返回 true
        System.out.println(circularDeque.deleteLast());            // 返回 true
        System.out.println(circularDeque.insertFront(4));    // 返回 true
        System.out.println(circularDeque.getFront());              // 返回
    }
}

class MyCircularDeque {

    private int[] queue;
    private int front, rear;
    private int capacity;

    public MyCircularDeque(int k) {
        front = rear = 0;
        // 为了区分空队列(front==rear)和满队列((rear+1+capacity)%capacity==front)的情况
        // 因为front是当前头节点的下标，而rear是当前尾节点的下标+1
        queue = new int[k + 1];
        capacity = k + 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        queue[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        queue[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}
