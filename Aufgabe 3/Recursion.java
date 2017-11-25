import java.util.Arrays;
public class Recursion {
	 /* setzt alle Elemente(zwichen left und right) groesser oder gleich dem Pivot rechts,
        und alle Elemente kleiner als pivot links in einem Array
     
        requires a != null && 0<=left<right && right < a. length
                 pivot is in dem array enthalten.
        modifies a
        ensures 
                 fuer left>right verlasst dass Prozedur partition.
                 fuer left<right macht folgende:
                 fuer a[left]<pivot macht nichts fuer a[left]
                      geht weiter fuer a[left+1].
                 fuer a[left]>= pivot prueft, ob a[right]>=pivot (da es soll nur mit werte von rechts die kleiner als pivot umtauschen).
                      falls true versuch mit a[tight-1].( ess soll kleiner als pivot sein fuer umtausch)
                 fuer a[right]<pivot && a[left]>=pivot
                      umtauscht die Wetre von a[right] und a[left]   
                      
               In alle möglichkeiten wird left um eins erhoet oder right um 1 verringert oder beide.
               Es wird auf left>right kommen. und das Prozedur verlassen.
*/
	static void partition(int[] a, int pivot, int left, int right) {
		//falls left>right verlasst Prozedur partition
		if (left > right) {
			return;
		}
		//falls a[left] < pivot versuch mit left+1 bis a[left]>=pivot
		if (a[left] < pivot) { 
			partition(a, pivot, left+1, right);
		// a[left]>=pivot prüft ob a[right-1] >= pivot bis a[right-1]<pivot
		} else if (a[right] >= pivot) {
			partition(a, pivot, left, right-1);
		// a[left]>=pivot && a[right-1]<pivot, dann mach einen umtausch.
		} else {
			// Ersetzt das erste Element auf der linken Seite, das groeser ist als pivot (a [left])
			// mit dem ersten Element von rechts, das kleiner ist als pivot (a [right])
			int t = a[left];
			a[left] = a[right];
			a[right] = t;
			//erhoeht left um eins und right und um eins.
			partition(a, pivot, left+1, right-1);
		}
	}

	static int sum(int[][] a, int i, int j, int n, int m) {
		if (j >= m || i > n) {
			return 0;
		} else if (i == n) {
			return sum(a, 0, j+1, n, m);
		} else {
			return a[i][j] + sum(a, i+1, j, n, m);
		}
	}

	public static void main(String...args) {
		int[] a = {7,23,3,10,11,5,3,2,23};
		partition(a, 500, 0, 8);
		System.out.println(Arrays.toString(a));
	}
}