import java.util.Arrays;
public class Recursion {


	static void partition(int[] a, int pivot, int left, int right) {
		if (left > right) {
			return;
		}
		if (a[left] < pivot) {
			partition(a, pivot, left+1, right);
		} else if (a[right] >= pivot) {
			partition(a, pivot, left, right-1);
		} else {
			int t = a[left];
			a[left] = a[right];
			a[right] = t;
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
		int[] a = {7,2,3,10,11,5,3,2,23};
		partition(a, 10, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
}