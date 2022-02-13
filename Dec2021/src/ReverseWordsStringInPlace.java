
public class ReverseWordsStringInPlace {
	
	 public static String reverseWords(String s) {
	        String[] wordArray = s.split("\\s+");
	        int n =wordArray.length;
	        for(int i=0;i<n/2;i++){
	            String temp = wordArray[i].trim();
	            wordArray[i] = wordArray[n-1-i].trim();
	            wordArray[n-1-i] = temp;
	        }
	       StringBuilder op = new StringBuilder("");
	        for(int i=0;i<n;i++){
	          op.append(wordArray[i].trim());
	            if(i!=n-1){
	                op.append(" "); 
	            }
	         
	        }
	        return op.toString().trim();
	    }

	public static void main(String[] args) {
		//System.out.println(reverseWords("a good   example"));
		
		System.out.println(13%3);

	}

}
