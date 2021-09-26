package Viikko5;
import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;

public interface TRAI_21_X4 {

    /**
     * Palauttaa binÃ¤Ã¤ripuun sisÃ¤jÃ¤rjestyksessÃ¤ viimeisen solmun.
     * @param T Tarkasteltava puu.
     * @return Viimeinen solmu tai null jos puu T on tyhjÃ¤.
     */
    public BTreeNode sisaViimeinen(BTree T);

    /**
     * Palauttaa binÃ¤Ã¤ripuun solmun n edeltÃ¤jÃ¤n sisÃ¤jÃ¤rjestyksessÃ¤.
     * @param n BinÃ¤Ã¤ripuun solmu.
     * @return edeltÃ¤jÃ¤solmu tai null jollei edeltÃ¤jÃ¤Ã¤ ole.
     */
    public BTreeNode sisaEdellinen(BTreeNode n);

}