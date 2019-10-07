package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    
    public static List<String> letterCombinations(String digits) {
        
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.equals("")) return ans;
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        
        ans.add("");
        char[] cs = digits.toCharArray();
        for(char c : cs) {
            ans = rec(ans, map.get(c));
        }
        
        return ans;
        
    }
    
    public static List<String> rec(List<String> lst, String alphs) {
        
        List<String> ans = new ArrayList<>();
        char[] cs = alphs.toCharArray();
        for (String e : lst) {
            for(char c : cs) {
                ans.add(e + c);
            }
        }
        return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
	    System.out.println(letterCombinations("23"));
	}

}
