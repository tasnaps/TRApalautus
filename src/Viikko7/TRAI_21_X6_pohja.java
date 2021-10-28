package Viikko7;
import java.util.*;

public class TRAI_21_X6_pohja implements TRAI_21_X6 {

    /**
     * ITSEARVIOINTI TĆ„HĆ„N:
     * Aikakompleksisuus = O(n**2)
     * Olen tyytyväinen omaan tulokseen. Koodini käy for loopissa settien sisällön läpi ja lisää ne yhteen settiin,
     * jolloin saadaan jokainen alkio avaimeksi.
     * Toisessa for silmukassa tein kaksi silmukkaa sisäkkäin joka vetää aikavaativuuden O(n**2).
     * silmukassa katsotaan contains metodilla löytyykö avain alkiota setistä, jos löytyy lisätään se settiin.
     * Lopuksi lisätään palautettavaan mappiin avainalkio ja muut tiedot.
     *
     *  Yritin ensin ratkaista tehtävää tekemällä kopion seteistä ja josta poistamalla alkioita voisi parantaa aikakopmleksisuutta.
     *  En saanut pähkäiltyä sitä valmiiksi vaan päädyin alla olevaan ratkaisuun.
     *
     */

    @Override
    public <E> Map<E, Set<Set<E>>> hakemisto(Set<Set<E>> SS) {
        Map<E, Set<Set<E>>> tulosHakemisto = new HashMap<>();
        Set<E> avaimetTanne = new HashSet<E>();

        for (Set<E> setti: SS){
            avaimetTanne.addAll(setti);
        }

        for(E alkio: avaimetTanne){
            Set<Set<E>> kaaro = new HashSet<Set<E>>();
            for(Set<E> setti: SS){
                if(setti.contains(alkio)){
                    kaaro.add(setti);
                }
            }
            tulosHakemisto.put(alkio, kaaro);
        }
return tulosHakemisto;
    }
}