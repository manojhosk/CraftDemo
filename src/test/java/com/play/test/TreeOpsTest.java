package com.play.test;


import com.play.TreeNodeOps;
import org.junit.Assert;
import org.junit.Test;

import com.play.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TreeOpsTest {

    public TreeNode setCustomTreeNode() {
        /*
                 1
               /   \
              2      3
             / \      \
            4   5      6
                      /
                     7
         */

        TreeNode l2_Lleft = new TreeNode(4, null, null);
        TreeNode l2_Lright = new TreeNode(5, null, null);


        TreeNode l3_Rleft = new TreeNode(7, null, null);
        TreeNode l2_Rright = new TreeNode(6, l3_Rleft, null);


        TreeNode l1_left = new TreeNode(2, l2_Lleft, l2_Lright);
        TreeNode l1_right = new TreeNode(3, null, l2_Rright);

        TreeNode root = new TreeNode(1, l1_left, l1_right);

        return root;
    }

    public TreeNode setUpSimpleTreeNode() {
        /*
                 1
               /   \
              2      3
             / \    / \
            4   5   6  7

         */

        TreeNode l2_Lleft = new TreeNode(4, null, null);
        TreeNode l2_Lright = new TreeNode(5, null, null);

        TreeNode l2_Rleft = new TreeNode(6, null, null);
        TreeNode l2_Rright = new TreeNode(7, null, null);


        TreeNode l1_left = new TreeNode(2, l2_Lleft, l2_Lright);
        TreeNode l1_right = new TreeNode(3, l2_Rleft, l2_Rright);

        TreeNode root = new TreeNode(1, l1_left, l1_right);

        return root;
    }

    @Test
    public void testNullInput() {
        int toDelete = 1;
        Assert.assertNull(TreeNodeOps.removeNode(null, toDelete));
    }

    @Test
    public void testNoDeletes() {
        TreeNode root = setUpSimpleTreeNode();
        int toDelete = 100;
        List<TreeNode> result = TreeNodeOps.removeNode(root, toDelete);

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void testDeleteRoot() {
        TreeNode root = setCustomTreeNode();
        int toDelete = 1;
        List<TreeNode> results = TreeNodeOps.removeNode(root, toDelete);

        Assert.assertEquals(2, results.size());
        for (TreeNode node : results) {
            boolean expected = node.getVal() == 2 || node.getVal() == 3;
            Assert.assertTrue(expected);
        }
    }

    @Test
    public void testInnerNode() {
        TreeNode root = setCustomTreeNode();
        int toDelete = 2;
        List<TreeNode> results = TreeNodeOps.removeNode(root, toDelete);

        Set<Integer> expectedValues = new HashSet<>();
        expectedValues.add(4);
        expectedValues.add(5);
        expectedValues.add(1);

        Assert.assertEquals(3, results.size());
        for (TreeNode node : results) {
            Assert.assertTrue(expectedValues.contains(node.getVal()));
            expectedValues.remove(node.getVal());
        }
    }

    @Test
    public void testLeafNode() {
        TreeNode root = setCustomTreeNode();
        int toDelete =  7;
        List<TreeNode> results = TreeNodeOps.removeNode(root, toDelete);
        Assert.assertEquals(1, results.size());

    }

    @Test
    public void testMultipleNodes() {
        TreeNode root = setCustomTreeNode();
        int[] toDelete = {5, 3};
        List<TreeNode> results = TreeNodeOps.removeNodes(root, toDelete);

        Set<Integer> expectedValues = new HashSet<>();
        expectedValues.add(1);
        expectedValues.add(6);

        Assert.assertEquals(2, results.size());
        for (TreeNode node : results) {
            Assert.assertTrue(expectedValues.contains(node.getVal()));
            expectedValues.remove(node.getVal());
        }
    }

    @Test
    public void testDeleteAllNodes() {
        TreeNode root = setCustomTreeNode();
        int[] toDelete = {1, 2, 3, 4, 5, 6, 7};
        List<TreeNode> results = TreeNodeOps.removeNodes(root, toDelete);


        Assert.assertEquals(0, results.size());

    }


}
