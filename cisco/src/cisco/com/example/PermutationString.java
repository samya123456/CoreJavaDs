package cisco.com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PermutationString {
	
	
	public void permutaionString(String input , String ans) {
		
		if(input.length()==0) {
			System.out.println(ans);
			return;
		}
		
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			
			String ros = input.substring(0,i)+ input.substring(i+1);
			
			permutaionString(ros, ans+ch);
		}
		
		
	}
	
	 public int strStr(String haystack, String needle) {
	        
			if (!"".equals(needle) && needle != null) {
				if (!"".equals(haystack) && haystack != null) {
					if (haystack.contains(needle)) {
						return haystack.indexOf(needle);
					}
				}
			} else {
				return 0;
			}

			return -1;
	    
	        
	    }
	 
		public int[] plusOne(int[] digits) {

		    int n = digits.length;
					int op[];
					List<Integer> output = new ArrayList<Integer>();
					int quotient = 0;
					int rem = 1;
		           

					for (int i = n - 1; i >= 0; i--) {
						    int sum = digits[i] + rem;
						    quotient = sum % 10;
						    rem = sum/10;
		                
		                output.add(quotient)  ;
					}
		        
		         	if (rem!=0) {
		         		output.add(rem);
		         	}
		         	int m =output.size();
		         	op = new int[m];
		         	for(int i =output.size()-1;i>=0;i--) {
		         		op[m-1-i] = output.get(i);
		         	}
					return op;
		}
		
		 public void merge(int[] nums1, int m, int[] nums2, int n) {
		        
			 int i =0;
			    int j=0;
			    int k =0;
			    int[] op = new int[m+n];
			    while(i<m+n && j<n ) {
			    	if(nums1[i]<nums2[j]) {
			    		op[k++]= nums1[i++];
			    		
			    	}else {
			    		op[k++]= nums2[j++];
			    	}
			    	
			    } 
			    while(i<m+n && k<m+n) {
			    	 {
			    		op[k]= nums1[i];
			    	}
			    	k++;
			    	i++;
			    }
			    
	         for(int x =0;x<m+n;x++){
	             nums1[x]= op[x];
	         }
	    
		 }
		 
		 static boolean balanced(int small[],
                 int caps[])
{

// For every character, check if
// there exists uppercase as well
// as lowercase characters
for(int i = 0; i < 26; i++)
{
 if (small[i] != 0 && (caps[i] == 0))
     return false;

 else if ((small[i] == 0) && (caps[i] != 0))
     return false;
}
return true;
}

//Function to find smallest length substring
//in the given string which is balanced


	public static void main(String[] args) {
		//new PermutationString().permutaionString("aac", "");
		//"mississippi"
		//"issip" 9,8,9
		//int[] ip = new int[] {9,9};
		//System.out.println(new PermutationString().strStr("mississippi","issip"));
		//int p[] = new int[] {-1,0,0,3,3,3,0,0,0};
		//int m= 6;
		//int q[] = new int[] {1,2,2};
		//int n= 3;
		//new PermutationString().merge(p,m,q,n);
		
	}
}
