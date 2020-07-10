package BinaryTree;

import java.util.Objects;

public class Node {
    public char value;
    public Node left;
    public Node right;

    public Node(char value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
