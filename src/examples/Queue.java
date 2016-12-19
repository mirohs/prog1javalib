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
import static prog1.graphics.Graphics.*;

/**
 *
 * @author michaelrohs
 */
public class Queue {

	private final int[] data;
	private int head, tail, n;

	public Queue(int size) {
		data = new int[size];
		head = 0;
		tail = 0;
		n = 0;
	}

	public void put(int x) {
		if (n == data.length) {
			Base.println("Error: overflow");
		} else {
			data[tail] = x;
			n++;
			tail = (tail + 1) % data.length;
		}
	}

	public int get() {
		if (n == 0) {
			Base.println("Error: underflow");
			return 0;
		} else {
			int x = data[head];
			n--;
			head = (head + 1) % data.length;
			return x;
		}	
	}
	
	public int count() {
		return n;
	}
	
	public static void test() {
		Queue q = new Queue(8);
		q.put(3);
		q.put(6);
		Base.checkExpect(q.get(), 3);
		Base.checkExpect(q.get(), 6);
	}

	public static void main(String[] args) {
		test();
	}
	
	private boolean used(int i) { // test if slot i is used
		if (n <= 0) return false;
		if (n >= data.length) return true;
		if (head < tail) {
			if (i >= head && i < tail) return true;
		} else /* head >= tail */ {
			if (i >= head || i < tail) return true;
		}
		return false;
	}

	public Image toImage() {
		double pieAngle = 360.0 / data.length;
		Image result = circle(100, pen("black"));
		for (int i = data.length - 1; i >= 0; i--) {
			String pieBackground = "transparent";
			if (used(i)) pieBackground = "yellow"; // occupied cell
			if (i == tail && n < data.length) pieBackground = "lightgreen"; // next input position (if any)
			if (i == head && n > 0) pieBackground = "orange"; // next output position (if any)
			Image pie = arc(100, -pieAngle/2, pieAngle, pieBackground, pen("black"));
			String s = used(i) ? ("" + data[i]) : "";
			Image text = overlay(text(s, 20, "black"), circle(20, "transparent"));
			text = rotate(-i * pieAngle, text);
			result = overlay("right", "center", text, pie, rotate(pieAngle, result));
		}
		result = overlay(circle(60, "white", pen("black")), result);
		return result;
	}

}
