package com.somedomain.ds.containers.list;

public interface List<T> {

    int NO_HOPE = -1;

    int insert(final T element);

    int insertFirst(final T element);

    int delete(final T element);

    int deleteFirst();

    T get(final int position);

    int findFirstIndexOf(final T element);

    T findElementBefore(final T element);

    void reset();

}
