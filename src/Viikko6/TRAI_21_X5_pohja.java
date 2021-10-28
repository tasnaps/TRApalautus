package Viikko6;

import java.util.HashSet;
import java.util.Set;

public class TRAI_21_X5_pohja implements TRAI_21_X5 {

    /**
     * Muistelin JTK kurssilta, että samantyyppistä tehtävää hahmoteltiin paperille.
     * Ei isompia ongelmia tehtävässä. Yritin alkuun luoda settejä tyylillä: Set<E> tempS1 = new Set<E>(S1);
     * Ei onnistunut luoda normaalia Settiä, vaan piti olla HashSet, en tiedä miksi.
     * Aikavaativuus: O(n), hashSetissä vakioaikaiset operaatiot (add, remove etc.)
     *
     */

    /**
     * Joukkojen kaksi kolmesta -leikkaus. Luo uuden joukon johon algoritmi laittaa ne syÃ¶tejoukkojen alkiot jotka
     * kuuluvat tasan kahteen kolmesta syÃ¶tejoukosta. Jos jokin alkio kuuluu vain yhteen tai kaikkiin kolmeen
     * syÃ¶tejoukkoon, alkiota ei laiteta tulosjoukkoon. Ei muuta syÃ¶tejoukkojensa sisÃ¤ltÃ¶Ã¤ (vaan luo uuden tulosjoukon)
     * Jos mikÃ¤Ã¤n alkio ei tÃ¤ytÃ¤ ehtoa, palautetaan tyhjÃ¤ joukko.
     *
     * @param S1 syÃ¶tejoukko
     * @param S2 syÃ¶tejoukko
     * @param S3 syÃ¶tejoukko
     * @return tulosjoukko
     */
    @Override
    public <E> Set<E> kaksiKolmesta(Set<E> S1, Set<E> S2, Set<E> S3) {
        Set<E> tulos = new HashSet<>();
        Set<E> tempS1 = new HashSet<E>(S1);
        Set<E> tempS2 = new HashSet<E>(S2);
        Set<E> tempS3 = new HashSet<E>(S3);
        Set<E> keskusta =new HashSet<E>(S1);

        //Keskustassa on alkiot jotka esiintyvät kaikissa seteissä, voin poistaa tämän avulla muista seteistä ylimääräset.
        keskusta.retainAll(S2);
        keskusta.retainAll(S3);

        //Leikkaukset:
        tempS3.retainAll(S1);
        tempS2.retainAll(S3);
        tempS1.retainAll(S2);

        //Keskustan alkion poistot leikkauksista
        tempS1.removeAll(keskusta);
        tempS2.removeAll(keskusta);
        tempS3.removeAll(keskusta);

        //Seuraavaksi lisätään tulokseen
        tulos.addAll(tempS1);
        tulos.addAll(tempS2);
        tulos.addAll(tempS3);
        return tulos;
    }
}