package Algorithms;

public class HasBinaryTree {

    public static void main(String[] args) {
        int[] post = new int[] { 3, 10, 48, 13, 63, 21, 52, 37 };
        int[] in = new int[] { 3, 48, 10, 13, 37, 63, 52, 21 };

        System.out.println(hasBinaryTree(post, 0, in, 0, post.length));
    }

    public static boolean hasBinaryTree(int[] P, int j, int[] I, int i, int m) {
        if (m == 0) {
            return true;
        }
        if (m == 1) {
            return P[j] == I[i];
        }
        int rootPos = isRoot(P[j + m - 1], I, i, m);
        if (rootPos == -1) {
            return false;
        }
        // Whether the left subtree and right subtree are a binary tree.
        return hasBinaryTree(P, j, I, i, rootPos - i) && hasBinaryTree(P,
                j + rootPos - i, I, rootPos + 1, m - (rootPos - i) - 1);
    }

    public static int isRoot(int root, int[] I, int i, int m) {
        while (m > 0) {
            if (I[i] == root)
                return i;
            ++i;
            --m;
        }
        return -1;
    }
}
