package Viikko8;

// DoubleLinkedList3_test.java SJ

// DoubleLinkedList3.java ja DoubleLinkedList3Node.java
// alihakemistossa List

// import List.*;
import java.util.Random;

public class DoubleLinkedList3_test {

    public static void main(String[] args) {

        int N = 10;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        DoubleLinkedList3<Integer> omalista = randomList(N, N, N);

        System.out.println("AlkuperÃ¤inen");
        printList(omalista);

        System.out.println("purge");
        purge(omalista);
        printList(omalista);

        DoubleLinkedList3<Integer> omalista2 = randomList(N, N, N);

        System.out.println("Toinen lista");
        printList(omalista2);

        System.out.println("Vertailu");
        System.out.println(compareLists(omalista, omalista2));

        System.out.println("purge 2");
        purge(omalista2);
        printList(omalista2);

        System.out.println("Vertailu");
        System.out.println(compareLists(omalista, omalista2));

        System.out.println("reverse");
        reverse(omalista2);
        printList(omalista2);

        DoubleLinkedList3<Integer> omalista3 = randomList(N, N/2, N);

        System.out.println("Kolmas lista");
        printList(omalista3);

        DoubleLinkedList3<Integer> omalista4 = xor(omalista2, omalista3);

        System.out.println("XOR 2 & 3");
        printList(omalista4);

    } // main()


    // returns a new DoubleLinkedList3<Integer>
    public static DoubleLinkedList3<Integer> randomList(int N, int M, int seed) {

        DoubleLinkedList3<Integer> L = new DoubleLinkedList3<>();

        Random r = new Random(seed);
        for (int i = 0; i < N; i++) {
            L.insert(L.EOL, r.nextInt(M));
        }

        return L;
    } // randomList()


    // prints a DoubleLinkedList3
    public static <E> void printList(DoubleLinkedList3<E> L) {

        DoubleLinkedList3Node<E> p = L.first();
        System.out.print("(");
        while (p != L.EOL) {
            System.out.print(p.getElement());
            p = p.getNext();
            if (p != L.EOL)
                System.out.print(",");
        }
        System.out.println(")");

    } // printList()

    // removes duplicate elements

    public static <E> void purge(DoubleLinkedList3<E> L) {
        DoubleLinkedList3Node<E> p = L.first();
        while ( p != L.EOL) {
            DoubleLinkedList3Node<E> q = p.getNext();
            // check if same elements will be found
            while (q != L.EOL) {
                if (q.getElement().equals(p.getElement())) {
                    // same element found, remove latter
                    DoubleLinkedList3Node<E> r = q.getNext();
                    L.remove(q);
                    q = r;

                } else
                    q = q.getNext();
            } // while q
            p = p.getNext();
        } // while p
    } // purge()


    // compare elements of two lists
    public static <E> boolean compareLists(DoubleLinkedList3<E> L1, DoubleLinkedList3<E> L2) {
        DoubleLinkedList3Node<E> p1 = L1.first();
        DoubleLinkedList3Node<E> p2 = L2.first();
        while (p1 != L1.EOL && p2 != L2.EOL) {
            if (! p1.getElement().equals(p2.getElement()))
                return false;
            p1 = p1.getNext();
            p2 = p2.getNext();
        } // while

        return (p1 == L1.EOL && p2 == L2.EOL);
    } // compareLists()


    // XOR two lists
    public static <E> DoubleLinkedList3<E> xor(DoubleLinkedList3<E> L1, DoubleLinkedList3<E> L2) {
        DoubleLinkedList3Node<E> p1 = L1.first();
        DoubleLinkedList3<E> L = new DoubleLinkedList3<>();

        while (p1 != L.EOL) {
            if (!contains(L, p1.getElement()) &&
                    !contains(L2, p1.getElement()))
                L.insert(L.EOL, p1.getElement());
            p1 = p1.getNext();
        }

        DoubleLinkedList3Node<E> p2 = L2.first();
        while (p2 != L.EOL) {
            if (!contains(L, p2.getElement()) &&
                    !contains(L1, p2.getElement()))
                L.insert(L.EOL, p2.getElement());
            p2 = p2.getNext();
        }

        return L;
    } // DoubleLinkedList3()


    public static <E> boolean contains(DoubleLinkedList3<E> L, E x) {
        DoubleLinkedList3Node<E> p = L.first();
        while (p != L.EOL) {
            if (p.getElement().equals(x))
                return true;
            p = p.getNext();
        }
        return false;
    } // contains()



    // reverse a list
    public static <E> void reverse(DoubleLinkedList3<E> L) {
        DoubleLinkedList3Node<E> p = L.first();

        DoubleLinkedList3Node<E> q = p.getNext();
        while (q != L.EOL) {
            L.insert(L.first(), q.getElement());
            DoubleLinkedList3Node<E> r = q.getNext();
            L.remove(q);
            q = r;
        }

    } // reverse()


} // class DoubleLinkedList3_test
