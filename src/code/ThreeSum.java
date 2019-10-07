package code;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://en.wikipedia.org/wiki/3SUM
public class ThreeSum {

	
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		
		int n = nums.length;
		for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) break;  // Its not possible to get a sum of 0 when min is > 0
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
			int s = i + 1;
			int e = n - 1;
			while (s < e) {
				int sum = nums[s] + nums[e] + nums[i];
				if (0 == sum) {
					ans.add(Arrays.asList(nums[i], nums[s], nums[e]));
                    s++;
                    e--;
                    while (s < e && nums[s] == nums[s - 1]) s++;
					while (s < e && nums[e] == nums[e + 1]) e--;
                    
				} else if (sum < 0) {
					s++;
                    
				} else {
					e--;
				}
			}
		}
		
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-3, 2, 1, 2, 1};
		System.out.println(threeSum(nums));
	}

}
