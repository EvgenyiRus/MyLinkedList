package com.example.one;

public interface MyLinkedList<T extends Comparable<T>> {
    MyLinkedListImpl<T> add(T value, MyLinkedListImpl<T> list);

    MyLinkedListImpl<T> removeByValue(T value, MyLinkedListImpl<T> list);

    MyLinkedListImpl<T> quickSort(MyLinkedListImpl<T> list, int begin, int end);
}
