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
// javac -cp .;prog1javalib.jar examples\UseQueue.java
// java -cp .;prog1javalib.jar examples.UseQueue

// OS X:
// javac -cp .:prog1javalib.jar examples/UseQueue.java
// java -cp .:prog1javalib.jar examples.UseQueue

/**
 *
 * @author michaelrohs
 */
public class UseQueue extends javafx.application.Application {

	private final Queue queue = new Queue(8);
	private String lastEvent = "";

	public UseQueue() {
		Queue.test();
		Base.summary();
	}
	
	@Override
	public void start(javafx.stage.Stage stage) { // entry point
		// start method: window title, width, and height, drawing method
		ApplicationBase.start("UseQueue", 800, 800, stage, this::onDraw);
		ApplicationBase.setOnKeyPressed(this::onKeyPress);
	}

	private Image onDraw() {
		Image i = queue.toImage();
		i = above(i, text(lastEvent, 20, "black"));
		i = scale(2, i); // .save("mytest.png");
		return i;
	}
	
	private void onKeyPress(String event) {
		int x = Base.rnd(100);
		if ("RIGHT".equals(event) && queue.count() < 8) {
			queue.put(x);
			lastEvent = "put " + x;
		} else if ("LEFT".equals(event) && queue.count() > 0) {
			x = queue.get();
			lastEvent = "get " + x;
		}
	}
	
}
