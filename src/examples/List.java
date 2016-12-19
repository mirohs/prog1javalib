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
public class List {
	Node first = null, last = null;

	void print() {
		for (Node n = first; n != null; n = n.next) {
			Base.print(n.value + " " + n + ", ");
		}
		Base.println(" first = " + first + ", last = " + last);
	}
	
	void prepend(int i) { // insert at front
		first = new Node(i, first);
		if (last == null) last = first;
	}

	void append(int i) { // insert at end
		Node p = new Node(i, null);
		if (last != null) last.next = p;
		last = p;
		if (first == null) first = p;
	}

	void remove(int value) { // delete first element with given value
		if (first != null) {
			if (first.value == value) {
				first = first.next;
				if (first == null) last = null;
			} else {
				for (Node n = first; n != null; n = n.next) {
					if (n.next != null && n.next.value == value) {
						if (n.next == last) last = n;
						n.next = n.next.next;
						return;
					}
				}
			}
		}
	}

	private final static Image arrow = rotate(90, polygon(array(
			-2.0, 0, -2, 10, -6, 10, 0, 20, 6, 10, 2, 10, 2, 0), 
			pen("blue")));
	
	public Image toImage() {
		Image result = space(0); // start with "empty" image
		for (Node n = first; n != null; n = n.next) {
			result = beside(result, arrow, n.toImage()); // put elements next to each other
		}
		return result;
	}

	public static void test() {
		List list = new List();
		list.append(20);
		list.prepend(10);
		list.append(30);
		Node n = list.first;
		Base.checkExpect(n.value, 10);
		n = n.next;
		Base.checkExpect(n.value, 20);
		n = n.next;
		Base.checkExpect(n.value, 30);
		Base.summary();
				
		list = new List();
		list.remove(20);
		list.print();

		list = new List();
		list.append(10);
		list.remove(10);
		list.print();
		
		list = new List();
		list.append(10);
		list.remove(20);
		list.print();
		
		list = new List();
		list.append(10);
		list.append(20);
		list.remove(10);
		list.print();
		
		list = new List();
		list.append(10);
		list.append(20);
		list.remove(20);
		list.print();
		
		list = new List();
		list.append(10);
		list.append(20);
		list.remove(30);
		list.print();
	}

	public static void main(String[] args) { // testing
		test();
	}

}
