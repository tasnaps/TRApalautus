package Viikko5;

import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;
import sun.net.www.content.text.Generic;

import static Viikko5.BinPuuEsim21.exampleBTree;

public class TRAI_21_X4_pohja implements TRAI_21_X4 {


    /**
     * ITSEARVIOINTI TÃ„HÃ„N:
     *
     *
     *
     */

    /**
     * Palauttaa binÃ¤Ã¤ripuun sisÃ¤jÃ¤rjestyksessÃ¤ viimeisen solmun.
     *
     * @param T Tarkasteltava puu.
     * @return Viimeinen solmu tai null jos puu T on tyhjÃ¤.
     */
    @Override
    public BTreeNode sisaViimeinen(BTree T) {
        if (T.isEmpty()) {
            return null;
        }
        BTreeNode n = T.getRoot();

        while (n.getRightChild() != null) {
            n = n.getRightChild();
        }
        return n;

    }

    /**
     * Palauttaa binÃ¤Ã¤ripuun solmun n edeltÃ¤jÃ¤n sisÃ¤jÃ¤rjestyksessÃ¤.
     *
     * @param n BinÃ¤Ã¤ripuun solmu.
     * @return edeltÃ¤jÃ¤solmu tai null jollei edeltÃ¤jÃ¤Ã¤ ole.
     */
    @Override
    public BTreeNode sisaEdellinen(BTreeNode n) {
        BTreeNode vastaus = null;

        // Nämä if lauseet toimivat.
        //Mikäli lapsen oikea lapsi on olemassa:
        if (n.getLeftChild() != null && n.getLeftChild().getRightChild() != null) {
            vastaus = n.getLeftChild().getRightChild();
            return vastaus;
        }
        else if (n.getParent() != null && n.getParent().getRightChild() != null && n.getParent().getRightChild().equals(n)) {
            vastaus = n.getParent();
            return vastaus;
        }

        //----------------------------------------------------------------------------------------------------------------
        //MIkäli n on vanhemman vasen lapsi
        //tee valmiiksi: palauta solmun edeltäjä joka on esivanhempi, jonka oikeassa haarassa solmu on
        else if (n.getParent() != null && n.getParent().getLeftChild() != null && n.getParent().getLeftChild().equals(n)) {



            // tämä if aiheuttaa kierron

            if(n.getParent() != null && n.getParent().getParent() != null && n.getParent().getParent().getRightChild().equals(n.getParent())){
                vastaus = n.getParent().getParent().getRightChild();
                return vastaus;
            }

            return vastaus;
        }

        return vastaus;
        // testauksen ajaksi tämä on kommentoitu poist tieltä
                        /**
                         * while (n.getParent() != null && n.getParent().getParent() != null &&n.getParent().getParent().getRightChild() == null) {
                         *                 n = n.getParent();
                         *                 System.out.println("loopissa");
                         *             }
                         *
                         *
                         */

    }
}
