package google.com;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExamRoom {

	Set<Integer> seats;
	int n;
	

	public ExamRoom(int n) {
		seats = new TreeSet<Integer>();

		this.n = n;

	}

	public int seat() {
		int start = 0;
		int max = 0;
		int index = 0;
		for (int i : seats) {
			if (start == 0) {
				if (max < i - start) {
					max = i - start;
					index = 0;
				}
			} else {
				if (max < (i - start + 1) / 2) {
					max = (i - start + 1) / 2;
					index = start + max - 1;
				}
			}
			start = i + 1;
		}
		if (start > 0 && max < n - start) {
			max = n - start;
			index = n - 1;
		}
		seats.add(index);
		return index;
	}

	public void leave(int p) {
		seats.remove(p);
	}

	public static void main(String[] args) {
		ExamRoom examRoom = new ExamRoom(100);
		System.out.println(examRoom.seat());
		System.out.println(examRoom.seat());
		System.out.println(examRoom.seat());
		System.out.println(examRoom.seat());
		System.out.println(examRoom.seat());
		System.out.println(examRoom.seat());
		examRoom.leave(4);
		System.out.println(examRoom.seat());
		System.out.println(examRoom.seat());
		System.out.println(examRoom.seat());

	}

}
