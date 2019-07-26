package com.tce.common.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Repository;

import com.tce.common.model.SystemConstants;

@Repository("cipher")
public class StreamEncryption {

	private static final String algorithm = "AES";//"PBEWithMD5AndDES";

	private byte[] oldsalt = "salt1234".getBytes(); 
	private byte[] newsalt = "cesalt201909213487".getBytes();
	
	public StreamEncryption() {}

	private Cipher getCipher(String password,int type) throws Exception{    

		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		byte[] salt = password.equals(SystemConstants.CLASSEDGE_V1_ENCRYPTION_KEY) ? oldsalt : newsalt;   
		// NOTE: last argument is the key length, and it is 256
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 1024, 256);
		SecretKey tmp = factory.generateSecret(spec);
		SecretKey passwordKey = new SecretKeySpec(tmp.getEncoded(), "AES");
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(type, passwordKey);
		return cipher;

	}

	public String encryptAsHex(String secretkey,String in) throws Exception {
		Cipher cipher = getCipher(secretkey, Cipher.ENCRYPT_MODE);
		byte[] ciphertext = cipher.doFinal(in.getBytes("UTF-8"));
		return new String(Hex.encodeHex(ciphertext)) ;
	}

	public String decryptFromHex(String secretkey,String in) throws Exception  {
		Cipher cipher = getCipher(secretkey, Cipher.DECRYPT_MODE);
		byte[] ciphertext = cipher.doFinal(Hex.decodeHex(in.toCharArray()));    	
		return new String(ciphertext, "UTF-8");
	}


	public OutputStream encryptStream(String secretkey,OutputStream out) throws Exception {

		return new CipherOutputStream (out, getCipher(secretkey, Cipher.ENCRYPT_MODE));   
	}

	public InputStream decryptStream(String secretkey, InputStream in) throws Exception  {

		return new CipherInputStream(in, getCipher(secretkey, Cipher.DECRYPT_MODE));
	}

	public String decryptResource(String resourceFile) throws Exception  {

		InputStream resourceFileURL=this.getClass().getClassLoader().getResourceAsStream(resourceFile);
		if(resourceFileURL == null){
			throw new FileNotFoundException();
		}
		StringWriter writer = new StringWriter();
		IOUtils.copy(decryptStream(SystemConstants.CLASSEDGE_V2_ENCRYPTION_KEY,resourceFileURL), writer,StandardCharsets.UTF_8);
		return writer.toString();
	}

	public String decryptResource(File resourceFile) throws Exception {
		StringWriter writer = new StringWriter();
		IOUtils.copy(decryptStream(SystemConstants.CLASSEDGE_V2_ENCRYPTION_KEY,new FileInputStream(resourceFile)), writer,StandardCharsets.UTF_8);
		return writer.toString();
	}

	// NOTE we are refering in the ant build for file encryption
	//dont change the method logic
	public static void main(String[] args){
		if (args.length == 0){
			throw new ExceptionInInitializerError("no arguments specified");
		}

		try{
			File srcFile = new File(args[0]);
			File destFile = new File(args[1],srcFile.getName());
			//read file and encrypt data
			StreamEncryption h = new StreamEncryption();
			IOUtils.copy(new FileInputStream(srcFile),
						h.encryptStream(SystemConstants.CLASSEDGE_V2_ENCRYPTION_KEY, new FileOutputStream(destFile)));			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("could not complete encryption"+e.getMessage());
		}
	}
}
