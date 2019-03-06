package com.wal.hs.crypto.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CryptoUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(CryptoUtils.class);
	private static SecretKeySpec secretKey;
	private static byte[] key;

	public static void setKey(String k) {
		MessageDigest sha = null;

		try {
			key = k.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static String encrypt(String strToEncrypt, String k) {
		LOGGER.debug("Setting key for encrypt : {}", k);

		try {
			setKey(k);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String decryptValue, String key) {
		LOGGER.debug("Setting key for decrypt : {}", key);

		try {

			setKey(key);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(decryptValue)));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
