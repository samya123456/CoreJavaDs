package com.microsoft;

import java.util.HashMap;
import java.util.Map;

public class CinemaSeatAllocation1386 {
	
public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        Map<Integer,Boolean[]> map = new HashMap<Integer,Boolean[]>();
        for(int i=0;i<reservedSeats.length;i++){
            int row = reservedSeats[i][0];
            int seatNo = reservedSeats[i][1];
            Boolean[] seatAllocation ;
            if(map.containsKey(row)){
                seatAllocation = map.get(row);
            }else{
                seatAllocation = new Boolean[3];
                seatAllocation[0]=true;
                seatAllocation[1]=true;
                seatAllocation[2]=true;
                
            }
            
            if(seatNo==1 || seatNo==10){
                continue;
            }
            
            if(seatNo==2 || seatNo==3){
                seatAllocation[0] =false;
            }else if(seatNo==4 || seatNo==5){
                seatAllocation[0] =false;
                seatAllocation[1] =false;
            }else if(seatNo==6 || seatNo==7){
                seatAllocation[1] =false;
                seatAllocation[2] =false;
            }else if(seatNo==8 || seatNo==9){
                 seatAllocation[2] =false;
            }
            
            map.put(row,seatAllocation);
        }
        int count =0;
        for(Map.Entry<Integer,Boolean[]> entry: map.entrySet()){
            
            Boolean[] seats = entry.getValue();
            
            if((seats[0] && seats[1] && seats[2]) || seats[0] && seats[2]){
                count+=2;
            }else if((seats[0] && seats[1]) || seats[0] || seats[1] ){
                count++;
            }else if((seats[1] && seats[2]) ||seats[1] || seats[2]){
                count++;
            }
        }
        count += (n-map.size()) *2;
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
