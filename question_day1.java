import java.util.*;
import ds_v1.BinaryTree.TreeNode;
// passed 289/289 testcases
public class question_day1 {
    public static boolean isSymmetric(TreeNode<Integer> root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode<Integer> a, TreeNode<Integer> b) {
        if (a == null || b == null) return a == b;           // both null -> true, one null -> false
        if (!Objects.equals(a.data, b.data)) return false;    // compare node values
        // Mirror: left of a vs right of b, right of a vs left of b
        return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}
