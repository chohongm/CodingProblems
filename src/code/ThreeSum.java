package code;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://en.wikipedia.org/wiki/3SUM
public class ThreeSum {

	
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
        	int s = i + 1, e = n - 1;
        	int a = nums[i];
        	while (s < e) {
        		int b = nums[s], c = nums[e];
        		int sum = a + b + c;
        		System.out.printf("a: %d, b: %d, c: %d, sum: %d\n", a, b, c, sum);
        		if (sum == 0) {
        			lst.add(Arrays.asList(a, b, c));
        			s++;
        			e--;
        		} else if (sum > 0) {
        			e--;
        		} else {
        			s++;
        		}
        	}
        }
        return lst;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(nums));
	}

}
