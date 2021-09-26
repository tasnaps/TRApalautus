package Viikko5;

import java.util.*;

import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;

/**
 * Testausluokka TRA I tehtÃ¤vÃ¤Ã¤n X4.
 */
public class TRAI_21_X4_testi {

    static Random rnd = new Random();

    static TRAI_21_X4 testattava = new TRAI_21_X4_pohja(); /* <-- Oma tunnus tÃ¤hÃ¤n */


    public static void main(String[] args) {

        // alkioiden mÃ¤Ã¤rÃ¤
        int N = 10;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        // satunnaislukusiemen
        int siemen = 42;
        if (args.length > 1)
            siemen = Integer.parseInt(args[1]);

        rnd.setSeed(siemen);

        // tulostusten mÃ¤Ã¤rÃ¤
        int print = 3;
        if (args.length > 2) print = Integer.parseInt(args[2]);


        boolean ok1 = true;

        System.out.println("Testataan ensin pelkÃ¤stÃ¤Ã¤n sisÃ¤ViimeistÃ¤:");

        ok1 &= testaaViimeinen(N, print);
        ok1 &= testaaViimeinen(0, print);
        ok1 &= testaaViimeinen(1, print);
        ok1 &= testaaViimeinen(2, print);
        ok1 &= testaaViimeinen(2, print);
        ok1 &= testaaViimeinen(3, print);
        ok1 &= testaaViimeinen(3, print);
        ok1 &= testaaViimeinen(4, print);
        ok1 &= testaaViimeinen(5, print);
        ok1 &= testaaViimeinen(N*4, print);

        System.out.println("\nsisÃ¤Viimeisen testit: " + ok1);

        System.out.println("\n\nTestataan sitten lÃ¤pikÃ¤yntiÃ¤ erikokoisilla puilla:");

        boolean ok = true;



        ok &= testaa(N, print);

        ok &= testaa(0, print);
        ok &= testaa(1, print);
        ok &= testaa(2, print);
        ok &= testaa(2, print);
        ok &= testaa(2, print);
        ok &= testaa(3, print);
        ok &= testaa(3, print);
        ok &= testaa(4, print);

        ok &= testaa(N*2, print);
        ok &= testaa(N*4, print);
        ok &= testaa(N*8, print);
        ok &= testaa(N*16, print);


        System.out.println("\n=== laitetaan vielÃ¤ joka kerta vaihtuva satunnaissiemen");
        rnd.setSeed(System.currentTimeMillis());

        System.out.println("=== ja sama uusiksi");

        ok &= testaa(N, print);

        ok &= testaa(0, print);
        ok &= testaa(1, print);
        ok &= testaa(2, print);
        ok &= testaa(2, print);
        ok &= testaa(2, print);
        ok &= testaa(3, print);
        ok &= testaa(3, print);
        ok &= testaa(4, print);

        ok &= testaa(N*2, print);
        ok &= testaa(N*4, print);
        ok &= testaa(N*8, print);
        ok &= testaa(N*16, print);

        System.out.println("\nLÃ¤pikÃ¤yntit testit: " + ok);

        if (ok && ok1)
            System.out.println("\nKaikki testit ok, muista itsearviointi.");

    }

    /**
     * testaa X4:sta n kokoisella syÃ¶tteellÃ¤
     * @param n syÃ¶tekoko
     * @param print
     */
    static boolean testaaViimeinen(int n, int print) {
        ArrayList<Integer> A = satunnainenLista(n, n*3);
        return testaaViimeinen(A, print);
    }


    /**
     * testaa X4:sta n kokoisella syÃ¶tteellÃ¤
     * @param n syÃ¶tekoko
     * @param print
     */
    static boolean testaa(int n, int print) {
        ArrayList<Integer> A = satunnainenLista(n, n*3);
        return testaa(A, print);
    }

