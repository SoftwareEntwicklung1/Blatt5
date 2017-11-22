import static org.junit.Assert.*;
import org.junit.Test; 

public class ProcTests {


  @Test
    public void testZuTake1 () {
        int [] eingabe = {1 , 2 , 3 , 4}; 
        int x = 0;
        int [] erwartet = {};
        assertArrayEquals ("n = 0", Procs.take(eingabe,x) , erwartet);
    }

    @Test
    public void testZuTake2 () {
        int [] eingabe = new int[4];
        int x = 4;
        int [] erwartet = new int [4];
        assertArrayEquals ("leeres Array", Procs.take(eingabe,x) , erwartet);
    }

    @Test
    public void testZuTake3 () {
        int [] eingabe = {1 , 2 , 3 , 4};
        int x = 2;
        int [] erwartet = {1 , 2};
        assertArrayEquals ("n < ar.length", Procs.take(eingabe,x) , erwartet);
    }

    @Test
    public void testZuReverse1 () {
        int [] eingabe = new int [1];
        Procs.reverse( eingabe );
        int [] erwartet = new int [1];
        assertArrayEquals ("ar.length = 1", eingabe , erwartet);
    }

    @Test
    public void testZuReverse2 () {
        int [] eingabe = {1 , 1 , 1 , 2 , 3};
        Procs.reverse(eingabe);
        int [] erwartet = {3 , 2 , 1 , 1 , 1};
        assertArrayEquals ("ar.length = 5", eingabe , erwartet);
    } 

    @Test
    public void testZuRepeat1 () {
        int [] eingabe = {1 , 2 , 3 , 4};
        int [] erwartet = {1 , 2};
        assertArrayEquals ("len < snippet.length", Procs.repeat(eingabe , 2) , erwartet);
    }

    @Test
    public void testZuRepeat2 () {
        int [] eingabe = {1 , 2 , 3 , 4};
        int [] erwartet = new int[6];
        erwartet[0] = 1;
        erwartet[1] = 2;
        erwartet[2] = 3;
        erwartet[3] = 4;
        erwartet[4] = 1;
        erwartet[5] = 2;
        assertArrayEquals ("len > snippet.length", Procs.repeat(eingabe , 6) , erwartet); 
    }

    @Test
    public void testZuRepeat3 () {
        int [] eingabe = {1 , 2 , 3 , 4};
        int [] erwartet = {1 , 2 , 3 , 4};
        assertArrayEquals ("len = snippet.length", Procs.repeat(eingabe , 4) , erwartet);
    } 

}
