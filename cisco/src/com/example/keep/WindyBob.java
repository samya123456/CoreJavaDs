package com.example.keep;

import java.util.ArrayList;
import java.util.List;

public class WindyBob {
	
	public static String gameWinner(String colors) {
	    // Write your code here
	    
	    char ch[] = colors.toCharArray();
	    List<Character> list = new ArrayList<>();
	    for(int i=0;i<ch.length;i++){
	        list.add(ch[i]);
	    }
	    
	    boolean windy =true;
	    boolean changed =false;
	    while(!list.isEmpty()){
	        for(int i=1;i<list.size()-1;i++){
	        if(windy){
	            if(list.get(i-1)=='w' && list.get(i+1)=='w' && list.get(i)=='w'){
	                list.remove(i);
	                changed=true;
	            }
	        }else{
	            if(list.get(i-1)=='b' && list.get(i+1)=='b' && list.get(i)=='b'){
	                list.remove(i);
	                changed=true;
	            }
	            
	        }
	        
	        if(changed) {
	        	break;
	        }
	        
	    }
	    
	    if(!changed){
	        break;
	    }
	    
	    changed =false;
	    windy = !windy;
	    }
	    if(windy){
	            return "bob";
	        }else{
	            return "windy";
	        }

	    }

	

	public static void main(String[] args) {
		System.out.println(gameWinner("wwwbbbbwww"));

	}

}
