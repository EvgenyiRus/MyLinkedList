package com.example.one;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class MyLinkedListImpl<T extends Comparable<T>> implements MyLinkedList<T> {
    int size;
    Node<T> currentNode;

    @Override
    public MyLinkedListImpl<T> add(T value, MyLinkedListImpl<T> list) {
        Node<T> newNode = new Node<>(value);
        if (list.currentNode == null) {
            list.currentNode = newNode;
        } else {
            Node<T> currentNode = list.currentNode; // текущий элемент
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            newNode.setPrevious(currentNode);
            currentNode.setNext(newNode);
        }
        ++list.size;
        return list;
    }

    @Override
    public MyLinkedListImpl<T> removeByValue(T value, MyLinkedListImpl<T> list) {
        Node<T> currentNode = list.currentNode;
        Node<T> previous = null;
        if (currentNode != null && currentNode.item == value) {
            list.currentNode = currentNode.getNext();
            return list;
        }
        while (currentNode != null && currentNode.item != value) {
            previous = currentNode;
            currentNode = currentNode.getNext();
        }
        if (currentNode != null) {
            previous.setNext(currentNode.getNext());
        }
        --list.size;
        return list;
    }

    @Override
    public MyLinkedListImpl<T> quickSort(MyLinkedListImpl<T> list, int begin, int end) {
        if (begin >= end) return null;
        int pivot = getMiddleElement(list, begin, end);
        quickSort(list, begin, pivot - 1);
        quickSort(list, pivot + 1, end);
        return list;
    }

    private int getMiddleElement(MyLinkedListImpl<T> list, int begin, int end) {
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (list.get(i, list).item.compareTo(list.get(end, list).item) < 0) {
                T temp = list.get(counter, list).item;
                list.get(counter, list).item = list.get(i, list).item;
                list.get(i, list).item = temp;
                counter++;
            }
        }
        T temp = list.get(end, list).item;
        list.get(end, list).item = list.get(counter, list).item;
        list.get(counter, list).item = temp;
        return counter;
    }

    public Node<T> get(int index, MyLinkedListImpl<T> list) {
        if (index > list.size || index < 0) {
            throw new IllegalArgumentException();
        }
        MyLinkedListImpl<T> tempList = new MyLinkedListImpl<>(list.size, list.currentNode);
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                return tempList.currentNode;
            }
            tempList.currentNode = tempList.currentNode.getNext();
        }
        return null;
    }

    public void set(int index, Node<T> node, MyLinkedListImpl<T> list) {
        if (index > list.size || index < 0) {
            throw new IllegalArgumentException();
        }
        MyLinkedListImpl<T> tempList = new MyLinkedListImpl<>(list.size, list.currentNode);
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                Node<T> currentNode = tempList.get(i, tempList);
                node.setNext(currentNode.getNext());
                node.setPrevious(currentNode.getPrevious());
                currentNode.setItem(node.item);
                break;
            }
        }
    }

    @Override
    public String toString() {
        Node<T> head = currentNode;
        StringBuilder result = new StringBuilder();
        while (currentNode != null) {
            result.append(currentNode.item).append(",");
            currentNode = currentNode.getNext();
        }
        currentNode = head;
        return result.delete(result.length() - 1, result.length()).toString();
    }
}
