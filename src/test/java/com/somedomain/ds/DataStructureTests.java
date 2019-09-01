package com.somedomain.ds;

import com.somedomain.ds.containers.queue.CircularIntQueue;
import com.somedomain.ds.dictionaries.tree.AbstractBinarySearchTree;
import com.somedomain.ds.dictionaries.tree.BinarySearchTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataStructureTests {

    public static void testInorderTraversal() {
        AbstractBinarySearchTree tree = new BinarySearchTree();
    }

    @Test
    public void testQueueAddition() {
        CircularIntQueue circularQ = new CircularIntQueue(10);
        circularQ.add('1');
        circularQ.add('2');
        circularQ.add('3');
        circularQ.add('4');
        circularQ.add('5');
        circularQ.display();
        circularQ.remove();
        circularQ.display();
        circularQ.remove();
        circularQ.display();
        circularQ.remove();
        circularQ.display();
        circularQ.remove();
        circularQ.display();
        circularQ.remove();
        circularQ.display();
        circularQ.remove();
        circularQ.display();
        circularQ.add('6');
        circularQ.add('7');
        circularQ.add('8');
        circularQ.add('9');
        circularQ.add('1');
        circularQ.display();
        circularQ.remove();
        circularQ.display();
        circularQ.add('a');
        circularQ.add('b');
        circularQ.display();
        circularQ.remove();
        String finalResult = circularQ.display();
        assertEquals(",8,9,1,a,b", finalResult, "Queue not working.");

    }

}
