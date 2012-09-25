package util;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

public class SecurityUtil {

	/**
	 * Calculates SHA-1 hash from given string value and returns hex
	 * result.
	 * 
	 * @param value
	 *            string value
	 * @return hex SHA-1 hash
	 */
	public static String hash(String value) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.update(value.getBytes("utf8"));
			return DatatypeConverter.printHexBinary(digest.digest());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