    /**
     * Testaa lisÃ¤ystÃ¤ viemÃ¤llÃ¤ puuhun A:n alkiot ja kÃ¤ymÃ¤llÃ¤ puun lÃ¤pi X4:tÃ¤ kÃ¤yttÃ¤en
     * @param A syÃ¶tetaulukko
     * @param print
     * @return
     */
    static <E extends Comparable<? super E>> boolean testaa(ArrayList<E> A, int print) {
        int na = A.size();
        BTree<E> T = new BTree<E>();
        System.out.println("\nViedÃ¤Ã¤n puuhun alkiot (" + na + " kpl) : " + A);
        for (E x : A) {
            sisaLisaa(T, x);
        }
        System.out.print("Puu sisÃ¤jÃ¤rjestyksessÃ¤:");
        sisaTulosta(T);

        // kÃ¤ydÃ¤Ã¤n puu lÃ¤pi, eli kutsutaan X4 metodeja

        ArrayList<E> AR = new ArrayList<E>(na);

        System.out.print("Testataan takaperin lÃ¤pikÃ¤ynti X4:llÃ¤:");
        int tn = 0;
        BTreeNode<E> n = testattava.sisaViimeinen(T);
        while (n != null) {
            E x = n.getElement();
            tn++;
            System.out.print(" " + x);
            AR.add(x);
            n = testattava.sisaEdellinen(n);
        }
        System.out.println(" (" + tn + " kpl)");

        // lajitellaan alkuperÃ¤inen A ja verrataan lÃ¤pikÃ¤ynnin tuloksen kÃ¤Ã¤nteiseen jÃ¤rjestykseen
        Collections.sort(A);
        boolean ok = samatTakaperin(A, AR);
        if (! ok)
            System.out.println("Eri alkiot tai ei tasan kÃ¤Ã¤nteinen jÃ¤rjestys");
        else
            System.out.println("Samat tuli, hienoa");

        return ok;

    }
    /**
     * Testaa lisÃ¤ystÃ¤ viemÃ¤llÃ¤ puuhun A:n alkiot ja kÃ¤ymÃ¤llÃ¤ puun lÃ¤pi X4:tÃ¤ kÃ¤yttÃ¤en
     * @param A syÃ¶tetaulukko
     * @param print
     * @return
     */
    static <E extends Comparable<? super E>> boolean testaaViimeinen(ArrayList<E> A, int print) {
        int na = A.size();
        BTree<E> T = new BTree<E>();
        if (print > 0)
            System.out.println("\nViedÃ¤Ã¤n puuhun alkiot (" + na + " kpl) : " + A);
        for (E x : A) {
            sisaLisaa(T, x);
        }
        if (print >  1) {
            System.out.print("Puu sisÃ¤jÃ¤rjestyksessÃ¤:");
            sisaTulosta(T);
        }

        if (print > 0) System.out.print("Testataan viimeisen haku X4:llÃ¤:");
        int tn = 0;
        BTreeNode<E> n = testattava.sisaViimeinen(T);

        if (print > 0) {
            if (n == null)
                System.out.println("Ei lÃ¶ytynyt viimeistÃ¤ solmua.");
            else
                System.out.println("Viimeisen solmun alkio: " + n.getElement());
        }

        if (A.isEmpty() && n == null) {
            if (print > 0) System.out.println("Ei pitÃ¤nykÃ¤Ã¤n lÃ¶ytyÃ¤, oikein");
            return true;
        } else if (A.isEmpty()) {
            if (print > 0) System.out.println("Ei pitÃ¤nyt lÃ¶ytyÃ¤ solmua tyhjÃ¤stÃ¤ puusta!");
            return false;
        } else if (n == null) {
            if (print > 0) System.out.println("Piti lÃ¶ytyÃ¤ viimeinen solmu: "+ Collections.max(A));
            return false;
        } else if (Collections.max(A).equals(n.getElement())) {
            if (print > 0) System.out.println("Oikein");
            return true;
        } else {
            if (print > 0) System.out.println("Piti olla: " + Collections.max(A));
            return false;
        }


    }

