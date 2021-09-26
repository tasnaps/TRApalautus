package Viikko5;

import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;
import sun.net.www.content.text.Generic;

import static Viikko5.BinPuuEsim21.exampleBTree;

public class TRAI_21_X4_pohja implements TRAI_21_X4 {


    /**
     * ITSEARVIOINTI TÃ„HÃ„N:
     *  5/5 Hirveästi piti debugata että sain oikean vastauksen.
     *  Aikavaativuus: O(
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

    @Override
    public BTreeNode sisaEdellinen(BTreeNode n) {
        BTreeNode vastaus = null;
        //Edeltäjää etsitään vasemman lapsen kaikkein oikeimmasta päästä tämä ei toimi.
        if (n.getLeftChild() != null) {//n.getLeftChild().getRightChild() != null
            n = n.getLeftChild();
            while(n.getRightChild() != null){
                n = n.getRightChild();
            }
            vastaus = n;
            return vastaus;
        }
        //nämä else haarat etsii missä kohti haaraudutaan oikealle
        else if (n.getParent() != null && n.getParent().getRightChild() != null && n.getParent().getRightChild().equals(n)) {
            vastaus = n.getParent();
            return vastaus;
        }else{
            while(n.getParent() != null){
                n = n.getParent();
                if(n.getParent()!= null && n.getParent().getRightChild()!=null &&n.getParent().getRightChild().equals(n)){
                    vastaus = n.getParent();
                    return vastaus;
                }
            }
            return vastaus;
        }
    }
}