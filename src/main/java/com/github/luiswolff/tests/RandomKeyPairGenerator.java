package com.github.luiswolff.tests;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.stream.IntStream;

public class RandomKeyPairGenerator {

	public static void main(String[] args) throws Exception {
		for (int i : IntStream.range(0, 10).toArray()) {			
			System.out.println("Key " + i + ": " + PrintUtils.keyPairToString(getKeyPair())); // NOSONAR
		}
	}
	
	private static KeyPair getKeyPair() throws GeneralSecurityException {
	    KeyPairGenerator pairGenerator = KeyPairGenerator.getInstance("RSA");
	    pairGenerator.initialize(2048);
	    return pairGenerator.generateKeyPair();
	}

}
