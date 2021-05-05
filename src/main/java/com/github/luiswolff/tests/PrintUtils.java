package com.github.luiswolff.tests;

import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class PrintUtils {
	
	private static final boolean PRIND_RAW_KEY = Boolean.getBoolean("printRawKey");
	
	private PrintUtils() {}

	static String keyPairToString(KeyPair keyPair) throws NoSuchAlgorithmException {
		return String.format("key: %s, pub: %s", hex(keyPair.getPrivate().getEncoded()), hex(keyPair.getPublic().getEncoded()));
	}

	private static String hex(byte[] input) throws NoSuchAlgorithmException {
		StringBuilder result = new StringBuilder();
		int size = input.length;
		if (!PRIND_RAW_KEY) {
			input = MessageDigest.getInstance("MD5").digest(input);
		}
		for (int i = 0; i < input.length; i++) {
			result.append(String.format("%02X", input[i]));
		}
		return result.toString() + "(Size: "+ size + ")";
	}

}
