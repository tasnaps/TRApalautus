package Viikko8;

// ArrayList2_test.java SJ

import java.util.Random;

public class ArrayList2_test {

    public static void main(String[] args) {

        int N = 10;
        if (args.length > 0)
            N = Integer.valueOf(args[0]);

        ArrayList2 omalista = randomList(N, N, N);

        System.out.println("Alkuperäinen");
        printList(omalista);

        System.out.println("purge");
        purge(omalista);
        printList(omalista);

        ArrayList2 omalista2 = randomList(N, N, N);

        System.out.println("Toinen lista");
        printList(omalista2);

        System.out.println("Vertailu");
        System.out.println(compareLists(omalista, omalista2));

        System.out.println("purge 2");
        purge(omalista2);
        printList(omalista2);

        System.out.println("Vertailu");
        System.out.println(compareLists(omalista, omalista2));

        ArrayList2 omalista3 = randomList(N, N/2, N);

        System.out.println("Kolmas lista");
        printList(omalista3);

        ArrayList2 omalista4 = xor(omalista2, omalista3);

        System.out.println("XOR 2 & 3");
        printList(omalista4);

    } // main()


    // returns a new ArrayList2<Integer>
    public static ArrayList2<Integer> randomList(int N, int M, int seed) {

        ArrayList2<Integer> L = new ArrayList2<Integer>(N+2);

        Random r = new Random(seed);
        Integer x = new Integer(0);
        for (int i = 0; i < N; i++) {
            x = r.nextInt(M);
            L.insert(L.EOL(), x);
        }

        return L;
    } // randomList()


    // prints a ArrayList2
    public static void printList(ArrayList2 L) {

        int p = L.first();
        System.out.print("(");
        while (p != L.EOL()) {
            System.out.print(L.getElement(p));
            p = L.getNext(p);
            if (p != L.EOL())
                System.out.print(",");
        }
        System.out.println(")");

    } // printList()

    // removes duplicate elements

    public static void purge(ArrayList2 L) {
        int p = L.first();
        while ( p != L.EOL()) {
            int q = L.getNext(p);
            // check if same elements will be found
            while (q != L.EOL()) {
                if (L.getElement(q).equals(L.getElement(p))) {
                    // same element found, remove latter
                    // viimeisen alkion poisto taulukkototeutuksessa
                    // jättää q:n epävakaaseen tilaan!!
                    if (q == L.last()) {
                        L.remove(q);
                        break;
                    } else
                        L.remove(q);
                } else
                    q = L.getNext(q);
            } // while q
            p = L.getNext(p);
        } // while p
    } // purge()


    // compare elements of two lists
    public static boolean compareLists(ArrayList2 L1, ArrayList2 L2) {
        int p1 = L1.first();
        int p2 = L2.first();
        while (p1 != L1.EOL() && p2 != L2.EOL()) {
            if (! L1.getElement(p1).equals(L2.getElement(p2)))
                return false;
            p1 = L1.getNext(p1);
            p2 = L2.getNext(p2);
        } // while

        if (p1 == L1.EOL() && p2 == L2.EOL())
            return true;
        else
            return false;
    } // compareLists()


    // XOR two lists
    public static ArrayList2 xor(ArrayList2 L1, ArrayList2 L2) {
        int p1 = L1.first();
        ArrayList2 L = new ArrayList2(L1.size() + L2.size());

        System.out.println(L1);
        System.out.println(L2);
        System.out.println(L);
        while (p1 != L1.EOL()) {
            if (!containsIter(L, L1.getElement(p1)) &&
                    !containsIter(L2, L1.getElement(p1)))
                L.insert(L.EOL(), L1.getElement(p1));
            p1 = L1.getNext(p1);
        }

        System.out.println(L);
        int p2 = L2.first();
        while (p2 != L2.EOL()) {
            if (!contains(L, L2.getElement(p2)) &&
                    !contains(L1, L2.getElement(p2)))
                L.insert(L.EOL(), L2.getElement(p2));
            p2 = L2.getNext(p2);
        }
        System.out.println(L);

        return L;
    } // ArrayList2()


    public static boolean contains(ArrayList2 L, Object x) {
        int p = L.first();
        while (p != L.EOL()) {
            if (L.getElement(p).equals(x))
                return true;
            p = L.getNext(p);
        }
        return false;
    } // contains()


    // iteraattoria hyödyntävä versio
    public static boolean containsIter(ArrayList2 L, Object x) {
        for (Object a : L)
            if (a.equals(x))
                return true;
        return false;
    } // containsIter()



} // class ArrayList2_test
