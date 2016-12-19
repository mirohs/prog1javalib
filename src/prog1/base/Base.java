/*
 * Copyright 2016 michaelrohs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package prog1.base;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

// javadoc prog1.base prog1.graphics prog1.functional -d doc -header 'Programming I Java Library' -footer 'version 0.6' -top '<a href="http://hci.uni-hannover.de" target="_blank"><img src="http://hci.uni-hannover.de/files/prog1lib/hcilogo.png" /></a>' -public -link http://docs.oracle.com/javase/8/javafx/api/ -link https://docs.oracle.com/javase/8/docs/api/
// jar cf prog1javalib.jar prog1

/**
 * Base class of the Programming I Java library. Contains static methods for
 * conversion of values, input, output (including files), random numbers, and --
 * most importantly -- testing.
 * 
 * @author michaelrohs
 * @version 0.1
 */
public class Base {
	
	/**
	 * A very small positive value. Typically used in specifying error tolerances.
	 */
	public final static double EPSILON = 0.00000001;
	
	private static int check_count = 0;
	private static int check_success_count = 0;
	private final static BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
	private final static Random rnd = new Random();
	
	/**
	 * This class is meant to be used in a static way.
	 */
	private Base() {}

	////////////////////////////////////////////////////////////////////////////
	// Conversion
	
	/**
	 * Convert a string to an integer.
	 * @param s string that contains an integer
	 * @return the converted integer
	 */
	public static int intOf(String s) {
		return Integer.parseInt(s);
	}
	
	/**
	 * Convert part of a string to an integer.
	 * @param s the string some part of which contains an integer
	 * @param start the start index of the integer in the string
	 * @param end the end index (exclusive) of the integer in the string
	 * @return the converted integer
	 */
	public static int intOf(String s, int start, int end) {
		int n = s.length();
		if (n <= 0 || end <= 0 || start >= n || start >= end) return 0;
		String t = s.substring(start, end);
		int i = intOf(t);
		return i;
	}
	
	/**
	 * Convert a string to a double.
	 * @param s string that contains a double
	 * @return the converted double
	 */
	public static double doubleOf(String s) {
		return Double.parseDouble(s);
	}
	
	/**
	 * Convert part of a string to a double.
	 * @param s the string some part of which contains a double
	 * @param start the start index of the double in the string
	 * @param end the end index (exclusive) of the double in the string
	 * @return the converted double
	 */
	public static double doubleOf(String s, int start, int end) {
		int n = s.length();
		if (n <= 0 || end <= 0 || start >= n || start >= end) return 0.0;
		String t = s.substring(start, end);
		double d = doubleOf(t);
		return d;
	}
	
	////////////////////////////////////////////////////////////////////////////
	// Output
	
	/**
	 * Print an object.
	 * @param obj the object to print
	 */
	public static void print(Object obj) {
		System.out.print(obj);
	}

	/**
	 * Print an object followed by a line break.
	 * @param obj the object to print
	 */
	public static void println(Object obj) {
		System.out.println(obj);
	}

	/**
	 * Print a line break.
	 */
	public static void println() {
		System.out.println();
	}
	
	/**
	 * Print formatted output, as in C.
	 * @param format format string (as in C: %d, %s, %f.2, %g)
	 * @param args the variables that fill the place holders in the format string
	 */
	public static void printf(String format, Object... args) {
		System.out.printf(format, args);
	}

