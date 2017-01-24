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

import prog1.graphics.*;
import static prog1.graphics.Graphics.*;

// Windows:
// javac -cp .;prog1javalib.jar examples\Button.java
// java -cp .;prog1javalib.jar examples.Button
// OS X:
// javac -cp .:prog1javalib.jar examples/Button.java
// java -cp .:prog1javalib.jar examples.Button
/**
 *
 * @author michaelrohs
 */
public class Button extends javafx.application.Application {

	private final Image button;
	private String status = "You clicked my button 0 times.";
	private int count = 0;

	public Button() {
		// a button is an overlay of a label on a gray rectangle
		button = overlay(text("Click me", 24, "black"),
				rectangle(140, 40, "lightgray", pen("darkgray")));

		// event handling with a named method:
		button.setOnMousePressed(this::onClick, "my button.");

		// alternative: event handling with an anonymous function:
//		button.setOnMousePressed(
//				(event, target) -> {
//					count++;
//					status = "You clicked " + target + " " + count + " times.";
//				}, "my button.");

	}

	@Override
	public void start(javafx.stage.Stage stage) { // entry point
		// window title, width, and height; drawing method
		ApplicationBase.start("Button", 500, 100, stage, this::onDraw);
	}

	private Image onDraw() {
		// output button above text
		return above(button,
				text(status, 24, "black"));
	}

	private void onClick(MouseEvent event, Object target) {
		count++;
		status = "You clicked " + target + " " + count + " times.";
	}

	public static void main(String[] args) {
		launch(args);
	}

}
