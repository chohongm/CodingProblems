package code;
import java.util.HashMap;
import java.util.Map;

class FindCharOfBothUpperAndLower {
	
	public static void main(String[] args) {
		System.out.println(solution("WeTestCodErs"));
	}
	
    public static String solution(String S) {
        // write your code in Java SE 8
        int len = S.length();
        if (len == 0) {
            return "NO";
        }
        
        // 1. find all uppers and store in map.
        Map<Character, Integer> uppers = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Character c = S.charAt(i);
            if (Character.isUpperCase(c)) {
                uppers.put(Character.toLowerCase(c), 0);
            }
        }
        
        // 2. iterate again to check if matching lower case is found and
        // if yes update min value.
        Character res = null;
        for (int i = 0; i < len; i++) {
            Character c = S.charAt(i);
            if (uppers.get(c) != null) {
                Character cand = Character.toUpperCase(c);
                if (res == null) {
                    res = cand;
                } else {
                    res = (cand > res) ? cand : res;
                }
            }
        }
        
        if (res == null) {
            return "NO";
        }
        
        return Character.toString(res);
    }
}