	/**
	 * Print an integer array.
	 * @param a the array to print
	 */
	public static void print(int[] a) {
		System.out.print('[');
		if (a.length > 0) {
			System.out.print(a[0]);
		}
		for (int i = 1; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.print(']');
	}

	/**
	 * Print an integer array followed by a line break.
	 * @param a the array to print
	 */
	public static void println(int[] a) {
		print(a);
		println();
	}

	/**
	 * Print a double array.
	 * @param a the array to print
	 */
	public static void print(double[] a) {
		System.out.print('[');
		if (a.length > 0) {
			System.out.print(a[0]);
		}
		for (int i = 1; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.print(']');
	}

	/**
	 * Print a double array followed by a line break.
	 * @param a the array to print
	 */
	public static void println(double[] a) {
		print(a);
		println();
	}

	/**
	 * Print a boolean array.
	 * @param a the array to print
	 */
	public static void print(boolean[] a) {
		System.out.print('[');
		if (a.length > 0) {
			System.out.print(a[0]);
		}
		for (int i = 1; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.print(']');
	}

	/**
	 * Print a boolean array followed by a line break.
	 * @param a the array to print
	 */
	public static void println(boolean[] a) {
		print(a);
		println();
	}

	/**
	 * Print a character array.
	 * @param a the array to print
	 */
	public static void print(char[] a) {
		System.out.print('[');
		if (a.length > 0) {
			System.out.print(a[0]);
		}
		for (int i = 1; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.print(']');
	}

	/**
	 * Print a character array followed by a line break.
	 * @param a the array to print
	 */
	public static void println(char[] a) {
		print(a);
		println();
	}

	/**
	 * Print a byte array.
	 * @param a the array to print
	 */
	public static void print(byte[] a) {
		System.out.print('[');
		if (a.length > 0) {
			System.out.print(a[0]);
		}
		for (int i = 1; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.print(']');
	}

	/**
	 * Print a byte array followed by a line break.
	 * @param a the array to print
	 */
	public static void println(byte[] a) {
		print(a);
		println();
	}

	/**
	 * Print an Object array (using the toString method of each Object).
	 * @param a the array to print
	 */
	public static void print(Object[] a) {
		System.out.print('[');
		if (a.length > 0) {
			System.out.print(a[0]);
		}
		for (int i = 1; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.print(']');
	}

	/**
	 * Print an Object array (using the toString method of each Object) followed by a line break.
	 * @param a the array to print
	 */
	public static void println(Object[] a) {
		print(a);
		println();
	}

	
	////////////////////////////////////////////////////////////////////////////
	// Input
	
	/**
	 * Read a line from standard input.
	 * @return the read input line
	 */
	public static String stringInput() {
		String s = "";
		try {
			s = bin.readLine();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/**
	 * Read a line from standard input and convert it to an integer.
	 * @return the read integer
	 */
	public static int intInput() {
		int i = 0;
		try {
			i = Integer.parseInt(bin.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	/**
	 * Read a line from standard input and convert it to a double.
	 * @return the read double
	 */
	public static double doubleInput() {
		double d = 0.0;
		try {
			d = Double.parseDouble(bin.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		return d;
	}

	////////////////////////////////////////////////////////////////////////////
	// Files
	
	/**
	 * Read a file and return its contents as a string.
	 * @param name the name of the file
	 * @return the file contents
	 */
	public static String sReadFile(String name) {
		Path path = FileSystems.getDefault().getPath(name);
		List<String> lines;
		try {
			lines = Files.readAllLines(path);
			return String.join("\n", lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * Read a file and return its contents as a byte array.
	 * @param name the name of the file
	 * @return the file contents
	 */
	public static byte[] bReadFile(String name) {
		Path path = FileSystems.getDefault().getPath(name);
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new byte[0];
	}
	
	/**
	 * Write a string to a file. Caution: Replaces an existing file of the same name.
	 * @param name the name of the file
	 * @param data the data to write to the file
	 */
	public static void writeFile(String name, String data) {
		Path path = FileSystems.getDefault().getPath(name);
		byte[] b = data.getBytes(StandardCharsets.UTF_8);
		try {
			Files.write(path, b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Write a byte array to a file. Caution: Replaces an existing file of the same name.
	 * @param name the name of the file
	 * @param data the data to write to the file
	 */
	public static void writeFile(String name, byte[] data) {
		Path path = FileSystems.getDefault().getPath(name);
		try {
			Files.write(path, data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	////////////////////////////////////////////////////////////////////////////
	// Random numbers
	
	/**
	 * A random number from the interval [0, i).
	 * @param i (exclusive) upper boundary
	 * @return the random number
	 */
	public static int rnd(int i) {
		return rnd.nextInt(i);
	}
	
	/**
	 * A random number from the interval [0, i).
	 * @param i (exclusive) upper boundary
	 * @return the random number
	 */
	public static double rnd(double i) {
		return rnd.nextDouble() * i;
	}
	
	/**
	 * A random boolean value.
	 * @return true or false
	 */
	public static boolean rnd() {
		return rnd.nextBoolean();
	}
	
	////////////////////////////////////////////////////////////////////////////
	// Testing

/*
	private static boolean checkExpect(int a, int e) {
		base_check_count++;
		Thread t = Thread.currentThread();
//		System.out.println(t);
		
		StackTraceElement[] stackTrace = t.getStackTrace();
//		for (int i = 0; i < stackTrace.length; i++) {
//			System.out.println("" + i + ": " + stackTrace[i]);
//		}
		
		StackTraceElement element = stackTrace[stackTrace.length - 1];
		// String cls = element.getClassName();
		// String method = element.getMethodName();
		String file = element.getFileName();
		int line = element.getLineNumber();
		// System.out.println("file = " + file + ", class = " + cls + ", method = " + method + ", line = " + line);

		if (a == e) {
			System.out.printf("%s, line %d: check passed\n", file, line);
			base_check_success_count++;
			return true;
		} else {
			System.out.printf("%s, line %d: Actual value %d differs from expected value %d.\n", file, line, a, e);
			return false;
		}
	}
*/

	private static StackTraceElement callPoint() {
		Thread t = Thread.currentThread();
		StackTraceElement[] stackTrace = t.getStackTrace();
		int n = stackTrace.length;
		for (int i = 0; i < n; i++) {
			StackTraceElement element = stackTrace[i];
			String cls = element.getClassName();
			String method = element.getMethodName();
			// println("class = '" + cls + "', '" + method + "'");
			if (cls.equals("prog1.base.Base") && method.startsWith("check") && i + 1 < stackTrace.length) {
				return stackTrace[i + 1];
			}
		}
		return null;
	}
	
	/**
	 * Check whether the actual value (first argument) is equal to the expected value (second argument).
	 * @param a actual value
	 * @param e expected value
	 * @return true if actual and expected values are equal
	 */
	public static boolean checkExpect(int a, int e) {
		check_count++;
		StackTraceElement element = callPoint();
		String file = element.getFileName();
		int line = element.getLineNumber();
		if (a == e) {
			System.out.printf("%s, line %d: check passed\n", file, line);
			check_success_count++;
			return true;
		} else {
			System.out.println(file + ", line " + line + ": Actual value " + a + " differs from expected value " + e + ".");
			return false;
		}
	}
	
	/**
	 * Check whether the actual value (first argument) is equal to the expected value (second argument).
	 * @param a actual value
	 * @param e expected value
	 * @return true if actual and expected values are equal
	 */
	public static boolean checkExpect(boolean a, boolean e) {
		check_count++;
		StackTraceElement element = callPoint();
		String file = element.getFileName();
		int line = element.getLineNumber();
		if (a == e) {
			System.out.printf("%s, line %d: check passed\n", file, line);
			check_success_count++;
			return true;
		} else {
			System.out.println(file + ", line " + line + ": Actual value " + a + " differs from expected value " + e + ".");
			return false;
		}
	}
	
	/**
	 * Check whether the actual value (first argument) and the expected value (second argument) differ less than epsilon.
	 * @param a actual value
	 * @param e expected value
	 * @param epsilon the +/- error range
	 * @return true if actual and expected values are within +/- epsilon of each other
	 */
	public static boolean checkWithin(double a, double e, double epsilon) {
		check_count++;
		StackTraceElement element = callPoint();
		String file = element.getFileName();
		int line = element.getLineNumber();
		if (Math.abs(a - e) <= epsilon) {
			System.out.printf("%s, line %d: check passed\n", file, line);
			check_success_count++;
			return true;
		} else {
			System.out.println(file + ", line " + line + ": Actual value " + a + " is not within " + epsilon + " of expected value " + e + ".");
			return false;
		}
	}
	
	/**
	 * Check whether the actual value (first argument) and the expected value (second argument) differ less than epsilon.
	 * @param a actual value
	 * @param e expected value
	 * @param epsilon the +/- error range
	 * @return true if actual and expected values are within +/- epsilon of each other
	 */
	public static boolean checkWithin(int a, int e, int epsilon) {
		check_count++;
		StackTraceElement element = callPoint();
		String file = element.getFileName();
		int line = element.getLineNumber();
		if (Math.abs(a - e) <= epsilon) {
			System.out.printf("%s, line %d: check passed\n", file, line);
			check_success_count++;
			return true;
		} else {
			System.out.println(file + ", line " + line + ": Actual value " + a + " is not within " + epsilon + " of expected value " + e + ".");
			return false;
		}
	}
	
	/**
	 * Check whether the actual value (first argument) is equal to the expected value (second argument).
	 * @param a actual value
	 * @param e expected value
	 * @return true if actual and expected values are equal
	 */
	public static boolean checkExpect(char a, char e) {
		check_count++;
		StackTraceElement element = callPoint();
		String file = element.getFileName();
		int line = element.getLineNumber();
		if (a == e) {
			System.out.printf("%s, line %d: check passed\n", file, line);
			check_success_count++;
			return true;
		} else {
			System.out.println(file + ", line " + line + ": Actual value " + a + " differs from expected value " + e + ".");
			return false;
		}
	}
	
	/**
	 * Check whether the actual value (first argument) is equal to the expected value (second argument).
	 * @param a actual value
	 * @param e expected value
	 * @return true if actual and expected values are equal
	 */
	public static boolean checkExpect(byte a, byte e) {
		check_count++;
		StackTraceElement element = callPoint();
		String file = element.getFileName();
		int line = element.getLineNumber();
		if (a == e) {
			System.out.printf("%s, line %d: check passed\n", file, line);
			check_success_count++;
			return true;
		} else {
			System.out.println(file + ", line " + line + ": Actual value " + a + " differs from expected value " + e + ".");
			return false;
		}
	}
	
	/**
	 * Check whether the actual value (first argument) is equal to the expected value (second argument).
	 * @param a actual value
	 * @param e expected value
	 * @return true if actual and expected values are equal
	 */
	public static boolean checkExpect(String a, String e) {
		check_count++;
		StackTraceElement element = callPoint();
		String file = element.getFileName();
		int line = element.getLineNumber();
		if (a == null && e == null) {
			System.out.printf("%s, line %d: Actual string and expected string are both NULL\n", file, line);
			System.out.printf("%s, line %d: check passed\n", file, line);
			check_success_count++;
			return true;
		}
		if (a != null && a.equals(e)) {
			System.out.printf("%s, line %d: check passed\n", file, line);
			check_success_count++;
			return true;
		} else {
			System.out.println(file + ", line " + line + ": Actual value " + a + " differs from expected value " + e + ".");
			return false;
		}
	}
	
	/**
	 * Check whether the actual value (first argument) is equal to the expected value (second argument).
	 * @param a actual value
	 * @param e expected value
	 * @return true if actual and expected values are equal
	 */
	public static boolean checkExpect(Object a, Object e) {
		check_count++;
		StackTraceElement element = callPoint();
		String file = element.getFileName();
		int line = element.getLineNumber();
		if (a == null && e == null) {
			System.out.printf("%s, line %d: Actual object and expected object are both NULL\n", file, line);
			System.out.printf("%s, line %d: check passed\n", file, line);
			check_success_count++;
			return true;
		}
		if (a != null && a.equals(e)) {
			System.out.printf("%s, line %d: check passed\n", file, line);
			check_success_count++;
			return true;
		} else {
			System.out.println(file + ", line " + line + ": Actual value " + a + " differs from expected value " + e + ".");
			return false;
		}
	}
	
	/**
	 * Check whether the actual value (first argument) is equal to the expected value (second argument).
	 * @param a actual value
	 * @param e expected value
	 * @return true if actual and expected values are equal
	 */
	public static boolean checkExpect(int[] a, int[] e) {
		check_count++;
		StackTraceElement element = callPoint();
		String file = element.getFileName();
		int line = element.getLineNumber();
		if (a == null && e == null) {
			System.out.printf("%s, line %d: Actual array and expected array are both NULL\n", file, line);
			System.out.printf("%s, line %d: check passed\n", file, line);
			check_success_count++;
			return true;
		}
		if (a == null) {
			System.out.printf("%s, line %d: Actual value array is NULL\n", file, line);
			return false;		
		}
		if (e == null) {
			System.out.printf("%s, line %d: Expected value array is NULL\n", file, line);
			return false;		
		}
		if (a.length != e.length) {
			System.out.printf("%s, line %d: Actual length %d differs from expected length %d\n", file, line, a.length, e.length);
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != e[i]) {
				if (a.length < 20) {
					System.out.print(file + ", line " + line + ": Actual value ");
					print(a);
					System.out.print(" differs from expected value ");
					print(e);
					System.out.println(" at index " + i + ".");
				} else {
					System.out.println(file + ", line " + line + ": Actual value " + a[i] + 
							" differs from expected value " + e[i] + " at index " + i + ".");
				}
				return false;
			}
		}
		System.out.printf("%s, line %d: check passed\n", file, line);
		check_success_count++;
		return true;
	}

	/**
	 * Check whether the actual value (first argument) is equal to the expected value (second argument).
	 * @param a actual value
	 * @param e expected value
	 * @return true if actual and expected values are equal
	 */
	public static boolean checkExpect(byte[] a, byte[] e) {
		check_count++;
		StackTraceElement element = callPoint();
		String file = element.getFileName();
		int line = element.getLineNumber();
		if (a == null && e == null) {
			System.out.printf("%s, line %d: Actual array and expected array are both NULL\n", file, line);
			System.out.printf("%s, line %d: check passed\n", file, line);
			check_success_count++;
			return true;
		}
		if (a == null) {
			System.out.printf("%s, line %d: Actual value array is NULL\n", file, line);
			return false;		
		}
		if (e == null) {
			System.out.printf("%s, line %d: Expected value array is NULL\n", file, line);
			return false;		
		}
		if (a.length != e.length) {
			System.out.printf("%s, line %d: Actual length %d differs from expected length %d\n", file, line, a.length, e.length);
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != e[i]) {
				if (a.length < 20) {
					System.out.print(file + ", line " + line + ": Actual value ");
					print(a);
					System.out.print(" differs from expected value ");
					print(e);
					System.out.println(" at index " + i + ".");
				} else {
					System.out.println(file + ", line " + line + ": Actual value " + a[i] + 
							" differs from expected value " + e[i] + " at index " + i + ".");
				}
				return false;
			}
		}
		System.out.printf("%s, line %d: check passed\n", file, line);
		check_success_count++;
		return true;
	}

	/**
	 * Check whether the actual value (first argument) is equal to the expected value (second argument).
	 * @param a actual value
	 * @param e expected value
	 * @return true if actual and expected values are equal
	 */
	public static boolean checkExpect(char[] a, char[] e) {
		check_count++;
		StackTraceElement element = callPoint();
		String file = element.getFileName();
		int line = element.getLineNumber();
		if (a == null && e == null) {
			System.out.printf("%s, line %d: Actual array and expected array are both NULL\n", file, line);
			System.out.printf("%s, line %d: check passed\n", file, line);
			check_success_count++;
			return true;
		}
		if (a == null) {
			System.out.printf("%s, line %d: Actual value array is NULL\n", file, line);
			return false;		
		}
		if (e == null) {
			System.out.printf("%s, line %d: Expected value array is NULL\n", file, line);
			return false;		
		}
		if (a.length != e.length) {
			System.out.printf("%s, line %d: Actual length %d differs from expected length %d\n", file, line, a.length, e.length);
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != e[i]) {
				if (a.length < 20) {
					System.out.print(file + ", line " + line + ": Actual value ");
					print(a);
					System.out.print(" differs from expected value ");
					print(e);
					System.out.println(" at index " + i + ".");
				} else {
					System.out.println(file + ", line " + line + ": Actual value " + a[i] + 
							" differs from expected value " + e[i] + " at index " + i + ".");
				}
				return false;
			}
		}
		System.out.printf("%s, line %d: check passed\n", file, line);
		check_success_count++;
		return true;
	}

	/**
	 * Check whether the i-th element of the first argument and i-th element of
	 * the second argument differ less than epsilon. The function returns true
	 * if all pairwise comparisons are within +/- epsilon of each other.
	 * 
	 * @param a actual value
	 * @param e expected value
	 * @param epsilon the +/- error range
	 * @return true if actual and expected values are within +/- epsilon of each other
	 */
	public static boolean checkWithin(double[] a, double[] e, double epsilon) {
		check_count++;
		StackTraceElement element = callPoint();
		String file = element.getFileName();
		int line = element.getLineNumber();
		if (a == null && e == null) {
			System.out.printf("%s, line %d: Actual array and expected array are both NULL\n", file, line);
			System.out.printf("%s, line %d: check passed\n", file, line);
			check_success_count++;
			return true;
		}
		if (a == null) {
			System.out.printf("%s, line %d: Actual value array is NULL\n", file, line);
			return false;		
		}
		if (e == null) {
			System.out.printf("%s, line %d: Expected value array is NULL\n", file, line);
			return false;		
		}
		if (a.length != e.length) {
			System.out.printf("%s, line %d: Actual length %d differs from expected length %d\n", file, line, a.length, e.length);
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (Math.abs(a[i] - e[i]) > epsilon) {
				if (a.length < 20) {
					System.out.print(file + ", line " + line + ": Actual value ");
					print(a);
					System.out.print(" differs from expected value ");
					print(e);
					System.out.println(" at index " + i + ".");
				} else {
					System.out.println(file + ", line " + line + ": Actual value " + a[i] + 
							" differs from expected value " + e[i] + " at index " + i + ".");
				}
				return false;
			}
		}
		System.out.printf("%s, line %d: check passed\n", file, line);
		check_success_count++;
		return true;
	}

	/**
	 * Check whether the actual value (first argument) is equal to the expected value (second argument).
	 * @param a actual value
	 * @param e expected value
	 * @return true if actual and expected values are equal
	 */
	public static boolean checkExpect(String[] a, String[] e) {
		check_count++;
		StackTraceElement element = callPoint();
		String file = element.getFileName();
		int line = element.getLineNumber();
		if (a == null && e == null) {
			System.out.printf("%s, line %d: Actual array and expected array are both NULL\n", file, line);
			System.out.printf("%s, line %d: check passed\n", file, line);
			check_success_count++;
			return true;
		}
		if (a == null) {
			System.out.printf("%s, line %d: Actual value array is NULL\n", file, line);
			return false;		
		}
		if (e == null) {
			System.out.printf("%s, line %d: Expected value array is NULL\n", file, line);
			return false;		
		}
		if (a.length != e.length) {
			System.out.printf("%s, line %d: Actual length %d differs from expected length %d\n", file, line, a.length, e.length);
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (!a[i].equals(e[i])) {
				if (a.length < 20) {
					System.out.print(file + ", line " + line + ": Actual value ");
					print(a);
					System.out.print(" differs from expected value ");
					print(e);
					System.out.println(" at index " + i + ".");
				} else {
					System.out.println(file + ", line " + line + ": Actual value " + a[i] + 
							" differs from expected value " + e[i] + " at index " + i + ".");
				}
				return false;
			}
		}
		System.out.printf("%s, line %d: check passed\n", file, line);
		check_success_count++;
		return true;
	}

	/**
	 * Check whether the actual value (first argument) is equal to the expected value (second argument).
	 * @param a actual value
	 * @param e expected value
	 * @return true if actual and expected values are equal
	 */
	public static boolean checkExpect(Object[] a, Object[] e) {
		check_count++;
		StackTraceElement element = callPoint();
		String file = element.getFileName();
		int line = element.getLineNumber();
		if (a == null && e == null) {
			System.out.printf("%s, line %d: Actual array and expected array are both NULL\n", file, line);
			System.out.printf("%s, line %d: check passed\n", file, line);
			check_success_count++;
			return true;
		}
		if (a == null) {
			System.out.printf("%s, line %d: Actual value array is NULL\n", file, line);
			return false;		
		}
		if (e == null) {
			System.out.printf("%s, line %d: Expected value array is NULL\n", file, line);
			return false;		
		}
		if (a.length != e.length) {
			System.out.printf("%s, line %d: Actual length %d differs from expected length %d\n", file, line, a.length, e.length);
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (!a[i].equals(e[i])) {
				if (a.length < 20) {
					System.out.print(file + ", line " + line + ": Actual value ");
					print(a);
					System.out.print(" differs from expected value ");
					print(e);
					System.out.println(" at index " + i + ".");
				} else {
					System.out.println(file + ", line " + line + ": Actual value " + a[i] + 
							" differs from expected value " + e[i] + " at index " + i + ".");
				}
				return false;
			}
		}
		System.out.printf("%s, line %d: check passed\n", file, line);
		check_success_count++;
		return true;
	}

	/**
	 * Prints a summary of the passed and failed tests. Should be called at the end of main.
	 */
	public static void summary() {
		if (check_count > 0) {
			int fail_count = check_count - check_success_count;
			if (fail_count <= 0) {
				if (check_count == 1) {
					System.out.printf("The test passed!\n");
				} else if (check_count == 2) {
					System.out.printf("Both tests passed!\n");
				} else if (check_count >= 3) {
					System.out.printf("All %d tests passed!\n", check_count);
				}
			} else {
				if (check_count == 1) {
					System.out.printf("The test failed.\n");
				} else {
					if (check_success_count == 0) {
						System.out.printf("0 of %d tests passed.\n", check_count);
					} else {
						System.out.printf("%d of %d tests failed.\n", fail_count, check_count);
					}
				}
			}
		}

	}

	/*
	public static void xmain(String[] args) {
		checkExpect(1, 2);
		checkExpect(1, 1);
		checkExpect(2, 3);
		checkExpect(true, false);
		checkExpect(true, true);
		checkWithin(1.0, 2.0, EPSILON);
		checkWithin(1.0, 1 + EPSILON / 2, EPSILON);
		checkWithin(1, 3, 1);
		checkWithin(1, 2, 1);
		checkExpect('a', 'b');
		checkExpect('a', 'a');
		checkExpect("ab", "abc");
		checkExpect(null, "abc");
		checkExpect("ab", null);
		checkExpect("ab", "ab");
		checkExpect(new File("ababa.txt"), new File("ababa.txt"));
		checkExpect(new File("ababa.txt"), new File("ababax.txt"));
		int[] ia1 = { 1, 2, 3 };
		int[] ie1 = { 1, 2, 3 };
		checkExpect(ia1, ie1);
		int[] ia2 = { 1, 2 };
		int[] ie2 = { 1, 2, 3 };
		checkExpect(ia2, ie2);
		int[] ia3 = { 1, 2, 3 };
		int[] ie3 = { 1, 2, 4 };
		checkExpect(ia3, ie3);
		
		println(new IntPair(1, 2));
		println(new IntTriple(1, 2, 3));
		println(new DoublePair(1, 2));
		println(new DoubleTriple(1, 2, 3));
		println(new StringPair("x", "y"));
		println(new StringTriple("x", "y", "z"));
		println(new ObjectPair(new StringPair("x", "y"), new IntTriple(1, 2, 3)));
		println(new ObjectTriple(new StringPair("x", "y"), new IntTriple(1, 2, 3), new DoublePair(1.1, 2.2)));
		
		println(intOf("123"));
		println(intOf("123", 1, 3));
		println(intOf("123", 1, 2));
		println(doubleOf("12.3"));
		println(doubleOf("12.3", 1, 4));
		println(doubleOf("12.3", 1, 2));

		println();
		println(5);
		println(5.5);
		println("hello");
		println(false);
		println('c');
		
		println();
		print(4);
		print(5.5);
		print("hello");
		print(false);
		print('c');
		println();
		
		println(ia1);
		double[] da1 = { 1.1, 2.2, 3.3 };
		println(da1);

		print(ia1);
		print(da1);
		println();

		String[] sa1 = { "a", "bb", "ccc" };
		print(sa1);
		println(sa1);

		boolean[] ba1 = { false, false, true };
		print(ba1);
		println(ba1);

		Object[] oa1 = { 
				new StringPair("x", "y"), 
				new IntTriple(1, 2, 3), 
				new DoublePair(1.1, 2.2)
		};
		print(oa1);
		println(oa1);

		char[] ca1 = { 'a', 'b', 'c', 'd' };
		print(ca1);
		println(ca1);
		
		byte[] ya1 = { 10, 20, 30, 40 };
		print(ya1);
		println(ya1);
		
//		print("input a string: ");
//		println(stringInput());
//		print("input a string: ");
//		println(stringInput());		
//		print("input an integer: ");
//		println(intInput() * 2);
//		print("input a double: ");
//		println(doubleInput() * 2);
		
		String s = sReadFile("src/IntPair.java");
		println(s);
		
		byte[] data = bReadFile("src/IntPair.java");
		println(data);
		
//		s = s.toUpperCase();
//		writeFile("mytest_s.txt", s);
//		
//		s = s.toUpperCase();
//		writeFile("mytest_b.txt", s.getBytes());
		
		println(rnd(10));
		println(rnd(10.0));
		println(rnd());
		
		byte[] ba3 = { 1, 2, 3 };
		byte[] be3 = { 1, 2, 4 };
		checkExpect(ba3, be3);

		String[] sa2 = { "a", "bb", "ccc" };
		checkExpect(sa1, sa2);
		String[] sa3 = { "a", "bb", "ccd" };
		checkExpect(sa1, sa3);

		Object[] oa2 = { 
				new StringPair("x", "y"), 
				new IntTriple(1, 2, 3), 
				new DoublePair(1.1, 2.2)
		};
		checkExpect(oa1, oa2);

		Object[] oa3 = { 
				new StringPair("x", "y"), 
				new IntTriple(1, 2, 3), 
				new DoublePair(1.1, 2.3)
		};
		checkExpect(oa1, oa3);

		double[] da2 = { 1.1, 2.2, 3.3 };
		checkWithin(da1, da2, EPSILON);
		double[] da3 = { 1.1, 2.2, 3.4 };
		checkWithin(da1, da3, EPSILON);

		summary();
	}
	*/
}
