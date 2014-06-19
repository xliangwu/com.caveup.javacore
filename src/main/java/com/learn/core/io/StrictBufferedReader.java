package com.learn.core.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * CRLFLineReader implements a readLine() method that requires exactly CRLF to
 * terminate an input line. This is required for IMAP, which allows bare CR and
 * LF.
 * 
 */
public class StrictBufferedReader extends BufferedReader {

	private static final char DEFAULT_LINE_SEP = '\n';
	private static int DEFAULT_CHAR_BUFFER_SIZE = 8192;

	/** customize line separator **/
	private char[] lineSeps;

	public StrictBufferedReader(Reader in, int sz, char[] lineSeps) {
		super(in, sz);
		setLineSeps(lineSeps);
	}

	public StrictBufferedReader(Reader in, int sz) {
		super(in, sz);

		char[] chars = null;
		String separator = System.getProperty("line.separator");
		if (separator == null) {
			chars = new char[] { DEFAULT_LINE_SEP };
		} else {
			chars = separator.toCharArray();
		}
		setLineSeps(chars);
	}

	/**
	 * Creates a buffering character-input stream that uses a default-sized
	 * input buffer.
	 * 
	 * @param in
	 *            A Reader
	 */
	public StrictBufferedReader(Reader in) {
		this(in, DEFAULT_CHAR_BUFFER_SIZE);
	}

	/**
	 * Read a line of text. A line is considered to be terminated by carriage
	 * return followed immediately by a line feed(CRLF), or line feed (LF) and
	 * carriage return (CR),so we set up a line separator to ignore other
	 * characters. This contrasts with BufferedReader which also allows other
	 * combinations.
	 * 
	 * @since 3.0
	 */
	@Override
	public String readLine() throws IOException {
		StringBuilder sb = new StringBuilder();
		int intch;

		int c = lineSeps[0];
		int i = 0;
		int len = lineSeps.length;
		synchronized (lock) { // make thread-safe (hopefully!)
			while ((intch = read()) != -1) {
				if (intch == c) {
					i++;
					if (i == len) {
						return sb.substring(0, sb.length() - len + 1);
					}
					c = lineSeps[i];
				}

				sb.append((char) intch);
			}
		}
		String string = sb.toString();
		if (string.length() == 0) { // immediate EOF
			return null;
		}
		return string;
	}

	public void setLineSeps(char[] lineSeps) {
		this.lineSeps = lineSeps;

		/** validate **/
		if (lineSeps == null || lineSeps.length == 0) {
			throw new RuntimeException("property 'lineSeps' must be not-empty");
		}
	}

}
