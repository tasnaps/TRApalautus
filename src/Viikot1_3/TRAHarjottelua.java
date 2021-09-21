package Viikot1_3;

import java.util.ArrayList;
import java.util.Iterator;


public class TRAHarjottelua {

        public static int poistot(ArrayList<Integer> A, ArrayList<Integer> B){
            /**
             * Homman nimi: Palauta monta kertaa poistetaan listasta A alkiot jotka esiintyvät listassa B.
             *
             * aikavaatimus:
             *      * O(n**2)
             *      * Koska: i.hasnext -> O(n)
             *      * ja if haaran B.contains(i.next()) -> (n)
             *      * If body on vaan O(1)
             *      *
             *      * Aikavaatimusta voisi parantaa muuttamalla while loopin if haaraa siten
             *      * että ei aina käydä B listaa alusta lähtien <- B.contains(i.next())
             *
             */
            int palautus = 0;
            Iterator<Integer> i = A.iterator();
            while(i.hasNext()){
                if(B.contains(i.next())){
                    i.remove();
                    palautus++;
                }
            }
            return palautus;




        }



    public static void main(String[] args) {
            ArrayList<Integer> A = new ArrayList<Integer>();
            A.add(1);
            A.add(2);
            A.add(3);
            ArrayList<Integer> B = new ArrayList<Integer>();
            B.add(1);
            B.add(2);
            B.add(3);
            B.add(4);
            int poisto =poistot(A,B);
            System.out.println(poisto);

    }
}
