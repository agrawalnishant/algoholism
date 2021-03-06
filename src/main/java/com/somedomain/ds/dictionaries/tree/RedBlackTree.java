package com.somedomain.ds.dictionaries.tree;

import com.google.common.flogger.FluentLogger;

public class RedBlackTree extends BinarySearchTree {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    private Node root;

    @Override
    public void insert(Node node) {
        int key = node.key();

        // Find insertion position.

        if (root == null) {
            root = node;
            node.setRed(false);
        } else {
            boolean isLeftNode = false;
            Node parent = root;
            Node current = root;
            Node nextLeft = current.left();
            Node nextRight = current.right();

            while (current != null) {
                parent = current;
                nextLeft = current.left();
                nextRight = current.right();

                if (key < current.key()) {
                    current = nextLeft;
                } else {
                    current = nextRight;

                }

            }

            // Check if null child is on left or right of parent.
            if (key < parent.key()) {

                parent.setLeft(node);
                isLeftNode = true;
            } else {
                parent.setRight(node);
                isLeftNode = false;
            }
            node.setParent(parent);

            // Traverse way up and perform flips and rotations.
            if (root != node) {
                reBalance(node);
            }

        }

    }

    private void reBalance(Node current) {

        logger.atFine().log("Balancing tree at current: " + current.key());
        Node parent = current.parent();

        if (current == root) {
            logger.atFine().log("Current is root. Setting it as black.");
            current.setRed(false);
            return;
        }

        // Re-balance only if current and parent are both red.
        if (parent.isRed()) {
            logger.atFine().log("Parent: " + parent.key() + " is red.");
            Node grandParent = parent.parent();

            if (grandParent != null) {
                Node uncle = null;
                if (parent == grandParent.left()) {
                    uncle = grandParent.right();
                } else if (parent == grandParent.right()) {
                    uncle = grandParent.left();
                }

                // If parent and uncle are both RED, then set parent,
                // uncle as BLACK, and grandparent as RED, and re-balance GP.

                if (uncle != null && uncle.isRed()) {
                    logger.atFine().log("Uncle: " + uncle.key() + " is also red.");
                    if (grandParent != root) {
                        grandParent.setRed(true);
                    }
                    parent.setRed(false);
                    uncle.setRed(false);
                    logger.atFine().log("Set GP: " + grandParent.key() + " to RED, and parent: " + parent.key() + ", and uncle: " + uncle.key() + " to BLACK.");
                    reBalance(grandParent);
                }

                // If uncle is black or is null, then there would be 2 cases
                // depending if current is inlined or not with grand-child.
                else {
                    // Case 1: current is not in-lined child of grandparent,
                    // perform a counter-direction rotation.

                    if (current == parent.left() && parent == grandParent.right()) {
                        logger.atFine().log("Rotate Right. GP: " + grandParent.key() + " --RIGHT --> parent: " + parent.key() + "  --LEFT--> current:" + current.key());
                        // Rotate right
                        grandParent.setRight(current);
                        parent.setLeft(current.right());
                        current.setLeft(parent);

                    } else if (current == parent.right() && parent == grandParent.left()) {
                        logger.atFine().log("Rotate Left. GP: " + grandParent.key() + " --LEFT --> parent: " + parent.key() + "  --RIGHT--> current:" + current.key());

                        // Rotate left
                        grandParent.setLeft(current);
                        parent.setRight(current.left());
                        current.setLeft(parent);
                    }

                    // If current, parent, and grand parent are inline, perform
                    // rotation at grand parent.
                    else {

                        // Switch colors of parent and grand parent.
                        logger.atFine().log("Set parent: " + parent.key() + " as Black, and GP: " + grandParent.key() + " as Red.");
                        parent.setRed(false);
                        grandParent.setRed(true);

                        Node newCurrent = grandParent;
                        Node newParent = grandParent.parent();
                        Node newGrandParent = newParent.parent();

                        if (newCurrent.isRed() && newParent.isRed()) {

                            if (newCurrent == newParent.left() && newParent == newGrandParent.left()) {
                                logger.atFine().log("GP: " + newGrandParent.key() + ", LEFT: " + newParent.key() + " , RIGHT:" + newCurrent.key());
                                // Rotate right at GP.
                                newGrandParent.setLeft(newParent.right());
                                newParent.setRight(newGrandParent);
                            } else if (newCurrent == newParent.right() && newParent == newGrandParent.right()) {
                                logger.atFine().log("Rotate Left. GP: " + newGrandParent.key() + " --LEFT --> parent: " + newParent.key() + "  --RIGHT--> current:" + newCurrent.key());

                                // Rotate left at GP.
                                newGrandParent.setRight(newParent.left());
                                newParent.setLeft(newGrandParent);
                                /*
                                 * newParent.setRight(newCurrent.left());
                                 * newCurrent.setLeft(newParent);
                                 */
                            }

                            // / Finally attach rotated nodes at correct
                            // position
                            // with great grand parent.
                            Node greatGrandParent = newGrandParent.parent();
                            if (greatGrandParent != null) {
                                logger.atFine().log("Set " + newCurrent.key() + " as child of " + newGrandParent.key());
                                if (greatGrandParent.left() == newGrandParent) {
                                    greatGrandParent.setLeft(newParent);
                                } else {
                                    greatGrandParent.setRight(newParent);
                                }
                            } else {
                                root = newParent;
                                root.setRed(false);
                            }
                        }
                    }

                }

            }
        }

        logger.atFine().log("Rotation done.");

    }

    /**
     * @return the root
     */
    @Override
    public Node getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    @Override
    public void setRoot(Node root) {
        this.root = root;
    }
}
