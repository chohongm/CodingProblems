package code;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i = 0, j = 0; j < n; j++) {
			char c = s.charAt(j);
			if (map.containsKey(c)) {
				i = map.get(c) + 1;
			}
			
			max = Math.max(max, j - i + 1);
		}
		
		return max;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int findLongestSubstring(final String s) {
		int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
            	i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
            System.out.println("j: " + j + ", i: " + i + ", ans: " + ans + ", charAt: " + s.charAt(j));
        }
        return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "pwwkewj";
		int res = findLongestSubstring(str);
		System.out.println(res);
	}

}
