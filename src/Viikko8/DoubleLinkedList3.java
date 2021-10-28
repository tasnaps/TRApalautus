package Viikko8;

// DoubleLinkedList3.java SJ
// two-directional implementation of linked list

// package List;	// store in directory List

import java.lang.NullPointerException;

public class DoubleLinkedList3<E> {

    private DoubleLinkedList3Node<E> first;
    private DoubleLinkedList3Node<E> last;

    public final DoubleLinkedList3Node<E> EOL = null;

    // new empty list
    public DoubleLinkedList3() {
        first = EOL;
        last = EOL;
    }


    public void insert(DoubleLinkedList3Node<E> p, E x) {
        DoubleLinkedList3Node<E> n = new DoubleLinkedList3Node<E>(x);

        if (p != EOL) {
            // elsewhere than end
            n.next = p;
            n.prev = p.prev;
            p.prev = n;
            if (p == first)
                first = n;
            else
                n.prev.next = n;
        } else {
            // list end
            n.next = EOL;
            n.prev = last;
            if (last == EOL)
                first = n;
            else
                n.prev.next = n;
            last = n;
        }
    }

    public E remove(DoubleLinkedList3Node<E> p) {
        if (p == EOL)
            throw new NullPointerException("Cannot remove nonexisting node");

        E x = p.element;

        if (p.next != EOL)
            p.next.prev = p.prev;
        else
            this.last = p.prev;

        if (p.prev != EOL)
            p.prev.next = p.next;
        else
            this.first = p.next;

        p.next = EOL;
        p.prev = EOL;

        return x;
    }

    public DoubleLinkedList3Node<E> first() {
        return first;
    }


    public DoubleLinkedList3Node<E> last() {
        return last;
    }


}
