package code;

public class MedianOfTwoSortedArrayOfDifferentLength {
	
	public double findMedianOfTwoSortedArrayOfDifferentLength(int[] x, int[] y) {
		
		// 1. init vars
		int xSize = x.length;
		int ySize = y.length;
		
		// we want to partition smaller array
		if (xSize > ySize) {
			return findMedianOfTwoSortedArrayOfDifferentLength(y, x);
		}
		
		int low = 0;
		int high = xSize;
		
		while (low <= high){
			// 2. partition lefts and rights
			int partX = (low + high) / 2;
			int partY = (xSize + ySize) / 2 - partX;
			int maxLeftX = (partX == 0) ? Integer.MIN_VALUE : x[partX - 1];
			int minRightX = (partX == xSize) ? Integer.MAX_VALUE : x[partX];
			int maxLeftY = (partY == 0) ? Integer.MIN_VALUE : y[partY - 1];
			int minRightY = (partY == ySize) ? Integer.MAX_VALUE : y[partY];
			
			boolean case1 = maxLeftX < minRightY;
			boolean case2 = maxLeftY < minRightX;
			if (case1 && case2) {
				if ((xSize + ySize) % 2 == 0) {
					return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return (Math.min(minRightX, minRightY) * 1.0);
				}
			} else if (!case1) {
				high -= 1;
			} else {
				low += 1;
			}
		}
		
		throw new RuntimeException();
	}
	
	public static void main(String[] args) {
		int[] x = {1, 3, 8, 9, 15};
		int[] y = {7, 11, 19, 21, 18, 25};
		
		final MedianOfTwoSortedArrayOfDifferentLength engine = new MedianOfTwoSortedArrayOfDifferentLength();
		System.out.println(engine.findMedianOfTwoSortedArrayOfDifferentLength(x, y));
	}

}
