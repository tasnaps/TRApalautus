package Viikko4;

import fi.uef.cs.tra.ListNode;
import fi.uef.cs.tra.TraLinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class TRAI_21_t11_pohja {

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
        Random r = new Random(siemen);
        ArrayList<String> AL1 = new ArrayList<>();
        ArrayList<String> AL2 = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            AL1.add(randomString(r, pituus));
        }

        for (int i = 0; i < n2; i++) {
            AL2.add(randomString(r, pituus));
        }
        Collections.sort(AL1);
        Collections.sort(AL2);

        TraLinkedList<String> LL1 = new TraLinkedList<>();
        TraLinkedList<String> LL2 = new TraLinkedList<>();
        for (String s : AL1)
            LL1.insert(LL1.EOL, s);
        for (String s : AL2)
            LL2.insert(LL2.EOL, s);

        // tulostetaan listat jos alkioita ei ole paljoa
        if (n1 <= 20 && n2 <= 20) {
            System.out.println("LL1: " + TraLinkedListToString(LL1));
            System.out.println("LL2: " + TraLinkedListToString(LL2));
        }

        // kutsutaan tehtÃ¤vÃ¤Ã¤ 11
        lomitaKasvavat(LL1, LL2);

        // tulostetaan listat jos alkioita ei ole paljoa
        if (n1 <= 20 && n2 <= 20) {
            System.out.println("LL1: " + TraLinkedListToString(LL1));
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
     * Kasvavien listojen lomitus. LisÃ¤Ã¤ B:n alkiot listaan A siten, ettÃ¤ A sÃ¤ilyy jÃ¤rjestyksessÃ¤.
     *
     * @param A   kasvava lista johon lisÃ¤tÃ¤Ã¤n
     * @param B   kasvava lista jonka alkiot lisÃ¤tÃ¤Ã¤n
     * @param <E> alkiotyyppi
     */
    static <E extends Comparable<? super E>> void lomitaKasvavat(TraLinkedList<E> A, TraLinkedList<E> B) {

        // TODO
        // katso mallia muista luentojen ja esimerkkihakemiston TraLinkedList -ohjelmista
    }

    /**
     * Listan merkkijonoesitys.
     *
     * @param L   lista
     * @param <E> alkiotyyppi
     * @return lista merkkijonona
     */
    static <E> String TraLinkedListToString(TraLinkedList<E> L) {
        StringBuilder sb = new StringBuilder();
        sb.append("( ");
        ListNode<E> n = L.first();
        while (n != L.EOL) {
            sb.append(n.getElement().toString());
            sb.append(" ");
            n = n.next();
        }
        sb.append(")");
        return sb.toString();
    }


}
