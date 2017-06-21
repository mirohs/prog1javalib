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
// javac -cp .;prog1javalib.jar examples\SortingGame.java
// java -cp .;prog1javalib.jar examples.SortingGame
// OS X:
// javac -cp .:prog1javalib.jar examples/SortingGame.java
// java -cp .:prog1javalib.jar examples.SortingGame
/**
 *
 * @author michaelrohs
 */
public class SortingGame extends javafx.application.Application {

    private ApplicationBase app;
    private Graphics g;
    private final double WIDTH = 600;
    private final double HEIGHT = 600;
    private final static int ICON_SIZE = 100;

    private  Image[] icons = new Image[4];
    private final Point[] positions = new Point[icons.length];
    private Point pickOffset = null;

    public SortingGame() {
    }

    private Image onDraw() {
        Image result = g.rectangle(WIDTH, HEIGHT, g.pen("black"));
        for (int i = 0; i < icons.length; i++) {
            Image icon = icons[i];
            Point p = positions[i];
            result = g.underlay("left", "top", p.x, p.y, result, icon);
        }
        return result;
    }

    private Image makeIcon(int codePoint) {
		// Unicode Emoji:
        // http://www.unicode.org/charts/
        // Font:
        // https://github.com/MorbZ/OpenSansEmoji
        int[] codepoints = {codePoint};
        String emoji = new String(codepoints, 0, codepoints.length);
        return g.overlay(g.text(emoji, "OpenSansEmoji", ICON_SIZE - 15, "black"),
                g.square(ICON_SIZE, "floralwhite", g.pen("gray", 2)));
    }

    @Override
    public void start(javafx.stage.Stage stage) {
        app = ApplicationBase.start("Sorting Game", WIDTH, HEIGHT, stage);
        g = app.getGraphics();

        icons[0] = makeIcon(0x1F40E); // donkey
        icons[1] = makeIcon(0x1F415); // dog
        icons[2] = makeIcon(0x1F408); // cat
        icons[3] = makeIcon(0x1F413); // rooster
        for (int i = 0; i < icons.length; i++) {
            positions[i] = new Point(
                    Math.random() * (WIDTH - 100),
                    Math.random() * (HEIGHT - 100));
            Image icon = icons[i];
            icon.setOnMousePressed((event, target) -> {
                Point p = positions[(int) target];
                pickOffset = new Point(
                        p.x - event.x,
                        p.y - event.y);
            }, i);
            icon.setOnMouseDragged((event, target) -> {
                double x = event.x + pickOffset.x;
                double y = event.y + pickOffset.y;
                positions[(int) target] = new Point(x, y);
            }, i);
        }

        app.setOnDraw(this::onDraw);
    }

}
