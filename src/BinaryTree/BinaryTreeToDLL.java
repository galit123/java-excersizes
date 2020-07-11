package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeToDLL {
//    Input: arr[] = {1, 2, 3, N, N, 4, 6, N, 5, N, N, 7, N}
//    Output: Root of the following tree
//              1
//             / \
//            2   3
//           / \ /  \
//          N  N 4   6
//              / \ / \
//            N   5 N  N
//              / \
//             7   N

//      Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place.
//      The left and right pointers in nodes are to be used as previous and next
//      pointers respectively in converted DLL. The order of nodes in DLL must be
//      same as Inorder of the given Binary Tree. The first node of Inorder traversal
//      (leftmost node in BT) must be the head node of the DLL.
//
//                     10
//                  /     \
//                12      15
//               /  \    /
//             25   30 36
// --->  25 <==> 12 <==> 30 <==> 10 <==> 36 <===> 15
//
//    25.left = null
//    25.right = 12
//    12.left = 25
//    12.right = 30
//    30.left = 12
//    30.right = 10
//    10.left = 30
//    10.right = 36
//    36.left = 10
//    36.right = 15
//    15.left = 36
//    15.right = null

    //This function should return head to the DLL
    public Node bToDLL(Node root){
        Node head = getLeftMost(root);
        bToDLLX(root);
        return head;
    }
    public Node bToDLLX(Node root)
    {
        if ((root.left == null) && (root.right == null)){
            return root;
        } else {
            if (root.left != null) {
                Node left = bToDLL(root.left);
                if (left != null) {
                    while (left.right != null) {
                        left = left.right;
                    }
                    left.right = root;
                }
                root.left = left;
            }

            if (root.right != null) {
                Node right = bToDLL(root.right);
                if (right != null) {
                    right.left = root;
                }
                root.right = right;
            }
        }
        return root.left;
    }

    private Node getLeftMost(Node root){
        if (root.left == null){
            return root;
        } else {
            return getLeftMost(root.left);
        }
    }

    public static void main(String[] args) {
        BinaryTreeToDLL bt = new BinaryTreeToDLL();
        ConstractBinaryTreeFromArray c = new ConstractBinaryTreeFromArray();
        int[] a = {10, 12, 15, 25, 30, 36 };
        Node root = c.constractBinaryTree(a);
        root.printTree();

        Node head = bt.bToDLL(root);
        head.printTree();


        int[] b = {'1', '2', '3', 'N', 'N', '4', '6', 'N', '5', 'N', 'N', '7', 'N'};

        root = c.constractBinaryTree(b);
        head = bt.bToDLL(root);
        head.printTree();


//        1 3 2
//        Output:
//        3 1 2
//        2 1 3
        int[] b1 = {1, 3, 2};
//
//         1
//       /   \
//      3     2
//
        root = c.constractBinaryTree(b1);
        root.printTree();
        head = bt.bToDLL(root);
        head.printTree();

//        10 20 30 40 60
//        Output:
//        40 20 60 10 30
//        30 10 60 20 40

        int[] b2 = {10, 20, 30, 40, 60};
//              10
//             /  \
//            20   30
//           /  \
//          40   60

//      40 <==> 20 <==> 60 <==> 10 <==> 30
        root = c.constractBinaryTree(b2);
        root.printTree();
        head = bt.bToDLL(root);
        head.printTree();

    }
}
