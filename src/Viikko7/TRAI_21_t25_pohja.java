package Viikko7;

// TRAI_21_t8_9.java SJ
// PÃ¤Ã¤ohjelma viikon 2 tehtÃ¤viin 8 ja 9

import java.lang.reflect.Array;
import java.util.*;


public class TRAI_21_t25_pohja {


    // PÃ¤Ã¤ohjelman kÃ¤yttÃ¶:
    // java TRAI_21_t25 [N] [N2] [S]
    // missÃ¤ N on alkioiden mÃ¤Ã¤rÃ¤, N2 on alkoiden mÃ¤Ã¤rÃ¤ toisessa taulukossa
    // ja S on satunnaislukusiemen
    public static void main(String[] args) {

        // alkioiden mÃ¤Ã¤rÃ¤
        int n1 = 15;
        if (args.length > 0)
            n1 = Integer.parseInt(args[0]);

        int pituus = 1; // merkkijonojen pituus
        if (n1 > 30)
            pituus = 2;

        // montaako eri merkkiÃ¤ kÃ¤ytetÃ¤Ã¤n merkkijonoissa
        int merkisto = 4;

        // satunnaislukusiemen
        int siemen = 42;
        if (args.length > 2)
            siemen = Integer.parseInt(args[2]);


        // testataan vaihteeksi merkkijonoilla

        ArrayList<String> AL = new ArrayList<>(n1);

        // tÃ¤ytetÃ¤Ã¤n alkioilla
        Random r = new Random(siemen);
        for (int i = 0; i < n1; i++) {
            AL.add(randomString(r, pituus, merkisto));
        }

        // tulostetaan taulukot jos alkioita ei ole paljoa
        if (n1 <= 20) {
            System.out.println("AL: " + AL);
        }

        // otetaan listasta kopiot LinkedList:iÃ¤ varten
        LinkedList<String> LL = new LinkedList<>(AL);


        // testataan tehtÃ¤vÃ¤Ã¤ 25
        // vaihda LL tilalle AL jos testaat ArrayList-versiota

        poistaYliKesiintymat(LL, 3);

        System.out.print("TehtÃ¤vÃ¤ 25, LL max 3 alkiota: ");
        if (n1 <= 20) {
            System.out.println(LL);
        } else {
            System.out.println(LL.size() + " alkiota");
        }

        poistaYliKesiintymat(LL, 1);

        System.out.print("TehtÃ¤vÃ¤ 25, LL max 1 alkiota: ");
        if (n1 <= 20) {
            System.out.println(LL);
        } else {
            System.out.println(LL.size() + " alkiota");
        }

        poistaYliKesiintymat(LL, 0);

        System.out.print("TehtÃ¤vÃ¤ 25, LL max 0 alkiota: ");
        if (n1 <= 20) {
            System.out.println(LL);
        } else {
            System.out.println(LL.size() + " alkiota");
        }




    } // main()


    // riittÃ¤Ã¤ tehdÃ¤ nÃ¤istÃ¤ toinen, mutta toki molempien tekeminen on
    // hyÃ¶dyllistÃ¤ harjoitusta kerrata ArrayList:n ja LinkedList:n eroja

    /**
     * Poistaa listasta LL kunkin alkion ylimÃ¤Ã¤rÃ¤iset (yli k kpl) esiintymÃ¤t.
     * @param LL muokattava lista
     * @param k montako kpl kutakin alkiota jÃ¤tettÃ¤Ã¤n
     * @param <E> alkiotyyppi
     */
    public static <E> void poistaYliKesiintymat(LinkedList<E> LL, int k) {

        // TODO

    }

    /**
     * Poistaa listasta AL kunkin alkion ylimÃ¤Ã¤rÃ¤iset (yli k kpl) esiintymÃ¤t.
     * @param AL muokattava lista
     * @param k montako kpl kutakin alkiota jÃ¤tettÃ¤Ã¤n
     * @param <E> alkiotyyppi
     */
    public static <E> void poistaYliKesiintymat(ArrayList<E> AL, int k) {

        // TODO

    }


    /**
     * Palauttaa satunnaisen len mittaisen merkkijonon.
     *
     * @param r   satunnaislukugeneraattori
     * @param pituus merkkijonon pituus
     * @param merkisto
     * @return uusi merkkijono
     */
    public static String randomString(Random r, int pituus, int merkisto) {
        char[] C = new char[pituus];
        for (int i = 0; i < pituus; i++)
            C[i] = (char) (r.nextInt(merkisto) + 'a');
        return new String(C);
    }


} // class
