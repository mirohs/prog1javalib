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
// javac -cp .;prog1javalib.jar examples\EventsApp.java
// java -cp .;prog1javalib.jar examples.EventsApp

// OS X:
// javac -cp .:prog1javalib.jar examples/Events.java
// java -cp .:prog1javalib.jar examples.EventsApp

/**
 *
 * @author michaelrohs
 */
public class EventsApp extends javafx.application.Application {

	private String status = "";
	private double time;
	
	public EventsApp() { // initialization
		// ...
	}

	@Override
	public void start(javafx.stage.Stage stage) { // entry point
		// start method: window title, width, and height, drawing method
		ApplicationBase.start("Events", 800, 600, stage, this::onDraw);
		// set methods to call upon certain types of events
		ApplicationBase.setOnKeyPressed(this::onKeyPress);
		ApplicationBase.setOnKeyReleased(this::onKeyRelease);
		ApplicationBase.setOnMousePressed(this::onMousePress);
		ApplicationBase.setOnMouseReleased(this::onMouseRelease);
		ApplicationBase.setOnMouseMoved(this::onMove);
		ApplicationBase.setOnMouseDragged(this::onDrag);
		ApplicationBase.setOnTick(this::onTick);
	}

	private Image onDraw() {
		String s = String.format("last event = %s\ntime = %.2f", status, time);
		Image txt = text(s, "Consolas", 24, "black");
		// set functions to call when the mouse is on the text object:
		txt.setOnMousePressed((event, target) -> {
			status = String.format("text: mouse press (%3.0f, %3.0f)", event.x, event.y);
			Base.println(status);
		}, null);
		txt.setOnMouseReleased((event, target) -> {
			status = String.format("text: mouse release (%3.0f, %3.0f)", event.x, event.y);
			Base.println(status);
		}, null);
		txt.setOnMouseMoved((event, target) -> 
				status = String.format("text: mouse move (%3.0f, %3.0f)", event.x, event.y), null);
		txt.setOnMouseDragged((event, target) -> 
				status = String.format("text: mouse drag (%3.0f, %3.0f)", event.x, event.y), null);
		return txt;
	}
        
	// when the key is held down, this method is called repeatedly
	private void onKeyPress(String event) {
		status = "key " + event + " pressed";
		Base.println(status);
	}

	private void onKeyRelease(String event) {
		status = "key " + event + " released";
		Base.println(status);
	}

	private void onMousePress(MouseEvent event, Object target) {
		status = String.format("mouse press (%3.0f, %3.0f)", event.x, event.y);
		Base.println(status);
	}

	private void onMouseRelease(MouseEvent event, Object target) {
		status = String.format("mouse release (%3.0f, %3.0f)", event.x, event.y);
		Base.println(status);
	}

	private void onMove(MouseEvent event, Object target) {
		status = String.format("mouse move (%3.0f, %3.0f)", event.x, event.y);
	}

	private void onDrag(MouseEvent event, Object target) {
		status = String.format("mouse drag (%3.0f, %3.0f)", event.x, event.y);
	}
	
	private void onTick(double time) {
		this.time = time;
	}

}
