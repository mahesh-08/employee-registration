package com.zensar.common;

public class Token {

	public static String generateToken() {
		// String token="";

		int n = 32;
		StringBuilder token = new StringBuilder(n);
		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of token
			token.append(AlphaNumericString.charAt(index));
		}

		return token.toString();

		// return token;
	}
}
