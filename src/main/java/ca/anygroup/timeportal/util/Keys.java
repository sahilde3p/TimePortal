package ca.anygroup.timeportal.util;

import java.util.Random;

public class Keys {
	
	private static String base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static String getUniqueKey() {
		Random rand = new Random();
		
		String key = "";
		
		for(int i=0; i < 10 ; i++) {
			
			int a = rand.nextInt(1000) %36;
			
			key += base.substring(a, a+1);
			
		}
		
		return key;
	}

}
