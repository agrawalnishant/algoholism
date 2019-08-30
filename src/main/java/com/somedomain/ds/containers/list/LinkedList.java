package com.somedomain.ds.containers.list;

import lombok.Data;

@Data
public class LinkedList<T> implements List<T> {
    private ListNode<T> headNode;
    private int count;


    @Override
    public int insert(T element) {
        int responseCode = ELEMENT_NOT_ADDED;
        if (element != null) {
            ListNode<T> newListNode = new ListNode<>(element, null);
            if (headNode == null) {
                headNode = newListNode;
            } else {
                ListNode<T> nextNode = headNode;
                while (nextNode.getNextNode() != null) {
                    nextNode = nextNode.getNextNode();
                }
                nextNode.setNextNode(newListNode);
            }
            responseCode = ++count;
        }
        return responseCode;
    }

    @Override
    public int insertAtPosition(final T element, final int position) {
        int responseCode = ELEMENT_NOT_ADDED;
        if (element != null && position > 0) {
            ListNode<T> newListNode = new ListNode<>(element, headNode);
            if (position == 1) {
                newListNode.setNextNode(headNode);
                headNode = newListNode;
            } else {
                ListNode<T> nodeBefore = headNode;
                for (int counter = 2; counter < position; counter++) {
                    nodeBefore = nodeBefore.getNextNode();
                }
                newListNode.setNextNode(nodeBefore.getNextNode());
                nodeBefore.setNextNode(newListNode);
            }
            responseCode = ++count;
        }
        return responseCode;
    }

    @Override
    public int insertFirst(T element) {
        return 0;
    }

    @Override
    public int insertLast(T element) {
        return 0;
    }

    @Override
    public int delete(T element) {
        return 0;
    }

    @Override
    public int deleteAtPosition(int position) {
        return 0;
    }

    @Override
    public int deleteFirst() {
        return 0;
    }

    @Override
    public int deleteLast() {
        return 0;
    }

    @Override
    public T get(final int position) {
        ListNode<T> targetNode = null;

        if (position > 0 && position <= count) {
            int positionCounter = 1;
            targetNode = headNode;
            while (positionCounter++ < position) {
                targetNode = targetNode.getNextNode();
            }
        }
        return targetNode.getElement();
    }

    @Override
    public int findFirstIndexOf(T element) {
        return 0;
    }

    @Override
    public void reset() {
        headNode = null;
        count = 0;
    }

    private ListNode<T> findElementBefore(final T element) {
        ListNode<T> nextNode = null;
        if (element != null) {
            nextNode = headNode;
            while (nextNode != null) {
                if (element == nextNode.getElement()) {
                    break;
                } else {
                    nextNode = nextNode.getNextNode();
                }
            }
        }
        return nextNode;
    }


    public int getCount() {
        return count;
    }

}