package Viikko8;

/**
 * Array implementation of list
 */

import java.lang.StringBuilder;
import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;


public class ArrayList2<E> implements Iterable<E> {

    private E[] data;
    private int n;

    private int modCount = 0;


    /**
     * Contructor for given initial capacity
     * @param initialCapacity
     */
    @SuppressWarnings({"unchecked"})
    public ArrayList2(int initialCapacity) {
        // Cannot create E[] array, create instead Object[]
        data = (E[]) (new Object[initialCapacity]);
        n = 0;
    }

    /**
     * default constructor
     */
    public ArrayList2() {
        this(20);
    }

    /**
     * Number of elements in the list.
     * @return # of elements
     */
    public int size() {
        return n;
    }


    /**
     * The position after the last position of the list.
     * @return
     */
    public int EOL() {
        return n;
    }

    /**
     * Insert element in front of position p.
     * @param p insertion position
     * @param x element to be added
     */
    public void insert(int p, E x) {
        if (p > n || p < 0)
            throw new ListException("Insert: invalid position" + p);

        if (n == data.length)
            doubleCapacity();

        for (int i = n; i > p; i--)
            data[i] = data[i-1];
        data[p] = x;
        n++;
        modCount++;
    }

    @SuppressWarnings({"unchecked"})
    private void doubleCapacity() {
        E[] data2 = (E[]) (new Object[2*data.length]);
        for (int i = 0; i < n; i++)
            data2[i] = data[i];
        data = data2;
    }

    /**
     * Remove element in position p
     * @param p position of the element to be removed
     * @return the removed element
     */
    public E remove(int p) {
        if (p >= n || p < 0)
            throw new ListException("Remove: invalid position" + p);

        E x = data[p];

        for (int i = p; i < n-1; i++)
            data[i] = data[i+1];
        data[n-1] = null;
        n--;

        modCount++;
        return x;
    }

    public int first() {
        return 0;
    }

    public int last() {
        return n-1;
    }

    public E getElement(int p) {
        return data[p];
    }

    public int getNext(int p) {
        if (p >= n || p < 0)
            throw new ListException("Next: invalid position" + p);

        return p+1;
    }

    // content to string
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(data[i].toString());
            sb.append(" ");
        }
        return sb.toString();
    }

    // implementation of Iterable
    public Iterator<E> iterator() {
        return new ArrayList2Iter();
    }

    // Iterator class
    // This is not parametrized, but instead uses E of the List class.
    private class ArrayList2Iter implements Iterator<E> {

        int ind; // next location
        int removeIndex = -1; // position of the element to be removed next

        // maintain information of original modCount
        // if modified from elsewhere, change is detected here
        int initialModCount;

        public ArrayList2Iter() {
            ind = 0;
            initialModCount = modCount; // modCount == ArrayList2.this.modCount
        }

        public boolean hasNext() {
            checkModCount();
            return ind < n; // n == ArrayList2.this.n;
        }

        public E next() {
            checkModCount();
            if (ind >= n) {
                throw new NoSuchElementException(
                        "next() called without hasNext()");
            }
            removeIndex = ind;
            return data[ind++];

        }

        public void remove() {
            if (removeIndex < 0)
                throw new IllegalStateException("remove() called without next()");
            for (int j = removeIndex; j < n-1; j++)
                data[j] = data[j+1];
            data[--n] = null;
            removeIndex = -1;
            initialModCount = ++modCount;

        }


        // check if modCount has changed
        void checkModCount() {
            if (modCount != initialModCount)
                throw new ConcurrentModificationException(
                        "List changed during iteration");
        }
    } // class ArrayList2Iter


} // class ArrayList2

