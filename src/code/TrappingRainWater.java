package code;

import java.util.Arrays;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] g = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(g));
	}
	
    public static int trap(int[] height) {
        int len = height.length;
        
        if (len <= 2) return 0;
        
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, 0);
        Arrays.fill(right, 0);
        
        left[0] = height[0]; 
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        
        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        
        return sum;
    }

}
