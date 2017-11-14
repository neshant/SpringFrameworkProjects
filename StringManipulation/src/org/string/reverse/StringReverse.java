package org.string.reverse;

public class StringReverse {

	
	public static void main(String[] args) {
		
		
		System.out.println(stringReverse("DimaagKharaab"));
		
	}
	
	private static String stringReverse(String input) {
		if(input.length()==0) {
			return "";
		}
		return input.charAt(input.length()-1)+ stringReverse(input.substring(0, input.length()-1));
	}
}
