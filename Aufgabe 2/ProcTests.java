import static org.junit . Assert .*;
import org. junit . Test ; 

public class ProcTests {
	/*Der erste Parameter dabei ist
    eine kurze Beschreibung des Testfalls (optional), danach folgt der erwartete Wert
    und der zu testende Ausdruck */
    //so is(beschreibung,erwartet,testausdruck)
  @Test
    public void testZuTake1 () {
        int [] eingabe = {1,2,3,4}; 
        int x = 2;
        int [] erwartet = {1,2};
        assertArrayEquals (erwartet,Procs.take(eingabe,x));
    }

    @Test
    public void testZuTake2 () {
        int [] eingabe ={1,2,3,4};
        int x = 4;
        int [] erwartet ={1,2,3,4};
        assertArrayEquals (erwartet,Procs.take(eingabe,x));
    }

    @Test
    public void testZuReverse1 () {
        int [] eingabe={1,2,3,4,5,6};
        Procs.reverse( eingabe );
        int [] erwartet={6,5,4,3,2,1};
        assertArrayEquals (erwartet,eingabe);
    }

    @Test
    public void testZuReverse2 () {
        int [] eingabe = {1,1,1,2,3};
        Procs.reverse(eingabe);
        int [] erwartet = {3,2,1,1,1};
        assertArrayEquals (erwartet,eingabe);
    } 

    @Test
    public void testZuRepeat1 () {
        //len < snippet.length
        int [] eingabe = { 1 , 2 , 3 , 4 };
        int [] erwartet = { 1 , 2 };
        assertArrayEquals (erwartet,Procs.repeat(eingabe,2));
    }

    @Test
    public void testZuRepeat2 () {
        //len >snippet.length
        int [] eingabe = { 1 , 2 , 3 , 4 };
        int [] erwartet = new int[6];
        erwartet[0] = 1;
        erwartet[1] = 2;
        erwartet[2] = 3;
        erwartet[3] = 4;
        erwartet[4] = 1;
        erwartet[5] = 2;
        assertArrayEquals (erwartet,Procs.repeat(eingabe,6)); 
    } 
    @Test
    public void testZuRepeat3 () {
        //len = snippet.length
        int [] eingabe = {1,2,3,4};
        int [] erwartet = {1,2,3,4};
        assertArrayEquals (erwartet,Procs.repeat(eingabe,4));
    }

}