    /**
     * LisÃ¤Ã¤ alkion sisÃ¤jÃ¤rjestettyyn binÃ¤Ã¤ripuuhun jollei sitÃ¤ ennestÃ¤Ã¤n ollut.
     * @param T Puu
     * @param x lisÃ¤ttÃ¤vÃ¤ alkio
     * @param <E> alkioiden tyyppi
     * @return true jos lisÃ¤ys tehtiin, muuten false
     */
    static <E extends Comparable<? super E>> boolean sisaLisaa(BTree<E> T, E x) {
        BTreeNode<E> n = T.getRoot();
        if (n == null) {
            T.setRoot(new BTreeNode<>(x));
            return true;
        }

        while (true) {

            if (x.compareTo(n.getElement()) == 0)
                // prev jo puussa, eli lisÃ¤tÃ¤
                return false;

            else if (x.compareTo(n.getElement()) < 0) {
                // prev edeltÃ¤Ã¤ n:n alkiota
                if (n.getLeftChild() == null) {
                    // lisÃ¤yskohta lÃ¤ydetty
                    n.setLeftChild(new BTreeNode<>(x));
                    return true;
                } else
                    n = n.getLeftChild();
            } else {
                // prev suurempi kuin n
                if (n.getRightChild() == null) {
                    // lisÃ¤yskohta lÃ¤ydetty
                    n.setRightChild(new BTreeNode<>(x));
                    return true;
                } else
                    n = n.getRightChild();
            }
        } // while

    }

    /**
     * tulostaa puun solmujen alkiot sisÃ¤jÃ¤rjestyksessÃ¤
     * @param T
     */
    static void sisaTulosta(BTree T) {
        sisaTulosta(T.getRoot());
        System.out.println();
    }


    static void sisaTulosta(BTreeNode n) {
        if (n == null)
            return;

        sisaTulosta(n.getLeftChild());
        System.out.print(" " + n.getElement());
        sisaTulosta(n.getRightChild());

    }




    /**
     * Tarkastaa onko listoissa samat alkiot, mutta kÃ¤Ã¤nteisessÃ¤ jÃ¤rjestyksessÃ¤.
     * @param A lista1
     * @param B lista2
     * @return true jos samat alkiot, mutta kÃ¤Ã¤nteinen jÃ¤rjestys, muuten false
     */
    public static boolean samatTakaperin(List A, List B) {
        ListIterator iA = A.listIterator();
        ListIterator iB = B.listIterator(B.size());
        while (iA.hasNext() && iB.hasPrevious()) {
            if (! iA.next().equals(iB.previous())) {
                return false;
            }

        }
        if (iA.hasNext() || iB.hasPrevious())
            return false;
        else
            return true;
    }


    /**
     * Generoi satunnaisen n kokoisen listan jossa alkiot ovat uniikkeja
     * Alkiot 1..max.
     * @param n alkioiden mÃ¤Ã¤rÃ¤
     * @param max suurin alkio
     * @return uusi lista.
     */
    static ArrayList<Integer> satunnainenLista(int n, int max) {
        return  satunnainenLista(n, 1, max);
    }

    /**
     * Generoi satunnaisen n kokoisen listan jossa alkiot ovat uniikkeja
     * Alkiot min..max ovat uniikkeja.
     * @param n alkioiden mÃ¤Ã¤rÃ¤
     * @param max suurin alkio
     * @return uusi lista.
     */
    static ArrayList<Integer> satunnainenLista(int n, int min, int max) {
        ArrayList<Integer> tulos = new ArrayList<Integer>(n);
        int diff = max-min+1;
        if (diff < 1)
            diff = 1;

        HashSet<Integer> hs = new HashSet<>(n*2);

        int kierr = n*20;
        int i = 0;
        while (tulos.size() < n && kierr > 0) {
            Integer x = rnd.nextInt(diff) + min;
            if (hs.add(x))
                tulos.add(x);
            kierr--;
        }
        if (tulos.size() < n)
            System.out.println("satunnainenLista: varoitus vain " + tulos.size() + " alkiota tehtiin vaikka "
                    + n + " pyydettiin, min ja max liian lÃ¤hellÃ¤ toisiaan.");

        return tulos;
    }

}