import java.util.HashMap;
import java.util.Map;

public class Anagrams {
	
	public boolean checkAnagrams(char a[], char b[]) {
		
		Map<Character, Integer> map = new HashMap<Character,Integer>();
		
		for(char c : a){
			int count = 1;
			if(map.containsKey(c)){
				count = map.get(c) + 1;
			}
			map.put(c, count);
		}
		
		for(char c : b){
			int count = -1;
			if(map.containsKey(c)){
				count = map.get(c) - 1;
			}
			map.put(c, count);
		}
		
		for(char c : map.keySet()){
			if(map.get(c) != 0){
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		Anagrams anagrams = new Anagrams();
		char a[] = "schoolmaster".toCharArray();
		char b[] = "theclassroom".toCharArray();
		
		System.out.println(anagrams.checkAnagrams(a, b));

	}

}
