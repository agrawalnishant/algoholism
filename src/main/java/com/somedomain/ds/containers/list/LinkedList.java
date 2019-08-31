package com.somedomain.ds.containers.list;

import lombok.Data;

@Data
public class LinkedList<T> implements List<T> {
    private final ListNode<T> START_NODE = new ListNode<T>(null);

    //private ListNode<T> headNode;
    private int currentSize;

    public LinkedList() {
        START_NODE.setNextNode(null);
    }

    @Override
    public int insert(T element) {
        int responseCode = NO_HOPE;
        if (element != null) {
            ListNode<T> iteratorNode = START_NODE;
            for (int counter = 1; counter <= currentSize; counter++) {
                iteratorNode = iteratorNode.getNextNode();
            }
            iteratorNode.setNextNode(new ListNode<>(element));
            responseCode = ++currentSize;
        }
        return responseCode;
    }

    @Override
    public int insertFirst(T element) {
        int responseCode = NO_HOPE;
        if (element != null) {
            ListNode<T> newNode = new ListNode<>(element);
            ListNode<T> firstNode = START_NODE.getNextNode();
            newNode.setNextNode(firstNode);
            START_NODE.setNextNode(newNode);
            responseCode = ++currentSize;
        }
        return responseCode;
    }

    @Override
    public int delete(T element) {
        int responseCode = NO_HOPE;
        if (currentSize > 0 && element != null) {
            ListNode<T> iteratorNode = START_NODE;
            while (iteratorNode.getNextNode() != null) {
                if (iteratorNode.getNextNode().getElement() == element) {
                    iteratorNode.setNextNode(iteratorNode.getNextNode().getNextNode());
                    --currentSize;
                    break;
                } else {
                    iteratorNode = iteratorNode.getNextNode();
                }
            }
        }
        return responseCode;
    }

    @Override
    public int deleteFirst() {
        int responseCode = NO_HOPE;
        ListNode<T> firstNode = START_NODE.getNextNode();
        if (firstNode != null) {
            ListNode<T> secondNode = firstNode.getNextNode();
            if (secondNode != null) {
                START_NODE.setNextNode(secondNode);
            } else {
                START_NODE.setNextNode(null);
            }
            responseCode = --currentSize;
        }
        return responseCode;
    }

    @Override
    public T get(final int position) {
        ListNode<T> targetNode = null;
        if (position > 0 && position <= currentSize) {
            int positionCounter = 0;
            targetNode = START_NODE;
            while (positionCounter++ < position) {
                targetNode = targetNode.getNextNode();
            }
        }
        return targetNode.getElement();
    }

    @Override
    public int findFirstIndexOf(T element) {
        int responseCode = NO_HOPE;
        int counter = 1;
        if (currentSize > 0 && element != null) {
            ListNode<T> iteratorNode = START_NODE;
            while (iteratorNode.getNextNode() != null && !iteratorNode.getNextNode().getElement().equals(element)) {
                ++counter;
                iteratorNode = iteratorNode.getNextNode();
            }
            responseCode = counter;
        }

        return responseCode;
    }

    @Override
    public void reset() {
        START_NODE.setNextNode(null);
        currentSize = 0;
    }

    @Override
    public T findElementBefore(final T element) {
        boolean foundTarget = false;
        ListNode<T> iteratorNode = null;
        if (currentSize > 0 && element != null) {
            iteratorNode = START_NODE;
            while (iteratorNode.getNextNode() != null) {
                if (iteratorNode.getNextNode().getElement().equals(element)) {
                    foundTarget = true;
                    break;
                } else {
                    iteratorNode = iteratorNode.getNextNode();
                }
            }
        }
        return foundTarget == true ? iteratorNode.getElement() : null;
    }
}