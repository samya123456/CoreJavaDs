
public class KMPAlgo {
	
	public static void KMPSearch(String text,String pattern) {
		int n= text.length();
		int m =pattern.length();
		int[] lps = new int[m];
		createLPSArray(pattern,lps,m);
		int i=0;
		int j=0;
		while(i<n) {
			if(text.charAt(i)==pattern.charAt(j)) {
				i++;
				j++;
			}else {
				if(j!=0) {
					j=lps[j-1];	
				}else {
					i++;
				}
				
			}
			if(j==m) {
				System.out.println(i-j);
				j=lps[j-1];	
			}
			
		}
		
		
	}

	private static void createLPSArray(String pattern, int[] lps, int m) {
		int count =0;
		int i=1;
		lps[0]=0;
		while(i<m) {
			if(pattern.charAt(count)==pattern.charAt(i)) {
				lps[i]=++count;
				i++;
				
				
			}else {
				if(count!=0) {
					count = lps[count-1];
					
				}else {
					lps[i]=0;
					i++;
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
