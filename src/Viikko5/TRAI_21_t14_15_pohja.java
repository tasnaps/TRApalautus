package Viikko5;

// TRAI_21_t14_15.java SJ


import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TRAI_21_t14_15_pohja {

    public static void main(String[] args) {

        BTree<Integer> puu = null;

        int N = 15;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);


        // testataan ensin vakiopuulla

        puu = exampleBTree();
        System.out.println("SisÃ¤jÃ¤rjestyksessÃ¤:");
        inorderPrint(puu);

        System.out.println("Matalin lehtisolmu = " + matalin(puu).getElement());

        // tehdÃ¤Ã¤n uusi puu

        puu = new BTree<Integer>();


        System.out.println("\nPuuhun:");
        Random r = new Random(42);
        Integer x = null;
        for (int i = 0; i < N; i++) {
            x = r.nextInt(N*2);
            System.out.print(x + " ");
            inorderInsert(puu, x);
        }
        System.out.println();

        System.out.println("SisÃ¤jÃ¤rjestyksessÃ¤:");
        inorderPrint(puu);

        System.out.println("Matalin lehtisolmu = " + matalin(puu).getElement());

        // rakenteiden vertailu

        puu = exampleBTree();

        BTree<Integer> puu2 = exampleBTree();

        System.out.println("Samat rakenteet : " + vertaaRakenne(puu, puu2));

        System.out.println("LisÃ¤tÃ¤Ã¤n: 7");
        inorderInsert(puu, 7);
        System.out.println("Samat rakenteet : " + vertaaRakenne(puu, puu2));

        System.out.println();


    } // main()



    /**
     * 14. Kirjoita algoritmi joka etsii binÃ¤Ã¤ripuun matalimman (vÃ¤hiten syvÃ¤n)
     * lehtisolmun. Vihje: tasoittainen lÃ¤pikÃ¤ynti. Aikavaativuus?
     * Aikavaativuus = O(log n) -> En ole satavarma, mietin että joka kerroksen kohdalla mahdollisuus löytää matalin kohta tuplaantuu.
     * Tein mielestäni tehokkaan ratkaisun.
     *
     *
     * @param T binÃ¤Ã¤ripuu
     * @return matalin lehtisolmu tai null jos puu on tyhjÃ¤
     **/

    public static BTreeNode matalin(BTree T) {
        if (T.getRoot() == null)
            return null;

        Queue<BTreeNode> jono = new LinkedList<>();
        BTreeNode node = T.getRoot();
        //BTreeNode siirto;
        jono.add(node);

        while(jono.peek() != null){
            node = jono.poll();

            if(node.getRightChild() == null && node.getLeftChild() == null){
                return node;
            }

            if(node.getRightChild() != null){
                jono.add(node.getRightChild());
            }
            if(node.getLeftChild() != null){
                jono.add(node.getLeftChild());
            }
        }

        return null;

    } // matalin()


    /**
     * 15. Kirjoita algoritmi, joka vertaa kahta binÃ¤Ã¤ripuuta ja palauttaa toden jos puut ovat raken-
     teeltaan samat, muuten epÃ¤toden. Puut ovat samat, jos juuren molemmat alipuut ovat
     keskenÃ¤Ã¤n rakenteeltaan samanlaiset. Puun sisÃ¤ltÃ¤miÃ¤ elementtejÃ¤ ei siis vertailla, vain puun
     rakennetta (â€oksaston muotoaâ€). Aikavaativuus? Tilavaativuus? Vihje: rekursio rinta rinnan.
     * @param T1 syÃ¶tepuu1
     * @param T2 syÃ¶tepuu2
     * @param <E> alkiotyyppi (ei kÃ¤ytetÃ¤)
     * @return ovatko rakenteeltaan samat vai ei
     *
     * Aikavaatimus: oliskohan O(2(log n)) en ole täysin varma.
     */
    public static <E> boolean vertaaRakenne(BTree<E> T1, BTree<E> T2) {

        BTreeNode n1 = T1.getRoot();
        BTreeNode n2 = T2.getRoot();
        Queue<BTreeNode> vertailuJ1 = new LinkedList<>();
        Queue<BTreeNode> vertailuJ2 = new LinkedList<>();


        vertailuJ1.add(n1);
        vertailuJ2.add(n2);

        while(vertailuJ1.peek() != null && vertailuJ2.peek() != null){
           n1 = vertailuJ1.poll();
           n2 = vertailuJ2.poll();
           if(n1.getRightChild() == null && n2.getRightChild() == null &&n1.getLeftChild() == null && n2.getLeftChild() == null){
               return true;
           }
           else if(n1.getLeftChild() != null && n2.getLeftChild() != null){
               vertailuJ1.add(n1.getLeftChild());
               vertailuJ2.add(n2.getLeftChild());
           }
           else if(n1.getRightChild() != null && n2.getRightChild() != null){
               vertailuJ1.add(n1.getRightChild());
               vertailuJ2.add(n2.getRightChild());
           }else{
               return false;
           }
        }
        return false;
    } // vertaaRakenne()


    // esimerkkejÃ¤ ja pohjia


    public static BTree<Integer> exampleBTree() {

        BTree<Integer> T = new BTree<Integer>();

        // juuri
        T.setRoot(new BTreeNode<Integer>(9));

        BTreeNode<Integer> n = T.getRoot();

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
        System.out.println("       9        ");
        System.out.println("    __/  \\__     ");
        System.out.println("   5        15   ");
        System.out.println("  / \\      /  \\  ");
        System.out.println(" 3   8   12    18");
        System.out.println("  \\      /\\      ");
        System.out.println("   4    11 13    ");
        System.out.println("                 ");

        return T;

    } // exampleBTree()



    /**
     * 13. LisÃ¤ys sisÃ¤jÃ¤rjestettyyn binÃ¤Ã¤ripuuhun.
     * @param T binÃ¤Ã¤ripuu
     * @param x lisÃ¤ttÃ¤vÃ¤ alkio
     * @return tehtiinkÃ¶ lisÃ¤ys vai ei
     */
    public static <E extends Comparable<? super E>>
    boolean inorderInsert(BTree<E> T, E x) {
        BTreeNode<E> n = T.getRoot();
        if (n == null) {
            T.setRoot(new BTreeNode<E>(x));
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


    } // inorderInsert()







    // Tulostus sisÃ¤jÃ¤rjestyksessÃ¤ rekursiivisesti
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


} // class TRAI_21_t14.java