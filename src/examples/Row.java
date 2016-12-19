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

import static prog1.functional.Functional.*;
import prog1.graphics.*;
import static prog1.graphics.Graphics.*;

// Windows:
// javac -cp .;prog1javalib.jar examples\Row.java
// java -cp .;prog1javalib.jar examples.Row

// OS X:
// javac -cp .:prog1javalib.jar examples/Row.java
// java -cp .:prog1javalib.jar examples.Row

/**
 *
 * @author michaelrohs
 */
public class Row extends javafx.application.Application {

	private String[] languages = { "HELLO", "World", "Java", "C", "Python" };

	public Row() {
		// languages = map(languages, (StringToString) s -> s.toLowerCase());
		// languages = map(range(8), (IntToString) i -> String.valueOf((int)Math.pow(i, 2)));
	}

	private Image onDraw() {
		Image[] texts = map(languages, (StringToImage) s -> text(s, 18, "green"));
		double maxWidth = foldl(texts, (mw, elem) -> Math.max(elem.getWidth(), mw), 0.0);
		double maxHeight = texts[0].getHeight() + 4;
		Image cell = rectangle(maxWidth + 10, maxHeight + 4, pen("gray"));
		Image[] row = map(texts, (ImageToImage) t -> overlay(t, cell));
		return beside(row);
	}
	
	private Image onDraw2() {
		int[] numbers = map(range(11), (IntToInt) i -> (int)Math.pow(i, 2));
		Image[] texts = map(numbers, (IntToImage) i -> text("" + i, 18, "green"));
		double maxWidth = foldl(texts, (mw, elem) -> Math.max(elem.getWidth(), mw), 0.0);
		Image cell = rectangle(maxWidth + 10, texts[0].getHeight() + 4, pen("gray"));
		Image[] row = map(texts, (ImageToImage) t -> overlay(t, cell));
		return beside(row);
	}
	
	@Override
	public void start(javafx.stage.Stage stage) {
		ApplicationBase.start("Row", 600, 100, stage, this::onDraw);
	}

}
