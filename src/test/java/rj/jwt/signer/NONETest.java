package rj.jwt.signer;

import org.junit.Test;
import rj.jwt.Algorithm;
import rj.jwt.Signer;
import rj.jwt.SignerFactory;

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