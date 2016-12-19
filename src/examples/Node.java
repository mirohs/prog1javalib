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

import static prog1.graphics.Graphics.*;
import prog1.graphics.Image;

/**
 *
 * @author michaelrohs
 */
public class Node {
	public int value;
	public Node next;
	
	public Node(int value, Node next) { 
		this.value = value; 
		this.next = next;
	}
	
	public Image toImage() {
		Image frame = rectangle(40, 20, pen("black"));
		Image text = text("" + value, 12, "black");
		return overlay(text, frame); // draw text on frame background
	}

}
