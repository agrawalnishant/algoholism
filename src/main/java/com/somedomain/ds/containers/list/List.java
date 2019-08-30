package com.somedomain.ds.containers.list;

public interface List<T> {

    final static int ELEMENT_NOT_ADDED = -1;

    int insert(final T element);
    int insertAtPosition(final T element, final int position);
    int insertFirst(final T element);
    int insertLast(final T element);

    int delete(final T element);
    int deleteAtPosition(final int position);
    int deleteFirst();
    int deleteLast();

    T get(final int position);
    int findFirstIndexOf(final T element);

    void reset();

}
