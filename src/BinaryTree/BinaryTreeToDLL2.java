package BinaryTree;

public class BinaryTreeToDLL2 {
    // head --> Pointer to head node of created doubly linked list
    Node head;

    // Initialize previously visited node as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls
    static Node prev = null;
    public Node bToDLL(Node root) {
        head = null;
        prev = null;
        BinaryTree2DoubleLinkedList(root);
        return head;
    }
    // A simple recursive function to convert a given Binary tree
    // to Doubly Linked List
    // root --> Root of Binary Tree
    void BinaryTree2DoubleLinkedList(Node root)
    {
        // Base case
        if (root == null)
            return;

        // Recursively convert left subtree
        BinaryTree2DoubleLinkedList(root.left);

        // Now convert this node
        if (prev == null)
            head = root;
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        // Finally convert right subtree
        BinaryTree2DoubleLinkedList(root.right);
    }

    /* Function to print nodes in a given doubly linked list */
    static void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.value + " ");
            node = node.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTreeToDLL2 bt = new BinaryTreeToDLL2();
        ConstractBinaryTreeFromArray c = new ConstractBinaryTreeFromArray();
        int[] a = {10, 12, 15, 25, 30, 36 };
        Node root = c.constractBinaryTree(a);
        Node res = bt.bToDLL(root);
        BinaryTreeToDLL2.printList(res);


        int[] b = {'1', '2', '3', 'N', 'N', '4', '6', 'N', '5', 'N', 'N', '7', 'N'};

        root = c.constractBinaryTree(b);
        res = bt.bToDLL(root);
        BinaryTreeToDLL2.printList(res);


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
        res = bt.bToDLL(root);
        BinaryTreeToDLL2.printList(res);

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
        res = bt.bToDLL(root);
        BinaryTreeToDLL2.printList(res);

    }

}
