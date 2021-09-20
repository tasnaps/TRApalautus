package Viikot1_3;

public class TRAI_21_X1_tapiomer implements TRAI_21_X1 {

    /**
     * Käytin tulostaSumma metodissa kahta while looppia pienimmän ja suurimman numeron etsintään. Olisi luultavasti pärjännyt yhdellä loopilla if lauseilla hyödyntämällä.
     * Mikäli toisen while lauseen saa karsittua, algoritmin nopeus kaksinkertaistuu.
     * Pyöräytin koodini testiohjelman lävitse, enkä havainnut ongelmia, joten toivon hyviä pisteitä tehtävästä.
     * Ongelmana oli aluksi for loopin käyttö tehtävän suorittamiseen,
     * en saanut indeksiä toimimaan oikein, ja siirryin siksi while looppiin.
     *
     * tehokkuudesta en ole täysin varma on oikea arvio, 2(n+(2n-1)+1)
     * 2(n) koska kaksi while looppia.
     *  (2n-1) koska taulukon koko pienenee indeksi<total ja pienin>A[indeksi] kohdissa
     *  indeksin kasvatus +1
     *  eli 2(n+(2n-1)+1) toivottavasti sinnepäin
     */

    static Integer tulostaSumma(Integer[] A){
        int indeksi= 0;
        int pienin= Integer.MAX_VALUE;
        int suurin = Integer.MIN_VALUE;
        int total = A.length;

            while(indeksi<total){
                try {
                    if((pienin>A[indeksi])){
                        pienin = A[indeksi];
                    }
                    indeksi++;
                } catch (NullPointerException exception){
                    indeksi++;
                }
            }
            indeksi = 0;
            while(indeksi<total){
                try {
                    if((suurin<A[indeksi])){
                        suurin = A[indeksi];
                    }
                    indeksi++;
                } catch (NullPointerException exception){
                    indeksi++;
                }
            }

        int summa = pienin + suurin;
        return summa;
    }

    @Override
    public Integer suurinJaPieninSumma(Integer[] A) {
        if (A.length < 1){
            return null;
        }else{
            return tulostaSumma(A);
        }

    }

    public static void main(String[] args) {
    }
}
