package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class IsBST {
    boolean isBST(Node root){
        List<Integer> list = new LinkedList<>();
        return isBST(root, list);
    }

    private boolean isBST(Node root, List<Integer> list) {
        if (root == null){
            return true;
        }
        if (isBST(root.left, list)) {

            if (!list.isEmpty() && list.get(list.size() - 1) >= root.value){
                return false;
            }
            list.add(root.value);

        }
        return isBST(root.right, list);
    }

    public static void main(String[] args) {
//           1
//        /     \
//       1       1
//      / \     / \
//     1   1   N   1
//    / \ / \     / \
//   1  1 1 1    N   N
        ConstractBinaryTreeFromArray c = new ConstractBinaryTreeFromArray();
        int[] a = {1, 1, 1, 1, 1, 'N', 1, 1, 1, 1, 1};
        Node t = c.constractBinaryTree(a);
        IsBST ibst = new IsBST();
//        boolean x = ibst.isBST(t);
//        System.out.println(x);

//                   3
//                  / \
//                 2   5
//               /  \
//              1    4
        int[] b = {3, 2, 5, 1, 4};
        t = c.constractBinaryTree(b);
        boolean y = ibst.isBST(t);
        System.out.println(y);

    }

}
