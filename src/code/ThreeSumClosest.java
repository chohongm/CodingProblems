package code;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1, 2, 1, -4};
		System.out.println(threeSumClosest(nums, 1));
	}
	
    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int closest = 0;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) return sum;
                
                int diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    closest = sum;
                }
                if (sum < target) {
                    l++;
                    
                } else {
                    r--;
                }
            }
        }
        return closest;
    }

}
