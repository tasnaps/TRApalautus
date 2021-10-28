package Viikko7;

// TRA_21_X6_testi.java SJ

import java.util.*;

public class TRAI_21_X6_testi {


    static TRAI_21_X6 testattava = new TRAI_21_X6_pohja(); /* <-- Oma tunnus tÃ¤hÃ¤n */

    public static void main(String[] args) {

        // joukkojen mÃ¤Ã¤rÃ¤
        int N = 4;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        // alkioiden mÃ¤Ã¤rÃ¤ joukoissa
        int M = 3;
        if (args.length > 1)
            M = Integer.parseInt(args[1]);

        // testien mÃ¤Ã¤rÃ¤
        int K = 3;
        if (args.length > 2)
            K = Integer.parseInt(args[2]);

        boolean ok = true;

        for (int i = 0; i < K; i++)
            ok &= testaa(N+i, M+i);

        System.out.println("\n\nAlun " + K + " testin tulos:" + ok);

        // testataan vielÃ¤ pari erikoistapausta

        // yksi  joukko
        ok &= testaa(1, 1);

        // yksi tyhjÃ¤ joukko
        ok &= testaa(1, 0);

        // ei joukkoja
        ok &= testaa(0, 0);


        System.out.println("\n\nTestien tulos: " + ok);

    } // main()

    /**
     * testaa hakemistoa N joukolla joissa on kussakin noin M alkiota
     * @param N joukkojen  mÃ¤Ã¤rÃ¤
     * @param M alkioiden mÃ¤Ã¤rÃ¤ joukoissa
     * @return true jos testi antoi oikean tuloksen, muuten false
     */
    static boolean testaa(int N, int M) {

        System.out.println("\nTesti " + N + " joukolla joissa kussakin " + M + " alkiota");

        boolean ok = true;

        Set<Set<Integer>> SS = new HashSet<>();

        // luodaan testausta varten myÃ¶s kuvaus joka kertoo monessako
        // syÃ¶tejoukossa kukin alkio on
        Map<Integer, Integer> kaikki = new HashMap<>();

        Random r = new Random(N+M);
        System.out.print("SyÃ¶te:\n[");
        int i = 0;
        int ii = 0;
        while (i < N) {
            if (ii++ > N*100+10) {
                System.out.println("Ikuinen silmukka generoinnissa!!!!");
                break;
            }

            Set<Integer> S = new HashSet<Integer>();
            for (int j = 0; j < M; j++) {
                // haetaan sellainen x jota ei ole vielÃ¤ joukossa S
                // pidÃ¤ j-silmukan raja (N/2) pienempÃ¤nÃ¤ kuin nextInt parametri (N+1)
                Integer x = r.nextInt(M*2+1);
                while (S.contains(x))
                    x = r.nextInt(M*2+1);
                S.add(x);	// lisÃ¤ys syÃ¶tteeseen
            }
            boolean uusiJoukko = SS.add(S);	// lisÃ¤ys voi epÃ¤onnistua jos tulee samanlainen joukko
            if (uusiJoukko) {
                i++;
                System.out.print((i==1 ? " " : "  ") + S + (i==N ? " ]\n" : "\n"));
                for (Integer x : S)
                    kaikki.compute(x, (k, v) -> v == null ? 1 : v + 1); // lisÃ¤ys verrokkiin
            }
        }


        System.out.println("\nKutsutaan hakemiston tekoa.");
        Map<Integer, Set<Set<Integer>>> tulos = testattava.hakemisto(SS);

        System.out.println("\n Saadun hakemiston sisÃ¤ltÃ¶:");
        for (Map.Entry<Integer, Set<Set<Integer>>> e : tulos.entrySet()) {
            System.out.print(" Alkio " + e.getKey() + " lÃ¶ytyy: [");
            for (Set<Integer> S : e.getValue()) {
                System.out.print(" " + S);
            }
            System.out.println(" ]");
        }

        // jotain tarkastamista

        // katsotaan lÃ¶ytyvÃ¤tkÃ¶ kaikki syÃ¶tejoukkojen alkiot tuloskuvauksen avaimista
        if (! tulos.keySet().containsAll(kaikki.keySet())) {
            System.out.print("Tuloskuvauksen avaimista puuttuu: ");
            Set<Integer> kaikkiKopio = new HashSet<>(kaikki.keySet());
            kaikkiKopio.retainAll(tulos.keySet());
            System.out.println("" + kaikkiKopio);
            ok = false;
        }

        if (! kaikki.keySet().containsAll(tulos.keySet())) {
            System.out.print("Tuloskuvauksessa on liikaa avaimia: ");
            Set<Integer> tulosKopio = new HashSet<>(tulos.keySet());
            tulosKopio.retainAll(kaikki.keySet());
            System.out.println("" + tulosKopio);
            ok = false;

        }

        // katsotaan lÃ¶ytyykÃ¶ kukin avain niistÃ¤ joukoista jotka sen kuvassa on
        for (Map.Entry<Integer, Set<Set<Integer>>> e : tulos.entrySet()) {
            for (Set<Integer> S : e.getValue()) {
                if (! S.contains(e.getKey())) {
                    System.out.println("Alkio " + e.getKey() + " ei ole joukossa " +
                            S + " mutta joukko on alkion kuvassa");
                    ok = false;
                }
            }
        }

        // katsotaan kunkin alkion kohdalta onko joukkojen mÃ¤Ã¤rÃ¤ oikea
        for (Map.Entry<Integer, Integer> e : kaikki.entrySet()) {
            if (tulos.get(e.getKey()) != null &&
                    ! (e.getValue().intValue() == tulos.get(e.getKey()).size())) {
                System.out.println("Alkio " + e.getKey() + " lisÃ¤ttiin " + e.getValue() +
                        " joukkoon, mutta tuloksessa on vain " + tulos.get(e.getKey()).size() + " joukkoa.");
                ok = false;
            }
        }

        // varmistetaan ovatko kaikki tuloskuvauksen joukot alkuperÃ¤isen syÃ¶tejoukon alkioita
        for (Set<Set<Integer>> TSS : tulos.values()) {
            for (Set<Integer> S : TSS) {
                if (! sisaltaaViittauksen(SS, S)) { // jollei viittausta alkuperÃ¤iseen lÃ¶ydy
                    System.out.println("Joukko " + S + " ei ole syÃ¶tejoukkojoukon jÃ¤sen (ainakaan alkuperÃ¤isenÃ¤)" +
                            " (tai olet muuttanut syÃ¶tejoukkojoukkoa).");
                    ok = false;

                    if (SS.contains(S)) // joukko on samanlainen, mutta ei sama
                        System.out.println("Olet ottanut kopion joukosta " + S);
                }
            }
        }

        return ok;

    } // testaa

    /**
     * Tarkastaa sisÃ¤ltÃ¤Ã¤kÃ¶ kokoelma C viittauksen olioon o.
     * Siis nimenomaan tiettyyn olioon o, eikÃ¤ samanlaiseen (.equals) olioon.
     * TÃ¤mÃ¤ antaa eri tuloksen kun .contains() jos eri olioille .equals() on sama.
     * @param C kokoelma
     * @param o viittaus olioon jota haetaan
     * @return true jos lÃ¶ytyy, muuten false
     */
    public static boolean sisaltaaViittauksen(Collection C, Object o) {
        for (Object x : C) {
            if (o == x)
                return true;
        }
        return false;
    }

} // class TRAI_21_X6_testi
