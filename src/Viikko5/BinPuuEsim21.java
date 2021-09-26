package Viikko5;

// BinPuuEsim.java SJ

import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;

import java.util.Random;

public class BinPuuEsim21 {

    public static void main(String[] args) {
        BTree<Integer> puu = new BTree<Integer>();

        int N = 10;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        System.out.println("Puuhun:");
        Random r = new Random(42);
        Integer x;
        for (int i = 0; i < N; i++) {
            x = r.nextInt(N*2);
            System.out.print(x + " ");
            inorderInsert(puu, x);
        }
        System.out.println();

        System.out.println("Sisajarjestyksessa:");
        inorderPrint(puu);

        for (int i = 0; i < 21; i++) {
            System.out.println("Onko " + i + " : " +
                    inorderMember(puu, i));
        }

        for (int i = 0; i < 21; i++) {
            System.out.println("Seuraava suurempi: " + i + " : " +
                    inorderGreaterThan(puu, i));
        }


        puu = exampleBTree();

        System.out.println("Sisajarjestyksessa:");
        inorderPrint(puu);

        for (int i = 0; i < 20; i++) {
            System.out.println("Onko " + i + " : " +
                    inorderMember(puu, i));
        }

        for (int i = 0; i < 20; i++) {
            System.out.println("Seuraava suurempi: " + i + " : " +
                    inorderGreaterThan(puu, i));
        }


    } // main()

    /* Luo pienen sisajarjestyn esimerkkipuun

           10
        __/  \__
       5        15
      / \      /  \
     3   8   12    18
      \      /\
       4    11 13

    */
    public static BTree<Integer> exampleBTree() {

        BTree<Integer> T = new BTree<Integer>();

        // juuri

        // BTreeNode<Integer> n = new BTreeNode<Integer>(10);
        // T.setRoot(n);
        BTreeNode<Integer> n = T.setRoot(new BTreeNode<Integer>(10));

        // juuren lapset
        n.setLeftChild(new BTreeNode<Integer>(5));
        n.setRightChild(new BTreeNode<Integer>(15));

        // vasen haara
        BTreeNode<Integer> l = n.getLeftChild();

        l.setLeftChild(new BTreeNode<Integer>(3));
        l.setRightChild(new BTreeNode<Integer>(8));

        l.getLeftChild().setRightChild(new BTreeNode<Integer>(4));

        // oikea haara
        l = n.getRightChild();

        l.setLeftChild(new BTreeNode<Integer>(12));
        l.setRightChild(new BTreeNode<Integer>(18));

        l.getLeftChild().setLeftChild(new BTreeNode<Integer>(11));
        l.getLeftChild().setRightChild(new BTreeNode<Integer>(13));


        System.out.println("                 ");
        System.out.println("       10        ");
        System.out.println("    __/  \\__     ");
        System.out.println("   5        15   ");
        System.out.println("  / \\      /  \\  ");
        System.out.println(" 3   8   12    18");
        System.out.println("  \\      /\\      ");
        System.out.println("   4    11 13    ");
        System.out.println("                 ");

        return T;

    } // exampleBTree()


    public static <E extends Comparable<? super E>>
    void inorderInsert(BTree<E> T, E x) {

        // TODO poistettu perjantaihin asti

    } // inorderInsert()

    /**
     * Onko annettu alkio sisÃ¤jÃ¤rjestetyssÃ¤ puussa vai ei
     * @param T syÃ¶tepuu
     * @param x etsittÃ¤vÃ¤ alkio
     * @param <E> alkiotyyppi
     * @return true jos alkio lÃ¶ytyy, muuten false
     */
    public static <E extends Comparable<? super E>>
    boolean inorderMember(BTree<E> T, E x) {
        BTreeNode<E> n = T.getRoot();

        while (n != null) {
            if (x.compareTo(n.getElement()) == 0)
                return true;
            else if (x.compareTo(n.getElement()) < 0)
                n = n.getLeftChild();
            else
                n = n.getRightChild();
        } // while
        return false;

    } // inorderMember()


    /**
     * Etsii sisÃ¤jÃ¤rjestetystÃ¤ puusta alkion joka on pienin
     * niistÃ¤ alkioista jotka ovat suurempia kuin x.
     *
     * @param T syÃ¶tepuu
     * @param x alkio jota suurempaa etsitÃ¤Ã¤n
     * @param <E> alkiotyyppi
     * @return suurempi alkio tai null jos z oli suurin
     */
    public static <E extends Comparable<? super E>>
    E inorderGreaterThan(BTree<E> T, E x) {
        BTreeNode<E> n = T.getRoot();

        E min = null;
        while (n != null) {
            if ((min == null || min.compareTo(n.getElement()) > 0) &&
                    x.compareTo(n.getElement()) < 0)
                min = n.getElement();
            if (x.compareTo(n.getElement()) < 0) {
                n = n.getLeftChild();
            } else
                n = n.getRightChild();
        } // while
        return min;

    } // inorderGreaterThan()


