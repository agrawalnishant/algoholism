package com.somedomain.ds.dictionaries.tree;

import com.google.common.flogger.FluentLogger;
import com.somedomain.ds.containers.stack.ArrayBackedStack;
import com.somedomain.ds.containers.stack.Stack;

import java.util.Arrays;

public abstract class AbstractBinarySearchTree {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public AbstractBinarySearchTree() {
        super();
    }

    public static int calculateDepth(Node startingNode) {

        if (startingNode == null) {
            return 0;
        } else if (startingNode.left() == null && startingNode.right() == null) {
            return 1;
        } else {

            int delthOfLeftSubtree = calculateDepth(startingNode.left());
            int delthOfRightSubtree = calculateDepth(startingNode.right());

            return 1 + Math.max(delthOfLeftSubtree, delthOfRightSubtree);
        }

    }

    protected static Node createInorderList(Node currentNode) {

        return currentNode;
    }

    private static void inorderNonRecur(Node root) {
        Stack<Node> bufferStack = new ArrayBackedStack<Node>(Node.class, 1000);
        while (true) {
            while (root != null) {
                //logger.atFine().log(root);
                bufferStack.push(root);
                root = root.left();
            }
            if (bufferStack.isEmpty()) {
                break;
            }
            Node aNode = bufferStack.pop();
            if (aNode != null) {
                logger.atFine().log("" + aNode);
                root = aNode.right();
            }
        }

    }

    public static void setInorder(Node node, Node[] array, int pos) {

        if (node == null) {
            return;
        }

        setInorder(node.left(), array, 2 * pos + 1);

        
        array[pos] = node;
        logger.atFine().log("Till Now : " + Arrays.asList(array));

        setInorder(node.right(), array, 2 * pos + 2);

    }

    static void preorder(Node node) {

        if (node == null) {
            return;
        }

        logger.atFine().log("[K:" + node.key() + ", V:" + node.getData() + "]");

        preorder(node.left());

        preorder(node.right());

    }

    static void inorder(Node node) {

        if (node == null) {
            return;
        }

        inorder(node.left());

        logger.atFine().log("[K:" + node.key() + ", V:" + node.getData() + "]");

        inorder(node.right());

    }

