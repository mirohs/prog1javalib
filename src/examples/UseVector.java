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

// Windows:
// javac -cp .;prog1javalib.jar examples\UseVector.java
// java -cp .;prog1javalib.jar examples.UseVector

// OS X:
// javac -cp .:prog1javalib.jar examples/UseVector.java
// java -cp .:prog1javalib.jar examples.UseVector

/**
 *
 * @author michaelrohs
 */
public class UseVector extends javafx.application.Application {

	private final Vector vector = new Vector();
	private String lastEvent = "";

	public UseVector() {
		Vector.test();
//		Base.summary();
	}
	
	@Override
	public void start(javafx.stage.Stage stage) { // entry point
		// start method: window title, width, and height, drawing method
		ApplicationBase.start("Vector", 800, 800, stage, this::onDraw);
		ApplicationBase.setOnKeyPressed(this::onKeyPress);
	}

	private Image onDraw() {
		Image i = vector.toImage(); // output the vector as an image
		i = above("right", i, text(lastEvent, 12, "black"));
		i = scale(2, i); //.save("mytest.png");
		return i;
	}
	
	private void onKeyPress(String event) {
		int x = Base.rnd(100);
		vector.add(x); // add a random value 0..99 to the vector
		lastEvent = "add " + x;
	}
	
}
