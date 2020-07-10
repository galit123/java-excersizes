package BinaryTree;

public class GetCommonParent {

    public static Node getCommonParent(Node r, Node n1, Node n2) {
        if ((r.value < n2.value) && (r.value > n1.value)){
            return r;
        }

        if (r.value > n1.value) {
            return getCommonParent(r.left, n1, n2);
        } else {
            return getCommonParent(r.right, n1, n2);
        }
    }
//           40
//     20            60
//10       30      50        70

    public static void main(String[] args) {
        Node root = new Node('4');

        root.right = new Node('6');
        root.right.right = new Node('7');
        root.right.left = new Node('5');


        root.left = new Node('2');
        root.left.right = new Node('3');
        root.left.left = new Node('1');

        Node node = getCommonParent(root, new Node('5'), new Node('7'));
        System.out.println(node);

        node = getCommonParent(root, new Node('2'), new Node('7'));
        System.out.println(node);

    }
}
