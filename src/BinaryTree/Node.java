package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "{" + value + "}";
    }
    private static List<Node> alreadyPrinted = new LinkedList<Node>();

    public void printTree() {
        alreadyPrinted.clear();
        this.print();
        System.out.println();
    }
    private void print(){
        if (alreadyPrinted.contains(this)){
            return;
        }
        alreadyPrinted.add(this);
        System.out.print(value +  ".left = ");
        System.out.println(left == null? "null ": left.value);

        System.out.print(value +  ".right = ");
        System.out.println(right == null? "null ": right.value);

        if (left != null){
            left.print();
        }

        if (right != null){
            right.print();
        }
    }
}
