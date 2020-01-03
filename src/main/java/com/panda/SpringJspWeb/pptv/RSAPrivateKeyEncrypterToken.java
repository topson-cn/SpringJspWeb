package com.panda.SpringJspWeb.pptv;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class RSAPrivateKeyEncrypterToken {

	Cipher ecipher;
	Cipher dcipher;

	public RSAPrivateKeyEncrypterToken() {
		try {

			String publicKeyFile = "D:\\workspace\\SpringJspWeb\\src\\main\\resources\\publicKey";
			String privateKeyFile = "D:\\workspace\\SpringJspWeb\\src\\main\\resources\\privateKey";
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			InputStream inStream = new FileInputStream(publicKeyFile);
			ObjectInputStream publicInput = new ObjectInputStream(inStream);
			PublicKey publicKey =  (PublicKey) publicInput.readObject();
			inStream = new FileInputStream(privateKeyFile);
			ObjectInputStream privateInput = new ObjectInputStream(inStream);
			PrivateKey privateKey = (PrivateKey) privateInput.readObject();
			ecipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			dcipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			ecipher.init(Cipher.ENCRYPT_MODE, privateKey);
			dcipher.init(Cipher.DECRYPT_MODE, publicKey);
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		} catch (NoSuchAlgorithmException e) {
		} catch (NoSuchPaddingException e) {
		} catch (InvalidKeyException e) {
		}
	}

	public String encrypt(String str) {
		try {
			byte[] utf8 = str.getBytes("UTF8");
			byte[] enc = ecipher.doFinal(utf8);
			return new String(new org.apache.commons.codec.binary.Base64(true).encode(enc));
		} catch (javax.crypto.BadPaddingException e) {
		} catch (IllegalBlockSizeException e) {
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}

	public String decrypt(String str) {
		try {
			byte[] dec = new org.apache.commons.codec.binary.Base64(true).decode(str);
			byte[] utf8 = dcipher.doFinal(dec);
			return new String(utf8, "UTF8");
		} catch (javax.crypto.BadPaddingException e) {
		} catch (IllegalBlockSizeException e) {
		} catch (UnsupportedEncodingException e) {
		} 
		return null;
	}
}
