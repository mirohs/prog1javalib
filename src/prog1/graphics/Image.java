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

import java.io.File;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Bounds;
import javafx.scene.SnapshotParameters;
import javafx.scene.paint.Color;
import javafx.scene.transform.Transform;
import javax.imageio.ImageIO;

/**
 * Image is the base class of all graphics output. Images may be combined. 
 * Use the static methods in {@link Graphics} to create images.
 * @author michaelrohs
 */
public abstract class Image {
	protected double width;
	protected double height;
	protected MouseFunction pressFunction;
	protected Object pressFunctionTarget;
	protected MouseFunction releaseFunction;
	protected Object releaseFunctionTarget;
	protected MouseFunction moveFunction;
	protected Object moveFunctionTarget;
	protected MouseFunction dragFunction;
	protected Object dragFunctionTarget;
//	public Image clip;

	/**
	 * Construct an image of the given width and height.
	 * @param width image width
	 * @param height image height
	 */
	public Image(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	/**
	 * The width of the image.
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * The height of the image.
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Returns the bounding box of this image under the given affine transformation.
	 * @param t affine transform
	 * @return bounding box
	 */
	protected Rect boundingBox(Transform t) {
		javafx.scene.Node e = render();
		e.getTransforms().setAll(t);
		Bounds b = e.getBoundsInParent();
		return new Rect(b.getMinX(), b.getMinY(), b.getWidth(), b.getHeight());
		// todo: generally use Bounds instead of Rect, remove class Rect
	}
	
	/**
	 * Draws the image. Will be overridden for each specific subtype.
	 * @return the JavaFX scene graph Node that represents this image in JavaFX
	 */
	protected abstract javafx.scene.Node render();
	
	protected String toString(String indent) {
		return indent + "  " + 
				String.format("<Image width=\"%.1f\" height=\"%.1f\"/>\n", 
				width, height);
	}
		
	/**
	 * String representation of the object.
	 * @return string representation of the object
	 */
	@Override
	public String toString() {
		return toString("");
	}
	
	/**
	 * Save the image as a png file.
	 * @param fileName the name of the file
	 * @return true if the image could successfully be saved
	 */
	public boolean save(String fileName) {
		File file = new File(fileName);
		SnapshotParameters sp = new SnapshotParameters();
		sp.setFill(Color.TRANSPARENT);
		try {
			ImageIO.write(SwingFXUtils.fromFXImage(render().snapshot(sp, null), null), "png", file);
		} catch (IOException ex) {
			System.err.println("Image.save:\n" + ex);
			return false;
		}
		return true;
	}
	
	/**
	 * Set a function that handles mouse button press events on this image.
	 * <pre>
	 * {@code
	 * Image i = square(100, "red");
	 * i.setOnMousePressed(this::onPressed, "my red square");
	 * ...
	 * void onPress(MouseEvent event, Object target) {
	 *     Base.println("You have pressed on " + target + "!");
	 * }
	 * }</pre>
	 * Output:
	 * <pre>
	 * {@code
	 * You have pressed on my red square!
	 * }</pre>
	 * 
	 * @param pressFunction the function to call
	 * @param pressFunctionTarget an arbitrary object that is used as an argument when the press function is called
	 */
	public void setOnMousePressed(MouseFunction pressFunction, Object pressFunctionTarget) {
		this.pressFunction = pressFunction;
		this.pressFunctionTarget = pressFunctionTarget;
	}

	/**
	 * Set a function that handles mouse button release events on this image.
	 * <pre>
	 * {@code
	 * Image i = square(100, "red");
	 * i.setOnMouseReleased(this::onRelease, "my red square");
	 * ...
	 * void onRelease(MouseEvent event, Object target) {
	 *     Base.println("You have releaseed on " + target + "!");
	 * }
	 * }</pre>
	 * Output:
	 * <pre>
	 * {@code
	 * You have released on my red square!
	 * }</pre>
	 * 
	 * @param releaseFunction the function to call
	 * @param releaseFunctionTarget an arbitrary object that is used as an argument when the release function is called
	 */
	public void setOnMouseReleased(MouseFunction releaseFunction, Object releaseFunctionTarget) {
		this.releaseFunction = releaseFunction;
		this.releaseFunctionTarget = releaseFunctionTarget;
	}

	/**
	 * Set a function that handles move events on this image.
	 * <pre>
	 * {@code
	 * Image i = square(100, "red");
	 * i.setOnMouseMoved(this::onMove, "my red square");
	 * ...
	 * void onMove(MouseEvent event, Object target) {
	 *     Base.println("You are moving on " + target + "!");
	 * }
	 * }</pre>
	 * Output:
	 * <pre>
	 * {@code
	 * You are moving on my red square!
	 * }</pre>
	 * 
	 * @param moveFunction the function to call
	 * @param moveFunctionTarget an arbitrary object that is used as an argument when the move function is called
	 */
	public void setOnMouseMoved(MouseFunction moveFunction, Object moveFunctionTarget) {
		this.moveFunction = moveFunction;
		this.moveFunctionTarget = moveFunctionTarget;
	}

	/**
	 * Set a function that handles drag events on this image.
	 * <pre>
	 * {@code
	 * Image i = square(100, "red");
	 * i.setOnMouseDragged(this::onDrag, "my red square");
	 * ...
	 * void onDrag(MouseEvent event, Object target) {
	 *     Base.println("You are dragging on " + target + "!");
	 * }
	 * }</pre>
	 * Output:
	 * <pre>
	 * {@code
	 * You are dragging on my red square!
	 * }</pre>
	 * 
	 * @param dragFunction the function to call
	 * @param dragFunctionTarget an arbitrary object that is used as an argument when the drag function is called
	 */
	public void setOnMouseDragged(MouseFunction dragFunction, Object dragFunctionTarget) {
		this.dragFunction = dragFunction;
		this.dragFunctionTarget = dragFunctionTarget;
	}

}
