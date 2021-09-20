package Viikko4;
import java.util.*;

/** Testausluokka TRA I tehtÃ¤vÃ¤Ã¤n X3. */
public class TRAI_21_X3_testi {

    static Random rnd = new Random();

    static TRAI_21_X3 testattava = new TRAI_21_X3_tapiomer(); /* <-- Oma tunnus tÃ¤hÃ¤n */

    public static void main(String[] args) {

        // taulukoiden koko
        int N = 10;
        if (args.length > 0) N = Integer.parseInt(args[0]);

        // satunnaislukusiemen
        int siemen = 42;
        if (args.length > 1) siemen = Integer.parseInt(args[1]);

        // tulostusten mÃ¤Ã¤rÃ¤
        int print = 3;
        if (args.length > 2) print = Integer.parseInt(args[2]);

        rnd.setSeed(siemen);

        boolean ok = true;

        System.out.println("Testataan ensin ilman null:ja");

        // ei duplikaatteja
        ok &= testaaTulosX3(N, 0, false, print);

        // yksi duplikaatti
        ok &= testaaTulosX3(N, 1, false, print);

        // jonkun verran duplikaatteja
        ok &= testaaTulosX3(N, N / 2, false, print);

        // enemmÃ¤n duplikaatteja
        ok &= testaaTulosX3(N, N * 2, false, print);

        // lyhyitÃ¤ listoja
        ok &= testaaTulosX3(1, 0, false, print);
        ok &= testaaTulosX3(1, 1, false, print);
        ok &= testaaTulosX3(1, 2, false, print);
        ok &= testaaTulosX3(2, 0, false, print);
        ok &= testaaTulosX3(2, 2, false, print);
        ok &= testaaTulosX3(2, 6, false, print);
        ok &= testaaTulosX3(0, 0, false, print);

        System.out.println("\nTestataan null:ja sisÃ¤ltÃ¤viÃ¤ listoja\n");

        // ei duplikaatteja
        ok &= testaaTulosX3(N, 0, true, print);

        // yksi duplikaatti
        ok &= testaaTulosX3(N, 1, true, print);

        ok &= testaaTulosX3(N, N / 2, true, print);
        ok &= testaaTulosX3(1, 1, true, print);
        ok &= testaaTulosX3(3, 3, true, print);

        if (ok) System.out.println("Alun testit antoivat kaikki oikean tuloksen.");

        // asetetaan "satunnainen" satunnaislukusiemen
        rnd.setSeed(System.currentTimeMillis());

        // testataan monta satunnaista syÃ¶tettÃ¤
        int nTest = 1000;
        int k = 0;
        int virheet = 0;
        int oikein = 0;
        for (k = 0; k < nTest; k++) {
            int N1 = rnd.nextInt(k+1) * 10;
            int N2 = rnd.nextInt(k+1) * 10;
            if (N1 == 0)
                N2 = 0;
            if (!testaaTulosX3(N1, N2, rnd.nextBoolean(), 0)) virheet++;
            else oikein++;
            if (virheet > 30) {
                break;
            }
        }
        if (virheet > 0) ok = false;
        System.out.println("\n" + (virheet+oikein) + " satunnaisesta lisÃ¤testistÃ¤ " + oikein + " oikein.");

        if (ok)
            System.out.println(
                    "\nKaikki tehdyt testit antoivat oikean tuloksen.\nMuista myÃ¶s itsearviointi ja aikavaativuus.");
        else System.out.println("\nJoissain testeissÃ¤ virheitÃ¤.");

    /*

    System.out.println("\nAjetaan vielÃ¤ muutama suoritus toisenlaisella syÃ¶tteellÃ¤ josta ei ole verrokkia olemassa:");
    System.out.println("Tarkasta itse, ettÃ¤ tulos on oikein");

    suoritaX3satunnaiselle(N, 3, false, 2);
    suoritaX3satunnaiselle(N, 2, false, 2);
    suoritaX3satunnaiselle(N, 1, false, 2);
    suoritaX3satunnaiselle(N, 3, true, 2);
    suoritaX3satunnaiselle(N, 2, true, 2);
    suoritaX3satunnaiselle(N, 1, true, 2);

    */
    } // main()

