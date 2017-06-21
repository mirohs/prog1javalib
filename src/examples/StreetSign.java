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

    private ApplicationBase app;
    private Graphics g;
    private double time;

    @Override
    public void start(javafx.stage.Stage stage) {
        // start method: window title, width, and height, drawing method
        app = ApplicationBase.start("Sign", 110, 80, stage);
        g = app.getGraphics();
        app.setOnTick(this::onTick); // register tick function
        app.setOnDraw(this::onDraw);
    }

    private Image onDraw() {
        Image sign = g.circle(30, "navy", g.pen("red", 9));
        sign = g.overlay(g.rectangle(60, 9, "red"), sign);
        sign = g.rotate(-45 - time * 100, sign); // time-based sign rotation
        Image highlight = g.ellipse(100, 30, "white", 0.5);
        sign = g.overlay(5, 25, highlight, sign);
//		save(sign, "sign4.png");
        return sign;
    }

    private void onTick(double time) { // time in seconds
        this.time = time;
    }

}
