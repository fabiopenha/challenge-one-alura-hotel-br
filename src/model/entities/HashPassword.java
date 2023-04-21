package model.entities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {
	public static String criptoPassword(String senha) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		md.update(senha.getBytes());
		
		byte[] digest = md.digest();
		
		
		StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        String hash = sb.toString();
		return hash;
	}
	
	public static Boolean compareHash(String senhaBD, String hash) {
        if (hash.equals(senhaBD)) {
            return true;
        } else {
        	return false;
        }
        
	}
}
