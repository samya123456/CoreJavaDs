package com.example.dp;

public class Test {

	public static void main(String[] args) {
		String ip = "198.15.0.099";
		String segments[] = ip.split("\\.");
		
		
		if (segments.length != 4) {
			System.out.println("INVALID");
		} else {
			
			try {
			if (segments[0].equals("198") && (segments[1].length() == 2 && segments[1].matches("[0-9]+"))
					&& segments[2].equals("0") && (segments[3].length() == 3 && Integer.parseInt(segments[3]) > 000
							&& Integer.parseInt(segments[3]) <= 100)) {
				System.out.println("VALID");
			} else {
				System.out.println("INVALID");
			}
			}catch(Exception e) {
				System.out.println("INVALID");
			}
		}
	}

}
