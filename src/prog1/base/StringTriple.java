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
 * Three strings.
 * @author michaelrohs
 * @version 0.1
 */
public class StringTriple {
	public String i, j, k;

	/**
	 * Create a String triple.
	 * @param i first element
	 * @param j second element
	 * @param k third element
	 */
	public StringTriple(String i, String j, String k) {
		this.i = i;
		this.j = j;
		this.k = k;
	}
	
	/**
	 * Print a String triple.
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
		StringTriple x = (StringTriple) o;
		return  (i == null && x.i == null || i != null && i.equals(x.i)) && 
				(j == null && x.j == null || j != null && j.equals(x.j)) && 
				(k == null && x.k == null || k != null && k.equals(x.k));
	}

	/**
	 * Compute hash code of this object.
	 * @return hash code
	 */
	@Override
	public int hashCode() {
		return (i == null ? 0 : i.hashCode()) + 
			31 * (j == null ? 0 : j.hashCode()) + 
			31 * 31 * (k == null ? 0 : k.hashCode());
	}

}
