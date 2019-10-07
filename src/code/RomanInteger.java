package code;

import java.util.HashMap;
import java.util.Map;

public class RomanInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("IV"));
		
	}

	public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
        
        int ans = 0;
        char[] ca = s.toCharArray();
        
        for (int i = 0; i < ca.length; i++) {
            String c = Character.toString(ca[i]);
            if (i < ca.length - 1) {
                String nc = Character.toString(ca[i + 1]);
                if (map.containsKey(c + nc)) {
                    ans += map.get(c + nc);
                    i++;
                } else {
                    ans += map.get(c);
                }
            } else {
                ans += map.get(c);
            }
        }

        return ans;
    }
}
