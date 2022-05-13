package google.com;

public class MeetingRoomII {
	
	 public int minMeetingRooms(int[][] intervals) {
	        int totalMeetingRoom=0;
	        int maxMeetingRoom=0;
	        int n = intervals[0].length;
	        int i =0;
	        int j =1;
	        
	        while(i<n && j<n){
	            int endTime = intervals[i][1];
	            int startTime = intervals[j][0];
	            if(endTime>startTime){
	                totalMeetingRoom++;
	                i++;
	                if(totalMeetingRoom>maxMeetingRoom){
	                    maxMeetingRoom = totalMeetingRoom;
	                }
	            }else{
	                totalMeetingRoom --;
	                j++;
	            }
	        }
	        
	        return maxMeetingRoom;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//[[0,30],[5,10],[15,20]]

	}

}
