package com.ssaptly.utils;

public class Base62Codec {
	private static final Integer ZERO = 0;
	private static final Integer ONE = 1;
	private static final String BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	public static String encode(long input) {
		StringBuilder encodedResult = new StringBuilder();

		do {
			int idx = (int) (input % BASE62.length());
			encodedResult.append(BASE62.charAt(idx));
			input /= BASE62.length();
		} while (input > ZERO);

		return encodedResult.toString();
	}
	
	public static long decode(String input) {
		long decodedResult = ZERO;
		long power = ONE;
		
		for(int idx = ZERO; idx < input.length(); idx++) {
			int digit = BASE62.indexOf(input.charAt(idx));
			decodedResult += digit * power;
			power *= BASE62.length();
		}
		
		return decodedResult;
	}
}