    /**
     * BinÃ¤Ã¤ripuun korkeus (tai -1 jos puu on tyhjÃ¤)
     * @param T syÃ¶tepuu
     * @return puun korkeus
     */
    public static int puunKorkeus(BTree T) {
        return solmunKorkeus(T.getRoot());
    }

    static int solmunKorkeus(BTreeNode n) {

        if (n == null)
            return -1;
        return Math.max(solmunKorkeus(n.getLeftChild()),
                solmunKorkeus(n.getRightChild()))
                + 1;

        // tai yhdellÃ¤ rivillÃ¤ jos sellaisesta pitÃ¤Ã¤:
        // return n==null ? -1 : Math.max(solmunKorkeus(n.getLeftChild()), solmunKorkeus(n.getRightChild())) + 1;
    }

    // etsii annetun elementin sisaltavan solmun
    public static <E extends Comparable<? super E>>
    BTreeNode<E> inorderFindNode(BTree<E> T, E x) {
        BTreeNode<E> n = T.getRoot();

        while (n != null) {
            if (x.compareTo(n.getElement()) == 0)
                return n;
            else if (x.compareTo(n.getElement()) < 0)
                n = n.getLeftChild();
            else
                n = n.getRightChild();
        } // while
        return null;

    } // inorderFindNode()


    // etsii annetun elementin sisaltavan solmun
    // rekursiivinen versio esimerkin vuoksi

    // kÃƒÂ¤ynnistysaliohjelma
    public static <E extends Comparable<? super E>>
    BTreeNode<E> inorderFindNode2(BTree<E> T, E x) {
        return inorderFindNode2_r(T.getRoot(), x);
    } // inorderFindNode2()

    // varsinainen rekursiivinen osa
    public static <E extends Comparable<? super E>>
    BTreeNode<E> inorderFindNode2_r(BTreeNode<E> n, E x) {
        if (n == null)
            return null;

        // vertailu
        int cmp = x.compareTo(n.getElement());

        if (cmp == 0)   // lÃƒÂ¶ytyi tÃƒÂ¤stÃƒÂ¤
            return n;

        if (cmp < 0)    // vasemmalle vai oikealle
            return inorderFindNode2_r(n.getLeftChild(), x);
        else
            return inorderFindNode2_r(n.getRightChild(), x);

    } // inorderFindNode2_r()



    public static <E extends Comparable<? super E>>
    BTreeNode<E> inorderNext(BTreeNode<E> n) {

        // TODO: poistettu, on harjoitustehtÃ¤vÃ¤nÃ¤

        return null;

    } // inorderNext()


    // poistaa annetun solmun siten, etta puu sailyy sisajarjestyksessa
    public static <E extends Comparable<? super E>>
    void inorderRemoveNode(BTree<E> T, BTreeNode<E> n) {

        // sukulaiset apumuuttujiin
        BTreeNode<E> lc = n.getLeftChild();
        BTreeNode<E> rc = n.getRightChild();

        BTreeNode<E> par = n.getParent();

        // muistetaan onko n vanhempansa oikea vai vasen lapsi
        boolean vasen = false;
        if (par != null) {
            if (par.getLeftChild() == lc)
                vasen = true;
            else
                vasen = false;
        }

        // 0-1 -lapsiset tapaukset erikseen

        // jos juuri, ei vasenta lasta: oikea lapsi tilalle
        if (n == T.getRoot() && lc == null) {
            T.setRoot(rc);
            return;
        }

        // jos juuri, ei oikeaa lasta: vasen lapsi tilalle
        else if (n == T.getRoot() && rc == null) {
            T.setRoot(lc);
            return;
        }

        // jos ei juuri, ei vasenta lasta: oikea lapsi tilalle
        if (lc == null) {
            if (vasen)
                par.setLeftChild(rc);
            else if (rc != null)
                par.setRightChild(rc);
        }

        // jos ei juuri, ei oikeaa lasta: vasen lapsi tilalle
        else if (rc == null) {
            if (vasen)
                par.setLeftChild(lc);
            else if (lc != null)
                par.setRightChild(lc);
        }


        // molemmat lapset olemassa
        else {

            BTreeNode<E> korv = inorderNext(n);
            E korvAlkio = korv.getElement();

            // poistetaan korvaava rekursiivisesti
            inorderRemoveNode(T, korv);

            // oikea lapsi saattoi muuttua
            rc = n.getRightChild();

            // alkio poistetun tilalle
            n.setElement(korvAlkio);

        }


    } // inorderRemoveNode


    // Tulostus sisajarjestyksessa rekursiivisesti
    public static void inorderPrint(BTree T) {
        inorderPrintBranch(T.getRoot());
        System.out.println();
    } // inorderPrint()


    public static void inorderPrintBranch(BTreeNode n) {
        if (n == null)
            return;

        inorderPrintBranch(n.getLeftChild());
        System.out.print(n.getElement() + " ");
        inorderPrintBranch(n.getRightChild());

    } // inorderPrintBranch()


} // class BinPuuEsim21
