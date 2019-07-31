package SinglyLinkedList;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2) 回文字符
 * 3）链表中存储的是int类型的数据；
 */
public class SinglyLinkedList {

    private static Node head = null;

    //头插入
    public static void insertHead(int value) {
        Node newHead = new Node(value);
        newHead.next = head;
        head = newHead;
    }

    //尾插
    public static void insertTail(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node tail = head.next;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;
    }

    //在某值前插入
    //注意考虑边界条件
    public static void insertBefore(int value, int beforValue) {
        Node newNode = new Node(value);

        if (head == null || head.value == beforValue) {
            insertHead(value);
            return;
        }

        //只有一个节点时避免空指针异常
        if (head.next == null) {
            return;
        }

        Node node = head;
        while (node.next.value != beforValue) {
            node = node.next;
        }

        if (node == null) {
            return;
        }

        newNode.next = node.next;
        node.next = newNode;
    }

    //尾插
    public static void insertAfter(int value, int afterValue) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }

        if (head.value == afterValue) {
            newNode.next = head.next;
            head.next = newNode;
            head = newNode;
            return;
        }

        Node node = head;
        while (node.value != afterValue) {
            node = node.next;
        }

        if (node == null) {
            return;
        }

        newNode.next = node.next;
        node.next = newNode;

    }

    //根据value删除节点
    //注意只有一个节点的边界条件
    public static void delByValue(int value) {
        if (head == null) {
            return;
        }

        if (head.value == value) {
            head = head.next;
            return;
        }
        //只有一个节点时避免空指针异常
        if (head.next == null) {
            return;
        }

        Node node = head;
        while (node.next.value != value) {
            node = node.next;
        }
        //链表中无该节点
        if (node == null) {
            return;
        }

        node.next = node.next.next;

    }

//    public static boolean palindrome(){
//        if(head == null){
//           return false;
//        }
//
//        //Node
//
//
//
//
//    }

}