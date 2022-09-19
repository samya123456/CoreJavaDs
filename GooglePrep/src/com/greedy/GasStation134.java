package com.greedy;

public class GasStation134 {

	public static int canCompleteCircuit(int[] gas, int[] cost) {

		int gasSum = 0;
		int costSum = 0;

		for (int i : gas) {
			gasSum += i;
		}

		for (int i : cost) {
			costSum += i;
		}

		if (gasSum < costSum) {
			return -1;
		}

		int start = 0;
		int total = 0;
		for (int i = 0; i < gas.length; i++) {
			total += gas[i] - cost[i];

			if (total < 0) {
				total = 0;
				start = i + 1;
			}
		}
		return start;

	}

	public static void main(String[] args) {
		 int gas[] = {1,2,3,4,5};
		 int cost[] = {3,4,5,1,2};
		 
		 canCompleteCircuit(gas,cost);

	}

}
