package GeeksForGeeks.ReverseGroupsInLinkedList;

import java.util.LinkedList;
import java.util.Queue;
//    Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.
//
//    Input:
//    First line of input contains number of testcases T. For each testcase, first line contains length of linked list and next line contains the linked list elements.
//
//    Output:
//    For each testcase, there will be a single line of output which contains the linked list with every k group elements reversed.
//
//    User Task:
//    The task is to complete the function reverse() which should reverse the linked list in group of size k.
//
//    Expected Time Complexity : O(n)
//    Expected Auxilliary Space : O(1)
//
//    Example:
//    Input:
//    2
//    8
//    1 2 2 4 5 6 7 8
//    4
//    5
//    1 2 3 4 5
//    3
//
//    Output:
//    4 2 2 1 8 7 6 5
//    3 2 1 5 4
//
//    Explanation:
//    Testcase 1: Since, k = 4. So, we have to reverse every group of four elements. Modified linked list is as 4, 2, 2, 1, 8, 7, 6, 5.

public class ReverseGroupsInLinkedList {
    public Node reverse(Node node, int k) {
        Queue<Node> q = new LinkedList<Node>();
        Node cur = node;
        while (cur != null) {
            q.add(cur);
            for (int i = 0; i < k && cur != null; i++) {
                cur = cur.next;
            }
        }

        cur = null;
        Queue<Node> r = new LinkedList<Node>();
        while (!q.isEmpty()) {
            cur = q.peek();
            r.add(reverseList(cur, 0, k));
            q.remove(cur);
        }

        Node head = r.peek();
        cur = head;
        while (!r.isEmpty()) {
            r.remove();
            for (int i = 0; cur.next != null; i++) {
                cur = cur.next;
            }
            cur.next = r.peek();
            cur = cur.next;
        }
        return head;
    }


    private Node reverseList(Node node, int i, int k) {
        if ((i >= k) || (node == null)) {
            return null;
        }
        Node newNode = reverseList(node.next, i + 1, k);
        if (node == null) {
            return newNode;
        }
        node.next = null;
        if (newNode == null) {
            return node;
        }
        Node cur = newNode;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;

        return newNode;
    }

    public static void main(String[] args) {
        ReverseGroupsInLinkedList l = new ReverseGroupsInLinkedList();
        int[] ar = {1, 2, 2, 4, 5, 6, 7, 8};
        l.doArray(ar, 4);

        int[] b = {1, 2, 3, 4, 5};
        l.doArray(b, 3);

        int[] c = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        l.doArray(c, 3);

    }

    private void doArray(int[] ar, int k) {
        Node cur = new Node(ar[0]);
        Node head = cur;
        for (int i = 1; i < ar.length; i++) {
            cur.next = new Node(ar[i]);
            cur = cur.next;
        }

        Node res = reverse(head, k);
        cur = res;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();

    }

}
