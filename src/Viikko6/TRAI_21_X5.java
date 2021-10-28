package Viikko6;

import java.util.Set;

public interface TRAI_21_X5 {

    /**
     * Joukkojen kaksi kolmesta -leikkaus.
     * Luo uuden joukon johon algoritmi laittaa ne syÃ¶tejoukkojen alkiot jotka
     * kuuluvat tasan kahteen kolmesta syÃ¶tejoukosta.
     * Jos jokin alkio kuuluu vain yhteen tai kaikkiin kolmeen syÃ¶tejoukkoon,
     * alkiota ei laiteta tulosjoukkoon.
     * Ei muuta syÃ¶tejoukkojensa sisÃ¤ltÃ¶Ã¤ (vaan luo uuden tulosjoukon)
     * Jos mikÃ¤Ã¤n alkio ei tÃ¤ytÃ¤ ehtoa, palautetaan tyhjÃ¤ joukko.
     * @param S1    syÃ¶tejoukko
     * @param S2    syÃ¶tejoukko
     * @param S3    syÃ¶tejoukko
     * @param <E>   alkioiden tyyppi
     * @return  tulosjoukko
     */
    public <E> Set<E> kaksiKolmesta(Set<E> S1, Set<E> S2, Set<E> S3);

}