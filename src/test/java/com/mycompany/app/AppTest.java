package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    public void testSingleCommon() {
        List l1 = Arrays.asList(1, 2, 3);
        List l2 = Arrays.asList(1, 4, 5);
        List l3 = Arrays.asList(1, 6 ,8);

        assertTrue(1 == App.findCommonElements(l1, l2, l3).size());
    }

    public void testMultipleCommon() {
        List l1 = Arrays.asList(1, 2, 3);
        List l2 = Arrays.asList(1, 4, 2);
        List l3 = Arrays.asList(1, 2 ,8);

        assertTrue(2 == App.findCommonElements(l1, l2, l3).size());
    }

    public void testNoCommon() {
        List l1 = Arrays.asList(1, 2, 3);
        List l2 = Arrays.asList(1, 4, 5);
        List l3 = Arrays.asList(6, 6 ,8);

        assertTrue(0 == App.findCommonElements(l1, l2, l3).size());
    }

    public void testMultipleUniqueCommon() {
        List l1 = Arrays.asList(1, 2, 3, 1, 1);
        List l2 = Arrays.asList(1, 4, 5, 1, 1);
        List l3 = Arrays.asList(1, 6 ,8, 1, 1);

        assertTrue(3 == App.findCommonElements(l1, l2, l3).size());
    }

    public void testNull() {
        List l1 = Arrays.asList(1, 2, 3);
        List l2 = Arrays.asList(1, 4, 5);
        assertNull(App.findCommonElements(l1, l2, null));
    }

    public void testList() {
        List l1 = Arrays.asList(1, 2, 3, 1, 1, 2);
        List l2 = Arrays.asList(1, 4, 5, 1, 2, 1);
        List l3 = Arrays.asList(1, 6 ,8, 1, 1, 2);
        List l4 = Arrays.asList(1, 1, 1, 2);

        assertEquals(App.findCommonElements(l1, l2, l3), l4);
    }

}