    /**
     * Testaa perÃ¤kkÃ¤isten duplikaattien poistoa.
     *
     * @param n listan alkioiden mÃ¤Ã¤rÃ¤
     * @param dupl lisÃ¤ttÃ¤vien duplikaattien mÃ¤Ã¤rÃ¤
     * @param nulleja laitetaanko nulleja sekaan.
     * @param print tulostusten mÃ¤Ã¤rÃ¤
     * @return true jos testi meni oikein, muuten false
     */
    static boolean testaaTulosX3(int n, int dupl, boolean nulleja, int print) {

        // generoidaan syÃ¶tteet
        LinkedList<String> L = satunnainenListaIlmanPerakkaisiaDuplikaatteja(n, nulleja);

        // kopio alkuperÃ¤isestÃ¤ talteen
        LinkedList<String> cL = new LinkedList<>(L);

        // lisÃ¤tÃ¤Ã¤n duplikaatteja
        lisaaPerakkaisiaDuplikaattejaString(L, dupl);

        // tulostetaan syÃ¶tteet
        if (print > 0) System.out.println("\nTESTI n=" + n + " dupl=" + dupl + " nulleja=" + nulleja);
        if ((n <= 20 && dupl <= 20 && print > 2) || print > 5) {
            System.out.println("L[" + n + "]: " + L);
        }

        // kutsutaan testattavaa metodia

        int pituus0 = L.size();
        int tul = testattava.poistaPerakkaisetDuplikaatit(L);

        boolean ok = true;

        if (print > 0)
            System.out.println(
                    "Palautusarvo (poistettujen mÃ¤Ã¤rÃ¤) = "
                            + tul
                            + ". Piti poistaa "
                            + dupl
                            + " kappaletta, listan pituus muuttui "
                            + (pituus0 - L.size())
                            + " alkiolla");

        if (tul != pituus0 - L.size()) {
            ok = false;
            if (print > 0) System.out.println("Palautusarvo ei tÃ¤smÃ¤Ã¤ listan lyhentymiseen!");
        }
        if (tul != pituus0 - cL.size()) {
            ok = false;
            if (print > 0) System.out.println("Palautusarvo ei tÃ¤smÃ¤Ã¤ listan odotettuun lyhentymiseen!");
        }

        // tulostetaan tulos
        if ((L.size() <= 20 && print > 1) || print > 5) System.out.println("JÃ¤ljelle jÃ¤i   : " + L);

        if ((cL.size() <= 20 && print > 1) || print > 5) System.out.println("Odotettu tulos : " + cL);

        // verrataan tulosta verrokkiyhdisteeseen
        ok &= vertaa(L, cL, print);

        return ok;
    } // testaaTulosX3()

