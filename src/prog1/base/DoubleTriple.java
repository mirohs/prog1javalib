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

/**
 * Three doubles.
 * @author michaelrohs
 * @version 0.1
 */
public class DoubleTriple {
	public double i, j, k;

	/**
	 * Create a double triple.
	 * @param i first element
	 * @param j second element
	 * @param k third element
	 */
	public DoubleTriple(double i, double j, double k) {
		this.i = i;
		this.j = j;
		this.k = k;
	}
	
	/**
	 * Print a double triple.
	 * @return string representation
	 */
	@Override
	public String toString() {
		return "(" + i + ", " + j + ", " + k + ")";
	}

	/**
	 * Check for equality.
	 * @param o other object
	 * @return true if (and only if) equal
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (getClass() != o.getClass()) return false;
		DoubleTriple x = (DoubleTriple) o;
		return  i == x.i && j == x.j && k == x.k;
	}

	/**
	 * Compute hash code of this object.
	 * @return hash code
	 */
	@Override
	public int hashCode() {
		return (int)(i + 31 * j + 31 * 31 * k);
	}

}
