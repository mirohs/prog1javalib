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

// Windows:
// javac -cp .;prog1javalib.jar examples\UseRBTree.java
// java -cp .;prog1javalib.jar examples.UseRBTree
// OS X:
// javac -cp .:prog1javalib.jar examples/UseRBTree.java
// java -cp .:prog1javalib.jar examples.UseRBTree
/**
 *
 * @author michaelrohs
 */
public class UseRBTree extends javafx.application.Application {

    private ApplicationBase app;
    private Graphics g;
    private RBTreeImmutable tree = new RBTreeImmutable();
    private String lastEvent = "";
    private int value = 0;

    public UseRBTree() {
        RBTreeImmutable.test();
        Base.summary();
    }

    @Override
    public void start(javafx.stage.Stage stage) { // entry point
        // start method: window title, width, and height, drawing method
        app = ApplicationBase.start("UseRBTree", 1200, 800, stage);
        g = app.getGraphics();
        app.setOnDraw(this::onDraw);
        app.setOnKeyPressed(this::onKeyPress);
    }

    private Image onDraw() {
        Image i = tree.toImage(g);
        i = g.overlay("center", "top", i, g.rectangle(1200, 1, "transparent"));
        i = g.above(i, g.text(lastEvent, 12, "black"));
        i = g.scale(1, i);
        return i;
    }

    private void onKeyPress(String event) {
        int x = Base.rnd(100);
//		int x = value++;
        tree.add(x);
        lastEvent = "add " + x;
    }

}
