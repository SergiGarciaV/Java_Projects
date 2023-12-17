package garcia.sergi.dam.mp09.uf01.pr2.seguretat.model.security;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class Algoritmes {

	private final String ENCRYPT_KEY = "clave-32-chars__________________";
	private final String ENCRYPT_ALGORITHM = "AES";
	// private final String CODE = "UTF-8";

	public String aesSecurityEncripta(String valorOriginal) {

		String result = null;

		byte[] encrypted = null;
		try {
			Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), ENCRYPT_ALGORITHM);
			Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			encrypted = cipher.doFinal(valorOriginal.getBytes());

		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			System.err.println(e.getMessage());

		}

		if (encrypted != null) {
			result = Base64.getEncoder().encodeToString(encrypted);
		}

		return result;

	}

	public String aesSecurityDesencripta(String encrypted) {
		String result = null;
		byte[] encryptedBytes = null;

		try {
			Key aesKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), ENCRYPT_ALGORITHM);

			Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, aesKey);

			encryptedBytes = Base64.getDecoder().decode(encrypted);
			result = new String(cipher.doFinal(encryptedBytes));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			System.err.println(e.getMessage());
		}

		return result;
	}
	
	public String sha256(String valorOriginal) {
		String resultat = null;

		try {
			MessageDigest md = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
			md.update(valorOriginal.getBytes());
			byte[] digestBytes = md.digest();

			resultat = Base64.getEncoder().encodeToString(digestBytes);

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		return resultat;
	}
	
	public String md5(String valorOriginal) {
		String resultat = null;

		try {
			MessageDigest md = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
			md.update(valorOriginal.getBytes());
			byte[] digestBytes = md.digest();

			resultat = Base64.getEncoder().encodeToString(digestBytes);

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		return resultat;
	}
	
	
	
	

}
