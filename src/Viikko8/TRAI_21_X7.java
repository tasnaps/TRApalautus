package Viikko8;
// Kodaa nää metodit
/**
 * Jonon toteutus. Vanhin jonoon laitettu alkio otetaan ensimmÃ¤isenÃ¤ pois (FIFO).
 * @param <E> Alkiotyyppi.
 */

// ota kommentit pois extends Iterable:n kohdalta kun teet tehtÃ¤vÃ¤Ã¤ 29.
public interface TRAI_21_X7<E> /* extends Iterable<E> */ {

    /**
     * LisÃ¤Ã¤ jonoon yhden alkion.
     * @param x lisÃ¤ttÃ¤vÃ¤ alkio.
     */
    public void lisaa(E x);

    /**
     * Poistaa ja palauttaa jonosta siellÃ¤ pisimpÃ¤Ã¤n olleen alkion.
     * @return poistettu jonossa pisimpÃ¤Ã¤n ollut alkio.
     * @throws java.util.NoSuchElementException jollei jonossa ole yhtÃ¤Ã¤n alkiota.
     */
    public E poista();

    /**
     * Onko jono tyhjÃ¤ vai ei?
     * @return true jos jonossa ei ole yhtÃ¤Ã¤n alkiota, muuten false
     */
    public boolean onkoTyhja();

    /**
     * TyhjentÃ¤Ã¤ jonon.
     * TÃ¤mÃ¤n voi tehdÃ¤ tehokkaammin toteuttavassa luokassa kun
     * toteutusrakenne on selvillÃ¤.
     */
    public default void poistaKaikki() {
        while (! onkoTyhja())
            poista();
    }
}
