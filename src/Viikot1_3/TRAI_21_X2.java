package Viikot1_3;

import java.util.ArrayList;

public interface TRAI_21_X2 {


    /**
     * Kasvavien listojen erotus.
     * Palauttaa sellaiset alkiot jotka lÃ¶ytyvÃ¤t listasta A, mutta eivÃ¤t listasta B.
     * Jos alkio on listassa A useasti, mutta ei lainkaan listassa B, alkio tulee tuloslistaan
     * yhtÃ¤ monta kertaa kuin se listassa A on. Jos alkio on edes yhden kerran listassa B, se ei tule
     * tuloslistaan lainkaan.
     * Tuloslista tulee myÃ¶s kasvavaan jÃ¤rjestykseen.
     * @param A ensimmÃ¤inen syÃ¶telista, alkiot kasvavassa jÃ¤rjestyksessÃ¤
     * @param B toinen syÃ¶telista, alkiot kasvavassa jÃ¤rjestyksessÃ¤
     * @return erotuslista
     */
    ArrayList<Integer> kasvavienErotus(ArrayList<Integer> A, ArrayList<Integer> B);
}