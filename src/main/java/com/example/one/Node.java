package com.example.one;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    T item;
    private Node<T> next;
    private Node<T> previous;

    public Node(T item) {
        this.item = item;
        this.next = null;
        this.previous = null;
    }

    @Override
    public String toString() {
        return item.toString();
    }

    @Override
    public int compareTo(Node<T> tkNode) {
        int cmp = this.item.compareTo(tkNode.item);
        if (cmp == 0)
            cmp = this.item.compareTo(tkNode.item);
        return cmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(item, node.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }
}
