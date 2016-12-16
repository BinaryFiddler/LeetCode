import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
//
//For example, Given s = “eceba”,
//
//T is "ece" which its length is 3.


public class Q159 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static public int lengthOfLongestSubstringTwoDistinct(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int maxLen = 0;
		
		for(int i=0, j=0; i<s.length(); i++){			
			char key = s.charAt(i);
			if(!map.containsKey(key) && map.size() == 2){
				j = Collections.min(map.values());
				map.remove(s.charAt(j));
				j = s.indexOf((char)map.keySet().toArray()[0], j);
			}
			
			maxLen = Math.max(maxLen, i - j + 1);
			map.put(key, i);
			
		}
		
		
		return maxLen;
	}
}
