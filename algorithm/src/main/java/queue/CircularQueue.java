package queue;

/**
 * 环形队列
 * (tail+1)%n==head
 * tail == head
 */
public class CircularQueue {

    private int[] items;
    private int capacity;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.items = new int[capacity];
    }

    //enter
    public boolean enQueue(int n) {
        if ((tail + 1) % capacity == head) return false;
        items[tail] = n;
        tail = (tail + 1) % capacity;
        return true;
    }

    //denter
    public int deQueue() {
        if (tail == head) return -1;
        int result = items[head];
        head = (head + 1) % capacity;
        return result;
    }

}
