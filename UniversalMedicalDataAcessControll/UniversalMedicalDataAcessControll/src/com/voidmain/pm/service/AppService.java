package com.voidmain.pm.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class AppService {

	public static String getHash(String data)
	{
		String hashKey="";
		
		try {
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
			hashKey=new String(hash);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return hashKey;
	}
	
	public static String getSHA(String input)
    { 
		String hashKey=null;
		
		try {
			
			// Static getInstance method is called with hashing SHA 
	        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
	  
	        // digest() method called 
	        // to calculate message digest of an input 
	        // and return array of byte
	        byte[] bytes=md.digest(input.getBytes(StandardCharsets.UTF_8));
	        
	        hashKey=toHexString(bytes);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return hashKey;
    }
    
    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation 
        BigInteger number = new BigInteger(1, hash); 
  
        // Convert message digest into hex value 
        StringBuilder hexString = new StringBuilder(number.toString(16)); 
  
        // Pad with leading zeros
        while (hexString.length() < 32) 
        { 
            hexString.insert(0, '0'); 
        } 
  
        return hexString.toString(); 
    }
}
