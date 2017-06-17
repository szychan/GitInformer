package com.szychan.gitinformer;

/**
 * The Class StringUtils Provides String formating methods for MyPdfWriter.
 */
public class StringUtils {

	/**
	 * Normalize date time removes unnecessary characters json response format.
	 *
	 * @param dateTime
	 *            the date time
	 * @return the string
	 */
	public static String normalizeDateTime(String dateTime) {

		String normalizedDateTime = dateTime.replace("T", " ").replace("Z", "");

		return removePrimes(normalizedDateTime);
	}

	/**
	 * Removes the primes from string.
	 *
	 * @param string
	 *            the string
	 * @return the string
	 */
	public static String removePrimes(String string) {

		return string.replaceAll("\"", "");
	}
}
