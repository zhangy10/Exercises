package Learning;

public class Node {
    Node left, right;
    Node parent;
    int value;
    int height = 0;

    public Node(int data, Node parent) {
        this.value = data;
        this.parent = parent;
    }

    @Override
    public String toString() {
        // return value + " height " + height + " parent "
        // + (parent == null ? "NULL" : parent.value) + " | ";
        return value + " | ";
    }

    void setLeftChild(Node child) {
        if (child != null) {
            child.parent = this;
        }

        this.left = child;
    }

    void setRightChild(Node child) {
        if (child != null) {
            child.parent = this;
        }

        this.right = child;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public int getHeight() {
        return height;
    }
}
