package com.example.one;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyLinkedListTest<T extends Comparable<T>> {

    static MyLinkedListImpl<Integer> LIST = new MyLinkedListImpl<>();
    static MyLinkedListImpl<Integer> QUICK_SORT_LIST = new MyLinkedListImpl<>();

    @BeforeAll
    static void init() {
        LIST.add(55, LIST);
        LIST.add(5, LIST);
        LIST.add(3, LIST);
        LIST.add(22, LIST);
        LIST.add(1, LIST);
        LIST.add(0, LIST);

        QUICK_SORT_LIST.add(0, QUICK_SORT_LIST);
        QUICK_SORT_LIST.add(1, QUICK_SORT_LIST);
        QUICK_SORT_LIST.add(3, QUICK_SORT_LIST);
        QUICK_SORT_LIST.add(5, QUICK_SORT_LIST);
        QUICK_SORT_LIST.add(22, QUICK_SORT_LIST);
        QUICK_SORT_LIST.add(55, QUICK_SORT_LIST);
    }

    @Test
    void add() {
        LIST.add(105, LIST);
        Assertions.assertEquals(LIST.get(LIST.size - 1, LIST), new Node<>(105));
        Assertions.assertSame(7, LIST.size);
        Assertions.assertNull(LIST.get(LIST.size - 1, LIST).getNext());
        Assertions.assertNotNull(LIST.get(LIST.size - 1, LIST).getPrevious());
    }

    @Test
    void removeByValue() {
        var value = LIST.get(1, LIST).item;
        LIST.removeByValue(value, LIST);
        Assertions.assertSame(6, LIST.size);
    }

    @Test
    void getNotExistElement() {
        Assert.assertThrows(IllegalArgumentException.class, () -> LIST.get(LIST.size + 1, LIST));
    }

    @Test
    void quickSort() {
        LIST = LIST.quickSort(LIST, 0, LIST.size - 1);
        Assert.assertEquals(QUICK_SORT_LIST, LIST);
    }
}