package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//    Input  :  arr[] = {1, 2, 3, 4, 5, 6}
//    Output : Root of the following tree
//                 1
//                / \
//               2   3
//              / \ /
//             4  5 6
//
//                    0  1  2  3  4  5  6  7  8  9
//    Input: arr[] = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6}
//    Output: Root of the following tree
//              1
//             / \
//            2   3
//           / \ / \
//          4  5 6  6
//         / \ /
//        6  6 6
public class ConstractBinaryTreeFromArray {
    public Node constractBinaryTree(char[] array){
        Queue<Node> q = new LinkedList<Node>();

        int i =0;
        Node node = new Node(array[i]);
        Node root = node;
        q.add(node);

        while (!q.isEmpty()){
            node = q.remove();

            i++;
            if (i < array.length) {
                if (array[i] == 'N'){
                    node.left = null;
                } else {
                    node.left = new Node(array[i]);
                    q.add(node.left);
                }
            }

            i++;
            if (i < array.length) {
                if (array[i] == 'N') {
                    node.right = null;
                } else {
                    node.right = new Node(array[i]);
                    q.add(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        char[] arr = {'1', '2', '3', '4', '5', '6'};
        ConstractBinaryTreeFromArray c = new ConstractBinaryTreeFromArray();
        Node node = c.constractBinaryTree(arr);

        System.out.println(node );


        char b[] = {'1', '2', '3', '4', '5', '6', '6', '6', '6', '6'};
        node = c.constractBinaryTree(b);
        System.out.println(node);


    }
 }
