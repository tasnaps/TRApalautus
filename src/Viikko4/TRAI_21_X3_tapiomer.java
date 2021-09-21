package Viikko4;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class TRAI_21_X3_tapiomer implements TRAI_21_X3 {
    //  ^^^^^ oma tunnus tÃ¤hÃ¤n

    /**
     * ITSEARVIOINTI TÃ„HÃ„N:
     *
     *
     */

    /**
     * Poistaa listasta A saman alkion perÃ¤kkÃ¤isistÃ¤ esiintymistÃ¤ muut paitsi ensimmÃ¤isen.
     * Listasta (4 3 3 2 2 2 2 1 2 2 3 3) tulee lista (4 3 2 1 2 3).
     * Lista voi sisÃ¤ltÃ¤Ã¤ myÃ¶s null:eja jotka kÃ¤sitellÃ¤Ã¤n samoin kuin muut alkiot.
     *
     * @param A syÃ¶telista
     * @return poistettujen mÃ¤Ã¤rÃ¤
     */
    @Override
    public <E> int poistaPerakkaisetDuplikaatit(LinkedList<E> A) {



        int poistot = 0;
        ListIterator<E> i = A.listIterator();
        //1,2,3,4,5,6,7,8,9

        /**
         * Esimerkki 2.8. Alkion x kaikkien esiintymien poisto listasta L:
         * • (x ei saa olla null).
         * ListIterator i = L.listIterator(); 1
         * while (i.hasNext()) // O(n) 2
         * if (x.equals(i.next())) 3
         * i.remove(); 4
         * • Jos null halutaan käsitellä kuten muutkin alkiot, se on erikseen huomioitava:
         * ListIterator i = L.listIterator(); 1
         * while (i.hasNext()) { 2
         * Object a = i.next(); 3
         * if ((x == null && a == null) || (x != null && x.equals(a))) 4
         * i.remove(); 5
         * } 6
         * • Tässä tarvitaan apumuuttuja a koska tarvitsemme viittausta alkioon kahdesti ja koska .next()
         * etenee listassa joka kutsukerralla
         */

//Pitää korjata kun tulee nulleja.
          while(i.hasNext()){
              Object poisto = i.next();
              if(i.hasNext()){
                  if(poisto.equals(i.next())){
                      i.remove();
                      poistot++;
                  }else if(poisto==null && i.next()==null){
                      i.remove();
                      poistot++;
                  }
                  i.previous();
              }

          }
        return poistot;
    }

    public static void main(String[] args) {
        LinkedList<Integer> A = new LinkedList<Integer>();
        TRAI_21_X3_tapiomer testi = new TRAI_21_X3_tapiomer();

        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        A.add(6);
        A.add(7);
        A.add(8);
        A.add(9);
        A.add(5);
        A.add(5);
        A.add(5);
        A.add(5);
        A.add(5);
        A.add(3);

        testi.poistaPerakkaisetDuplikaatit(A);
        System.out.println(A);
    }

}
