package Viikko7;

// TRAI_21_t27.java SJ

import java.util.Random;

class TRAI_21_t27_pohja {

    static Random rnd = new Random(System.currentTimeMillis());

    public static void main(String[] args) {

        Random rnd = new Random(System.currentTimeMillis());

        // ensimmÃ¤inen komentoriviparametri: alkioiden mÃ¤Ã¤rÃ¤
        int N = 10000;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);

        // toinen parametri: tulostetaanko vai ei, >1 = tulosta
        boolean print = true;
        if (args.length > 1 && (Integer.parseInt(args[1]) > 0))
            print = true;

        // kolmas parametri: jÃ¤rjesteyksessÃ¤ vai ei
        // -1 : laskeva jÃ¤rjestys, 1 = kasvava jÃ¤rjestys, 0 = satunnainen, 2 = satunnainen kasvava, 3 = satunnaisesti joku edellisistÃ¤
        int J = 3;
        if (args.length > 2)
            J = Integer.parseInt(args[2]);

        if (J == 3)
            J = satunnainenLuku(rnd, -1, 2);

        if (J == -1) System.out.println("SyÃ¶te laskevassa jÃ¤rjestyksessÃ¤");
        if (J == 0) System.out.println("SyÃ¶te satunnaisessa jÃ¤rjestyksessÃ¤");
        if (J == 2) System.out.println("SyÃ¶te satunnaisessa jÃ¤rjestyksessÃ¤, mutta pieniÃ¤ aluksi ja sitten isoja");
        if (J == 1) System.out.println("SyÃ¶te kasvavassa jÃ¤rjestyksessÃ¤");


        Integer[] taulu;
        long start, end;

        if (N <= 50000) {
            // Kuplalajittelu
            taulu = satunnainenTaulu(N, J, 1);
            if (print && N < 50)
                for (int i = 0; i < N; i++)
                    System.out.print(taulu[i] + " ");
            System.out.println();
            System.out.println("Kuplalajittelu alkaa");
            start = System.nanoTime();
            bubbleSort(taulu);
            end = System.nanoTime();
            System.out.println("               " +
                    (end - start) + " ns");
            if (print && N < 50)
                for (int i = 0; i < N; i++)
                    System.out.print(taulu[i] + " ");
            System.out.println();
        }

        // Tavallinen pikalajittelu
        taulu = satunnainenTaulu(N, J, 1);
        System.out.println("Pikalajittelu  alkaa");
        start = System.nanoTime();
        quicksort(taulu, 0, N - 1);
        end = System.nanoTime();
        System.out.println("               " +
                (end - start) + " ns");
        if (print && N < 50)
            for (int i = 0; i < N; i++)
                System.out.print(taulu[i] + " ");
        System.out.println();

