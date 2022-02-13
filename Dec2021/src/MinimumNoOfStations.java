import java.util.Arrays;

public class MinimumNoOfStations {
	public static int minStationRequired(int[] arriv, int[] dept) {
		Arrays.sort(arriv);
		Arrays.sort(dept);
		int required_stations = 1;
		int max_stations =1;
		int i=1;
		int j=0;
		int n = arriv.length;
		
		while(i<n && j<n) {
			if(arriv[i]<=dept[j]) {
				required_stations++;
				i++;
				if(required_stations>max_stations) {
					max_stations = required_stations;
				}
			}else {
				required_stations--;
				j++;
			}
		}
		return max_stations;
		
	}

	public static void main(String[] args) {
		int arr[] = {900, 940, 950, 1100, 1500, 1800}; 
		int dep[] = {910, 1200, 1120, 1130, 1900, 2000}; 
		System.out.println(minStationRequired(arr,dep));

	}

}
