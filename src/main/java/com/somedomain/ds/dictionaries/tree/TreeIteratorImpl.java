package com.somedomain.ds.dictionaries.tree;

public class TreeIteratorImpl implements TreeIterator {

    private final Node[] stackOfNodes;
    private final AbstractBinarySearchTree tree;
    private Integer stackPointer;
    private final Integer itrCount = 0;

    public TreeIteratorImpl(final AbstractBinarySearchTree tree) {
        this.tree = tree;
        stackOfNodes = new Node[tree.getDepth()];
        stackPointer = tree.getDepth();
    }

    @Override
    public Node next() {

        return next(tree.getRoot());

    }

    private Node next(Node node) {

        //If stack is empty, then iterate over child
        if (stackPointer == stackOfNodes.length) {

            //If
            if (itrCount == 0 && node.left() != null) {
                stackOfNodes[stackPointer--] = node;
            }

            return next(node.left());
        }

        return null;
    }

    @Override
    public Boolean hasNext() {
        // TODO Auto-generated method stub
        return null;
    }

}
