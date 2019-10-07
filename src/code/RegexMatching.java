package code;

import java.util.Arrays;

public class RegexMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaa";
		String p = "aa*a";
		System.out.println(isMatch(s, p));

	}
	
	public static boolean isMatch(String s, String p) {
		
		int sl = s.length();
		int pl = p.length();
		
		char[] cs = s.toCharArray();
		char[] ps = p.toCharArray();
		
		boolean[][] map = new boolean[sl + 1][pl + 1];
		map[0][0] = true;
        //Deals with patterns like a* or a*b* or a*b*c*..
        for (int i = 1; i < map[0].length; i++) {
            if (ps[i-1] == '*') {
            	map[0][i] = map[0][i - 2];
            }
        }
		// We need to determine all cases for dynamic programming.
		//
		// 1. Basic case: cs[i] == ps[j] or ps[j] == '.'
		// In this case, we want to verify previous c and p matched. 
		// 
		// 2. Complex case of '*': cs[i] == ps[j - 1] or map[i][j - 2]
		// if cs[i] == ps[j - 1] is true, then we want to recursively verify the current pattern 'x*' is also true for the
        // previous i or 
		for (int i = 1; i <= sl; i++) {
			for (int j = 1; j <= pl; j++) {
				if (cs[i - 1] == ps[j - 1] || ps[j - 1] == '.') {
					map[i][j] = map[i - 1][j - 1];
					
				} else if (ps[j - 1] == '*') {
					if (cs[i - 1] == ps[j - 2] || ps[j - 2] == '.') {
						map[i][j] = map[i - 1][j] | map[i][j - 2];
						
					} else {
						map[i][j] = map[i][j - 2];
					}
				}
			}
		}
		System.out.println(Arrays.deepToString(map));
		return map[sl][pl];
	}
	

}
