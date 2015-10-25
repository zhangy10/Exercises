package Algorithms;

public class TreeHelper {

    static class StackNode {
        public Node item;
        public StackNode next;

        public StackNode(Node val) {
            item = val;
        }

    }

    static class LinkedListStack {
        private StackNode first;

        public LinkedListStack() {
            first = null;
        }

        public boolean isEmpty() {
            return (first == null);
        }

        public void insert(Node key)// inserts at beginning of list
        {
            StackNode newLLNode = new StackNode(key);
            newLLNode.next = first;
            first = newLLNode;
        }

        public Node delete()// deletes at beginning of list
        {
            StackNode temp = first;
            first = first.next;
            return temp.item;
        }
    }

    static class Stack {
        private LinkedListStack listObj;

        public Stack() {
            listObj = new LinkedListStack();
        }

        public void push(Node num) {
            listObj.insert(num);
        }

        public Node pop() {
            return listObj.delete();
        }

        public boolean isEmpty() {
            return listObj.isEmpty();
        }
    }

    /**
     * To display a AVL Tree as a diagram.
     * 
     */
    public static void displayTree(Node root) {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int emptyLeaf = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "+------------------------------------------------------------+");
        while (isRowEmpty == false) {

            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < emptyLeaf; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                Node temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getValue());
                    localStack.push(temp.getLeft());
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null || temp.getRight() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < emptyLeaf * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            emptyLeaf /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println(
                "+------------------------------------------------------------+");
    }

    /**
     * To count the number of subtrees
     * 
     */
    public static int count(Node root) {
        if (root == null)
            return 0;
        else
            return count(root.getLeft()) + count(root.getRight()) + 1;
    }

    /**
     * To find the Kth maximum value in an AVL tree.
     * 
     */
    public static int maxByKth(Node root, int k) {
        if (root == null)
            return -1;
        int right = count(root.getRight());

        if (k == right + 1)
            return root.getValue();
        else if (right < k)
            return maxByKth(root.getLeft(), k - right - 1);
        else
            return maxByKth(root.getRight(), k);
    }

    /**
     * To find the Kth minimum value in an AVL tree.
     * 
     */
    public static int minByKth(Node root, int k) {
        if (root == null)
            return -1;

        int left = count(root.getLeft());
        if (k == left + 1)
            return root.getValue();
        else if (left < k)
            return minByKth(root.getRight(), k - left - 1);
        else
            return minByKth(root.getLeft(), k);
    }

    /**
     * To find the second smallest value in an AVL tree.
     * 
     */
    public static int secondSmallest(Node node) {
        if (node == null) {
            return -1;
        }
        int left = count(node.getLeft());
        if (left == 0)
            return node.getRight().getValue();
        else if (left == 1)
            return node.getValue();
        else
            return secondSmallest(node.getLeft());
    }

    /* Use a instance variable to hold the reference of a parent node */
    private static Node parentNode;

    /**
     * Alternative way to find the second smallest value in an AVL tree without
     * counting the number of subtrees.
     * 
     */
    public static int findSecondSmallest(Node node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return parentNode.getValue();
        }
        else if (node.getLeft() == null) {
            return node.getRight().getValue();
        }
        else if (node.getRight() == null) {
            return node.getValue();
        }
        parentNode = node;
        return findSecondSmallest(node.getLeft());
    }

    /**
     * Thirdly, non-recursive way to find the second smallest value in an AVL
     * tree
     * 
     */
    public static int getSecondSmallest(Node node) {
        Node parentNode = null;
        while (node.getLeft() != null) {
            parentNode = node;
            node = node.getLeft();
        }

        if (node.getRight() == null) {
            return parentNode.getValue();
        }
        return node.getRight().getValue();
    }
}