    /**
     * Suorittaa ajon kertaalleen. Tulostaa listan ennen ja jÃ¤lkeen, mutta
     * ei tarkasta tuloksen oikeellisuutta.
     *
     * @param n listan alkioiden mÃ¤Ã¤rÃ¤
     * @param aakkosto montaako erilaista alkiota arvotaan
     * @param nulleja laitetaanko sekaan nulleja vai ei
     * @param print tulostusten mÃ¤Ã¤rÃ¤
     */
    static void suoritaX3satunnaiselle(int n, int aakkosto, boolean nulleja, int print) {

        // generoidaan syÃ¶tteet
        LinkedList<String> L = satunnainenLista(n, aakkosto, nulleja);

        // kopio alkuperÃ¤isestÃ¤ talteen
        LinkedList<String> cL = new LinkedList<>(L);

        // tulostetaan syÃ¶tteet
        if (print > 0) System.out.println("\nAJO n=" + n + " aakkosto=" + aakkosto + " nulleja=" + nulleja);
        if ((n <= 20 && aakkosto <= 20 && print > 1) || print > 5) {
            System.out.println("L[" + n + "]: " + L);
        }

        // kutsutaan testattavaa metodia

        int pituus0 = L.size();
        int tul = testattava.poistaPerakkaisetDuplikaatit(L);

        if (print > 0)
            System.out.println(
                    "Palautusarvo (poistettujen mÃ¤Ã¤rÃ¤) = "
                            + tul
                            + " kappaletta, listan pituus muuttui "
                            + (pituus0 - L.size())
                            + " alkiolla");

        if (tul != pituus0 - L.size()) {
            if (print > 0) System.out.println("Palautusarvo ei tÃ¤smÃ¤Ã¤ listan lyhentymiseen!");
        }

        // tulostetaan tulos
        if ((L.size() <= 20 && print > 1) || print > 5) System.out.println("JÃ¤ljelle jÃ¤i   : " + L);
        System.out.println("HUOM: tÃ¤mÃ¤ ajo ei testaa tuloksen oikeellisuutta, vaan ainoastaan tulostaa.");


    }


    /**
     * LisÃ¤Ã¤ listaan L perÃ¤kkÃ¤isiÃ¤ duplikaatteja dupl kappaletta.
     * Monistaa listan satunnaisia alkioita yhteensÃ¤ dupl lisÃ¤ystÃ¤.
     * Luo uuden Stringin eikÃ¤ vain kopioi viittausta.
     *
     * @param L muutettava lista
     * @param dupl lisÃ¤ttÃ¤vien alkioiden mÃ¤Ã¤rÃ¤
     */
    static void lisaaPerakkaisiaDuplikaattejaString(LinkedList<String> L, int dupl) {
        int n = L.size();
        if (n == 0) return;
        int[] lis = new int[n];
        for (int i = 0; i < dupl; i++) lis[rnd.nextInt(n)]++;
        ListIterator<String> li = L.listIterator();
        int i = 0;
        while (li.hasNext()) {
            String x = li.next();
            for (int j = 0; j < lis[i]; j++)
                li.add(x == null ? null : new String(x.toCharArray()));
            i++;
        }
    } // lisaaPerakkaisiaDuplikaatteja()


    /**
     * LisÃ¤Ã¤ listaan L perÃ¤kkÃ¤isiÃ¤ duplikaatteja dupl kappaletta. Monistaa listan satunnaisia alkioita
     * yhteensÃ¤ dupl lisÃ¤ystÃ¤.
     * HUOM: lisÃ¤Ã¤ viittauksia samaan alkioon, ei luo uusia olioita.
     *
     * @param L muutettava lista
     * @param dupl lisÃ¤ttÃ¤vien alkioiden mÃ¤Ã¤rÃ¤
     * @param <E> alkiotyyppi
     */
    static <E> void lisaaPerakkaisiaDuplikaatteja(LinkedList<E> L, int dupl) {
        int n = L.size();
        if (n == 0) return;
        int[] lis = new int[n];
        for (int i = 0; i < dupl; i++) lis[rnd.nextInt(n)]++;
        ListIterator<E> li = L.listIterator();
        int i = 0;
        while (li.hasNext()) {
            E x = li.next();
            for (int j = 0; j < lis[i]; j++) li.add(x);
            i++;
        }
    } // lisaaPerakkaisiaDuplikaatteja()

