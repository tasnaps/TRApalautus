import java.util.Arrays;
import java.util.Random;

/**
 * Testausluokka TRA I 2021 tehtÃ¤vÃ¤Ã¤n X1.
 */
public class TRAI_21_X1_testi {

    static Random rnd = new Random();

    static TRAI_21_X1 testattava = new TRAI_21_X1_tapiomer(); /* <-- Oma tunnus tÃ¤hÃ¤n */


    public static void main(String[] args) {

        // taulukoiden koko
        int N = 11;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        // satunnaislukusiemen
        int siemen = 42;
        if (args.length > 1)
            siemen = Integer.parseInt(args[1]);

        // tulostusten mÃ¤Ã¤rÃ¤
        int print = 7;
        if (args.length > 2)
            print = Integer.parseInt(args[2]);

        rnd.setSeed(siemen);

        boolean ok = true;

        // testataan erilaisilla syÃ¶tteillÃ¤
        ok &= testaaTulosX1(1, 1, 1, print);
        ok &= testaaTulosX1(2, 2, 4, print);
        ok &= testaaTulosX1(2, 2, 2, print);
        ok &= testaaTulosX1(3, 1, 3, print);
        ok &= testaaTulosX1(3, 1, 10, print);
        ok &= testaaTulosX1(4, 1, 10, print);
        ok &= testaaTulosX1(N, 1, N, print);
        ok &= testaaTulosX1(N, 1, N*2, print);
        ok &= testaaTulosX1(N/2, 1, N, print);
        ok &= testaaTulosX1(N*2, 0, N, print);
        ok &= testaaTulosX1(2, 300, 310, print);    // toimiihan myÃ¶s isommilla luvuilla?
        ok &= testaaTulosX1(5, 300, 310, print);
        ok &= testaaTulosX1(0, 0, 0, print);

        if (ok)
            System.out.println("Alun testit antoivat kaikki oikean tuloksen.");

        // asetetaan "satunnainen" satunnaislukusiemen
        rnd.setSeed(System.currentTimeMillis());

        // testataan monta satunnaista syÃ¶tettÃ¤
        int nTest = 1000;
        int k = 0;
        int virheet = 0;
        for (k = 0; k < nTest; k++) {
            if (! testaaTulosX1(rnd.nextInt(nTest)+2, rnd.nextInt(nTest), rnd.nextInt(nTest) + nTest, 0))
                virheet++;
            if (virheet > 30)
                break;
        }
        if (virheet > 0)
            ok = false;
        System.out.println("\n" + k + " lisÃ¤testistÃ¤ " + (k-virheet) + " oikein.");

        if (ok)
            System.out.println("\nKaikki tehdyt testit antoivat oikean tuloksen.\n\nMuista myÃ¶s itsearviointi.");
        else
            System.out.println("\nJoissain testeissÃ¤ virheitÃ¤.");


    }


    /**
     * Testaa tehtÃ¤vÃ¤Ã¤ satunnaisella syÃ¶tteellÃ¤.
     * @param n syÃ¶tteen koko
     * @param min pienin kokonaisluku
     * @param max suurin kokonaisluku
     * @param print miten paljon tulostetaan 0: ei mitÃ¤Ã¤n, 1 jotain, 2-: enemmÃ¤n
     * @return true jos testauksen tulos oli odotettu, muuten false
     */
    static boolean testaaTulosX1(int n, int min, int max, int print) {

        // syÃ¶tteen generointi, syÃ¶tteestÃ¤ kopio talteen ja mahdollinen tulostus
        Integer[] A = satunnainenTaulukko(n, min, max);
        Integer[] cA = Arrays.copyOf(A, A.length);

        if (print > 0) System.out.println("\nTesti n="+n + " min="+min + " max=" + max);
        if (n < 20 && print > 2 || print > 5) System.out.println("A[" + n + "]: " + Arrays.toString(A));

        Integer vrt = min + max; // oikea tulos
        if (n == 0)
            vrt = null;

        // kutsutaan varsinaista testattavaa metodia
        Integer tulos = testattava.suurinJaPieninSumma(A);

        // verrataan odotettuun tulokseen
        boolean samat = java.util.Objects.equals(tulos, vrt);

        // tulostetaan tulokset odotettuun
        if (print > 1) System.out.println("Tulos: " + tulos);
        if (print > 0 && ! samat)
            System.out.println("VÃ¤Ã¤rÃ¤ tulos: " + tulos + " vaikka piti olla: " + vrt);

        boolean sisaltoSailynyt = Arrays.equals(A, cA);
        if (! sisaltoSailynyt && print > 0)
            System.out.println("Virhe: metodi muuttaa taulukon sisÃ¤ltÃ¶Ã¤!");

        if (print > 1 && samat && sisaltoSailynyt)
            System.out.println("Testi ok");

        return samat && sisaltoSailynyt;

    }



    /**
     * Generoi satunnaisen n kokoisen taulukon jossa on annetut pienin ja
     * suurin alkio.
     * @param n alkioiden mÃ¤Ã¤rÃ¤
     * @param min pienin alkio
     * @param max suurin alkio
     * @return uusi taulukko.
     */
    static Integer[] satunnainenTaulukko(int n, int min, int max) {
        if (n < 0 || max < min || (n == 1 && min != max))
            throw new RuntimeException("Ei voi tehdÃ¤ vaadittua taulukkoa");
        Integer[] A = new Integer[n];

        if (n == 0)
            return A;
        if (n == 1) {
            A[0] = min; // == max
            return A;
        }

        for (int i = 0; i < n; i++) {
            A[i] = min + rnd.nextInt(max-min+1);
        }
        int minIndex = rnd.nextInt(n);
        int maxIndex = 0;
        do {
            maxIndex = rnd.nextInt(n);
        } while (minIndex == maxIndex);

        A[minIndex] = min;
        A[maxIndex] = max;
        return A;
    }

}
