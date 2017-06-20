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

import java.util.ArrayList;
import javafx.scene.paint.Color;
import prog1.graphics.*;
import static prog1.graphics.Graphics.*;

// Windows:
// javac -cp .;prog1javalib.jar examples\Voronoi.java
// java -cp .;prog1javalib.jar examples.Voronoi
// OS X:
// javac -cp .:prog1javalib.jar examples/Voronoi.java
// java -cp .:prog1javalib.jar examples.Voronoi
/**
 *
 * @author michaelrohs
 */
public class Voronoi extends javafx.application.Application {

    private ArrayList<Point> points = new ArrayList();

    public Voronoi() {
    }

    @Override
    public void start(javafx.stage.Stage stage) { // entry point
        // window title, width, and height; drawing method
        ApplicationBase.start("Voronoi", 800, 800, stage, this::onDraw);
        ApplicationBase.setOnMousePressed(this::onClick);
    }

    private double distanceClosest(double x, double y) {
        double dMin = Double.POSITIVE_INFINITY;
        for (Point p : points) {
            double dx = x - p.x;
            double dy = y - p.y;
            double d = dx * dx + dy * dy;
            if (d < dMin) {
                dMin = d;
            }
        }
        return Math.sqrt(dMin);
    }

    private Image onDraw() {
        Image img = rectangle(800, 800, "white");
        final int side = 30;
        for (int y = 0; y < 800; y += side) {
            for (int x = 0; x < 800; x += side) {
                double d = distanceClosest(x, y) / (5 * side);
                if (d > 1.0) d = 1.0;
                img = underlay("left", "top", x, y, img, square(side, Color.gray(d)));
            }
        }
        Image c = circle(6, "red");
        for (Point p : points) {
            img = underlay("left", "top", p.x - 6, p.y - 6, img, c);
            
        }
        return img;
    }

    private void onClick(MouseEvent event, Object target) {
        points.add(new Point(event.x, event.y));
    }

    public static void main(String[] args) {
        launch(args);
    }

}
