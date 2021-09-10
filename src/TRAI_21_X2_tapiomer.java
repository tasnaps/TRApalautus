import java.util.ArrayList;
import java.util.Objects;

public class TRAI_21_X2_tapiomer implements TRAI_21_X2 {
    /**
     * ITSEARVIONTI TÃ„HÃ„N:
     *
     *
     */
    @Override
    public ArrayList<Integer> kasvavienErotus(ArrayList<Integer> A, ArrayList<Integer> B) {
        int pituusA = A.size()-1;
        int pituusB = B.size()-1;
        int ilmentymat = 0;
        boolean tyhja;
        ArrayList<Integer> tulos = new ArrayList<Integer>();

        //Käydään lista A läpi
        for(int i = 0; i<pituusA; i++){
            boolean ok1 = false;
            boolean ok2 = false;


            //Tarkastetaan tuloslista
            tyhja = tulos.isEmpty();

            //Jokaisen listan A alkion kohdalla käydään lista B läpi
            for(int j = 0; j<pituusB; j++){




                // if haarat vertaavat ettei A listan arvoa löydy listasta B
                if(!A.get(i).equals(B.get(j))){
                    ok1 = true;
                }


                //Mikäli tuloslista ei ole tyhjä, voidaan tehdä vertailu sen alkioihin.
                if(!tyhja){
                    //Verrataan A:n alkiota tuloslistaan.
                    if(!A.get(i).equals(tulos.get(j))){
                        ok2 = true;
                    }
                    //if haaran looppi laskee montako kertaa A alkion indeksi esiintyy siellä
                    if(ok1 && ok2){
                        for(int o = 0; o<tulos.size()-1;o++){
                            if(tulos.get(o).equals(A.get(i))){
                                ilmentymat +=1;
                            }
                        }
                        //Lisätään ilmentymien verran A alkioita indeksillä i.
                        for(int x = 0; x<ilmentymat; x++)
                            tulos.add(A.get(i));
                    }
                }else if(tyhja&&ok1){
                    tulos.add(A.get(i));
                }
                ilmentymat = 0;
            }
        }
        return tulos;
    }


    public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<Integer>();
    A.add(1);
    A.add(2);
    A.add(5);
    A.add(6);
    ArrayList<Integer> B = new ArrayList<Integer>();
    B.add(3);
    B.add(2);
    TRAI_21_X2 kokeilu = new TRAI_21_X2_tapiomer();
    ArrayList<Integer> C = kokeilu.kasvavienErotus(A,B);
    //Tulosteessa pitäisi olla numerot: 1,5,6
    System.out.println(C);

    }
}
