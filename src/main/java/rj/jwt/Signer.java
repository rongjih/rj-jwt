package rj.jwt;

/**
 * JWT Signer.
 *
 * @author RJ
 * @since JDK1.8
 */
public interface Signer {
	/**
	 * sign the data to base64 with the specific secret key.
	 *
	 * @param data the data to be signed
	 * @param key  secret key
	 * @throws SignException if signed failed.
	 */
	byte[] sign(byte[] data, byte[] key);
}
