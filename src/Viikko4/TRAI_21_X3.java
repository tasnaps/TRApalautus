package Viikko4;

import java.util.LinkedList;

public interface TRAI_21_X3 {

    /**
     * Poistaa listasta A saman alkion perÃ¤kkÃ¤isistÃ¤ esiintymistÃ¤ muut paitsi ensimmÃ¤isen.
     * Listasta (4 3 3 2 2 2 2 1 2 2 3 3) tulee lista (4 3 2 1 2 3).
     * Lista voi sisÃ¤ltÃ¤Ã¤ myÃ¶s null:eja jotka kÃ¤sitellÃ¤Ã¤n samoin kuin muut alkiot.
     * @param A syÃ¶telista
     * @param <E> alkiotyyppi
     * @return poistettujen mÃ¤Ã¤rÃ¤
     */
    public <E> int poistaPerakkaisetDuplikaatit(LinkedList<E> A);

}
