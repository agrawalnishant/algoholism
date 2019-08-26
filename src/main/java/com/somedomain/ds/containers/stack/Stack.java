package com.somedomain.ds.containers.stack;

public interface Stack<T> {

	public void push(T t);

	public T pop();

	public boolean isEmpty();

	public boolean isFull();

	public Integer size();


}
