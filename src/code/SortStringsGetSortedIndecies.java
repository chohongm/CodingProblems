package code;
import java.util.Arrays;
import java.util.Comparator;

public class SortStringsGetSortedIndecies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"a", "i", "e", "s", "j"};
		System.out.println(Arrays.toString(sortStringsGetSortedIndecies(input)));

	}
	
	public static Integer[] sortStringsGetSortedIndecies(final String[] input) {
		
		int len = input.length;
		Integer[] indecies = new Integer[len];
		for (int i = 0; i < len; i++) {
			indecies[i] = i;
		}
		
		System.out.println(Arrays.toString(indecies));

		Arrays.sort(indecies, new Comparator<Integer>() {
			public int compare(final Integer o1, final Integer o2) {
				return input[o1].compareTo(input[o2]);
			}
		});
		
		System.out.println(Arrays.toString(input));

		return indecies;
	}

}
