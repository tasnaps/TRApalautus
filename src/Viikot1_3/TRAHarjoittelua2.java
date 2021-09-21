package Viikot1_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class TRAHarjoittelua2 {
    /**
     * Aikavaatimus:
     * O(n**2)
     * Koska: i.hasnext -> O(n)
     * ja if haaran B.contains(i.next()) -> (n)
     * If body on vaan O(1)
     *
     * Aikavaatimusta voisi parantaa muuttamalla while loopin if haaraa siten
     * että ei aina käydä B listaa alusta lähtien <- B.contains(i.next())
     *
     * Opiskelijan kannalta hyvä algorimti, sillä pätee molempiin tehtäviin: 8 ja 9
     *
     *
     */

    public static int kasvavienErotus (LinkedList<Integer> A, LinkedList<Integer> B){
        Iterator<Integer> i = A.iterator();
        int summa = 0;

        while(i.hasNext()){
            if(B.contains(i.next())){
                i.remove();
                summa++;
            }

        }
        return summa;
    }


    public static void main(String[] args) {
        LinkedList<Integer> A = new LinkedList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        LinkedList<Integer> B = new LinkedList<Integer>();
        B.add(1);
        B.add(2);
        B.add(3);
        B.add(4);
        int poisto =kasvavienErotus(A,B);
        System.out.println(poisto);

    }
}
