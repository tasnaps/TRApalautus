package Viikko8;

package Viikko8;


import java.util.NoSuchElementException;

/**
 *
 * Itesearviointi:
 *  Melko työläs tehtävä minun taidoilleni, sain jotenkuten toimivan ratkaisun käyttämällä taulukkoa rakenteena
 *  alustavasti jonon koko on 10 alkiota, joka tuplaantuu aina tilan loppuessa, kun tila loppuu vaaditaan O(n) verran aikaa uuden alkion lisäämiseen jonoon.
 *
 * Aikavaativuus:
 * lisaa = O(1) paras tapaus, pahimmassa tapauksessa O(n) kun pitää kasvattaa jonon kokoa.
 * poista = varmaan O(n), kun aina poistettaessa joudutaan siirtämään alkioita n verran
 * onkoTyhja = O(1)
 *
 * @param <E>
 */
public class TRAI_21_29<E> implements TRAI_21_X7<E> {

    private E[] data;
    int taka, etu, koko;

    @SuppressWarnings({"unchecked"})
    public TRAI_21_29(){
        koko = 10;
        etu = -1;
        taka = -1;
        //castaus E:n taulukoksi
        data = (E[]) (new Object[koko]);

    };



    /**
     * LisÃ¤Ã¤ jonoon yhden alkion.
     *
     * @param x lisÃ¤ttÃ¤vÃ¤ alkio.
     */
    @Override
    public void lisaa(E x) {
        if(onkoTaysi()){
            System.out.println("Jono täysi, tuplataan koko...");
            lisaaKokoa();
        }
        else{
            taka++;
        }
        System.out.println("lisätään alkio: " + x + " jonon loppuun paikalle: " + data[taka]);
        data[taka] = x;

    }
    @SuppressWarnings({"unchecked"})
    private void lisaaKokoa(){
        //ArrayList2 esimerkin mukaisesti:
        E[] data2 = (E[]) (new Object[2*data.length]);
        for(int i = 0; i < data.length; i++){
            data2[i] = data[i];
        }
        taka++;
        data = data2;
    }

    /**
     * Poistaa ja palauttaa jonosta siellÃ¤ pisimpÃ¤Ã¤n olleen alkion.
     *
     * @return poistettu jonossa pisimpÃ¤Ã¤n ollut alkio.
     * @throws NoSuchElementException jollei jonossa ole yhtÃ¤Ã¤n alkiota.
     */
    @Override
    public E poista() {
        int paikka = 0;
        E poistettava;

        if(data[paikka]== null){
            throw new NoSuchElementException();
        }

        if(!onkoTyhja() && data[paikka]!=null){
            poistettava = data[paikka];
            for(int i = 0; i<= taka -1; i++){
                data[i] = data[i+1];
            }
            //kokeillaan
            data[taka] = null;
            taka--;
        }else if(etu == taka){
            poistettava = data[paikka];
            etu = -1;
            taka = -1;
        }else{
            throw new NoSuchElementException();
        }
        return poistettava;
    }


    /**
     * Onko jono tyhjÃ¤ vai ei?
     *
     * @return true jos jonossa ei ole yhtÃ¤Ã¤n alkiota, muuten false
     */
    @Override
    public boolean onkoTyhja() {
        if(data.length>0){
            if(data[0]==null){
                return true;
            }
        }else{
            return false;
        }
        return false;
    }

    public boolean onkoTaysi(){
        return taka == data.length - 1;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Object alkio: data){
            sb.append(" ").append(alkio).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}

