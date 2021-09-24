package Viikko4;

// TRAI_21_t12.java SJ

/**
 * Aikavaativuus?
 * O(n) lineaarinen algoritmi. Ei ihmeellisempiä kommentteja. Olen tyytyväinen ratkaisuun.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TRAI_21_t12_pohja {


    // PÃ¤Ã¤ohjelman kÃ¤yttÃ¶:
    // java TRAI_21_t12 [merkkijono]
    public static void main(String[] args) {

        String mjono = null;

        if (args.length > 0)
            mjono = args[0];

        if (mjono == null) {
            System.out.print("Anna merkkijono : ");
            Scanner sc = new Scanner(System.in);
            mjono = sc.nextLine();
        }

        System.out.print("Merkkijono '" + mjono + "' ");
        if (onkoPalindromi(mjono))
            System.out.println("on palindromi");
        else
            System.out.println("ei ole palindromi");

    } // main()


    /**
     * Merkkijonosta merkkipakka.
     *
     * @param S syÃ¶temerkkijono
     * @return merkit pakkana
     */
    public static Deque<Character> merkkijonostaPakka(String S) {
        Deque<Character> D = new ArrayDeque<>();

        for (int i = 0; i < S.length(); i++)
            D.addLast(S.charAt(i));

        return D;

    } // merkkijonostaPakka()


    /**
     * Onko merkkijono palindromi vai ei?
     *
     * @param S syÃ¶temerkkijono
     * @return totuusarvo
     */

    public static boolean onkoPalindromi(String S) {
        Deque<Character> D = merkkijonostaPakka(S);
        while(!D.isEmpty()){
            if(D.getFirst().equals(D.getLast())){
                D.removeFirst();
                D.removeLast();
            }else{
                return false;
            }
        }
        return true;
    } // onkoPalindromi()

} // class
