package rj.jwt.signer;

import org.junit.Test;
import rj.jwt.Algorithm;
import rj.jwt.Signer;
import rj.jwt.SignerFactory;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class HS256Test {
	static Signer signer = SignerFactory.get(Algorithm.HS256);

	@Test
	public void sign_EMPTY() {
		// header={}, payload={}
		byte[] data = "e30=.e30=".getBytes(StandardCharsets.UTF_8);
		byte[] key = "test".getBytes(StandardCharsets.UTF_8);
		byte[] sign = signer.sign(data, key);
		assertEquals("8Yr6vjx78DFGAaXJ_j6Wa5kq82wa1AFyZzyMXtOs91Y=", new String(sign, StandardCharsets.UTF_8));
	}
}