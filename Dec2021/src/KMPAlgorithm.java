
public class KMPAlgorithm {
	
	public static int KMPSearch(String word,String pattern) {
		int N = word.length();
		int M = pattern.length();
		int lps[] = new int[M];
		computeLPS(pattern,M,lps);
		int i=0;
		int j=0;
		while(i<N) {
			if(word.charAt(i)==pattern.charAt(j)) {
				i++;
				j++;
			}else {
				if(j!=0) {
				j =lps[j-1];
				}else {
					i++;
				}
			}
			
			
			
		}
		if(j==M) {
			return (i-j);
		}else {
			return -1;
		}
	}

	private static void computeLPS(String pattern, int m, int[] lps) {
		int len=0;
		int i=1;
		lps[0]=0;
		
		while(i<m) {
			if(pattern.charAt(len)==pattern.charAt(i)) {
				lps[i]=++len;
				i++;
			}else {
				if(len!=0) {
					len =lps[len-1];
				}else {
					i++; 
				}
				
				
			}
			
		}
		
	}

	public static void main(String[] args) {



	}

}
