package Viikko6;

// TRAI_21_t22.java SJ

import java.util.*;

public class TRAI_21_t22_pohja {

    // kannattaa testata monipuolisesti erilaisilla syÃ¶tteillÃ¤ ja vaikka
    // tehdÃ¤ eri versioita syÃ¶tteen generoinnista

    public static void main(String[] args) {

        // taulukoiden koko
        int N1 = 15;
        if (args.length > 0)
            N1 = Integer.parseInt(args[0]);

        int N2 = N1 + 2;
        if (args.length > 0)
            N2 = Integer.parseInt(args[1]);

        // satunnaislukusiemen
        int siemen = N1 + N2;
        if (args.length > 2)
            siemen = Integer.parseInt(args[2]);

        // saako olla samoja alkioita
        int eri = 0;
        if (args.length > 3)
            eri = 1;

        Random r = new Random(siemen);

        LinkedList<Integer> L1 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();

        for (int i = 0; i < N1; i++) {
            L1.add(r.nextInt(N1 / 2));
        }
        for (int i = 0; i < N1; i++) {
            L2.add(r.nextInt((N2 / 2) + eri * N1));
        }

        // tulostetaan taulukot jos alkioita ei ole paljoa
        if (N1 <= 20 && N2 <= 20) {
            System.out.println("L1: " + L1);
            System.out.println("L2: " + L2);
        }

        // kutsutaan tehtÃ¤vÃ¤Ã¤ 22
        System.out.println();
        Map<Integer, Integer> esiintymat1 = esiintymat(L1);
        for (Map.Entry<Integer, Integer> e : esiintymat1.entrySet()) {
            System.out.println("Alkio " + e.getKey() + " esiintyi " + e.getValue() + " kertaa.");
        }
        System.out.println();


    } // main()


    /**
     * 22. Kirjoita algoritmi joka saa parametrinaan kokoelman (Collection<E>) ja joka muodostaa
     * ja palauttaa kuvauksen (HashMap<E, Integer>) jossa on avaimina kaikki eri alkiot jotka
     * kokoelmasta lÃ¶ytyvÃ¤t. Kunkin avaimen kuvana on ko. esiintymien lukumÃ¤Ã¤rÃ¤. Vihje: kaikki
     * kokoelmat tukevat foreach-lÃ¤pikÃ¤yntiÃ¤. Aikavaativuus?
     *
     * @param C   syÃ¶tekokoelma
     * @param <E> alkiotyyppi
     * @return kuvaus jossa avaimina ovat C:n alkiot ja arvona ko. alkion esiintymismÃ¤Ã¤rÃ¤t
     */
    public static <E> HashMap<E, Integer> esiintymat(Collection<E> C) {

        HashMap<E, Integer> esiintymat = new HashMap<>();

        // TODO

        return esiintymat;
    }


} // class
