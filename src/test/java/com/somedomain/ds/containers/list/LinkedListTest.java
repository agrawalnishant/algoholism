package com.somedomain.ds.containers.list;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTest {

    LinkedList<String> stringLinkedList;

    @BeforeEach
    void setUp() {
        stringLinkedList = new LinkedList<>();
    }

    @AfterEach
    void destruct() {
        stringLinkedList.reset();
    }

    @Test
    void insert() {
        stringLinkedList.insert("A");
        assertEquals(1, stringLinkedList.getCount());
    }

    @Test
    void insertAtPosition() {
        stringLinkedList.insert("A");
        stringLinkedList.insert("B");
        stringLinkedList.insertAtPosition("C", 1);
        System.out.println(stringLinkedList);
        assertEquals("C", stringLinkedList.get(1));
        assertEquals("A", stringLinkedList.get(2));
        assertEquals("B", stringLinkedList.get(3));
    }

    @Test
    void getCount() {
        //stringLinkedList.insert("A");
        //stringLinkedList.insert("B");
       // assertEquals(2, stringLinkedList.getCount());
    }
}