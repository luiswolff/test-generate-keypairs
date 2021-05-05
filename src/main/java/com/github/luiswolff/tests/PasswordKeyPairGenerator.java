package com.github.luiswolff.tests;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class PasswordKeyPairGenerator {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Key 1: " + PrintUtils.keyPairToString(getKeyPair("pwd-1"))); // NOSONAR
		System.out.println("Key 2: " + PrintUtils.keyPairToString(getKeyPair("pwd-1"))); // NOSONAR
		System.out.println("Key 3: " + PrintUtils.keyPairToString(getKeyPair("pwd-2"))); // NOSONAR
		System.out.println("Key 4: " + PrintUtils.keyPairToString(getKeyPair("pwd-2"))); // NOSONAR
		System.out.println("Key 5: " + PrintUtils.keyPairToString(getKeyPair("Very long passworddddddddddddddddddddddddd"))); // NOSONAR
	}
	
	private static KeyPair getKeyPair(String password) throws GeneralSecurityException {
	    SecureRandom rnd = SecureRandom.getInstance("SHA1PRNG");
	    rnd.setSeed(password.getBytes(StandardCharsets.UTF_8));

	    KeyPairGenerator pairGenerator = KeyPairGenerator.getInstance("RSA");
	    pairGenerator.initialize(2048, rnd);

	    return pairGenerator.generateKeyPair();
	}

}
