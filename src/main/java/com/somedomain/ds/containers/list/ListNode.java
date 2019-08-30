package com.somedomain.ds.containers.list;

import lombok.Data;

@Data
class ListNode<T> {
    private final T element;
    private ListNode<T> nextNode;

    public ListNode(T element) {
        this(element, null);
    }

    public ListNode(T element, ListNode<T> nextNode) {
        this.element = element;
        this.nextNode = nextNode;
    }
}
