package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public Node root;

    private Node insert(Node current, char val){
        if (current == null){
            return new Node(val);
        }

        if (val < current.value){
            current.left = insert (current.left, val);
        } else if (val > current.value){
            current.right = insert(current.right, val);
        }

        return current;
    }

    public Node add(char val){
        root = insert(root, val);
        return root;
    }

    public void printInLevel(){
        printInLevel(root);
        System.out.println();

    }

    private void printInLevel(Node current){
        if (current == null){
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node node = queue.remove();
            System.out.print(" " + node.value + " ");
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    private void printInOrder(Node current){
        if (current == null){
            return;
        }

        printInOrder(current.left);

        System.out.print(" " + current.value + " ");

        printInOrder(current.right);

    }

    private void printPreOrder(Node current){
        if (current == null){
            return;
        }

        System.out.print(" " + current.value + " ");

        printPreOrder(current.left);

        printPreOrder(current.right);

    }

    public void printPreOrder(){
        printPreOrder(root);
        System.out.println();

    }


    public void printInOrder(){
        printInOrder(root);
        System.out.println();
    }

    public boolean isFound(int val){
        return isFound(root, val);
    }

    private boolean isFound(Node current, int val){
        if (current == null){
            return false;
        }

        if (current.value == val){
            return true;
        } else if (current.value > val) {
            return isFound(current.left, val);
        } else if (current.value < val){
            return isFound(current.right, val);
        }
        return false;

    }

    private Node delete(Node current, int val){
        if (current == null){
            return null;
        }

        if (current.value == val){
            if (current.left == null && current.right == null){
                return null;
            } else if (current.right == null){
                return current.left;
            } else if (current.left == null){
                return current.right;
            }else {
                int smallest = findSmallest(current.right);
                current.value = smallest;
                current.right = delete(current.right, smallest);
                return current;
            }

        }

        if (val < current.value) {
            current.left = delete(current.left, val);
        } else if (val > current.value){
            current.right = delete(current.right, val);
        }

        return current;

    }

    private int findSmallest(Node current){
        if (current.left == null){
            return current.value;
        } else {
            return findSmallest(current.left);
        }
    }

    public Node delete(char val){
        return delete(root, val);
    }


    public void printPostOrder() {
        printPostOrder(root);
        System.out.println();

    }

    private void printPostOrder(Node current) {
        if (current == null){
            return;
        }

        printPostOrder(current.left);
        printPostOrder(current.right);
        System.out.print(" " + current.value + " ");
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.add('6');
        bt.add('4');
        bt.add('8');
        bt.add('3');
        bt.add('5');
        bt.add('7');
        bt.add('9');

        printTree(bt);

        System.out.println("Is 1 found in tree = " + bt.isFound(1));
        System.out.println("Is 5 found in tree = " + bt.isFound(5));
        System.out.println("Is 2 found in tree = " + bt.isFound(2));
        System.out.println("Is 6 found in tree = " + bt.isFound(6));
        System.out.println("Is 11 found in tree = " + bt.isFound(11));

        System.out.println("Delete 6");

        bt.delete('6');
        printTree(bt);

        System.out.println("Delete 5");

        bt.delete('5');
        printTree(bt);

    }

    static void printTree(BinaryTree bt){
        bt.printInOrder();
        bt.printPreOrder();
        bt.printPostOrder();
        bt.printInLevel();

    }

}
