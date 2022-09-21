package com.play;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class is to provide capabilities of operations to be done on the TreeNode data structure
 */
public class TreeNodeOps {

    public static List<TreeNode> removeNode(TreeNode root, int toBeDeleted) {
        int[] toDelete = new int[1];
        toDelete[0] = toBeDeleted;

        return removeNodes(root, toDelete);
    }

    public static List<TreeNode> removeNodes(TreeNode root, int[] toDelete) {

        if (root == null) {
            return null;
        }

        Set<Integer> toDeleteSet = new HashSet<Integer>();
        for (int i : toDelete) {
            toDeleteSet.add(i);
        }

        List<TreeNode> remaining = new ArrayList<TreeNode>();
        performDeletes(root, remaining, toDeleteSet);

        if (!toDeleteSet.contains(root.val)) {
            remaining.add(root);
        }

        return remaining;
    }

    static TreeNode performDeletes(TreeNode root, List<TreeNode> remaining, Set<Integer> toDeleteSet) {

        if (root == null) {
            return null;
        }

        root.left = performDeletes(root.left, remaining, toDeleteSet);
        root.right = performDeletes(root.right, remaining, toDeleteSet);


        if (toDeleteSet.contains(root.val)) {
            if (root.left != null) {
                remaining.add(root.left);
            }

            if (root.right != null) {
                remaining.add(root.right);
            }

            return null;
        }

        return root;
    }
}


