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
// javac -cp .;prog1javalib.jar examples\StreetSign.java
// java -cp .;prog1javalib.jar examples.StreetSign

// OS X:
// javac -cp .:prog1javalib.jar examples/StreetSign.java
// java -cp .:prog1javalib.jar examples.StreetSign

/**
 *
 * @author michaelrohs
 */
public class StreetSign extends javafx.application.Application {
	
	private double time;

	public StreetSign() {
	}

	@Override
	public void start(javafx.stage.Stage stage) {
		// start method: window title, width, and height, drawing method
		ApplicationBase.start("Sign", 110, 80, stage, this::onDraw);
		ApplicationBase.setOnTick(this::onTick); // register tick function
	}

	private Image onDraw() {
		Image sign = circle(30, "navy", pen("red", 9));
		sign = overlay(rectangle(60, 9, "red"), sign);
		sign = rotate(-45 - time * 100, sign); // time-based sign rotation
		Image highlight = ellipse(100, 30, "white", 0.5);
		sign = overlay(5, 25, highlight, sign);
//		save(sign, "sign4.png");
		return sign;
	}

	private void onTick(double time) { // time in seconds
		this.time = time;
	}

}
