package SinglyLinkedList;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 */
public class LinkedListOperation {

    //反转链表
    //注意边界条件
    public static Node reverseLinkedList(Node head) {
        if (head == null) {
            return head;
        }

        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //链表中环的检测
    //快慢指针
    public static boolean checkCircle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //有序链表的合并
    public static Node mergeSortList(Node la, Node lb) {
        if (la == null) return lb;
        if (lb == null) return la;
        Node head = null;
        if (la.value < lb.value) {
            head = la;
            la = la.next;
        } else {
            head = lb;
            lb = lb.next;
        }
        Node n = head;
        while (la != null && lb != null) {
            if (la.value < lb.value) {
                n.next = la;
                la = la.next;
                n = n.next;
            } else {
                n.next = lb;
                lb = lb.next;
                n = n.next;
            }
        }

        if (la == null) {
            n.next = lb;
        } else if (lb == null) {
            n.next = la;
        }

        return head;
    }

    //删除指定倒数n节点
    //使用快慢指针，快指针先周n步然后同步走，快走到tail则慢指针可以定位倒数n
    public static Node delNthNode(Node head, int n) {
        if (head == null || n == 0) return head;
        Node fast = head;
        int i = 1;
        while (fast != null && i <= n) {
            fast = fast.next;
            i++;
        }

        //快指针走到的null,表明需要删除第一个节点
        if (fast == null) {
            head = head.next;
            return head;
        }

        Node slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    //链表中间节点
    //快慢指针 快指针每次走两步，慢指针每次走一步，因为快指针速度时慢指针的两倍，所以当快指针走到了链表尾，慢指针就是在中间处
    public static Node findMiddleNode(Node head) {
        if (head == null) return head;
        Node fast = head;
        Node slow = head;
        while (fast!=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node la = new Node(1);
        la.next = new Node(2);
        la = la.next;
        la.next = new Node(4);
        Node lb = new Node(1);
        lb.next = new Node(3);
        lb = lb.next;
        lb.next = new Node(4);
        Node node = mergeSortList(la, lb);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

}
