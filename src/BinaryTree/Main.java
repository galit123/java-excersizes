package BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        printTree(bt);

        System.out.println("Is 1 found in tree = " + bt.isFound(1));
        System.out.println("Is 5 found in tree = " + bt.isFound(5));
        System.out.println("Is 2 found in tree = " + bt.isFound(2));
        System.out.println("Is 6 found in tree = " + bt.isFound(6));
        System.out.println("Is 11 found in tree = " + bt.isFound(11));

        System.out.println("Delete 6");

        bt.delete(6);
        printTree(bt);

        System.out.println("Delete 5");

        bt.delete(5);
        printTree(bt);

    }

    private static void printTree(BinaryTree bt){
        bt.printInOrder();
        bt.printPreOrder();
        bt.printPostOrder();
        bt.printInLevel();

    }
}
