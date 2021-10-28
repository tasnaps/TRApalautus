package Viikko6;

// TRAI_21_X5_testi.java SJ

import java.util.*;

public class TRAI_21_X5_testi {


    static TRAI_21_X5 testattava = new TRAI_21_X5_pohja(); /* <-- Oma tunnus tÃ¤hÃ¤n */
    static int print = 4;

    public static void main(String[] args) {

        int N = 5;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        int seed = N;
        if (args.length > 0)
            seed = Integer.parseInt(args[1]);

        if (args.length > 0)
            print = Integer.parseInt(args[2]);

        int virhe = 0;
        Random r = new Random(seed);

        virhe += testaa(r, 1, 1, 1, false, 2);    // satunnainen syÃ¶te
        virhe += testaa(r, 2, 2, 2, false, 2);    // satunnainen syÃ¶te
        virhe += testaa(r, 3, 3, 3, false, 2);    // satunnainen syÃ¶te

        virhe += testaa(r, N, N, N, false, 2);    // satunnainen syÃ¶te
        virhe += testaa(r, N, N, N, false, 1);    // satunnainen syÃ¶te
        virhe += testaa(r, N, N + 1, N + 2, false, 2);    // satunnainen syÃ¶te
        virhe += testaa(r, N + 2, N + 1, N, false, 2);    // satunnainen syÃ¶te
        virhe += testaa(r, N, N * 2, N * 3, false, 2);    // satunnainen syÃ¶te
        virhe += testaa(r, N * 3, N * 2, N, false, 2);    // satunnainen syÃ¶te
        virhe += testaa(r, N, N, N, false, 2);    // satunnainen syÃ¶te
        virhe += testaa(r, N, N, N, false, 4);    // satunnainen syÃ¶te
        virhe += testaa(r, N, N, N, false, 10);    // satunnainen syÃ¶te
        virhe += testaa(r, N, N, N, false, 100);    // satunnainen syÃ¶te
        virhe += testaa(r, N, N, N, true, 2);        // kaikkiin samat arvot
        virhe += testaa(r, N, N, 0, true, 2);    // kahteen samat arvot ja kolmas tyhjÃ¤
        virhe += testaa(r, N, 0, N, true, 2);    // kahteen samat arvot ja kolmas tyhjÃ¤
        virhe += testaa(r, 0, N, N, true, 2);    // kahteen samat arvot ja kolmas tyhjÃ¤
        virhe += testaa(r, N, N, 0, false, 1);    // kahteen jotain ja kolmas tyhjÃ¤
        virhe += testaa(r, N, 0, N, false, 1);    // kahteen jotain ja kolmas tyhjÃ¤
        virhe += testaa(r, 0, N, N, false, 1);    // kahteen jotain ja kolmas tyhjÃ¤
        virhe += testaa(r, 0, 0, N, true, 2);    // kaksi tyhjÃ¤Ã¤, kolmanteen jotain
        virhe += testaa(r, 0, 0, 0, true, 2);    // kolme tyhjÃ¤Ã¤

        r.setSeed(System.currentTimeMillis());
        virhe += testaa(r, N, N, N, false, 2);    // satunnainen syÃ¶te
        virhe += testaa(r, N, N, N, false, 4);    // satunnainen syÃ¶te

        System.out.println("\nYhteensÃ¤ " + virhe + " testiÃ¤ epÃ¤onnistui.");


    } // main()

