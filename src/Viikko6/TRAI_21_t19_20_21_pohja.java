package Viikko6;

// TRAI_21_t19_20_21.java SJ

import java.util.*;

public class TRAI_21_t19_20_21_pohja {

    public static void main(String[] args) {

        int N = 6;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        Set<Set<Integer>> SS = new HashSet<>();

        Random r = new Random(N + 1);
        System.out.println("SyÃ¶tejoukot:");
        for (int i = 0; i < N; i++) {
            Set<Integer> S = new HashSet<>();
            for (int j = 0; j < N; j++) {
                S.add(r.nextInt(N * 2));
            }
            SS.add(S);
            System.out.println("S" + i + ": " + S);
        }

        Set<Integer> tulos = yhdiste(SS);
        System.out.println("\nKaikkien yhdiste: " + tulos);
        System.out.println();

        tulos = vainYhdessa(SS);
        System.out.println("Vain yhdessÃ¤: " + tulos);
        System.out.println();


        LinkedList<Set<Integer>> LS = new LinkedList<>(SS);
        System.out.println("Joukkojen lista:");
        tulostaRiveittain(LS);

        lajitteleAlkiomaaranMukaan((LS));

        System.out.println("Lista lajiteltuna joukkojen alkiomÃ¤Ã¤rÃ¤n mukaan:");
        tulostaRiveittain(LS);

    } // main()

    /**
     * Tulosta kokoelma riveittÃ¤in.
     *
     * @param CC  syÃ¶tekokoelma
     * @param <E> alkiotyyppi
     */
    static <E> void tulostaRiveittain(Collection<E> CC) {
        System.out.println("(");
        for (E x : CC) {
            System.out.println(x.toString());
        }
        System.out.println(")");
    }

    /**
     * 19. Kirjoita algoritmi joka saa parametrinaan joukkojen joukon (Set<Set<E>>) ja joka pa- lauttaa joukkona
     * (Set<E>) kaikki ne alkiot jossakin (tai joissakin) syÃ¶tejoukoissa. Siis yhdisteen. Vihje: iteraattori ja
     * joukko-operaatiot. MikÃ¤ on algoritmisi aikavaativuus?
     *
     * @param SS  joukkojen joukko
     * @param <E> joukkojen alkioiden tyyppi
     * @return kaikki jossain joukossa esiintyneet alkiot
     */
    public static <E> Set<E> yhdiste(Set<Set<E>> SS) {
        // TODO
        return null;
    }

    /**
     * 20. Kirjoita algoritmi joka saa parametrinaan joukkojen joukon (Set<Set<E>>) ja joka pa- lauttaa joukkona
     * (Set<E>) kaikki ne alkiot jotka ovat tasan yhdessÃ¤ syÃ¶tejoukoista. Ne alkiot jotka ovat useammassa kuin yhdessÃ¤
     * syÃ¶tejoukoista eivÃ¤t tule tulokseen. Ã„lÃ¤ muuta syÃ¶tejoukkoja. Vihje: iteraattori ja joukko-operaatiot. MikÃ¤ on
     * algoritmisi aikavaativuus?
     *
     * @param SS  joukkojen joukko
     * @param <E> joukkojen alkioiden tyyppi
     * @return kaikki ne alkiot jotka esiintyvÃ¤t vain yhdessÃ¤ joukossa
     */
    public static <E> Set<E> vainYhdessa(Set<Set<E>> SS) {
        Set<E> tulos = new HashSet<>();

        // TODO

        return tulos;
    } // vainYhdessa()


    /**
     * 21. Kirjoita algoritmi joka saa parametrinaan joukkojen listan (List<Set<E>>) ja lajittelee listan joukkojen
     * alkiomÃ¤Ã¤rÃ¤n mukaiseen jÃ¤rjestykseen. Vihje: Collections.sort() ja Compa- rator<Set>. MikÃ¤ on algoritmisi
     * aikavaativuus?
     *
     * @param LS  lista
     * @param <E> joukkojen alkiotyyppi (ei kÃ¤ytetÃ¤)
     */
    public static <E> void lajitteleAlkiomaaranMukaan(List<Set<E>> LS) {
        // TODO
    }

    static class kokoVertailija<T extends Set> implements Comparator<T> {
        /**
         * Compares its two arguments for order.  Returns a negative integer, zero, or a positive integer as the first
         * argument is less than, equal to, or greater than the second.
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or
         * greater than the second.
         * @throws NullPointerException if an argument is null and this comparator does not permit null arguments
         * @throws ClassCastException   if the arguments' types prevent them from being compared by this comparator.
         */
        @Override
        public int compare(T o1, T o2) {
            // TODO
            return 0;
        }

    }

} // class