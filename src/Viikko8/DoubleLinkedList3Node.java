package Viikko8;

// DoubleLinkedList3Node.java SJ
// two-directional implementation of linked list

// package List;

import java.lang.NullPointerException;

public class DoubleLinkedList3Node<E> {

    protected DoubleLinkedList3Node<E> prev;
    protected DoubleLinkedList3Node<E> next;
    protected E element;

    public static final DoubleLinkedList3Node EOL = null;

    protected DoubleLinkedList3Node(E x) {
        prev = EOL;
        next = EOL;
        element = x;
    }


    public DoubleLinkedList3Node<E> getPrev() {
        return prev;
    }

    public DoubleLinkedList3Node<E> getNext() {
        return next;
    }

    public E getElement() {
        return element;
    }


}

