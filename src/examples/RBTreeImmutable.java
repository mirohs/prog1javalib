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
package examples;

import prog1.base.Base;
import static prog1.graphics.Graphics.*;
import prog1.graphics.Image;

/**
 *
 * @author michaelrohs
 */
public class RBTreeImmutable {

	private Node root = null; // reference to the root node of the tree

	private static enum Color { B, R }; // black, red

	private static class Node { // node of red-black tree, inner class

		private final Color color;
		private final int value;
		private final Node left, right;

		private final static Image frame = overlay(
				rectangle(40, 1, "transparent"),
				circle(20, "white", pen("black")));
		private final static Image empty = overlay(
				rectangle(40, 1, "transparent"),
				circle(10, "transparent"));

		private Node(Color color, Node left, int value, Node right) {
			this.color = color;
			this.value = value;
			this.left = left;
			this.right = right;
		}

		private boolean contains(int x) {
			if (x == value) return true;
			if (x < value && left != null) return left.contains(x); // it cannot be in the right subtree
			if (x > value && right != null) return right.contains(x); // it cannot be in the left subtree
			return false;
		}

		private int height() {
			int l = (left == null) ? 0 : left.height();
			int r = (right == null) ? 0 : right.height();
			return 1 + Math.max(l, r);
		}

		@Override
		public String toString() {
			String l = (left == null) ? "E" : left.toString();
			String r = (right == null) ? "E" : right.toString();
			return "Node(" + l + ", " + value + ", " + r + ")";
		}

		public Image toImage() {
			Image n = overlay(
					text("" + value, 14, "black"),
					frame);
			Image result = above(n,
					rotate(0, beside("top",
									(left != null) ? left.toImage() : empty,
									(right != null) ? right.toImage() : empty)));
			return result;
		}

	}

	public void clear() {
		root = null;	// remove all elements by setting the root to null
	}

	public boolean contains(int x) {
		if (root == null) {
			return false;
		} else {
			return root.contains(x);
		}
	}

	public void add(int x) {
		root = addRec(x, root);
		root = new Node(Color.B, root.left, root.value, root.right); // make root black
	}

	private static Node addRec(int x, Node n) {
		if (n == null) {
			return new Node(Color.R, null, x, null); // found insertion point
		}
		if (x < n.value) {
			return balance(n.color, addRec(x, n.left), n.value, n.right);
		}
		if (x > n.value) {
			return balance(n.color, n.left, n.value, addRec(x, n.right));
		}
		return n; // do not insert again if value already exists
	}
	
	private static Node balance(Color color, Node l, int v, Node r) {
		boolean lRed = l != null && l.color == Color.R;	// is left red?
		boolean rRed = r != null && r.color == Color.R;	// is right red?
		Node ll = l == null ? null : l.left;	// left-left
		Node lr = l == null ? null : l.right;	// left-right
		Node rl = r == null ? null : r.left;	// right-left
		Node rr = r == null ? null : r.right;	// right-right
		boolean llRed = ll != null && ll.color == Color.R;
		boolean lrRed = lr != null && lr.color == Color.R;
		boolean rlRed = rl != null && rl.color == Color.R;
		boolean rrRed = rr != null && rr.color == Color.R;
		Node a, b, c, d;
		int x, y, z;
		if (lRed && llRed) {
			a = ll.left;
			b = ll.right;
			c = lr;
			d = r;
			x = ll.value;
			y = l.value;
			z = v;
			return new Node(Color.R, new Node(Color.B, a, x, b), y, new Node(Color.B, c, z, d));
		} else if (lRed && lrRed) {
			a = ll;
			b = lr.left;
			c = lr.right;
			d = r;
			x = l.value;
			y = lr.value;
			z = v;
			return new Node(Color.R, new Node(Color.B, a, x, b), y, new Node(Color.B, c, z, d));
		} else if (rRed && rlRed) {
			a = l;
			b = rl.left;
			c = rl.right;
			d = rr;
			x = v;
			y = rl.value;
			z = r.value;
			return new Node(Color.R, new Node(Color.B, a, x, b), y, new Node(Color.B, c, z, d));
		} else if (rRed && rrRed) {
			a = l;
			b = rl;
			c = rr.left;
			d = rr.right;
			x = v;
			y = r.value;
			z = rr.value;
			return new Node(Color.R, new Node(Color.B, a, x, b), y, new Node(Color.B, c, z, d));
		}
		return new Node(color, l, v, r); // none of the violation cases applied

	} // end of method balance

	@Override
	public String toString() {
		if (root == null) {
			return "E"; // output an empty node
		} else {
			return root.toString();
		}
	}

	public Image toImage() {
		if (root == null) {
			return space(0);
		} else {
			return root.toImage();
		}
	}

	public int height() {
		if (root == null) {
			return 0;
		} else {
			return root.height();
		}
	}

	public static void test() {
//		RBTreeImmutable t = new RBTreeImmutable();
//		t.add(1);
//		t.add(2);
//		t.add(3);
//		t.add(4);
//		t.add(5);
//		Base.println(t);
		
		// test HashMap and TreeMap
		
//		int n = 10000000;
//		// n = 10000000:
//		// time TreeMap = 26176 ms, 28148, 25351, 26263, 27982: mean = 26784, std = 1224
//		// time HashMap = 64803 ms, 68243, 69918, 67364, 61152: mean = 66296, std = 3418
//		// time HashMap : time TreeMap = 2.5
//		int x;
//		long time;
//		
//		TreeMap<String, String> tm = new TreeMap<>();
//		time = System.currentTimeMillis();
//		for (int i = 0; i < n; i++) {
//			String key = "" + i;
//			String value = "" + (2 * i);
//			tm.put(key, value);
//		}
//		x = 0;
//		for (int i = 0; i < n; i++) {
//			String key = "" + i;
//			x ^= tm.get(key).length();
//		}
//		time = System.currentTimeMillis() - time;
//		Base.println("time TreeMap = " + time);
//		Base.println(x);

//		HashMap<String, String> hm = new HashMap<>();
//		time = System.currentTimeMillis();
//		for (int i = 0; i < n; i++) {
//			String key = "" + i;
//			String value = "" + (2 * i);
//			hm.put(key, value);
//		}
//		x = 0;
//		for (int i = 0; i < n; i++) {
//			String key = "" + i;
//			x ^= hm.get(key).length();
//		}
//		time = System.currentTimeMillis() - time;
//		Base.println("time HashMap = " + time);
//		Base.println(x);

		
		
		
		RBTreeImmutable t = new RBTreeImmutable();
		long time = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			int x = Base.rnd(1000000 * 100000);
			t.add(x);
			if (!t.contains(x)) {
				Base.println("error: " + x + " not found");
				System.exit(0);
			}
		}
		if (t.contains(-1)) {
			Base.println("error: tree contains -1, which was never inserted");
			System.exit(0);
		}
		time = System.currentTimeMillis() - time;
		Base.println("insertion test passed in " + time + " ms");
		Base.println("height = " + t.height());
		
		
		
		
	}

}
