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
public class RBTree {

	private Node root = null; // reference to the root node of the tree

	private static enum Color { B, R }; // black, red

	private static class Node { // node of red-black tree, inner class

		private Color color;
		private int value;
		private Node left, right;

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

		private void add(int x) {
			if (x < value) {
				if (left != null) {
					left.add(x);
					balance();
				} else {
					left = new Node(Color.R, null, x, null); // found insertion point
				}
			} else if (x > value) {
				if (right != null) {
					right.add(x);
					balance();
				} else {
					right = new Node(Color.R, null, x, null); // found insertion point
				}
			}
		}

		private void balance() {
			boolean lRed = left != null && left.color == Color.R;	// is left red?
			boolean rRed = right != null && right.color == Color.R;	// is right red?
			if (!lRed && !rRed) return;
			Node ll = left == null ? null : left.left;	// left-left
			Node lr = left == null ? null : left.right;	// left-right
			Node rl = right == null ? null : right.left;	// right-left
			Node rr = right == null ? null : right.right;	// right-right
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
				d = right;
				x = ll.value;
				y = left.value;
				z = value;
				right = ll;
			} else if (lRed && lrRed) {
				a = ll;
				b = lr.left;
				c = lr.right;
				d = right;
				x = left.value;
				y = lr.value;
				z = value;
				right = lr;
			} else if (rRed && rlRed) {
				a = left;
				b = rl.left;
				c = rl.right;
				d = rr;
				x = value;
				y = rl.value;
				z = right.value;
				left = rl;
			} else if (rRed && rrRed) {
				a = left;
				b = rl;
				c = rr.left;
				d = rr.right;
				x = value;
				y = right.value;
				z = rr.value;
				left = rr;
			} else {
				return;
			}
			left.value = x;
			value = y;
			right.value = z;
			left.left = a;
			left.right = b;
			right.left = c;
			right.right = d;
			left.color = Color.B;
			color = Color.R;
			right.color = Color.B;
		} // end of method balance
		
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
			Image frame = overlay(
				rectangle(40, 1, "transparent"),
				circle(20, "white", pen(color == Color.B ? "black" : "red")));
			Image n = overlay(
					text("" + value, 14, "black"),
					frame);
			Image result = above(n,
					rotate(0, beside("top",
									(left != null) ? left.toImage() : empty,
									(right != null) ? right.toImage() : empty)));
			return result;
		}
		
		public void printInorder() {
			if (left != null) left.printInorder();
			Base.println(value);
			if (right != null) right.printInorder();
		}

	}

	public void clear() {
		root = null; // remove all elements by setting the root to null
	}

	public boolean contains(int x) {
		if (root == null) {
			return false;
		} else {
			return root.contains(x);
		}
	}

	public void add(int x) {
		if (root == null) {
			root = new Node(Color.B, null, x, null);
		} else {
			root.add(x);
			root.color = Color.B;
		}
	}
	
	public int height() {
		if (root == null) {
			return 0;
		} else {
			return root.height();
		}
	}

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
	
	public void printInorder() {
		if (root != null) root.printInorder();
	}

	public static void test() {
		RBTree t = new RBTree();
//		t.add(1);
//		t.add(2);
//		t.add(3);
//		t.add(4);
//		t.add(5);
//		Base.println(t.toString());
//		Base.println("height = " + t.height());
//		t.printInorder();

		long time = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
//			int x = Base.rnd(1000000 * 100000);
			int x = Base.rnd(100);
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
		t.printInorder();
	}

}
