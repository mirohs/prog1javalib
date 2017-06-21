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
package prog1.graphics;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Static methods for starting an application and event handling.
 *
 * @author michaelrohs
 */
public class ApplicationBase {

    private Pane root;
    private Scene scene;
    private DrawFunction onDraw;
    private InteractionTimer timer;
    private TickFunction onTick;

    private EventHandler mousePressedHandler;
    private EventHandler mouseReleasedHandler;
    private EventHandler mouseDraggedHandler;
    private EventHandler mouseMovedHandler;
    private EventHandler keyPressedHandler;
    private EventHandler keyReleasedHandler;

    private Graphics graphics;

    /**
     * This class is meant to be used in a static way.
     */
    private ApplicationBase() {
    }

    /**
     * Needs to be called for starting an application.
     *
     * @param title the window title
     * @param width the window width
     * @param height the window height
     * @param stage a JavaFX object passed to the application
     * @return the app
     */
    public static ApplicationBase start(String title, double width, double height, Stage stage) {
        ApplicationBase ab = new ApplicationBase();
        ab.graphics = new Graphics(ab);
        ab.root = new Pane();
        ab.scene = new Scene(ab.root, width, height);

        stage.setTitle(title);
        stage.setScene(ab.scene);
        stage.show();

        return ab;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    /**
     * Registers another drawing callback function.
     *
     * @param onDraw drawing callback function
     */
    public void setOnDraw(DrawFunction onDraw) {
        this.onDraw = onDraw;
        draw();
    }

    protected void draw() {
        if (onDraw != null) {
            root.getChildren().setAll(onDraw.apply().render());
        }
    }

    /**
     * Register a mouse-button-press callback function.
     *
     * @param onMouse the callback function
     */
    public void setOnMousePressed(MouseFunction onMouse) {
        if (mousePressedHandler != null) {
            scene.removeEventHandler(javafx.scene.input.MouseEvent.MOUSE_PRESSED, mousePressedHandler);
        }
        mousePressedHandler = (EventHandler<javafx.scene.input.MouseEvent>) e -> {
//			double x = e.getSceneX();
//			double y = e.getSceneY();
//			System.out.println("x = " + x + ", y = " + y);
//			System.out.println(Thread.currentThread());
            onMouse.apply(new MouseEvent(e), null);
            e.consume(); // prevent further processing
            if (onTick == null) { // update output on next tick, or immediately, if not available, todo: makes sense?
                draw();
            }
        };
        scene.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_PRESSED, mousePressedHandler);
    }

    /**
     * Register a mouse-button-release callback function.
     *
     * @param onMouse the callback function
     */
    public void setOnMouseReleased(MouseFunction onMouse) {
        if (mouseReleasedHandler != null) {
            scene.removeEventHandler(javafx.scene.input.MouseEvent.MOUSE_RELEASED, mouseReleasedHandler);
        }
        mouseReleasedHandler = (EventHandler<javafx.scene.input.MouseEvent>) e -> {
//			double x = e.getSceneX();
//			double y = e.getSceneY();
//			System.out.println("x = " + x + ", y = " + y);
//			System.out.println(Thread.currentThread());
            onMouse.apply(new MouseEvent(e), null);
            e.consume(); // prevent further processing
            if (onTick == null) { // update output on next tick, or immediately, if not available, todo: makes sense?
                draw();
            }
        };
        scene.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_RELEASED, mouseReleasedHandler);
    }

    /**
     * Register a mouse-drag callback function.
     *
     * @param onMouse the callback function
     */
    public void setOnMouseDragged(MouseFunction onMouse) {
        if (mouseDraggedHandler != null) {
            scene.removeEventHandler(javafx.scene.input.MouseEvent.MOUSE_DRAGGED, mouseDraggedHandler);
        }
        mouseDraggedHandler = (EventHandler<javafx.scene.input.MouseEvent>) e -> {
//			double x = e.getSceneX();
//			double y = e.getSceneY();
//			System.out.println("x = " + x + ", y = " + y);
//			System.out.println(Thread.currentThread());
            onMouse.apply(new MouseEvent(e), null);
            e.consume(); // prevent further processing
            if (onTick == null) { // update output on next tick, or immediately, if not available, todo: makes sense?
                draw();
            }
        };
        scene.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_DRAGGED, mouseDraggedHandler);
    }

    /**
     * Register a mouse-move callback function.
     *
     * @param onMouse the callback function
     */
    public void setOnMouseMoved(MouseFunction onMouse) {
        if (mouseMovedHandler != null) {
            scene.removeEventHandler(javafx.scene.input.MouseEvent.MOUSE_MOVED, mouseMovedHandler);
        }
        mouseMovedHandler = (EventHandler<javafx.scene.input.MouseEvent>) e -> {
//			double x = e.getSceneX();
//			double y = e.getSceneY();
//			System.out.println("x = " + x + ", y = " + y);
//			System.out.println(Thread.currentThread());
            onMouse.apply(new MouseEvent(e), null);
            e.consume(); // prevent further processing
            if (onTick == null) { // update output on next tick, or immediately, if not available, todo: makes sense?
                draw();
            }
        };
        scene.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_MOVED, mouseMovedHandler);
    }

    /**
     * Register a tick callback function.
     *
     * @param onTick the callback function
     */
    public void setOnTick(TickFunction onTick) {
        if (timer != null) {
            timer.stop();
        }
        this.onTick = onTick;
        if (onTick == null) {
            timer = null;
        } else {
            if (timer == null) {
                timer = new InteractionTimer();
            }
            timer.start();
        }
    }

    /**
     * Register a key-press callback function.
     *
     * @param onKeyPressed the callback function
     */
    public void setOnKeyPressed(KeyFunction onKeyPressed) {
        keyPressedHandler = (EventHandler<KeyEvent>) e -> {
            String s = e.getText();
            if (s.length() == 0) {
                s = e.getCode().toString();
            }
            onKeyPressed.apply(s);
            e.consume();
            if (onTick == null) { // update output on next tick, or immediately, if not available, todo: makes sense?
                draw();
            }
        };
        scene.setOnKeyPressed(keyPressedHandler);
    }

    /**
     * Register a key-release callback function.
     *
     * @param onKeyReleased the callback function
     */
    public void setOnKeyReleased(KeyFunction onKeyReleased) {
        keyReleasedHandler = (EventHandler<KeyEvent>) e -> {
            String s = e.getText();
            if (s.length() == 0) {
                s = e.getCode().toString();
            }
            onKeyReleased.apply(s);
            e.consume();
            if (onTick == null) { // update output on next tick, or immediately, if not available, todo: makes sense?
                draw();
            }
        };
        scene.setOnKeyReleased(keyReleasedHandler);
    }

    private class InteractionTimer extends AnimationTimer {

        private long nowInit;

        // now timestamp of current frame given in nanoseconds
        @Override
        public void handle(long now) {
            if (nowInit == 0) {
                nowInit = now;
            }
            double sec = (now - nowInit) * 1.0e-9;
            // System.out.println(sec);
            // System.out.println(Thread.currentThread());
            if (onTick != null) {
                onTick.apply(sec);
                draw();
            }
        }

    }

}
