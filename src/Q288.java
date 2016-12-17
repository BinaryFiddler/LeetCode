import java.util.*;

//An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
//
//a) it                      --> it    (no abbreviation)
//
//     1
//b) d|o|g                   --> d1g
//
//              1    1  1
//     1---5----0----5--8
//c) i|nternationalizatio|n  --> i18n
//
//              1
//     1---5----0
//d) l|ocalizatio|n          --> l10n
//Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
//
//Example: 
//Given dictionary = [ "deer", "door", "cake", "card" ]
//
//isUnique("dear") -> 
//false
//
//isUnique("cart") -> 
//true
//
//isUnique("cane") -> 
//false
//
//isUnique("make") -> 
//true
public class Q288 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ValidWordAbbr {
    Map<String, Integer> map;
    Set<String> dic;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        dic = new HashSet<>();
        for(String word:dictionary){
            String abbr = findAbbr(word);
            dic.add(word);
            if(abbr.equals(word))
                continue;
            if(map.containsKey(abbr))
                map.put(abbr, 1);
            else
                map.put(abbr, -1);
        }
    }

    public boolean isUnique(String word) {
        String abbr = findAbbr(word);
        if(dic.contains(word)){
            return !map.containsKey(abbr) || map.get(abbr) < 0;
        }
        else{
            return !map.containsKey(abbr);
        }
    }
    
    String findAbbr(String word){
        StringBuilder sb = new StringBuilder();
        int n = word.length();
        
        return (n < 3) ? word : sb.append(word.charAt(0)).append(n-2).append(word.charAt(n-1)).toString();
    }

}
// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