    /**
     * Testaa metodia halutun kokoisilla syÃ¶tteillÃ¤.
     * Joukkojen koot voivat olla pienempiÃ¤ jos/kun satunnaislukugeneraattori
     * antaa samoja lukuja uudestaan.
     *
     * @param r     satunnaislukugeneraattori
     * @param n1    S1 koko
     * @param n2    S2 koko
     * @param n3    S3 koko
     * @param samat laitetaanko joukkoisin samoja lukuja vai eri lukuja
     * @param k     kerroin N:lle satunnaisluvun maksimia varten
     * @return 0 jos tulos oli oikea, muuten 1
     */
    static int testaa(Random r, int n1, int n2, int n3, boolean samat, int k) {
        Set<Integer> S1 = new HashSet<Integer>();
        Set<Integer> S2 = new HashSet<Integer>();
        Set<Integer> S3 = new HashSet<Integer>();

        if (samat) {    // samat arvot kaikkiin
            int N = Math.max(Math.max(n1, n2), n3);
            for (int i = 0; i < N; i++) {
                int x = r.nextInt(N * k);
                if (i < n1) S1.add(x);
                if (i < n2) S2.add(x);
                if (i < n3) S3.add(x);
            }

        } else {    // kullekin eri arvoja
            for (int i = 0; i < n1; i++)
                S1.add(r.nextInt(n1 * k));

            for (int i = 0; i < n2; i++)
                S2.add(r.nextInt(n2 * k));

            for (int i = 0; i < n3; i++)
                S3.add(r.nextInt(n3 * k));
        }

        System.out.println("---------------------------------------------\nSyÃ¶tejoukot:");
        System.out.println("S1:          " + S1);
        System.out.println("S2:          " + S2);
        System.out.println("S3:          " + S3);

        Set<Integer> vrt = kahdessaKolmestaKuvauksella(S1, S2, S3);

        Set<Integer> tulos = testattava.kaksiKolmesta(S1, S2, S3);

        System.out.println("kaksiKolmesta: " + (new HashSet<>(tulos)));	// jos haluat lajiteltuna tuloksen

        System.out.println("verrokki     : " + (new HashSet<>(vrt)));	    // jos haluat lajiteltuna tuloksen


        if (print > 2) {

            System.out.println("SyÃ¶tejoukot kutsun jÃ¤lkeen (tarkasta etteivÃ¤t muuttuneet):");
            System.out.println("S1:          " + S1);
            System.out.println("S2:          " + S2);
            System.out.println("S3:          " + S3);
        }

        if (vrt.equals(tulos)) {
            System.out.println("SisÃ¤ltÃ¶ tÃ¤smÃ¤Ã¤vÃ¤t, hienoa");
            return 0;
        } else {
            System.out.println("SisÃ¤llÃ¶issÃ¤ eroa");
            return 1;
        }
    }
    /**
     * kahdessa kolmesta -yhdiste kÃ¤yttÃ¤en kuvausta.
     * TÃ„MÃ„ SIIS TEKEE SAMAN KUIN X5 VAADITAAN, MUTTA X5:SSA ON NYT KIELLETTY KUVAUKSEN KÃ„YTTÃ–
     * JOTEN TÃ„STÃ„ EI KANNATA OTTAA MALLIA. EIKÃ„ TÃ„MÃ„ MUUTENKAAN OLE OHJELMOINTITEKNISESTI
     * TYYLIKÃ„S RATKAISU.
     * Luo ja palauttaa uuden joukon jossa on ne alkiot jotka ovat
     * tasan kahdessa kolmesta syÃ¶tejoukosta.
     * Jos mikÃ¤Ã¤n alkio ei tÃ¤ytÃ¤ ehtoa, palautetaan tyhjÃ¤ joukko.
     * Ei muuta syÃ¶tejoukkoja.
     *
     * @param S1 syÃ¶tejoukko
     * @param S2 syÃ¶tejoukko
     * @param S3 syÃ¶tejoukko
     * @param <E> alkiotyyppi
     * @return tulosjoukko
     */
    public static <E> Set<E> kahdessaKolmestaKuvauksella(Set<E> S1, Set<E> S2, Set<E> S3) {
        HashMap<E, Integer> HM = new HashMap<>((S1.size()+S2.size()+S3.size()*2));
        for (Set<E> S : new LinkedList<Set<E>>() {{ add(S1); add(S2); add(S3); }} )
            for (E x : S) HM.compute(x, (k, v) -> v == null ? 1 : v+1);
        HM.entrySet().removeIf(e -> e.getValue() != 2);
        return HM.keySet();
    }


} // class TRAI_21_X5_testi