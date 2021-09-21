package Viikko4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

 class TRAI_21_t10_pohja {

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

        LinkedList<String> LL1 = new LinkedList<>();
        LinkedList<String> LL2 = new LinkedList<>();

        // tÃ¤ytetÃ¤Ã¤n alkioilla
        Random r = new Random(siemen);
        for (int i = 0; i < n1; i++) {
            LL1.add(randomString(r, pituus));
        }

        for (int i = 0; i < n2; i++) {
            LL2.add(randomString(r, pituus));
        }

        Collections.sort(LL1);
        Collections.sort(LL2);

        // tulostetaan listat jos alkioita ei ole paljoa
        if (n1 <= 20 && n2 <= 20) {
            System.out.println("LL1: " + LL1);
            System.out.println("LL2: " + LL2);
        }

        // kutsutaan tehtÃ¤vÃ¤Ã¤ 10
        lomitaKasvavat(LL1, LL2);

        // tulostetaan listat jos alkioita ei ole paljoa
        if (n1 <= 20 && n2 <= 20) {
            System.out.println("LL1: " + LL1);
            System.out.println("LL2: " + LL2);
        }


    }

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
     * Kasvavien listojen lomitus.
     * LisÃ¤Ã¤ B:n alkiot listaan A siten, ettÃ¤ A sÃ¤ilyy jÃ¤rjestyksessÃ¤.
     * @param A kasvava lista johon lisÃ¤tÃ¤Ã¤n
     * @param B kasvava lista jonka alkiot lisÃ¤tÃ¤Ã¤n
     * @param <E> alkiotyyppi
     */
    static <E extends Comparable<? super E>> void lomitaKasvavat(LinkedList<E> A, LinkedList<E> B) {

        // TODO
        // vihje: mieti todella tarkkaan kuvan kanssa miten iteraattoria kÃ¤ytÃ¤t!
        // kullakin kierroksella joko kÃ¤sittele yksi toisen listan alkio ja 0 tai useampi toisesta
        // tai kullakin kierroksella kÃ¤sittele yksi alkio jommastakummasta listasta
    }


}
