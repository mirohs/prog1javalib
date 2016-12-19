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
 * A pair of objects.
 * @author michaelrohs
 * @version 0.1
 */
public class ObjectPair {
	public Object i, j;

	/**
	 * Create an object pair.
	 * @param i first element
	 * @param j second element
	 */
	public ObjectPair(Object i, Object j) {
		this.i = i;
		this.j = j;
	}
	
	/**
	 * Print an object pair.
	 * @return string representation
	 */
	@Override
	public String toString() {
		return "(" + i + ", " + j + ")";
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
		ObjectPair x = (ObjectPair) o;
		return  (i == null && x.i == null || i != null && i.equals(x.i)) && 
				(j == null && x.j == null || j != null && j.equals(x.j));
	}

	/**
	 * Compute hash code of this object.
	 * @return hash code
	 */
	@Override
	public int hashCode() {
		return (i == null ? 0 : i.hashCode()) + 31 * (j == null ? 0 : j.hashCode());
	}

}
