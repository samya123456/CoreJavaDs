package com.twopointer;

public  class LongestRepeatingCharacterReplacement424 {
	
    public static int characterReplacement(String s, int k) {
        
        int n = s.length();
        int start =0;
        int end = 0;
        int max_count =0;
        int max_length =0;
        int[] count_map = new int[26];
        
        for(end =0;end<n;end++){
            
            count_map[s.charAt(end) - 'A']++;
            
            max_count = Math.max(max_count,count_map[s.charAt(end) - 'A']);
            
            while(end - start - max_count +1 -k >0){
                
                count_map[s.charAt(start) - 'A']--;
                start++;
                
            }
            
            max_length = Math.max(max_length , end -start +1);
            
        }
        
        return max_length ;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
