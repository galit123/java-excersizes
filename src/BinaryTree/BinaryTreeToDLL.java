//package BinaryTree;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class BinaryTreeToDLL {
//
//    //This function should return head to the DLL
//    Node bToDLL(Node root)
//    {
//        return null;
//    }
//
//    public static void main(String[] args) {
//        BinaryTreeToDLL bt = new BinaryTreeToDLL();
//
//        int[] a = {1, 2, 3, 0, 0, 4, 6, 0, 5, 0, 0, 7, 0};
//        Queue<Integer> q = new LinkedList<Integer>();
//        q.add(a[0]);
//        int i = 1;
////
////        for (int i = 0; i < a.length; i++){
////            q.add(a[i]);
////        }
//
//        Node node;
//        while (!q.isEmpty()){
//
//
//        }
//        Node root = bt.getNextNode(q);
//        bt.buildTree(root, q, a);
//        System.out.println(root);
//        Node dll = bt.bToDLL(root);
//    }
//
//    private void buildTree(Node root,Queue<Integer> q, int[] a, int i) {
//        if (!q.isEmpty()) {
//            q.add(a[i++]);
//            q.add(a[i++]);
//
//            if (root.left != null) {
//                buildTree(root.left, q, a);
//            }
//            if (root.right != null) {
//                buildTree(root.right, q);
//            }
//        }
//    }
//
//    private Node getNextNode(Queue<Integer> q){
//        if (q.isEmpty()){
//            return null;
//        }
//        int x = q.poll();
//        if (x == 0) {
//            return null;
//        }
//       return new Node(x);
//    }
//
//}
