import org.junit.Test;
import static org.junit.Assert.*;

public class IntersectionTests {

  // Tests fuer contains
  @Test
  public void containsTestIn() {
    int[] ar = {1,2,3,4};
    assertEquals(true, Intersection.contains(ar, 1));
    assertEquals(true, Intersection.contains(ar, 2));
    assertEquals(true, Intersection.contains(ar, 3));
    assertEquals(true, Intersection.contains(ar, 4));
  }

  @Test
  public void containsTestOut() {
    int[] ar = {2, 3, 4};
    assertEquals(false, Intersection.contains(ar, 1));
    assertEquals(false, Intersection.contains(ar, 5));
  }

  @Test
  public void containsCorner() {
    assertEquals(false, Intersection.contains(new int[]{}, 0));
  }

  // Tests fuer increasing
  @Test
  public void increasingTestIn() {
    assertEquals(true, Intersection.increasing(new int[] {1,2,3,4}));
    assertEquals(true, Intersection.increasing(new int[] {1, 10, 100}));
    assertEquals(true, Intersection.increasing(new int[] {42}));
  }

  @Test
  public void increasingTestOut() {
    assertEquals(false, Intersection.increasing(new int[] {4,3,2,1}));
    assertEquals(false, Intersection.increasing(new int[] {1,3,2,4}));
    assertEquals(false, Intersection.increasing(new int[] {42, 13}));
  }

  @Test
  public void increasingTestEmpty() {
    assertEquals(true, Intersection.increasing(new int[] {}));
  }

  // Tests fuer subset
  @Test
  public void subsetTest_bothEmpty() {
    int[] a = {};
    int[] b = {};
    assertEquals(true, Intersection.subset(a, b));
  }

  @Test
  public void subsetTest_leftEmpty() {
    int[] a = {};
    int[] b = {1, 2, 3};
    assertEquals(true, Intersection.subset(a, b));
  }

  @Test
  public void subsetTest_true1() {
    int[] a = {2};
    int[] b = {1, 2, 3};
    assertEquals(true, Intersection.subset(a, b));
  }

  @Test
  public void subsetTest_true2() {
    int[] a = {1, 2, 9};
    int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    assertEquals(true, Intersection.subset(a, b));
  }

  @Test
  public void subsetTest_false1() {
    int[] a = {2, 4};
    int[] b = {1, 2, 3};
    assertEquals(false, Intersection.subset(a, b));
  }

  @Test
  public void subsetTest_false2() {
    int[] a = {1, 2, 9};
    int[] b = {1, 2, 3, 4, 5, 6, 7, 8};
    assertEquals(false, Intersection.subset(a, b));
  }


  // Tests fuer intersection
  @Test
  public void intersectionTest1() {
    int[] ar1 = {1,2,3,4};
    int[] ar2 = {2,3,4,5};
    assertArrayEquals(new int[]{2,3,4}, Intersection.intersection(ar1, ar2));
  }

  @Test
  public void intersectionTest2() {
    int[] ar1 = {1,2,3};
    int[] ar2 = {4,5,6};
    assertArrayEquals(new int[]{}, Intersection.intersection(ar1, ar2));
  }

  @Test
  public void intersectionTest3() {
    int[] ar1 = {1,2,3};
    int[] ar2 = {1,2,3};
    assertArrayEquals(new int[]{1,2,3}, Intersection.intersection(ar1, ar2));
  }

  @Test
  public void intersectionTest4() {
    int[] ar1 = {42};
    int[] ar2 = {};
    assertArrayEquals(new int[]{}, Intersection.intersection(ar1, ar2));
  }

  @Test
  public void intersectionTest5() {
    int[] ar1 = {};
    int[] ar2 = {42};
    assertArrayEquals(new int[]{}, Intersection.intersection(ar1, ar2));
  }

  @Test
  public void intersectionTest6() {
    int[] ar1 = {};
    int[] ar2 = {};
    assertArrayEquals(new int[]{}, Intersection.intersection(ar1, ar2));
  }
}
