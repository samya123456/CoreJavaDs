package google.com;

import java.util.*;

public class CanJobEndWithCPU {
	
	static class Job{
		int startTime;
		int endTime;
		int num_cup_required;
		
	}
	
	 private static boolean canExecutedAll(List<Job> jobs, int total_num_cups) {
	        Map<Integer, List<Integer>> endTime_map = new HashMap<>();
	        Map<Integer, List<Integer>> startTime_map = new HashMap<>();
	        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	        int index = 0;
	        for(Job job : jobs){
	            int startTime = job.startTime;
	            int endTime = job.endTime + startTime;
	            List list = endTime_map.getOrDefault(endTime, new ArrayList<>());
	            list.add(index);
	            endTime_map.put(endTime, list);
	            list = startTime_map.getOrDefault(startTime, new ArrayList<>());
	            list.add(index);
	            startTime_map.put(startTime, list);
	            index++;

	            min = Math.min(startTime, min);
	            max = Math.max(max, endTime);
	        }
	        int cur_num_cups = 0;
	        for(int time = min; time <= max; time++){
	            if(startTime_map.containsKey(time)){
	                List<Integer> list = startTime_map.get(time);
	                for(int i : list){
	                    cur_num_cups += jobs.get(i).num_cup_required;    
	                }
	            }
	            if(endTime_map.containsKey(time)){
	                List<Integer> list = endTime_map.get(time);
	                for(int i : list){
	                    cur_num_cups -= jobs.get(i).num_cup_required;
	                }
	            }
	            if(total_num_cups < cur_num_cups)
	                return false;
	        }
	        return true;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
