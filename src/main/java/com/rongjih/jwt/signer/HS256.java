package com.rongjih.jwt.signer;

import com.rongjih.jwt.SignException;
import com.rongjih.jwt.Signer;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Use HMAC SHA256 method to sign data to base64.
 *
 * @author RJ
 * @since JDK1.8
 */
public final class HS256 implements Signer {
	private static final String HMAC_SHA_256 = "HmacSHA256";

	@Override
	public byte[] sign(byte[] data, byte[] key) {
		try {
			Mac mac = Mac.getInstance(HMAC_SHA_256);
			mac.init(new SecretKeySpec(key, HMAC_SHA_256));
			return Base64.getUrlEncoder().encode(mac.doFinal(data));
		} catch (InvalidKeyException | NoSuchAlgorithmException e) {
			throw new SignException(e.getMessage(), e);
		}
	}
}
