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
import prog1.graphics.*;
import static prog1.functional.Functional.*;
import static prog1.graphics.Graphics.*;

/**
 *
 * @author michaelrohs
 */
public class Stack {
	private Node top = null; // top of stack, stack initially empty
	
	public void push(int value) {
		top = new Node(value, top); // Stack implemented a singly linked list
	}

	public int pop() {
		if (top == null) {
			Base.println("Error: underflow"); 
			return 0;
		} else {
			Node p = top;
			top = top.next;
			return p.value;
		}
	}

	private final Image arrow = rotate(180, polygon(array(
			-2.0, 0, -2, 10, -6, 10, 0, 20, 6, 10, 2, 10, 2, 0), 
			pen("blue")));

	public Image toImage() {
		Image background = rectangle(50, 260, pen("blue"));
		if (top == null) return background;
		Image result = above(top.toImage(), arrow);
		for (Node n = top.next; n != null; n = n.next) {
			result = above(result, n.toImage(), arrow);
		}
		return overlay("center", "bottom", 0, 5, result, background);
	}

	public static void test() {
		Stack s = new Stack();
		s.push(10);
		Base.checkExpect(s.pop(), 10);
		s.push(10);
		s.push(20);
		Base.checkExpect(s.pop(), 20);
		Base.checkExpect(s.pop(), 10);
		Base.summary();
	}

	public static void main(String[] args) {
		test();
	}

}
