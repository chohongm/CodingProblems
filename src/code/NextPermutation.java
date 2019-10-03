package code;
import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 8, 4, 7, 6, 5, 3, 1};
		System.out.println(Arrays.toString(findNextPermutation(arr)));
	}
	
	public static int[] findNextPermutation(int[] perm) {
		// [1, 8, 4, 7, 6, 5, 3, 1]
		// 1. backtrack to find the first non-increasing element.
		int end = perm.length;
		int i = end - 2;
		while (perm[i] > perm[i + 1]) {
			i--;
		}
		// 2. swap with the number that is just larger than i
		int j = end - 1;
		while (perm[j] < perm[i]) {
			j--;
		}
		
		swap(perm, i, j);
		reverse(perm, i + 1, end - 1);
		return perm;
	}
	
	public static void swap(int [] perm, int i, int j) {
		int temp = perm[i];
		perm[i] = perm[j];
		perm[j] = temp;
	}
	
	public static void reverse(int[] perm, int i, int j) {
		while(i < j) {
			swap(perm, i, j);
			i++;
			j--;
		}
	}
}
