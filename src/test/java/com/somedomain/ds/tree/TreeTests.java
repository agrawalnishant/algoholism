/**
 *
 */
package com.somedomain.ds.tree;

import com.google.common.flogger.FluentLogger;
import com.somedomain.ds.dictionaries.tree.AbstractBinarySearchTree;
import com.somedomain.ds.dictionaries.tree.AbstractBinarySearchTree.NonRecursiveTraversal;
import com.somedomain.ds.dictionaries.tree.AbstractBinarySearchTree.RecursiveTraversal;
import com.somedomain.ds.dictionaries.tree.BinarySearchTree;
import com.somedomain.ds.dictionaries.tree.Node;
import lombok.extern.flogger.Flogger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author _root_nishi
 *
 */
public class TreeTests {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    public static void main(String[] args) {
        TreeTests tests = new TreeTests();
        try {
            tests.test();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws InterruptedException {
        AbstractBinarySearchTree tree = new BinarySearchTree();
        Node root = new Node(100, "1", null);
        Node leftChild = new Node(30, "2", null);
        Node rightChild = new Node(700, "3", null);

        tree.insert(root);
        tree.insert(leftChild);
        tree.insert(rightChild);


        tree.traverse(RecursiveTraversal.PREORDER);
        tree.traverse(RecursiveTraversal.INORDER);
        tree.traverse(RecursiveTraversal.POSTORDER);

        tree.traverse(NonRecursiveTraversal.PREORDER);
        //tree.traverse(NonRecursiveTraversal.INORDER);
        //tree.traverse(NonRecursiveTraversal.POSTORDER);

        Node node = new Node(20, "4", null);
        tree.insert(node);

        node = new Node(50, "5", null);
        tree.insert(node);

        node = new Node(35, "6", null);
        tree.insert(node);

        node = new Node(60, "7", null);
        tree.insert(node);

        node = new Node(40, "8", null);
        tree.insert(node);

        node = new Node(80, "9", null);
        tree.insert(node);

        node = new Node(800, "10", null);
        tree.insert(node);
        node = new Node(801, "11", null);
        tree.insert(node);
        node = new Node(802, "13", null);
        tree.insert(node);

        node = new Node(812, "14", null);
        tree.insert(node);

        node = new Node(822, "15", null);
        tree.insert(node);

        tree.traverse(RecursiveTraversal.INORDER);

        assertEquals(tree.getDepth(), 6, "Depth should be 7 for given data, but instead it is: " + tree.getDepth());

        Node newNode = new Node(30, "8", null);
        tree.delete(newNode);
        tree.traverse(RecursiveTraversal.INORDER);

        assertEquals(tree.getDepth(), 6, "Depth should still be 7 for given data, but instead it is: " + tree.getDepth());

        newNode = new Node(822, "8", null);
        tree.delete(newNode);
        assertEquals(
                AbstractBinarySearchTree.calculateDepth(tree.getRoot()), 6, "Depth should now be 6 for given data, but instead it is: " + AbstractBinarySearchTree.calculateDepth(tree.getRoot()));

        logger.atFine().log("Depth is :" + tree.getDepth());

        Node nd = tree.getAsInorderLinkedList();
        while (nd != null) {
            logger.atFine().log(" - " + nd.key());
            nd = nd.getNextLink();
        }

    }

    /*
     * @Test public void testRedBlackTreeInsertion() { RedBlackTree rbTree = new RedBlackTree(); Node root = new Node(100, "1", null); rbTree.insert(root);
     *
     * Node node = new Node(50, "50", null); rbTree.insert(node);
     *
     * node = new Node(150, "150", null); rbTree.insert(node);
     *
     * node = new Node(20, "20", null); rbTree.insert(node);
     *
     * node = new Node(10, "10", null); rbTree.insert(node);
     *
     * }
     */

    /*
     * @Test public void testRedBlackTreeInsertion() { RedBlackTree rbTree = new RedBlackTree(); Node node = new Node(200, "200", null); rbTree.insert(node);
     *
     * node = new Node(1, "1", null); rbTree.insert(node);
     *
     * node = new Node(55, "55", null); rbTree.insert(node);
     *
     * node = new Node(100, "100", null); rbTree.insert(node);
     *
     * node = new Node(300, "300", null); rbTree.insert(node);
     *
     * node = new Node(50, "50", null); rbTree.insert(node);
     *
     * node = new Node(150, "150", null); rbTree.insert(node);
     *
     * node = new Node(20, "20", null); rbTree.insert(node);
     *
     * node = new Node(10, "10", null); rbTree.insert(node);
     *
     * rbTree.traverse(Traversal.INORDER);
     *
     * }
     */
}
