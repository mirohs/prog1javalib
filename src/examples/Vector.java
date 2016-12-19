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
public class Vector {
	private int[] data = new int[2]; // initial capacity
	private int size = 0; // number of valid elements in data

	public void add(int value) {
		if (size >= data.length) { // need a larger array, reallocate
			int[] dataNew = new int[2 * data.length]; // duplicate capacity
			System.arraycopy(data, 0, dataNew, 0, data.length); // copy elements
			data = dataNew; // now old data array can be garbage collected
		}
		data[size++] = value; // store value
	}
	
	public int size() {
		return size;
	}
	
	public int get(int i) {
		return data[i];
	}
	
	public Image toImage() {
		Image frame = rectangle(40, 20, pen("black"));
		Image[] cells = map(data, (IntIntToImage) 
				(d, i) -> overlay(text(i < size ? "" + d : "", 12, "black"), frame));
		return beside(cells);
	}

	public static void test() {
		Vector v = new Vector();
		Base.checkExpect(v.size(), 0);
		Base.checkExpect(v.data.length, 2);
		v.add(10);
		Base.checkExpect(v.size(), 1);
		Base.checkExpect(v.data.length, 2);
		Base.checkExpect(v.get(0), 10);
		v.add(20);
		Base.checkExpect(v.size(), 2);
		Base.checkExpect(v.data.length, 2);
		Base.checkExpect(v.get(0), 10);
		Base.checkExpect(v.get(1), 20);
		v.add(30);
		Base.checkExpect(v.size(), 3);
		Base.checkExpect(v.data.length, 4);
		Base.checkExpect(v.get(0), 10);
		Base.checkExpect(v.get(1), 20);
		Base.checkExpect(v.get(2), 30);
		v.add(40);
		Base.checkExpect(v.size(), 4);
		Base.checkExpect(v.data.length, 4);
		Base.checkExpect(v.get(0), 10);
		Base.checkExpect(v.get(1), 20);
		Base.checkExpect(v.get(2), 30);
		Base.checkExpect(v.get(3), 40);
		v.add(50);
		Base.checkExpect(v.size(), 5);
		Base.checkExpect(v.data.length, 8);
		Base.checkExpect(v.get(0), 10);
		Base.checkExpect(v.get(1), 20);
		Base.checkExpect(v.get(2), 30);
		Base.checkExpect(v.get(3), 40);
		Base.checkExpect(v.get(4), 50);
		Base.summary();
	}

	public static void main(String[] args) { // testing
		test();
	}

}
