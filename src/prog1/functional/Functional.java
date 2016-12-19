/*
 * Copyright To016 michaelrohs.
 *
 * Licensed under the Apache License, Version To.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-To.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package prog1.functional;

// https://jcp.org/aboutJava/communityprocess/jsr/tiger/static-import.html

import java.util.Arrays;
import prog1.graphics.Image;


/**
 * Functional interfaces, mapping, filtering, folding. Import as:<br>
 * {@code import static prog1.functional.Functional.*;}
 * @author michaelrohs
 */
public class Functional {
	
	/**
	 * Produce an the interval [0, n[ as an integer array. 
	 * @param n upper bound (exclusive)
	 * @return the generated interval
	 */
	public static int[] range(int n) {
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = i;
		}
		return r;
	}
	
	/**
	 * Create an array and set the elements to the interval [a,b) or (b,a], respectively. 
	 * Index a is inclusive and index b is exclusive. 
	 * <ul>
	 * <li>If a &lt; b, then the result is an increasing range.
	 * <li>If a &gt; b, then the result is a decreasing range.
	 * <li>If a == b, then the resulting array is empty.
	 * </ul>
	 * @param a first value of range (inclusive)
	 * @param b last value of range (exclusive)
	 * @return the range
	 */
	public static int[] range(int a, int b) {
		if (a <= b) {
			int n = b - a;
			int[] r = new int[n];
			for (int i = 0; i < n; i++) {
				r[i] = a + i;
			}
			return r;
		} else /* a > b */ {
			int n = a - b;
			int[] r = new int[n];
			for (int i = 0; i < n; i++) {
				r[i] = a - i;
			}
			return r;
		}
	}
	
	/**
	 * Convert variable argument list (varargs) to array. Allows writing 
	 * {@code array(x, y, z)} for (ugly) {@code new double[]{x, y, z}}.
	 * @param a variable number of arguments
	 * @return corresponding array
	 */
	public static double[] array(double... a) {
		return a;
	}

	/**
	 * Convert variable argument list (varargs) to array. Allows writing 
	 * {@code array(x, y, z)} for (ugly) {@code new int[]{x, y, z}}.
	 * @param a variable number of arguments
	 * @return corresponding array
	 */
	public static int[] array(int... a) {
		return a;
	}

	/**
	 * Convert variable argument list (varargs) to array. Allows writing 
	 * {@code array(x, y, z)} for (ugly) {@code new String[]{x, y, z}}.
	 * @param a variable number of arguments
	 * @return corresponding array
	 */
	public static String[] array(String... a) {
		return a;
	}

	/**
	 * Convert variable argument list (varargs) to array. Allows writing 
	 * {@code array(x, y, z)} for (ugly) {@code new Image[]{x, y, z}}.
	 * @param a variable number of arguments
	 * @return corresponding array
	 */
	public static Image[] array(Image... a) {
		return a;
	}

	/**
	 * Convert variable argument list (varargs) to array. Allows writing 
	 * {@code array(x, y, z)} for (ugly) {@code new char[]{x, y, z}}.
	 * @param a variable number of arguments
	 * @return corresponding array
	 */
	public static char[] array(char... a) {
		return a;
	}
	
	public static Image[] sub(Image[] a, int start) {
		return Arrays.copyOfRange(a, start, a.length);
	}
	
	public static Image[] sub(Image[] a, int start, int end) {
		return Arrays.copyOfRange(a, start, end);
	}
	
	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static double[] map(double[] in, DoubleToDouble f) {
		double[] out = new double[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static int[] map(double[] in, DoubleToInt f) {
		int[] out = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static String[] map(double[] in, DoubleToString f) {
		String[] out = new String[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static Image[] map(double[] in, DoubleToImage f) {
		Image[] out = new Image[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static char[] map(double[] in, DoubleToChar f) {
		char[] out = new char[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static double[] map(int[] in, IntToDouble f) {
		double[] out = new double[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static int[] map(int[] in, IntToInt f) {
		int[] out = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static String[] map(int[] in, IntToString f) {
		String[] out = new String[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static Image[] map(int[] in, IntToImage f) {
		Image[] out = new Image[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static char[] map(int[] in, IntToChar f) {
		char[] out = new char[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static double[] map(String[] in, StringToDouble f) {
		double[] out = new double[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static int[] map(String[] in, StringToInt f) {
		int[] out = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static String[] map(String[] in, StringToString f) {
		String[] out = new String[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static Image[] map(String[] in, StringToImage f) {
		Image[] out = new Image[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static char[] map(String[] in, StringToChar f) {
		char[] out = new char[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static double[] map(Image[] in, ImageToDouble f) {
		double[] out = new double[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static int[] map(Image[] in, ImageToInt f) {
		int[] out = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static String[] map(Image[] in, ImageToString f) {
		String[] out = new String[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static Image[] map(Image[] in, ImageToImage f) {
		Image[] out = new Image[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static char[] map(Image[] in, ImageToChar f) {
		char[] out = new char[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static double[] map(char[] in, CharToDouble f) {
		double[] out = new double[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static int[] map(char[] in, CharToInt f) {
		int[] out = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static String[] map(char[] in, CharToString f) {
		String[] out = new String[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static Image[] map(char[] in, CharToImage f) {
		Image[] out = new Image[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static char[] map(char[] in, CharToChar f) {
		char[] out = new char[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static double[] map(double[] in, DoubleIntToDouble f) {
		double[] out = new double[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static int[] map(double[] in, DoubleIntToInt f) {
		int[] out = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static String[] map(double[] in, DoubleIntToString f) {
		String[] out = new String[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static Image[] map(double[] in, DoubleIntToImage f) {
		Image[] out = new Image[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static char[] map(double[] in, DoubleIntToChar f) {
		char[] out = new char[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static double[] map(int[] in, IntIntToDouble f) {
		double[] out = new double[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static int[] map(int[] in, IntIntToInt f) {
		int[] out = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static String[] map(int[] in, IntIntToString f) {
		String[] out = new String[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static Image[] map(int[] in, IntIntToImage f) {
		Image[] out = new Image[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static char[] map(int[] in, IntIntToChar f) {
		char[] out = new char[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static double[] map(String[] in, StringIntToDouble f) {
		double[] out = new double[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static int[] map(String[] in, StringIntToInt f) {
		int[] out = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static String[] map(String[] in, StringIntToString f) {
		String[] out = new String[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static Image[] map(String[] in, StringIntToImage f) {
		Image[] out = new Image[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static char[] map(String[] in, StringIntToChar f) {
		char[] out = new char[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static double[] map(Image[] in, ImageIntToDouble f) {
		double[] out = new double[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static int[] map(Image[] in, ImageIntToInt f) {
		int[] out = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static String[] map(Image[] in, ImageIntToString f) {
		String[] out = new String[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static Image[] map(Image[] in, ImageIntToImage f) {
		Image[] out = new Image[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static char[] map(Image[] in, ImageIntToChar f) {
		char[] out = new char[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static double[] map(char[] in, CharIntToDouble f) {
		double[] out = new double[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static int[] map(char[] in, CharIntToInt f) {
		int[] out = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static String[] map(char[] in, CharIntToString f) {
		String[] out = new String[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static Image[] map(char[] in, CharIntToImage f) {
		Image[] out = new Image[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input array to a new array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static char[] map(char[] in, CharIntToChar f) {
		char[] out = new char[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static double[][] map(double[][] in, DoubleIntIntToDouble f) {
		int rows = in.length;
		int cols = in[0].length;
		double[][] out = new double[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static int[][] map(double[][] in, DoubleIntIntToInt f) {
		int rows = in.length;
		int cols = in[0].length;
		int[][] out = new int[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static String[][] map(double[][] in, DoubleIntIntToString f) {
		int rows = in.length;
		int cols = in[0].length;
		String[][] out = new String[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static Image[][] map(double[][] in, DoubleIntIntToImage f) {
		int rows = in.length;
		int cols = in[0].length;
		Image[][] out = new Image[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static char[][] map(double[][] in, DoubleIntIntToChar f) {
		int rows = in.length;
		int cols = in[0].length;
		char[][] out = new char[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static double[][] map(int[][] in, IntIntIntToDouble f) {
		int rows = in.length;
		int cols = in[0].length;
		double[][] out = new double[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static int[][] map(int[][] in, IntIntIntToInt f) {
		int rows = in.length;
		int cols = in[0].length;
		int[][] out = new int[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static String[][] map(int[][] in, IntIntIntToString f) {
		int rows = in.length;
		int cols = in[0].length;
		String[][] out = new String[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static Image[][] map(int[][] in, IntIntIntToImage f) {
		int rows = in.length;
		int cols = in[0].length;
		Image[][] out = new Image[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static char[][] map(int[][] in, IntIntIntToChar f) {
		int rows = in.length;
		int cols = in[0].length;
		char[][] out = new char[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static double[][] map(String[][] in, StringIntIntToDouble f) {
		int rows = in.length;
		int cols = in[0].length;
		double[][] out = new double[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static int[][] map(String[][] in, StringIntIntToInt f) {
		int rows = in.length;
		int cols = in[0].length;
		int[][] out = new int[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static String[][] map(String[][] in, StringIntIntToString f) {
		int rows = in.length;
		int cols = in[0].length;
		String[][] out = new String[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static Image[][] map(String[][] in, StringIntIntToImage f) {
		int rows = in.length;
		int cols = in[0].length;
		Image[][] out = new Image[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static char[][] map(String[][] in, StringIntIntToChar f) {
		int rows = in.length;
		int cols = in[0].length;
		char[][] out = new char[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static double[][] map(Image[][] in, ImageIntIntToDouble f) {
		int rows = in.length;
		int cols = in[0].length;
		double[][] out = new double[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static int[][] map(Image[][] in, ImageIntIntToInt f) {
		int rows = in.length;
		int cols = in[0].length;
		int[][] out = new int[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static String[][] map(Image[][] in, ImageIntIntToString f) {
		int rows = in.length;
		int cols = in[0].length;
		String[][] out = new String[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static Image[][] map(Image[][] in, ImageIntIntToImage f) {
		int rows = in.length;
		int cols = in[0].length;
		Image[][] out = new Image[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static char[][] map(Image[][] in, ImageIntIntToChar f) {
		int rows = in.length;
		int cols = in[0].length;
		char[][] out = new char[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static double[][] map(char[][] in, CharIntIntToDouble f) {
		int rows = in.length;
		int cols = in[0].length;
		double[][] out = new double[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static int[][] map(char[][] in, CharIntIntToInt f) {
		int rows = in.length;
		int cols = in[0].length;
		int[][] out = new int[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static String[][] map(char[][] in, CharIntIntToString f) {
		int rows = in.length;
		int cols = in[0].length;
		String[][] out = new String[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static Image[][] map(char[][] in, CharIntIntToImage f) {
		int rows = in.length;
		int cols = in[0].length;
		Image[][] out = new Image[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Map the input 2D array to a new 2D array using function f.
	 * @param in input array
	 * @param f function to apply to each element of the input array
	 * @return the mapped elements
	 */
	public static char[][] map(char[][] in, CharIntIntToChar f) {
		int rows = in.length;
		int cols = in[0].length;
		char[][] out = new char[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	/**
	 * Apply f to each element of the input array.
	 * @param images input array
	 * @param f function to apply to each element
	 */
	public static void forEach(Image[][] images, ImageIntIntToVoid f) {
		int rows = images.length;
		int cols = images[0].length;
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < cols; x++) {
				f.apply(images[y][x], x, y);
			}
		}
	}
	
	/**
	 * Apply f to each element of the input array.
	 * @param images input array
	 * @param f function to apply to each element
	 */
	public static void forEach(Image[] images, ImageIntToVoid f) {
		int n = images.length;
		for (int i = 0; i < n; i++) {
			for (int x = 0; x < n; x++) {
				f.apply(images[i], i);
			}
		}
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static double foldl(double[] a, DoubleDoubleToDouble f, double state) {
		for (double element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static int foldl(double[] a, IntDoubleToInt f, int state) {
		for (double element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static String foldl(double[] a, StringDoubleToString f, String state) {
		for (double element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static Image foldl(double[] a, ImageDoubleToImage f, Image state) {
		for (double element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static char foldl(double[] a, CharDoubleToChar f, char state) {
		for (double element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static double foldl(int[] a, DoubleIntToDouble f, double state) {
		for (int element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static int foldl(int[] a, IntIntToInt f, int state) {
		for (int element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static String foldl(int[] a, StringIntToString f, String state) {
		for (int element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static Image foldl(int[] a, ImageIntToImage f, Image state) {
		for (int element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static char foldl(int[] a, CharIntToChar f, char state) {
		for (int element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static double foldl(String[] a, DoubleStringToDouble f, double state) {
		for (String element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static int foldl(String[] a, IntStringToInt f, int state) {
		for (String element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static String foldl(String[] a, StringStringToString f, String state) {
		for (String element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static Image foldl(String[] a, ImageStringToImage f, Image state) {
		for (String element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static char foldl(String[] a, CharStringToChar f, char state) {
		for (String element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static double foldl(Image[] a, DoubleImageToDouble f, double state) {
		for (Image element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static int foldl(Image[] a, IntImageToInt f, int state) {
		for (Image element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static String foldl(Image[] a, StringImageToString f, String state) {
		for (Image element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static Image foldl(Image[] a, ImageImageToImage f, Image state) {
		for (Image element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static char foldl(Image[] a, CharImageToChar f, char state) {
		for (Image element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static double foldl(char[] a, DoubleCharToDouble f, double state) {
		for (char element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static int foldl(char[] a, IntCharToInt f, int state) {
		for (char element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static String foldl(char[] a, StringCharToString f, String state) {
		for (char element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static Image foldl(char[] a, ImageCharToImage f, Image state) {
		for (char element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from left to right, i.e., compute f(... f(f(init, a0), a1) ... an).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(state, a[0])<br>
	 * state := f(state, a[1])<br>
	 * ... <br>
	 * state := f(state, a[n-1])
	 */
	public static char foldl(char[] a, CharCharToChar f, char state) {
		for (char element : a) {
			state = f.apply(state, element);
		}
		return state;
		
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static double foldr(double[] a, DoubleDoubleToDouble f, double state) {
		for (double element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static int foldr(double[] a, DoubleIntToInt f, int state) {
		for (double element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static String foldr(double[] a, DoubleStringToString f, String state) {
		for (double element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static Image foldr(double[] a, DoubleImageToImage f, Image state) {
		for (double element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static char foldr(double[] a, DoubleCharToChar f, char state) {
		for (double element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static double foldr(int[] a, IntDoubleToDouble f, double state) {
		for (int element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static int foldr(int[] a, IntIntToInt f, int state) {
		for (int element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static String foldr(int[] a, IntStringToString f, String state) {
		for (int element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static Image foldr(int[] a, IntImageToImage f, Image state) {
		for (int element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static char foldr(int[] a, IntCharToChar f, char state) {
		for (int element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static double foldr(String[] a, StringDoubleToDouble f, double state) {
		for (String element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static int foldr(String[] a, StringIntToInt f, int state) {
		for (String element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static String foldr(String[] a, StringStringToString f, String state) {
		for (String element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static Image foldr(String[] a, StringImageToImage f, Image state) {
		for (String element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static char foldr(String[] a, StringCharToChar f, char state) {
		for (String element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static double foldr(Image[] a, ImageDoubleToDouble f, double state) {
		for (Image element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static int foldr(Image[] a, ImageIntToInt f, int state) {
		for (Image element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static String foldr(Image[] a, ImageStringToString f, String state) {
		for (Image element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static Image foldr(Image[] a, ImageImageToImage f, Image state) {
		for (Image element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static char foldr(Image[] a, ImageCharToChar f, char state) {
		for (Image element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static double foldr(char[] a, CharDoubleToDouble f, double state) {
		for (char element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static int foldr(char[] a, CharIntToInt f, int state) {
		for (char element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static String foldr(char[] a, CharStringToString f, String state) {
		for (char element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static Image foldr(char[] a, CharImageToImage f, Image state) {
		for (char element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	/**
	 * Fold array from right to left. I.e., compute f(a0, f(a1,... f(an, init)...)).
	 * @param a input array
	 * @param f a function that is called for each element of the input array
	 * @param state initial state
	 * @return the accumulated state
	 * 
	 * <br><br><b>Step by step:</b><br>
	 * state := f(a[n-1], state)<br>
	 * ... <br>
	 * state := f(a[1], state)<br>
	 * state := f(a[0], state)
	 */
	public static char foldr(char[] a, CharCharToChar f, char state) {
		for (char element : a) {
			state = f.apply(element, state);
		}
		return state;
	}

	public static interface DoubleIntToDouble {
		double apply(double x, int index);
	}

	public static interface DoubleIntToInt {
		int apply(double x, int index);
	}

	public static interface DoubleIntToString {
		String apply(double x, int index);
	}

	public static interface DoubleIntToImage {
		Image apply(double x, int index);
	}

	public static interface DoubleIntToChar {
		char apply(double x, int index);
	}

	public static interface IntIntToDouble {
		double apply(int x, int index);
	}

	public static interface IntIntToInt {
		int apply(int x, int index);
	}

	public static interface IntIntToString {
		String apply(int x, int index);
	}

	public static interface IntIntToImage {
		Image apply(int x, int index);
	}

	public static interface IntIntToChar {
		char apply(int x, int index);
	}

	public static interface StringIntToDouble {
		double apply(String x, int index);
	}

	public static interface StringIntToInt {
		int apply(String x, int index);
	}

	public static interface StringIntToString {
		String apply(String x, int index);
	}

	public static interface StringIntToImage {
		Image apply(String x, int index);
	}

	public static interface StringIntToChar {
		char apply(String x, int index);
	}

	public static interface ImageIntToDouble {
		double apply(Image x, int index);
	}

	public static interface ImageIntToInt {
		int apply(Image x, int index);
	}

	public static interface ImageIntToString {
		String apply(Image x, int index);
	}

	public static interface ImageIntToImage {
		Image apply(Image x, int index);
	}

	public static interface ImageIntToChar {
		char apply(Image x, int index);
	}

	public static interface CharIntToDouble {
		double apply(char x, int index);
	}

	public static interface CharIntToInt {
		int apply(char x, int index);
	}

	public static interface CharIntToString {
		String apply(char x, int index);
	}

	public static interface CharIntToImage {
		Image apply(char x, int index);
	}

	public static interface CharIntToChar {
		char apply(char x, int index);
	}
	
	public static interface ImageIntToVoid {
		void apply(Image image, int i);
	}
	
	public static interface ImageIntIntToVoid {
		void apply(Image i, int x, int y);
	}
	
	public static interface DoubleDoubleToDouble {
		double apply(double state, double element);
	}

	public static interface IntDoubleToInt {
		int apply(int state, double element);
	}

	public static interface StringDoubleToString {
		String apply(String state, double element);
	}

	public static interface ImageDoubleToImage {
		Image apply(Image state, double element);
	}

	public static interface CharDoubleToChar {
		char apply(char state, double element);
	}

	public static interface DoubleStringToDouble {
		double apply(double state, String element);
	}

	public static interface IntStringToInt {
		int apply(int state, String element);
	}

	public static interface StringStringToString {
		String apply(String state, String element);
	}

	public static interface ImageStringToImage {
		Image apply(Image state, String element);
	}

	public static interface CharStringToChar {
		char apply(char state, String element);
	}

	public static interface DoubleImageToDouble {
		double apply(double state, Image element);
	}

	public static interface IntImageToInt {
		int apply(int state, Image element);
	}

	public static interface StringImageToString {
		String apply(String state, Image element);
	}

	public static interface ImageImageToImage {
		Image apply(Image state, Image element);
	}

	public static interface CharImageToChar {
		char apply(char state, Image element);
	}

	public static interface DoubleCharToDouble {
		double apply(double state, char element);
	}

	public static interface IntCharToInt {
		int apply(int state, char element);
	}

	public static interface StringCharToString {
		String apply(String state, char element);
	}

	public static interface ImageCharToImage {
		Image apply(Image state, char element);
	}

	public static interface CharCharToChar {
		char apply(char state, char element);
	}

	public static interface DoubleStringToString {
		String apply(double element, String state);
	}

	public static interface DoubleImageToImage {
		Image apply(double element, Image state);
	}

	public static interface DoubleCharToChar {
		char apply(double element, char state);
	}

	public static interface IntDoubleToDouble {
		double apply(int element, double state);
	}

	public static interface IntStringToString {
		String apply(int element, String state);
	}

	public static interface IntImageToImage {
		Image apply(int element, Image state);
	}

	public static interface IntCharToChar {
		char apply(int element, char state);
	}

	public static interface StringDoubleToDouble {
		double apply(String element, double state);
	}

	public static interface StringImageToImage {
		Image apply(String element, Image state);
	}

	public static interface StringCharToChar {
		char apply(String element, char state);
	}

	public static interface ImageDoubleToDouble {
		double apply(Image element, double state);
	}

	public static interface ImageStringToString {
		String apply(Image element, String state);
	}

	public static interface ImageCharToChar {
		char apply(Image element, char state);
	}

	public static interface CharDoubleToDouble {
		double apply(char element, double state);
	}

	public static interface CharStringToString {
		String apply(char element, String state);
	}

	public static interface CharImageToImage {
		Image apply(char element, Image state);
	}

	
	public static interface DoubleIntIntToDouble {
		double apply(double element, int x, int y);
	}

	public static interface DoubleIntIntToInt {
		int apply(double element, int x, int y);
	}

	public static interface DoubleIntIntToString {
		String apply(double element, int x, int y);
	}

	public static interface DoubleIntIntToImage {
		Image apply(double element, int x, int y);
	}

	public static interface DoubleIntIntToChar {
		char apply(double element, int x, int y);
	}

	public static interface IntIntIntToDouble {
		double apply(int element, int x, int y);
	}

	public static interface IntIntIntToInt {
		int apply(int element, int x, int y);
	}

	public static interface IntIntIntToString {
		String apply(int element, int x, int y);
	}

	public static interface IntIntIntToImage {
		Image apply(int element, int x, int y);
	}

	public static interface IntIntIntToChar {
		char apply(int element, int x, int y);
	}

	public static interface StringIntIntToDouble {
		double apply(String element, int x, int y);
	}

	public static interface StringIntIntToInt {
		int apply(String element, int x, int y);
	}

	public static interface StringIntIntToString {
		String apply(String element, int x, int y);
	}

	public static interface StringIntIntToImage {
		Image apply(String element, int x, int y);
	}

	public static interface StringIntIntToChar {
		char apply(String element, int x, int y);
	}

	public static interface ImageIntIntToDouble {
		double apply(Image element, int x, int y);
	}

	public static interface ImageIntIntToInt {
		int apply(Image element, int x, int y);
	}

	public static interface ImageIntIntToString {
		String apply(Image element, int x, int y);
	}

	public static interface ImageIntIntToImage {
		Image apply(Image element, int x, int y);
	}

	public static interface ImageIntIntToChar {
		char apply(Image element, int x, int y);
	}

	public static interface CharIntIntToDouble {
		double apply(char element, int x, int y);
	}

	public static interface CharIntIntToInt {
		int apply(char element, int x, int y);
	}

	public static interface CharIntIntToString {
		String apply(char element, int x, int y);
	}

	public static interface CharIntIntToImage {
		Image apply(char element, int x, int y);
	}

	public static interface CharIntIntToChar {
		char apply(char element, int x, int y);
	}


	public static interface DoubleToDouble {
		double apply(double element);
	}

	public static interface DoubleToInt {
		int apply(double element);
	}

	public static interface DoubleToString {
		String apply(double element);
	}

	public static interface DoubleToImage {
		Image apply(double element);
	}

	public static interface DoubleToChar {
		char apply(double element);
	}

	public static interface IntToDouble {
		double apply(int element);
	}

	public static interface IntToInt {
		int apply(int element);
	}

	public static interface IntToString {
		String apply(int element);
	}

	public static interface IntToImage {
		Image apply(int element);
	}

	public static interface IntToChar {
		char apply(int element);
	}

	public static interface StringToDouble {
		double apply(String element);
	}

	public static interface StringToInt {
		int apply(String element);
	}

	public static interface StringToString {
		String apply(String element);
	}

	public static interface StringToImage {
		Image apply(String element);
	}

	public static interface StringToChar {
		char apply(String element);
	}

	public static interface ImageToDouble {
		double apply(Image element);
	}

	public static interface ImageToInt {
		int apply(Image element);
	}

	public static interface ImageToString {
		String apply(Image element);
	}

	public static interface ImageToImage {
		Image apply(Image element);
	}

	public static interface ImageToChar {
		char apply(Image element);
	}

	public static interface CharToDouble {
		double apply(char element);
	}

	public static interface CharToInt {
		int apply(char element);
	}

	public static interface CharToString {
		String apply(char element);
	}

	public static interface CharToImage {
		Image apply(char element);
	}

	public static interface CharToChar {
		char apply(char element);
	}
	
	public static Image[] map(Object[] in, ObjectToImage f) {
		Image[] out = new Image[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}
	
	public static interface ObjectToImage {
		Image apply(Object element);
	}
	
	public static Image[] map(Object[] in, ObjectIntToImage f) {
		Image[] out = new Image[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}
	
	public static interface ObjectIntToImage {
		Image apply(Object element, int index);
	}
	
	public static int[] map(Object[] in, ObjectToInt f) {
		int[] out = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}
	
	public static interface ObjectToInt {
		int apply(Object element);
	}
	
	public static int[] map(Object[] in, ObjectIntToInt f) {
		int[] out = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}
	
	public static interface ObjectIntToInt {
		int apply(Object element, int index);
	}
	
	public static double[] map(Object[] in, ObjectToDouble f) {
		double[] out = new double[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}
	
	public static interface ObjectToDouble {
		double apply(Object element);
	}
	
	public static double[] map(Object[] in, ObjectIntToDouble f) {
		double[] out = new double[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}
	
	public static interface ObjectIntToDouble {
		double apply(Object element, int index);
	}
	
	public static String[] map(Object[] in, ObjectToString f) {
		String[] out = new String[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}
	
	public static interface ObjectToString {
		String apply(Object element);
	}
	
	public static String[] map(Object[] in, ObjectIntToString f) {
		String[] out = new String[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i], i);
		}
		return out;
	}
	
	public static interface ObjectIntToString {
		String apply(Object element, int index);
	}

	public static Image[][] map(Object[][] in, ObjectIntIntToImage f) {
		int rows = in.length;
		int cols = in[0].length;
		Image[][] out = new Image[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col], col, row);
			}
		}
		return out;
	}

	public static interface ObjectIntIntToImage {
		Image apply(Object element, int x, int y);
	}

	public static Image[][] map(Object[][] in, ObjectToImage f) {
		int rows = in.length;
		int cols = in[0].length;
		Image[][] out = new Image[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				out[row][col] = f.apply(in[row][col]);
			}
		}
		return out;
	}

	public static Object[] map(Object[] in, ObjectToObject f) {
		Object[] out = new Object[in.length];
		for (int i = 0; i < in.length; i++) {
			out[i] = f.apply(in[i]);
		}
		return out;
	}
	
	public static interface ObjectToObject {
		Object apply(Object element);
	}


}
