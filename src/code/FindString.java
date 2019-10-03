package code;

public class FindString {

	public int findString(String[] strs, String str, int low, int high) {
		while (low <= high) {
			int idx = (low + high) / 2;
			
			// if empty string, find nearest non empty string
			if (strs[idx].equals("")) {
				
				int left = idx - 1;
				int right = idx + 1;
				while (left >= 0 && strs[left].equals("") && right < high && strs[left].equals("")) {
					left--;
					right++;
				}
				
				if (left >= 0 && !strs[left].equals("")) {
					idx = left;
				} else if (right < high && !strs[right].equals("")) {
					idx = right;
				} else {
					return -1;
				}
			}

			String cand = strs[idx];
			int compared = cand.compareTo(str);
			if (compared == 0) {
				return idx;
			} else if (compared < 0) {
				low = idx + 1;
			} else {
				high = idx - 1;
			}
		}
		return -1;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"for", "", "", "", "geeks", "ide", "", "practice", "" , "", "quiz", "", ""};
		String str = "quiz";
		FindString fs = new FindString();
		System.out.println(fs.findString(strs, str, 0, strs.length));
	}

}
