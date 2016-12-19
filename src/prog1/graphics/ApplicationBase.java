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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

		
/**
 * Static methods for starting an application and event handling.
 * @author michaelrohs
 */
public class ApplicationBase {
	private static Pane root;
	private static Scene scene;
	private static DrawFunction onDraw;
	private static InteractionTimer timer;
	private static TickFunction onTick;
	
	private static EventHandler mousePressedHandler;
	private static EventHandler mouseReleasedHandler;
	private static EventHandler mouseDraggedHandler;
	private static EventHandler mouseMovedHandler;
	private static EventHandler keyPressedHandler;
	private static EventHandler keyReleasedHandler;

	/**
	 * This class is meant to be used in a static way.
	 */
	private ApplicationBase() {}

	/**
	 * Needs to be called for starting an application.
	 * @param title the window title
	 * @param width the window width
	 * @param height the window height
	 * @param stage a JavaFX object passed to the application
	 * @param onDraw the drawing callback function
	 */
	public static void start(String title, double width, double height, Stage stage, DrawFunction onDraw) {
		ApplicationBase.onDraw = onDraw;
		root = new Pane();
//		root.getChildren().addAll(g.render());
//		scene = new Scene(root, 200+g.width, 200+g.height);
		scene = new Scene(root, width, height);

		stage.setTitle(title);
		stage.setScene(scene);
		stage.show();
		
		draw();
	}
	
	/**
	 * Registers another drawing callback function.
	 * @param onDraw drawing callback function
	 */
	public static void setOnDraw(DrawFunction onDraw) {
		ApplicationBase.onDraw = onDraw;
	}
	
	protected static void draw() {
		root.getChildren().setAll(onDraw.apply().render());
	}
	
	/**
	 * Register a mouse-button-press callback function.
	 * @param onMouse the callback function
	 */
	public static void setOnMousePressed(MouseFunction onMouse) {
		if (mousePressedHandler != null) {
			scene.removeEventHandler(MouseEvent.MOUSE_PRESSED, mousePressedHandler);
		}
		mousePressedHandler = (EventHandler<MouseEvent>) e -> {
//			double x = e.getSceneX();
//			double y = e.getSceneY();
//			System.out.println("x = " + x + ", y = " + y);
//			System.out.println(Thread.currentThread());
			onMouse.apply(e, null);
			e.consume(); // prevent further processing
			if (onTick == null) { // update output on next tick, or immediately, if not available, todo: makes sense?
				draw();
			}
		};
		scene.addEventHandler(MouseEvent.MOUSE_PRESSED, mousePressedHandler);
	}
	
	/**
	 * Register a mouse-button-release callback function.
	 * @param onMouse the callback function
	 */
	public static void setOnMouseReleased(MouseFunction onMouse) {
		if (mouseReleasedHandler != null) {
			scene.removeEventHandler(MouseEvent.MOUSE_RELEASED, mouseReleasedHandler);
		}
		mouseReleasedHandler = (EventHandler<MouseEvent>) e -> {
//			double x = e.getSceneX();
//			double y = e.getSceneY();
//			System.out.println("x = " + x + ", y = " + y);
//			System.out.println(Thread.currentThread());
			onMouse.apply(e, null);
			e.consume(); // prevent further processing
			if (onTick == null) { // update output on next tick, or immediately, if not available, todo: makes sense?
				draw();
			}
		};
		scene.addEventHandler(MouseEvent.MOUSE_RELEASED, mouseReleasedHandler);
	}
	
	/**
	 * Register a mouse-drag callback function.
	 * @param onMouse the callback function
	 */
	public static void setOnMouseDragged(MouseFunction onMouse) {
		if (mouseDraggedHandler != null) {
			scene.removeEventHandler(MouseEvent.MOUSE_DRAGGED, mouseDraggedHandler);
		}
		mouseDraggedHandler = (EventHandler<MouseEvent>) e -> {
//			double x = e.getSceneX();
//			double y = e.getSceneY();
//			System.out.println("x = " + x + ", y = " + y);
//			System.out.println(Thread.currentThread());
			onMouse.apply(e, null);
			e.consume(); // prevent further processing
			if (onTick == null) { // update output on next tick, or immediately, if not available, todo: makes sense?
				draw();
			}
		};
		scene.addEventHandler(MouseEvent.MOUSE_DRAGGED, mouseDraggedHandler);
	}
	
	/**
	 * Register a mouse-move callback function.
	 * @param onMouse the callback function
	 */
	public static void setOnMouseMoved(MouseFunction onMouse) {
		if (mouseMovedHandler != null) {
			scene.removeEventHandler(MouseEvent.MOUSE_MOVED, mouseMovedHandler);
		}
		mouseMovedHandler = (EventHandler<MouseEvent>) e -> {
//			double x = e.getSceneX();
//			double y = e.getSceneY();
//			System.out.println("x = " + x + ", y = " + y);
//			System.out.println(Thread.currentThread());
			onMouse.apply(e, null);
			e.consume(); // prevent further processing
			if (onTick == null) { // update output on next tick, or immediately, if not available, todo: makes sense?
				draw();
			}
		};
		scene.addEventHandler(MouseEvent.MOUSE_MOVED, mouseMovedHandler);
	}
	
	/**
	 * Register a tick callback function.
	 * @param onTick the callback function
	 */
	public static void setOnTick(TickFunction onTick) {
		if (timer != null) {
			timer.stop();
		}
		ApplicationBase.onTick = onTick;
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
	 * @param onKeyPressed the callback function
	 */
	public static void setOnKeyPressed(KeyFunction onKeyPressed) {
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
	 * @param onKeyReleased the callback function
	 */
	public static void setOnKeyReleased(KeyFunction onKeyReleased) {
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

	private static class InteractionTimer extends AnimationTimer {

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
