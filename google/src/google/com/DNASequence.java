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

	public static void main(String[] args) {

		// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
		// Output: ["AAAAACCCCC","CCCCCAAAAA"]
		// https://leetcode.com/problems/repeated-dna-sequences/
		
		System.out.println(getRepeatedString("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

	}

}