    /**
     * Generoi satunnaisen merkkilistan jossa ei ole perÃ¤kkÃ¤isiÃ¤ duplikaatteja.
     *
     * @param n tuloslistan alkioiden mÃ¤Ã¤rÃ¤
     * @param nulleja laitetaanko listaan ainakin yksi null
     * @return tuloslista
     */
    static LinkedList<String> satunnainenListaIlmanPerakkaisiaDuplikaatteja(int n, boolean nulleja) {

        LinkedList<String> tulos = new LinkedList<>();
        if (n == 0)
            return tulos;

        int aakkosto = (n < 10) ? 5 : ((n < 26) ? n : 26);

        boolean nullLisatty = false;

        int i = 0;
        String edell = null;
        while (i < n) {
            String s = randomString(rnd, 1, aakkosto);
            if (nulleja && rnd.nextInt(aakkosto) == 0) s = null;
            if ((edell == null && s == null) || (edell != null && edell.equals(s))) continue;
            tulos.add(s);
            edell = s;
            i++;
            nullLisatty |= s == null;
        }

        if (nulleja && !nullLisatty) tulos.set(rnd.nextInt(n), null);

        return tulos;
    }

    /**
     * Generoi satunnaisen merkkijonolistan jossa voi olla duplikaatteja.
     * @param n listan koko
     * @param aakkosto montaako eri merkkiÃ¤ kÃ¤ytetÃ¤Ã¤n
     * @param nulleja laitetaanko null:ja sekaa
     * @return satunnainen merkkijonolista
     */
    static LinkedList<String> satunnainenLista(int n, int aakkosto, boolean nulleja) {
        LinkedList<String> tulos = new LinkedList<>();
        if (n == 0)
            return tulos;

        for (int i = 0; i < n; i++) {
            int c = (aakkosto == 0) ? 0 : rnd.nextInt(aakkosto);
            if (! nulleja || c != aakkosto-1) {
                char[] C = new char[1];
                C[0] = (char)('A' + c);
                tulos.add(new String(C));
            } else
                tulos.add(null);
        }
        return tulos;
    } // satunnainenLista()

    /**
     * Palauttaa satunnaisen pituus mittaisen merkkijonon.
     *
     * @param r satunnaislukugeneraattori
     * @param pituus merkkijonon pituus
     * @param aakkosto
     * @return uusi merkkijono
     */
    public static String randomString(Random r, int pituus, int aakkosto) {
        char[] C = new char[pituus];
        for (int i = 0; i < pituus; i++) C[i] = (char) (r.nextInt(aakkosto) + 'A');
        return new String(C);
    }

    /**
     * Vertaa kahden listan sisÃ¤ltÃ¶Ã¤.
     *
     * @param L verrattava
     * @param V verrokki
     * @param print
     * @return tosi jos samat alkiot samassa jÃ¤rjestyksessÃ¤, muuten epÃ¤tosi
     */
    public static <E> boolean vertaa(LinkedList<E> L, LinkedList<E> V, int print) {

        // jollei haluta tarkkaa raportointia, niin riittÃ¤Ã¤ nopeampi sisÃ¤ltÃ¶vertailu
        if (print == 0 || L.size() > 100 || V.size() > 100) return L.equals(V);

        if (print > 1 && L.size() <= 20 && V.size() <= 20) {
            System.out.println("Vertailu odotettuun tulokseen (verrokkiin V):");
            System.out.println("L=" + L);
            System.out.println("V=" + V);
        }

        if (L.size() != V.size()) {
            System.out.println("Eri kokoiset: T:" + L.size() + "  V:" + V.size());
            if (L.size() > V.size())
                System.out.println("Tuloslistassa enemmÃ¤n alkioita, jotain ei ole poistettu?");
            else System.out.println("Tuloslistassa vÃ¤hemmÃ¤n alkioita, onko poistettu liikaa?");
            return false;
        }

        if (!L.containsAll(V) || !V.containsAll(L)) {
            System.out.println("SisÃ¤llÃ¶t eivÃ¤t tÃ¤smÃ¤Ã¤");
            return false;
        }

        if (!L.equals(V)) {
            System.out.println("Alkioiden jÃ¤rjestys ei tÃ¤smÃ¤Ã¤");
            return false;
        }

        if (print > 1) System.out.println("Vertailu ok");

        return true;
    }
}
