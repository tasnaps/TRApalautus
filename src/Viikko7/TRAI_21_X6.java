package Viikko7;
import java.util.Map;
import java.util.Set;

public interface TRAI_21_X6 {
    /**
     * Alkioiden hakemisto.
     * Palauttaa kuvauksen jossa kutakin syĆ¶tejoukoissa olevaa alkiota kohti
     * on joukko niitĆ¤ joukkoja jossa ko. syĆ¶tealkio esiintyi.
     * @param SS syĆ¶tejoukkojen joukko
     * @param <E> alkioiden tyyppi
     * @return kuvaus alkioilta syĆ¶tejoukoille
     */
    <E> Map<E, Set<Set<E>>> hakemisto(Set<Set<E>> SS);
}
