package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    public void testSingleCommon() {
        List l1 = Arrays.asList(1, 2, 3);
        List l2 = Arrays.asList(1, 4, 5);
        List l3 = Arrays.asList(1, 6 ,8);

        assertEquals(App.findCommonElements(l1, l2, l3), Arrays.asList(1));
    }

    public void testMultipleCommon() {
        List l1 = Arrays.asList(1, 2, 3);
        List l2 = Arrays.asList(1, 4, 2);
        List l3 = Arrays.asList(1, 2 ,8);

        assertEquals(App.findCommonElements(l1, l2, l3), Arrays.asList(1, 2));
    }

    public void testNoCommon() {
        List l1 = Arrays.asList(1, 2, 3);
        List l2 = Arrays.asList(1, 4, 5);
        List l3 = Arrays.asList(6, 6 ,8);

        assertTrue(App.findCommonElements(l1, l2, l3).size() == 0);
    }

    public void testMultipleUniqueCommon() {
        List l1 = Arrays.asList(1, 2, 3, 2, 1, 1);
        List l2 = Arrays.asList(1, 4, 5, 1, 1, 2, 2);
        List l3 = Arrays.asList(1, 6, 2, 2, 8, 1, 1);
        assertEquals(App.findCommonElements(l1, l2, l3), Arrays.asList(1, 2, 2, 1, 1));
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

        assertEquals(App.findCommonElements(l1, l2, l3), Arrays.asList(1, 1, 1, 2));
    }

    public void testNegative() {
        List l1 = Arrays.asList(1, 2, 3, 1, 1, 2, -5);
        List l2 = Arrays.asList(1, 4, -5, 5, 1, 2, 1, -5);
        List l3 = Arrays.asList(-5, 1, 6 ,8, 1, 1, 2);

        assertEquals(App.findCommonElements(l1, l2, l3), Arrays.asList(-5, 1, 1, 1, 2));        
    }

}

