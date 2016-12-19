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
// javac -cp .;prog1javalib.jar examples\UseList.java
// java -cp .;prog1javalib.jar examples.UseList

// OS X:
// javac -cp .:prog1javalib.jar examples/UseList.java
// java -cp .:prog1javalib.jar examples.UseList

/**
 *
 * @author michaelrohs
 */
public class UseList extends javafx.application.Application {

	private final List list = new List();
	private String lastEvent = "";

	public UseList() {
		List.test();
//		Base.summary();
	}
	
	@Override
	public void start(javafx.stage.Stage stage) { // entry point
		// window title, width, and height; drawing method
		ApplicationBase.start("UseList", 800, 800, stage, this::onDraw);
		ApplicationBase.setOnKeyPressed(this::onKeyPress);
	}

	private Image onDraw() {
		Image i = list.toImage();
		String align = lastEvent.startsWith("append") ? "right" : "left";
		i = above(i, text(lastEvent, 12, "black"));
		i = scale(2, i);
		return i;
	}
	
	private void onKeyPress(String event) {
		Base.println(event);
		int x = Base.rnd(100);
		if ("RIGHT".equals(event)) {
			list.append(x);
			lastEvent = "append " + x;
		} else if ("LEFT".equals(event)) {
			list.prepend(x);
			lastEvent = "prepend " + x;
		}
	}
	
}
