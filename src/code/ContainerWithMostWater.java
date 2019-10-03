package code;


public class ContainerWithMostWater {

	public static int maxArea(int[] c) {
		int maxArea = 0, l = 0, r = c.length - 1;
		while (l < r) {
			int lh = c[l];
			int rh = c[r];
			maxArea = Math.max(maxArea, Math.min(lh, rh) * (r - l));
			if (lh < rh) {
				l++;
			} else {
				r--;
			}
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] c = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(c));
	}

}
