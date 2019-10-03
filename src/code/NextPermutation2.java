package code;
import java.util.Arrays;

public class NextPermutation2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', ' ', '?', '!'};
		reverseIt(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static char[] reverseIt (char[] arr) {
		int len = arr.length;
		if (len <= 1) {
			return arr;
		}
		
		// 1. reverse the whole thing.
		int i = 0, j = len - 1;
		flip(i, j, arr);
		
		// 2. reverse each words.
		int start = 0;
		for (int k = 1; k < len; k++) {
			if (Character.isWhitespace(arr[k])) {
				flip(start, k - 1, arr);
				start = k + 1;
			}
		}
		flip(start, len - 1, arr);
		return arr;
	}
	
	public static void flip(int i, int j, char[] arr) {
		while (i < j) {
			char c = arr[i];
			arr[i] = arr[j];
			arr[j] = c;
			i++;
			j--;
		}
	}

}
