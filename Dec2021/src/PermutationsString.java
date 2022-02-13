
public class PermutationsString {
	
	public static void printPermutation(String input,String restOfString) {
		if(input.length()==0) {
			System.out.println(restOfString);
		}
		
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			String newInput = input.substring(0,i) + input.substring(i+1);
			printPermutation(newInput,restOfString+ch);
		}
	}

	public static void main(String[] args) {
		printPermutation("abc","");

	}

}
