package com.acnsiq.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyListTest {
    @Test
    public void testAdd() {
        MyList myList = new MyList();
        assertEquals(10, myList.getCapacity());
        assertDoesNotThrow(() -> myList.add("hello"));
        assertEquals("hello", myList.getElements()[0]);
        assertEquals(1, myList.getSize());
        for (int i = 0; i < 10; i++) {
            int number = i;
            assertDoesNotThrow(() -> myList.add(number));
        }
        assertEquals(20, myList.getCapacity());
        assertEquals(11, myList.getSize());
    }

    @Test
    public void testReadonly() {
        MyList myReadonlyList = new MyList();
        myReadonlyList.setReadOnly(true);
        assertTrue(myReadonlyList.isReadOnly());
        assertThrows(Exception.class, () -> myReadonlyList.add("test"));
        assertThrows(Exception.class, () -> myReadonlyList.addRange("test", 1, 2, 6));
    }

    @Test
    public void testAddRange() {
        MyList myList = new MyList();
        assertDoesNotThrow(() -> myList.addRange(1, 2, 3, "test"));
        assertEquals(2, myList.getElements()[1]);
        assertDoesNotThrow(() -> myList.addRange(1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3));
        assertEquals(30, myList.getCapacity());
        assertEquals(28, myList.getSize());
    }
}