    static void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left());

        inorder(node.right());

        logger.atFine().log("[K:" + node.key() + ", V:" + node.getData() + "]");

    }

    public void traverse(BinarySearchTree.RecursiveTraversal mode) {

        switch (mode) {

            case INORDER:
                logger.atFine().log("\n Inorder \n");
                inorder(getRoot());
                break;

            case PREORDER:
                logger.atFine().log("\n PREORDER \n");
                preorder(getRoot());
                break;

            case POSTORDER:
                logger.atFine().log("\n POSTORDER \n");
                postorder(getRoot());
                break;

            default:
                break;
        }
    }

    public void traverse(BinarySearchTree.NonRecursiveTraversal mode) {

        switch (mode) {

            case INORDER:
                logger.atFine().log("\n Inorder NonRecursive \n");
                inorderNonRecur(getRoot());
                break;
            /*
             * case PREORDER: logger.atFine().log("\n PREORDER \n"); preorderNonRecur(getRoot()); break;
             *
             * case POSTORDER: logger.atFine().log("\n POSTORDER \n"); postorderNonRecur(getRoot()); break;
             */

            default:
                break;
        }
    }

    /**
     * Find the node having required key. If not found, then return a node having null value / data , but not-null parent.
     *
     * @param key
     * @return node with its parent.
     */
    public Node find(Node input) {
        int key = input.key();

        Node next = getRoot();

        while (next != null && next.key() != key) {

            if (key < next.key()) {
                next = next.left();
            } else {
                next = next.right();
            }

        }

        return next;
    }

    /**
     * Inserts input node at appropriate position.
     *
     * @param input
     */
    public void insert(Node input) {

        if (getRoot() == null) {
            setRoot(input);
            setDepth(0);
            input.setLevel(0);
        } else {

            // Start at root.
            int key = input.key();
            Node targetPos = getRoot();
            Node parent = targetPos;

            // Find the appropriate parent for target position.
            while (targetPos != null) {
                parent = targetPos;

                if (key < targetPos.key()) {
                    targetPos = targetPos.left();
                } else {
                    targetPos = targetPos.right();
                }

            }

            // Now see if this new node has to be left or right child.
            if (key < parent.key()) {
                parent.setLeft(input);
                input.setLevel(parent.getLevel() + 1);
            } else {
                parent.setRight(input);
                input.setLevel(parent.getLevel() + 1);
            }

            input.setParent(parent);

            // Update deplth on each insertion.
            // Change depth only if parent has no previous child and if parent's level is not less than tree's existing depth.
            if (((parent.left() != null && parent.right() == null) || (parent.left() == null && parent.right() != null)) && getDepth() <= parent.getLevel()) {
                setDepth(getDepth() + 1);
            }

        }
        setTotalNodes(getTotalNodes() + 1);

    }

    public void delete(Node input) {

        // If the node is root, set root to null.
        if (input == getRoot()) {
            setRoot(null);
        }

        int key = input.key();

        // Find the node to be deleted.
        Node current = getRoot();
        Node parent = current;
        boolean isLeftChild = false;

        while (current != null && current.key() != key) {

            parent = current;

            if (key < current.key()) {
                isLeftChild = true;
                current = current.left();
            } else {
                isLeftChild = false;
                current = current.right();
            }

        }

        // Return if node is not found.
        if (current == null) {
            return;
        }

        int childCount = (current.left() != null ? 1 : 0);
        childCount += (current.right() != null ? 1 : 0);

        switch (childCount) {

            // If no child
            case 0:

                if (isLeftChild) {
                    parent.setLeft(null);
                } else {
                    parent.setRight(null);
                }

                break;

            // If one child
            case 1:
                if (current.left() != null) { // if target node to be deleted had a left child
                    if (current == getRoot()) { // imp check.
                        setRoot(current.left());
                    } else if (isLeftChild) { // and was itself left child
                        parent.setLeft(current.left());
                    } else {// or was itself right child
                        parent.setRight(current.left());
                    }

                } else if (current.right() != null) { // if target node to be deleted had a right child
                    if (current == getRoot()) {
                        setRoot(current.right());
                    } else if (isLeftChild) {
                        parent.setLeft(current.right());
                    } else {
                        parent.setRight(current.right());
                    }
                }

                break;

            // If both child
            case 2: {

                Node successor = getSuccessor(current);

                if (current == getRoot()) {
                    setRoot(successor);
                } else if (isLeftChild) {
                    parent.setLeft(successor);
                } else {
                    parent.setRight(successor);
                }

                successor.setLeft(current.left());

            }
        }

        // Update depth on each deletion.
        // Change depth only if parent has no previous child and if parent's level is not less than tree's existing depth.
        if ((parent.left() == null && parent.right() == null) && getDepth() <= parent.getLevel()) {
            setDepth(getDepth() + 1);
        }

    }

    public abstract Node getSuccessor(Node current);

    public Node[] displayAsInorderArray() {

        Node[] treeAsArray = new Node[(new Double(Math.pow(2, getDepth() + 1)).intValue() - 1)];
        Node next = getRoot();
        setInorder(next, treeAsArray, 0);
        return treeAsArray;

    }

    public Node getAsInorderLinkedList() {

        Node headOfList = createInorderList(getRoot());
        return headOfList;

    }

    /**
     * @return the root
     */
    public abstract Node getRoot();

    public abstract void setRoot(Node input);

    public abstract int getTotalNodes();

    public abstract void setTotalNodes(int totalNodes);

    public abstract int getDepth();

    public abstract void setDepth(int depth);

    public enum RecursiveTraversal {
        INORDER, PREORDER, POSTORDER

    }

    public enum NonRecursiveTraversal {
        INORDER, PREORDER, POSTORDER

    }

}