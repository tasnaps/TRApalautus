package Viikko5;

// TRAI_21_t17.java SJ

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TRAI_21_t17_pohja {

    // kannattaa testata monipuolisesti erilaisilla syÃ¶tteillÃ¤ ja vaikka
    // tehdÃ¤ eri versioita syÃ¶tteen generoinnista

    public static void main(String[] args) {

        // listojen koko
        int N1 = 10;
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

        // tulostetaan listat jos alkioita ei ole paljoa
        if (N1 <= 20 && N2 <= 20) {
            System.out.println("L1: " + L1);
            System.out.println("L2: " + L2);
        }


        System.out.println();

        // kutsutaan tehtÃ¤vÃ¤Ã¤ 17
        List<Integer> xorTulos = listaXor(L1, L2);

        if (N1 <= 20 && N2 <= 20) {
            System.out.println("\nTehtÃ¤vÃ¤ 17, vain toisessa = " + xorTulos);
        } else {
            System.out.println(xorTulos.size() + " alkiota");
        }


    } // main()


    /**
     * 17. Kirjoita algoritmi joka saa parametrinaan kaksi jÃ¤rjestÃ¤mÃ¤tÃ¶ntÃ¤ listaa ja joka muodostaa ja palauttaa uuden
     * listan joka sisÃ¤ltÃ¤Ã¤ kaikki ne alkiot jotka ovat vain jommastakummassa listassa (siis niiden joko-tai -yhdisteen
     * (xor)). Jos jokin alkio esiintyy jommassakummassa listassa useasti, mutta ei toisessa listassa, niin se tulee
     * tuloslistaan vain kerran. KÃ¤ytÃ¤ jouk- ko(j)a (Set) apuna ja pyri lineaariseen aikavaativuuteen. Vihje: mieti
     * ensin tarkasti miten kÃ¤ytÃ¤t joukko(j)a hyÃ¶dyksi ja ryhdy tarkentamaan algoritmiasi vasta sitten.
     *
     * @param L1  syÃ¶telista
     * @param L2  syÃ¶telista
     * @param <E> parametrityyppi
     * @return alkiot jotka ovat vain toisessa listassa
     */
    public static <E> List<E> listaXor(List<E> L1, List<E> L2) {

        // tehdÃ¤Ã¤n samantyyppinen tuloslista kuin mitÃ¤ on lista L1
        List<E> tulos = null;
        try {
            tulos = L1.getClass().getConstructor().newInstance();
        } catch (Exception e) {
            System.out.println("Pieleen meni vaikka ei pitÃ¤nyt...");
            return null;
        }

        // TODO

        return tulos;

    }

} // class

