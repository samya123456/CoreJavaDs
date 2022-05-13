package google.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsNumber {
	
	public static void permutationsNumer(Integer[] input) {
		
		List<Integer> newIp = Arrays.asList(input);
		List<Integer> restOfNumbers = new ArrayList<>();
		permutationsNumerUtil(newIp,restOfNumbers,newIp.size());
	}

	private static void permutationsNumerUtil(List<Integer> newIp, List<Integer> restOfNumbers,int size) {
			if(restOfNumbers.size() ==size) {
				System.out.println(restOfNumbers);
				return;
		
			}
	
			for(int i=0;i<newIp.size();i++) {
				restOfNumbers.add(newIp.get(i));
				List<Integer> temp = new ArrayList<>();
				for(int j=0;j<newIp.size();j++) {
					if(i!=j) {
						temp.add(newIp.get(j));
					}
					
				}
				permutationsNumerUtil(temp,restOfNumbers,size);
				restOfNumbers.remove(restOfNumbers.size()-1);
				
				
			}
	}
	
	public static void permutationString(String input,String ros, int size) {
		if(ros.length()==size) {
			System.out.println(ros);
			return;
		}
		
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			String newIp = input.substring(0,i) + input.substring(i+1);
			permutationString(newIp,ros+ch,size);
		}
	}
	

	public static void main(String[] args) {
		
		Integer[] arr = {1,2,3};
		//permutationsNumer(arr);
		permutationString("123","",3);
		

	}

}
