import java.util.*;

//Given a string, find the length of the longest substring T that contains at most k distinct characters.
//
//For example, Given s = “eceba” and k = 2,
//
//T is "ece" which its length is 3.

public class Q340 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int maxLen = 0;
		
		for(int i=0, j=0; i<s.length(); i++){
			char key = s.charAt(i);
			if(!map.containsKey(key) && map.size() == k){
				if(k == 0)
					break;
				else if(k == 1)
					j = i+1;
				else {
					int leftmost = Collections.min(map.values());
					map.remove(s.charAt(leftmost));
					j = leftmost + 1;
				}
			}
			maxLen = Math.max(maxLen, i - j + 1);
			map.put(key, i);
		}
		
		return maxLen;
	}

}