        // Pikalajittelu viritettynÃ¤
        taulu = satunnainenTaulu(N, J, 1);
        System.out.println("Viritetty pikalajittelu alkaa");
        start = System.nanoTime();
        quicksort27(taulu, 0, N - 1);
        end = System.nanoTime();
        System.out.println("               " +
                (end - start) + " ns");
        if (print && N < 50)
            for (int i = 0; i < N; i++)
                System.out.print(taulu[i] + " ");
        System.out.println();


    } // main()

    public static Integer[] satunnainenTaulu(int N, int J, int seed) {
        Integer[] taulu = new Integer[N];

        Random r = new Random(seed);
        for (int i = 0; i < N; i++) {
            if (J == 0)
                taulu[i] = (r.nextInt(N * 2));
            else if (J == 1)
                taulu[i] = (i);
            else if (J == -1)
                taulu[i] = (N - i);
            else
                taulu[i] = (r.nextInt((i+1) * 2));

        }

        return taulu;
    } // satunnainenTaulu()

    /**
     * Kuplalajittelu.
     *
     * @param A   lajiteltava taulukko
     * @param <E> alkiotyyppi
     */
    public static <E extends Comparable<? super E>> void bubbleSort(E[] A) {

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = A.length - 1; j > i; j--) {
                if (A[j - 1].compareTo(A[j]) > 0) {
                    E tmp = A[j - 1];
                    A[j - 1] = A[j];
                    A[j] = tmp;
                }
            }
        }
    } // bubbleSort()


    /**
     * Kuplalajittelu osataulukolle.
     *
     * @param A     lajiteltava taulukko
     * @param alku  lajiteltavan osan ensimmÃ¤inen indeksi
     * @param loppu lajiteltavan osan viimeinen indeksi
     * @param <E>   alkiotyyppi
     */
    public static <E extends Comparable<? super E>>
    void bubbleSort(E[] A, int alku, int loppu) {
        for (int i = alku; i <= loppu; i++) {
            for (int j = loppu; j > i; j--) {
                if (A[j - 1].compareTo(A[j]) > 0) {
                    E tmp = A[j - 1];
                    A[j - 1] = A[j];
                    A[j] = tmp;
                }
            }
        }
    } // bubbleSort()


    /**
     * Viritetty pikalajittelu
     *
     * @param A
     * @param i
     * @param j
     * @param <E>
     */
    public static <E extends Comparable<? super E>>
    void quicksort27(E[] A, int i, int j) {
        // TODO: viritÃ¤
        if (i >= j)
            return;
        else {
            int k = partition27(A, i, j);
            quicksort27(A, i, k - 1);
            quicksort27(A, k + 1, j);
        }
    } // quicksort()


    /**
     * Viritetyn pikalajittelun viritetty jaottelu
     *
     * @param A
     * @param i
     * @param j
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>>
    int partition27(E[] A, int i, int j) {

        // TODO: viritÃ¤
        E jakoalkio = A[i];

        // toistetaan kunnes i ja j tÃ¶rmÃ¤Ã¤vÃ¤t
        while (i < j) {

            // etsitÃ¤Ã¤n lopusta jakoalkiota pienempi
            while ((i < j) && (jakoalkio.compareTo(A[j]) < 0))
                j--;
            A[i] = A[j];

            // etsitÃ¤Ã¤n alusta jakoalkiota suurempi tai yhtÃ¤suuri
            while ((i < j) && (jakoalkio.compareTo(A[i]) >= 0))
                i++;
            A[j] = A[i];

        } // while

        // jakoalkio paikalleen ja palautetaan sijainti
        A[i] = jakoalkio;
        return i;

    } // partition()


    /**
     * Tavallinen pikalajittelu.
     *
     * @param A
     * @param i
     * @param j
     * @param <E>
     */
    public static <E extends Comparable<? super E>>
    void quicksort(E[] A, int i, int j) {
        if (i < j) {
            int k = partition(A, i, j);
            quicksort(A, i, k - 1);
            quicksort(A, k + 1, j);
        }
    } // quicksort()

    public static <E extends Comparable<? super E>>
    int partition(E[] A, int i, int j) {

        // jakoalkioksi ensimmÃ¤inen
        // NÃ„IN SAA TEHDÃ„ VAIN OPETUSTARKOITUKSESSA, EI KOSKAAN
        // OIKEASSA OHJELMASSA
        // HarjoitustehtÃ¤vÃ¤nÃ¤ satunnainen alkio
        E jakoalkio = A[i];

        // toistetaan kunnes i ja j tÃ¶rmÃ¤Ã¤vÃ¤t
        while (i < j) {

            // etsitÃ¤Ã¤n lopusta jakoalkiota pienempi
            while ((i < j) && (jakoalkio.compareTo(A[j]) < 0))
                j--;
            A[i] = A[j];

            // etsitÃ¤Ã¤n alusta jakoalkiota suurempi tai yhtÃ¤suuri
            while ((i < j) && (jakoalkio.compareTo(A[i]) >= 0))
                i++;
            A[j] = A[i];

        } // while

        // jakoalkio paikalleen ja palautetaan sijainti
        A[i] = jakoalkio;
        return i;

    } // partition()


    private static int satunnainenLuku(Random r, int min, int max) {
        int d = max - min + 1;
        if (d < 1)
            d = 1;
        return r.nextInt(d) + min;
    }


} // class TRAI_21_t27

