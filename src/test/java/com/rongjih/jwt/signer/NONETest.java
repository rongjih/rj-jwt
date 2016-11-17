package com.rongjih.jwt.signer;

import com.rongjih.jwt.SignerFactory;
import org.junit.Test;
import com.rongjih.jwt.Algorithm;
import com.rongjih.jwt.Signer;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class NONETest {
	static Signer signer = SignerFactory.get(Algorithm.NONE);

	@Test
	public void sign_EMPTY() {
		// header={}, payload={}
		byte[] data = "e30=.e30=".getBytes(StandardCharsets.UTF_8);
		byte[] key = "test".getBytes(StandardCharsets.UTF_8);
		byte[] sign = signer.sign(data, key);
		assertEquals("", new String(sign, StandardCharsets.UTF_8));
	}
}