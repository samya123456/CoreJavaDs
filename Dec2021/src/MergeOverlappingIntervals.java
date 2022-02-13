import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {

	static class Interval {
		int start, end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void mergeInterval(Interval[] arr) {

		Arrays.sort(arr, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {

				return o1.start - o2.start;
			}

		});

		int index = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[index].end > arr[i].start) {
				arr[index].end = Math.max(arr[index].end, arr[i].end);
			}else {
				index++;
				arr[index] =arr[i];
			}
		}
		
		for(int i=0;i<=index;i++) {
			System.out.print("["+ arr[i].start +","+arr[i].end +"]");
		}
		
	}

	public static void main(String[] args) {
		
		 Interval arr[]=new Interval[4];
	        arr[0]=new Interval(6,8);
	        arr[1]=new Interval(1,9);
	        arr[2]=new Interval(2,4);
	        arr[3]=new Interval(4,7);
	        mergeInterval(arr);

	}

}
