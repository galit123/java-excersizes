package BinaryTree;

import java.util.LinkedList;
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
    //This function should return head to the DLL
    Node bToDLL(Node root)
    {
        return null;
    }

    public static void main(String[] args) {
        BinaryTreeToDLL bt = new BinaryTreeToDLL();
        ConstractBinaryTreeFromArray c = new ConstractBinaryTreeFromArray();
        char[] a = {'1', '2', '3', 'N', 'N', '4', '6', 'N', '5', 'N', 'N', '7', 'N'};

        Node root = c.constractBinaryTree(a);
        System.out.println(root);
        Node dll = bt.bToDLL(root);
    }
}
