package Viikko6;

// TraI_21_t18.java SJ

import fi.uef.cs.tra.TraSet;

import java.util.Random;

public class TraI_21_t18_pohja {

    public static void main(String[] args) {

        int N = 10;
        if (args.length > 0)
            N = Integer.parseInt(args[0]);


        TraSet<Integer> S1 = new TraSet<>();
        TraSet<Integer> S2 = new TraSet<>();
        TraSet<Integer> S3 = new TraSet<>();

        Random r = new Random(42);
        Integer x, y;
        for (int i = 0; i < N; i++) {
            x = r.nextInt(N * 2);
            y = r.nextInt(N * 2);
            S1.add(x);
            S2.add(x - y);
            S3.add(x + y);
        }


        System.out.println("S1:      " + S1);
        System.out.println("S2:      " + S2);
        System.out.println("S3:      " + S3);


        System.out.println("KaksikolmestaTRA: " + kaksiKolmesta(S1, S2, S3));


    } // main()


    /**
     * 18. Kirjoita algoritmi joka hakee joukkojen â€kaksi kolmestaâ€ leikkauksen. Algoritmi saa siis parametrinaan kolme
     * tietorakennekirjastomme joukkoa (TraSet) ja muodostaa uuden joukon niistÃ¤ alkioista jotka kuuluvat tÃ¤smÃ¤lleen
     * kahteen syÃ¶tejoukoista. Mukana ei siis ole niitÃ¤ alkioita jotka kuuluvat vain yhteen syÃ¶tejoukoista, eikÃ¤ niitÃ¤
     * alkioita jotka kuuluvat kaikkiin syÃ¶tejoukkoihin. Ã„lÃ¤ muuta syÃ¶tejoukkoja Ã¤lÃ¤kÃ¤ kÃ¤ytÃ¤ apuna kuvausta (Map) tai
     * Javan va- kiokirjaston joukkoa (Set). VihjeitÃ¤: voit ottaa joukoista kopioita, kÃ¤ytÃ¤ joukko-operaatioita, ei
     * kannata lÃ¤hteÃ¤ iteroimaan joukkoja alkioittain. MikÃ¤ on algoritmisi aikavaativuus kun TraSet:n operaatioiden
     * aikavaativuus on kuten vastaavilla TreeSet -operaatioilla?
     *
     * @param A   syÃ¶tejoukko
     * @param B   syÃ¶tejoukko
     * @param C   syÃ¶tejoukko
     * @param <E> alkiotyyppi (ei kÃ¤ytetÃ¤)
     * @return uusi joukko jossa on ne alkiot jotka lÃ¶ytyvÃ¤t tasan kahdesta syÃ¶tejoukosta
     */
    public static <E> TraSet<E> kaksiKolmesta(TraSet<E> A, TraSet<E> B, TraSet<E> C) {
        TraSet<E> tulos = new TraSet<E>();
        TraSet<E> tempS1 = new TraSet<E>(A);
        TraSet<E> tempS2 = new TraSet<E>(B);
        TraSet<E> tempS3 = new TraSet<E>(C);
        TraSet<E> keskusta = new TraSet<E>(A);

        keskusta.removeAll(keskusta.difference(B));
        keskusta.removeAll(keskusta.difference(C));

        //Leikkaukset:
        tempS3.removeAll(tempS3.difference(A));
        tempS2.removeAll(tempS2.difference(C));
        tempS1.removeAll(tempS1.difference(B));

        //Keskustan alkion poistot leikkauksista
        tempS1.removeAll(keskusta);
        tempS2.removeAll(keskusta);
        tempS3.removeAll(keskusta);

        //Seuraavaksi lisätään tulokseen
        tulos.addAll(tempS1);
        tulos.addAll(tempS2);
        tulos.addAll(tempS3);
        return tulos;

    } // kaksiKolmesta()


} // class TraI_21_t18
