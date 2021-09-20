package Viikot1_3;// TRAI_21_t8_9.java SJ
// PÃ¤Ã¤ohjelma viikon 2 tehtÃ¤viin 8 ja 9

import java.util.*;

/**
 * 8. Kirjoita algoritmi joka saa parametrinaan kaksi jÃ¤rjestÃ¤mÃ¤tÃ¶ntÃ¤ listaa A ja B (ArrayList)
 * ja joka poistaa listasta A kaikki ne alkiot jotka esiintyvÃ¤t listassa B. Ã„lÃ¤ kÃ¤ytÃ¤ valmista
 * removeAll() -operaatioita. Aikavaativuus? Miten aikavaativuutta voisi parantaa?
 *
 * 9. Kirjoita algoritmi joka saa parametrinaan kaksi jÃ¤rjestÃ¤mÃ¤tÃ¶ntÃ¤ listaa A ja B (LinkedList)
 * ja joka poistaa listasta A kaikki ne alkiot jotka esiintyvÃ¤t listassa B. Algoritmi palauttaa
 * poistettujen alkioiden mÃ¤Ã¤rÃ¤n. Nyt ei siis luoda uutta listaa, vaan muokataan parametrina
 * saatua. Ã„lÃ¤ kÃ¤ytÃ¤ valmista remove(Object) tai removeAll() -operaatiota. Aikavaativuus?
 * Miten aikavaativuutta voisi parantaa?
 **/

public class TRAI_21_t8_9_pohja {


    // PÃ¤Ã¤ohjelman kÃ¤yttÃ¶:
    // java TRAI_21_t8_9 [N] [N2] [S]
    // missÃ¤ N on alkioiden mÃ¤Ã¤rÃ¤, N2 on alkoiden mÃ¤Ã¤rÃ¤ toisessa taulukossa
    // ja S on satunnaislukusiemen
    public static void main(String[] args) {

        // alkioiden mÃ¤Ã¤rÃ¤
        int n1 = 10;
        if (args.length > 0)
            n1 = Integer.parseInt(args[0]);

        int n2 = n1 + 2;
        if (args.length > 1)
            n2 = Integer.parseInt(args[1]);

        int pituus = 1; // merkkijonojen pituus
        if (n1 > 30)
            pituus = 2;

        // satunnaislukusiemen
        int siemen = 42;
        if (args.length > 2)
            siemen = Integer.parseInt(args[2]);


        // testataan vaihteeksi merkkijonoilla

        ArrayList<String> AL1 = new ArrayList<>(n1);
        ArrayList<String> AL2 = new ArrayList<>(n2);

        // tÃ¤ytetÃ¤Ã¤n alkioilla
        Random r = new Random(siemen);
        for (int i = 0; i < n1; i++) {
            AL1.add(randomString(r, pituus));
        }

        for (int i = 0; i < n2; i++) {
            AL2.add(randomString(r, pituus));
        }

        // tulostetaan taulukot jos alkioita ei ole paljoa
        if (n1 <= 20 && n2 <= 20) {
            System.out.println("AL1: " + AL1);
            System.out.println("AL2: " + AL2);
        }

        // otetaan listoista kopiot tehtÃ¤vÃ¤Ã¤n 9
        LinkedList<String> LL1 = new LinkedList<>(AL1);
        LinkedList<String> LL2 = new LinkedList<>(AL2);


        // testataan tehtÃ¤vÃ¤Ã¤ 8

        poistaKaikki8(AL1, AL2);

        System.out.print("TehtÃ¤vÃ¤ 8, AL1-AL2: ");
        if (n1 <= 20 && n2 <= 20) {
            System.out.println(AL1);
        } else {
            System.out.println(AL1.size() + " alkiota");
        }

        // testataan tehtÃ¤vÃ¤Ã¤ 9

        poistaKaikki9(LL1, LL2);

        System.out.print("TehtÃ¤vÃ¤ 9, LL1-LL2: ");
        if (n1 <= 20 && n2 <= 20) {
            System.out.println(LL1);
        } else {
            System.out.println(LL1.size() + " alkiota");
        }


    } // main()


    /**
     * Palauttaa satunnaisen len mittaisen merkkijonon.
     *
     * @param r   satunnaislukugeneraattori
     * @param len merkkijonon pituus
     * @return uusi merkkijono
     */
    public static String randomString(Random r, int len) {
        char[] C = new char[len];
        for (int i = 0; i < len; i++)
            C[i] = (char) (r.nextInt(26) + 'a');
        return new String(C);
    }


    /**
     * Poista kaikki B alkioiden esiintymÃ¤t listasta A.
     *
     * @param A lista josta poistetaan
     * @param B alkiot jotka poistetaan
     * @return poistettujen alkioiden mÃ¤Ã¤rÃ¤
     */
    public static <E> int poistaKaikki8(ArrayList<E> A, ArrayList<E> B) {
        int poistettu = 0; // alustus

        // TODO

        return poistettu;
    }

    /**
     * Poista kaikki B alkioiden esiintymÃ¤t listasta A.
     *
     * @param A lista josta poistetaan
     * @param B alkiot jotka poistetaan
     * @return
     */
    /* triviaali neliÃ¶llinen versio */
    public static <E> int poistaKaikki9(LinkedList<E> A, LinkedList<E> B) {
        int poistettu = 0; // alustus

        // TODO

        return poistettu;
    }


} // class
