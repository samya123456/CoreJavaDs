package google.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DNASequence {

	public static List<String> getRepeatedString(String s) {

		List<String> repeatedCharacter = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();

		int i = 0;
		while (i + 10 <= s.length()) {
			String dnaSample = s.substring(i, i++ + 10);
			map.put(dnaSample, map.getOrDefault(dnaSample, 0) + 1);
			if (map.get(dnaSample) == 2) {
				repeatedCharacter.add(dnaSample);
			}

		}
		return repeatedCharacter;
	}
	
	
	public static List<String> findRepeatedDnaSequences(String s) {
        List<String> output = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        if(s.length()<10){
            return output;
        }
        
        
        for(int i=10;i<=s.length();i++){
            String current = s.substring(i-10,i);
            if(map.containsKey(current)){
                int count = map.get(current);
                if(count==1){
                    output.add(current); 
                }
                 map.put(current,count+1);
            }else{
                map.put(current,1);
            }
        }
        
        return output;
        
    }

	public static void main(String[] args) {

		// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
		// Output: ["AAAAACCCCC","CCCCCAAAAA"]
		// https://leetcode.com/problems/repeated-dna-sequences/
		
		//System.out.println(getRepeatedString("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));

	}

}
