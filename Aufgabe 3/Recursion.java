import java.util.Arrays;
public class Recursion {
	 /* setzt alle Elemente(zwichen left und right) groesser oder gleich dem Pivot rechts,
        und alle Elemente kleiner als pivot links in einem Array
     
        requires a != null && 0<=left<right && right < a. length
                  min a[i]<pivot<=max a[i]
        modifies a
        ensures 
                 fuer left>right verlasst dass Prozedur partition.
                 fuer left<=right macht folgende:
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
			//umtausch von a[left] und a[right]
			int t = a[left];
			a[left] = a[right];
			a[right] = t;
			//erhoeht left um eins und right und um eins.
			partition(a, pivot, left+1, right-1);
		}
	}
/* Die Summe von Wete a[i][j]+...+a[n][m]
   + due Summe von a[0][j+1]+...+a[n][m]
     
     requires i<n<=array.length && j<m<=min(a[i].length) fuer alle i;
              && a[i].length>0 fur all i
              && a[i]!= null, a!=null
              &&  0<=i<n && 0<=j<m
     
     modifies nothing
     ensures /Return Summe von Werte a[i][j]+...+a[n-1][m-1]
   + Die Summe von Werte a[0][j+1]+...+a[n-1][m-1]
              
              falls (j >= m || i > n) bedeuted dass j (elements to skip)=m(element to inlcude)
              also return "". falls i>n bedeuted a[a.length+1] out of bound
              falls i==n  
              a[0][j+1]+...+a[n-1][j+1]+...+a[0][j+2]+...+a[n-1][j+2]
              +...+a[0][j+c]+...+a[n-1][j+c] wo j+c<=m; c>0
              falls i<n && j<m
              a[i][j]+...a[i+1][j]+...+a[n-1][j]
              
//Bedeutung von werte
		//n ist die nummber die inthaltenen innere arrays
		// a[i...n] falls n=2 &&a.length=3 die lezte array ist nicht enhalten
		// m = number of elements to include
		// j=1 means skip first 2 elements in all arrays
		// j=1 means include a[i][j]
		// j means from which element to start in a[i]
		// i means from which array to start


        in alle möglichkeiten wird j um eins vergosert oder i um eins vergrosert
        n und m bleiben fest. der fall wo j >= m || i > n wird immer vorkommen.
        
 */
	
	static String sum(String[][] a, int i, int j, int n, int m) {

		
		
		//m= number of elements to count
		if (j >= m || i > n) {
			return "";
		} else if (i == n) {
			//always include the sum of all arrays and skip j first elements
			return sum(a, 0, j+1, n, m);
		} else {
			//starts from array n-1, from element number m-1
			//beispiel i=2 j=1 n=3 and m=3
			//fängt mit a[2][1]
			//adds the sum of first and second array
			//by skipping first 2 elements skips first j elements.
			//j=1 means skip first 2 elements in all arrays
			//n is equal to number of arrays to include 
			//m = number of elements to include
			//result icgj
			return a[i][j] + sum(a, i+1, j, n, m);
		}
	}

	public static void main(String...args) {
		int[] a = {7,23,3,10,11,5,3,2,23};
		partition(a, 23, 0, 8);
		System.out.println(Arrays.toString(a));
		String[][] b = {{"a","b","c"},{"e","f","g"},{"h","i","j"}};
		String x;
		x=sum(b,0, 2, 3, 3);
		System.out.println(x);
		for (int i=0;i<b.length;i++){
			for(int j=0;j<b[i].length;j++){
				for(int n=0;n<=b.length;n++){
					for(int m=0;m<=b[i].length;m++){
						//System.out.println("array="+i+" Element="+j
						//		+" numberofarrays="+n+" and numberofelements="+m);
						//x=sum(b,i, j, n, m);
						//System.out.println(x);
					}
				}
			}
		}
	}
}