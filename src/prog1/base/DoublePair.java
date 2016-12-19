package prog1.base;

/**
 * A pair of doubles.
 * @author michaelrohs
 * @version 0.1
 */
public class DoublePair {
	public double i, j;

	/**
	 * Create a double pair.
	 * @param i first element
	 * @param j second element
	 */
	public DoublePair(double i, double j) {
		this.i = i;
		this.j = j;
	}
	
	/**
	 * Print a double pair.
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
		DoublePair x = (DoublePair) o;
		return i == x.i && j == x.j;
	}

	/**
	 * Compute hash code of this object.
	 * @return hash code
	 */
	@Override
	public int hashCode() {
		return (int)(i + 31 * j);
	}

}
