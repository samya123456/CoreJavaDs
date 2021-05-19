package payPal;

import java.util.Arrays;

public class MinimumStation {
	
	
	public static int minStationRequired(int[] arriv, int[] dept) {
		Arrays.sort(arriv);
		Arrays.sort(dept);
		
		int i =1 ,j=0;
		int n = arriv.length;
		int maxPlatForm=1;
		int neededPlatForm=1;
		while(i<n && j<n) {
			
			if(arriv[i]<=dept[j]) {
				maxPlatForm++;
				i++;
				
				if(maxPlatForm>neededPlatForm) {
					neededPlatForm = maxPlatForm;
				}
			}
			
			else {
				maxPlatForm--;
				j++;
			}
			
		}
		
		return neededPlatForm;
	}

	public static void main(String[] args) {
		int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
		int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
		System.out.println(minStationRequired(arr,dep));

	}

}
