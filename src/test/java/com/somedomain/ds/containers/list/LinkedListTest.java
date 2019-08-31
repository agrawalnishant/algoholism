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
        assertEquals(1, stringLinkedList.getCurrentSize());
    }

    @Test
    void insertFirst() {
        stringLinkedList.insert("A");
        stringLinkedList.insert("B");
        stringLinkedList.insertFirst("C");
        assertEquals("C", stringLinkedList.get(1));
        assertEquals("A", stringLinkedList.get(2));
        assertEquals("B", stringLinkedList.get(3));
    }

    @Test
    void getCurrentSize() {
        stringLinkedList.insert("A");
        stringLinkedList.insert("B");
        assertEquals(2, stringLinkedList.getCurrentSize());
    }

    @Test
    void delete() {
        stringLinkedList.insert("A");
        stringLinkedList.insert("B");
        stringLinkedList.delete("B");
        System.out.println(stringLinkedList);
        assertEquals(1, stringLinkedList.getCurrentSize());
        assertEquals("A", stringLinkedList.get(1));
    }

    @Test
    void deleteFirst() {
        stringLinkedList.insert("A");
        stringLinkedList.insert("B");
        stringLinkedList.deleteFirst();
        System.out.println(stringLinkedList);
        assertEquals(1, stringLinkedList.getCurrentSize());
        assertEquals("B", stringLinkedList.get(1));
    }

    @Test
    void get() {
        stringLinkedList.insert("A");
        stringLinkedList.insert("B");
        assertEquals("B", stringLinkedList.get(2));
    }

    @Test
    void findFirstIndexOf() {
        stringLinkedList.insert("A");
        stringLinkedList.insert("B");
        stringLinkedList.insert("B");
        stringLinkedList.insert("C");
        stringLinkedList.insert("A");
        System.out.println(stringLinkedList);
        assertEquals(2, stringLinkedList.findFirstIndexOf("B"));
        assertEquals(4, stringLinkedList.findFirstIndexOf("C"));
    }

    @Test
    void findElementBefore() {
    }
}