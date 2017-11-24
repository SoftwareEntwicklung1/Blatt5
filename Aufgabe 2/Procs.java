public class Procs {

/*
    requires    ar != null && 0 <= n < ar.length
    modifies    \nothing
    ensures     \result ist ein neues Array mit den n ersten Einträgen aus ar
*/


    public static int[] take(int[] ar, int n) {
        int[] res = new int[n];
        for (int i=0; i<n; i++) {
            res[i] = ar[i];
        }        
        return res;
    }

/*
    requires    input != null && input.length >= 1
    modifies    input
    ensures     Ergebnis ist input mit umgekehrter Reihenfolge der Elemente
*/


    public static void reverse(int[] input) {
        for (int i=0; i<input.length/2; i++) {
            int temp = input[i];
            input[i] = input[input.length - 1 - i];
            input[input.length - 1 - i] = temp;
        }
    }

/*
    requires    snippet != null && 1 <= len
    modifies    /nothing
    ensures     für len < snippet.length ist das Ergebnis ein Array mit den len ersten Einträgen aus snippet und Länge len
                für len = snippet.length ist das Ergebnis eine Kopie des Arrays snippet
                für len > snippet.length ist das Ergebnis ein Array, in dem sich die Einträge von snippet len/snippet.length-mal wiederholen
*/

    public static int[] repeat(int[] snippet, int len) {
        int[] res = new int[len];
        int resPos = 0;
        while (resPos < len) {
            for (int i=0; i < snippet.length && resPos < len; i++) {
                res[resPos] = snippet[i];
                resPos = resPos + 1;
            }
        }
        return res;
    }
}
