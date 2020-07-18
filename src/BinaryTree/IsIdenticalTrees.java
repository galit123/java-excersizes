package BinaryTree;

import BinaryTree.Node;

public class IsIdenticalTrees {
    // Given two binary trees, the task is to find if both of them are identical or not.
    boolean isIdentical(Node root1, Node root2)
    {
        if ((root1 == null) && (root2 == null)){
            return true;
        }
        if ((root1 == null) || (root2 == null)){
            return false;
        }
        if (root1.value == root2.value){
            return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
        }
        return false;
   }
}
