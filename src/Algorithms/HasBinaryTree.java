package Algorithms;

public class HasBinaryTree {

    public static void main(String[] args) {
        int[] post = new int[] { 48, 13, 63, 21, 52, 37 };
        int[] in = new int[] { 48, 13, 37, 63, 52, 21 };

        System.out.println(hasBinaryTree(post, 0, in, 0, post.length));
    }

    public static boolean hasBinaryTree(int[] post, int i, int[] in, int j,
            int size) {
        if (size == 0) {
            return true;
        }
        if (size == 1) {
            return post[i] == in[j];
        }
        int rootPos = isRoot(post[i + size - 1], in, j, size);
        if (rootPos == -1) {
            return false;
        }
        // Whether the left subtree and right subtree are a binary tree.
        return hasBinaryTree(post, i, in, j, rootPos - j) && hasBinaryTree(post,
                i + rootPos - j, in, rootPos + 1, size - (rootPos - j) - 1);
    }

    public static int isRoot(int root, int[] in, int j, int size) {
        while (size > 0) {
            if (in[j] == root)
                return j;
            ++j;
            --size;
        }
        return -1;
    }
}
