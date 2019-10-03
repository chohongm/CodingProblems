package code;

public class TwoStringsSameWhenOnceCharRemoved {

	public static boolean equalsWhenOneCharRemoved(String x, String y) {
		
		int xLen = x.length();
		int yLen = y.length();
		
		boolean isRemoved = false;
		int xIdx = 0;
		int yIdx = 0;
		
		if (xLen - 1 == yLen) {
			while (xIdx < xLen) {
				if (x.charAt(xIdx) != y.charAt(yIdx)) {
					if (!isRemoved) {
						isRemoved = true;
					} else {
						return false;
					}
				} else {
					yIdx++;
				}
				xIdx++;
			}
			return true;
			
		} else if (xLen + 1 == yLen) {
			while (yIdx < yLen) {
				if (x.charAt(xIdx) != y.charAt(yIdx)) {
					if (!isRemoved) {
						isRemoved = true;
					} else {
						return false;
					}
				} else {
					xIdx++;
				}
				yIdx++;
			}
			return true;
		}

		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcd";
		String s2 = "abced";
		System.out.println(equalsWhenOneCharRemoved(s1, s2));
	}

}
