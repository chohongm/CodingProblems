package code;

public class MedianOfTwoSortedArrayOfDifferentLength {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

	    int xl = nums1.length;
	    int yl = nums2.length;
	    
	    // Case 1: nums1 is empty.
	    if (xl == 0) {
	        if (yl % 2 == 0) {
	            return (nums2[(yl / 2) - 1] + nums2[yl / 2]) / 2.0;
	        }
	        return nums2[yl / 2] * 1.0;
	    }
	    
	    // Case 2: nums2 is empty.
	    if (yl == 0) {
	        if (xl % 2 == 0) {
	            return (nums1[(xl / 2) - 1] + nums1[xl / 2]) / 2.0;
	        }
	        return nums1[xl / 2] * 1.0;
	    }
	    
	    // Case 3: Both arrays are not empty.
	    if (xl > yl) {
	        return findMedianSortedArrays(nums2, nums1);
	    }
	    
	    int l = 0;
	    int h = xl;

	    while (l <= h) {
	    	int xp = (l + h) / 2;
	        int yp = (xl + yl) / 2 - xp;
	        int lx = (xp == 0) ? Integer.MIN_VALUE : nums1[xp - 1];
	        int rx = (xp == xl) ? Integer.MAX_VALUE : nums1[xp];
	        int ly = (yp == 0) ? Integer.MIN_VALUE : nums2[yp - 1];
	        int ry = (yp == yl) ? Integer.MAX_VALUE : nums2[yp];
	        
	        boolean case1 = lx <= ry;
	        boolean case2 = ly <= rx;
	        
	        if (case1 && case2) {
	            if ((xl + yl) % 2 == 0) {
	                return (Math.max(lx, ly) + Math.min(rx, ry)) / 2.0;
	                
	            } else {
	                return Math.min(rx, ry) * 1.0;
	            }
	            
	        } else if (!case1) {
	            h = xp - 1;
	        } else {
	            l = xp + 1;
	        }
	    }
	    
	    return 0.0;
    }
	
	public static void main(String[] args) {
		int[] x = {1};
		int[] y = {2, 3, 4};
		
		final MedianOfTwoSortedArrayOfDifferentLength engine = new MedianOfTwoSortedArrayOfDifferentLength();
		System.out.println(engine.findMedianSortedArrays(x, y));
	}

}
