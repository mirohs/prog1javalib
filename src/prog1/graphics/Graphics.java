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

import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.TextAlignment;
import prog1.base.Base;

/**
 * Static graphics factory methods. Most methods create
 * {@code Image} objects. Images may be combined to form other images. 
 * Import as:<br>
 * {@code import static prog1.graphics.Graphics.*;}
 * 
 * <br/>This work is strongly inspired by the Racket 
 * <a href="https://docs.racket-lang.org/teachpack/2htdpimage.html"
 * target="_blank">image teachpack</a>.
 *
 * @author michaelrohs
 */
public class Graphics {
	
	/**
	 * This class is meant to be used in a static way.
	 */
	private Graphics() {}

	/**
	 * Returns a color given the color name (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>).
	 * @param name color name
	 * @return the color
	 */
	public static Color color(String name) {
		// http://grepcode.com/file_/repo1.maven.org/maven2/net.java.openjfx.backport/openjfx-78-backport/1.8.0-ea-b96.1/javafx/scene/paint/Color.java/?v=source
		try {
			return Color.web(name);
		} catch (IllegalArgumentException ex) {
			Base.println("Error: The color \"" + name + "\" is unknown. List of colors: http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html");
			System.exit(0);
		}
		return null;
	}
	
	/**
	 * Returns a color given the color name 
	 * (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>) 
	 * and opacity.
	 * @param name color name
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @return the color
	 */
	public static Color color(String name, double opacity) {
		// http://grepcode.com/file_/repo1.maven.org/maven2/net.java.openjfx.backport/openjfx-78-backport/1.8.0-ea-b96.1/javafx/scene/paint/Color.java/?v=source
		try {
			return Color.web(name, opacity);
		} catch (IllegalArgumentException ex) {
			Base.println("Error: The color \"" + name + "\" is unknown. List of colors: http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html");
			System.exit(0);
		}
		return null;
	}
	
	/**
	 * Returns a color given the read, green, blue, and alpha (opacity) values.
	 * @param red red channel (0..255)
	 * @param green green channel (0..255)
	 * @param blue blue channel (0..255)
	 * @param alpha alpha (opacity) channel (0..255)
	 * @return the color
	 */
	public static Color color(int red, int green, int blue, int alpha) {
		return new Color(red / 255.0, green / 255.0, blue / 255.0, alpha / 255.0);
	}
	
	/**
	 * Returns a color given the read, green, and blue values.
	 * @param red red channel (0..255)
	 * @param green green channel (0..255)
	 * @param blue blue channel (0..255)
	 * @return the color
	 */
	public static Color color(int red, int green, int blue) {
		return new Color(red / 255.0, green / 255.0, blue / 255.0, 1.0);
	}
	
	/**
	 * Returns a color given the read, green, blue, and alpha (opacity) values.
	 * @param red red channel (0..1)
	 * @param green green channel (0..1)
	 * @param blue blue channel (0..1)
	 * @param alpha alpha (opacity) channel (0..1)
	 * @return the color
	 */
	public static Color color(double red, double green, double blue, double alpha) {
		return new Color(red, green, blue, alpha);
	}
	
	/**
	 * Returns a color given the read, green, and blue values.
	 * @param red red channel (0..1)
	 * @param green green channel (0..1)
	 * @param blue blue channel (0..1)
	 * @return the color
	 */
	public static Color color(double red, double green, double blue) {
		return new Color(red, green, blue, 1.0);
	}
	
	/**
	 * {@code Image i = circle(25, color(255, 0, 0));}<br>
	 * <img src="./doc-files/circle(25,color(255,0,0)).png" alt="" >
	 * @param radius radius
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the circle
	 */
	public static Image circle(double radius, Color fillColor) {
		return new Circle(radius, fillColor, null);
	}
	
	/**
	 * {@code Image i = circle(25, pen("black"));}<br>
	 * <img src="./doc-files/circle(25,pen(black)).png" alt="" >
	 * @param radius radius
	 * @param pen pen for drawing the outline
	 * @return the circle
	 */
	public static Image circle(double radius, Pen pen) {
		return new Circle(radius, null, pen);
	}
	
	/**
	 * {@code Image i = circle(25, color(255, 0, 0), pen("black"));}<br>
	 * <img src="./doc-files/circle(25,color(255,0,0),pen(black)).png" alt="" >
	 * @param radius radius
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the circle
	 */
	public static Image circle(double radius, Color fillColor, Pen pen) {
		return new Circle(radius, fillColor, pen);
	}
	
	/**
	 * {@code Image i = circle(25, "red");}<br>
	 * <img src="./doc-files/circle(25,red).png" alt="" >
	 * @param radius radius
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the circle
	 */
	public static Image circle(double radius, String fillColor) {
		return new Circle(radius, color(fillColor), null);
	}
	
	/**
	 * {@code Image i = circle(25, "red", pen("black"));}<br>
	 * <img src="./doc-files/circle(25,red,pen(black)).png" alt="" >
	 * @param radius radius
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the circle
	 */
	public static Image circle(double radius, String fillColor, Pen pen) {
		return new Circle(radius, color(fillColor), pen);
	}
	
	/**
	 * {@code Image i = circle(25, "red", 0.5);}<br>
	 * <img src="./doc-files/circle(25,red,0.5).png" alt="" >
	 * @param radius radius
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @return the circle
	 */
	public static Image circle(double radius, String fillColor, double opacity) {
		return new Circle(radius, color(fillColor, opacity), null);
	}
	
	/**
	 * {@code Image i = circle(25, "red", 0.5, pen("black"));}<br>
	 * <img src="./doc-files/circle(25,red,0.5,pen(black)).png" alt="" >
	 * @param radius radius
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @param pen pen for drawing the outline
	 * @return the circle
	 */
	public static Image circle(double radius, String fillColor, double opacity, Pen pen) {
		return new Circle(radius, color(fillColor, opacity), pen);
	}

	/**
	 * {@code Image i = rectangle(50, 20, "red");}<br>
	 * <img src="./doc-files/rectangle(50,20,red).png" alt="" >
	 * @param width width
	 * @param height height
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the rectangle
	 */
	public static Image rectangle(double width, double height, String fillColor) {
		return new Rectangle(width, height, color(fillColor), null);
	}
	
	/**
	 * {@code Image i = rectangle(50, 20, "red", 0.5);}<br>
	 * <img src="./doc-files/rectangle(50,20,red,0.5).png" alt="" >
	 * @param width width
	 * @param height height
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @return the rectangle
	 */
	public static Image rectangle(double width, double height, String fillColor, double opacity) {
		return new Rectangle(width, height, color(fillColor, opacity), null);
	}
	
	/**
	 * {@code Image i = rectangle(50, 20, pen("black", 3));}<br>
	 * <img src="./doc-files/rectangle(50,20,pen(black,3)).png" alt="" >
	 * @param width width
	 * @param height height
	 * @param pen pen for drawing the outline
	 * @return the rectangle
	 */
	public static Image rectangle(double width, double height, Pen pen) {
		return new Rectangle(width, height, null, pen);
	}
	
	/**
	 * {@code Image i = rectangle(50, 20, "red", pen("black"));}<br>
	 * <img src="./doc-files/rectangle(50,20,red,pen(black)).png" alt="" >
	 * @param width width
	 * @param height height
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the rectangle
	 */
	public static Image rectangle(double width, double height, String fillColor, Pen pen) {
		return new Rectangle(width, height, color(fillColor), pen);
	}
	
	/**
	 * {@code Image i = rectangle(50, 20, "red", 0.5, pen("black"));}<br>
	 * <img src="./doc-files/rectangle(50,20,red,0.5,pen(black)).png" alt="" >
	 * @param width width
	 * @param height height
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @param pen pen for drawing the outline
	 * @return the rectangle
	 */
	public static Image rectangle(double width, double height, String fillColor, double opacity, Pen pen) {
		return new Rectangle(width, height, color(fillColor, opacity), pen);
	}
	
	/**
	 * {@code Image i = rectangle(50, 20, color(255, 0, 0));}<br>
	 * <img src="./doc-files/rectangle(50,20,color(255,0,0)).png" alt="" >
	 * @param width width
	 * @param height height
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the rectangle
	 */
	public static Image rectangle(double width, double height, Color fillColor) {
		return new Rectangle(width, height, fillColor, null);
	}
	
	/**
	 * {@code Image i = rectangle(50, 20, color(255, 0, 0), pen("black"));}<br>
	 * <img src="./doc-files/rectangle(50,20,color(255,0,0),pen(black)).png" alt="" >
	 * @param width width
	 * @param height height
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the rectangle
	 */
	public static Image rectangle(double width, double height, Color fillColor, Pen pen) {
		return new Rectangle(width, height, fillColor, pen);
	}
	
	/**
	 * {@code Image i = square(50, color(255, 0, 0));}<br>
	 * <img src="./doc-files/square(50,color(255,0,0)).png" alt="" >
	 * @param width width
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the square
	 */
	public static Image square(double width, Color fillColor) {
		return new Rectangle(width, width, fillColor, null);
	}
	
	/**
	 * {@code Image i = square(50, pen("black"));}<br>
	 * <img src="./doc-files/square(50,pen(black)).png" alt="" >
	 * @param width width
	 * @param pen pen for drawing the outline
	 * @return the square
	 */
	public static Image square(double width, Pen pen) {
		return new Rectangle(width, width, null, pen);
	}

	/**
	 * {@code Image i = square(50, color(255, 0, 0), pen("black"));}<br>
	 * <img src="./doc-files/square(50,color(255,0,0),pen(black)).png" alt="" >
	 * @param width width
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the square
	 */
	public static Image square(double width, Color fillColor, Pen pen) {
		return new Rectangle(width, width, fillColor, pen);
	}
		
	/**
	 * {@code Image i = square(50, "red");}<br>
	 * <img src="./doc-files/square(50,red).png" alt="" >
	 * @param width width
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the square
	 */
	public static Image square(double width, String fillColor) {
		return new Rectangle(width, width, color(fillColor), null);
	}

	/**
	 * {@code Image i = square(50, "red", pen("black"));}<br>
	 * <img src="./doc-files/square(50,red,pen(black)).png" alt="" >
	 * @param width width
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the square
	 */
	public static Image square(double width, String fillColor, Pen pen ) {
		return new Rectangle(width, width, color(fillColor), pen);
	}
	
	/**
	 * {@code Image i = square(50, "red", 0.5);}<br>
	 * <img src="./doc-files/square(50,red,0.5).png" alt="" >
	 * @param width width
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @return the square
	 */
	public static Image square(double width, String fillColor, double opacity) {
		return new Rectangle(width, width, color(fillColor, opacity), null);
	}
	
	/**
	 * {@code Image i = square(50, "red", 0.5, pen("black"));}<br>
	 * <img src="./doc-files/square(50,red,0.5,pen(black)).png" alt="" >
	 * @param width width
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @param pen pen for drawing the outline
	 * @return the square
	 */
	public static Image square(double width, String fillColor, double opacity, Pen pen) {
		return new Rectangle(width, width, color(fillColor, opacity), pen);
	}

	/**
	 * Empty (transparent) square space.
	 * @param width the width of the empty space
	 * @return space image
	 */
	public static Image space(double width) {
		return new Rectangle(width, width, color("transparent"), null);
	}

	/**
	 * Empty (transparent) rectangular space.
	 * @param width the width of the empty space
	 * @param height the height of the empty space
	 * @return space image
	 */
	public static Image space(double width, double height) {
		return new Rectangle(width, height, color("transparent"), null);
	}

	/**
	 * {@code Image i = ellipse(50, 20, color(255, 0, 0));}<br>
	 * <img src="./doc-files/ellipse(50,20,color(255,0,0)).png" alt="" >
	 * @param width width
	 * @param height height
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the ellipse
	 */
	public static Image ellipse(double width, double height, Color fillColor) {
		return new Ellipse(width, height, fillColor, null);
	}

	/**
	 * {@code Image i = ellipse(50, 20, pen("black"));}<br>
	 * <img src="./doc-files/ellipse(50,20,pen(black)).png" alt="" >
	 * @param width width
	 * @param height height
	 * @param pen pen for drawing the outline
	 * @return the ellipse
	 */
	public static Image ellipse(double width, double height, Pen pen) {
		return new Ellipse(width, height, null, pen);
	}

	/**
	 * {@code Image i = ellipse(50, 20, color(255, 0, 0), pen("black"));}<br>
	 * <img src="./doc-files/ellipse(50,20,color(255,0,0),pen(black)).png" alt="" >
	 * @param width width
	 * @param height height
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the ellipse
	 */
	public static Image ellipse(double width, double height, Color fillColor, Pen pen) {
		return new Ellipse(width, height, fillColor, pen);
	}

	/**
	 * {@code Image i = ellipse(50, 20, "red");}<br>
	 * <img src="./doc-files/ellipse(50,20,red.png" alt="" >
	 * @param width width
	 * @param height height
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the ellipse
	 */
	public static Image ellipse(double width, double height, String fillColor) {
		return new Ellipse(width, height, color(fillColor), null);
	}

	/**
	 * {@code Image i = ellipse(50, 20, "red", 0.5);}<br>
	 * <img src="./doc-files/ellipse(50,20,red,0.5).png" alt="" >
	 * @param width width
	 * @param height height
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @return the ellipse
	 */
	public static Image ellipse(double width, double height, String fillColor, double opacity) {
		return new Ellipse(width, height, color(fillColor, opacity), null);
	}
	
	/**
	 * {@code Image i = ellipse(50, 20, "red", pen("black"));}<br>
	 * <img src="./doc-files/ellipse(50,20,red,pen(black)).png" alt="" >
	 * @param width width
	 * @param height height
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the ellipse
	 */
	public static Image ellipse(double width, double height, String fillColor, Pen pen) {
		return new Ellipse(width, height, color(fillColor), pen);
	}

	/**
	 * {@code Image i = ellipse(50, 20, "red", 0.5, pen("black"));}<br>
	 * <img src="./doc-files/ellipse(50,20,red,0.5,pen(black)).png" alt="" >
	 * @param width width
	 * @param height height
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @param pen pen for drawing the outline
	 * @return the ellipse
	 */
	public static Image ellipse(double width, double height, String fillColor, double opacity, Pen pen) {
		return new Ellipse(width, height, color(fillColor, opacity), pen);
	}
		
	/**
	 * {@code Image i = line(50, 20, color(255, 0, 0));}<br>
	 * <img src="./doc-files/line(50,20,color(255,0,0)).png" alt="" >
	 * @param x x-coordinate of end point
	 * @param y y-coordinate of end point
	 * @param color line color
	 * @return the line
	 */
	public static Image line(double x, double y, Color color) {
		return new Line(x, y, pen(color));
	}

	/**
	 * {@code Image i = line(50, 20, "red");}<br>
	 * <img src="./doc-files/line(50,20,red).png" alt="" >
	 * @param x x-coordinate of end point
	 * @param y y-coordinate of end point
	 * @param color line color (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the line
	 */
	public static Image line(double x, double y, String color) {
		return new Line(x, y, pen(color));
	}
	
	/**
	 * {@code Image i = line(50, 20, pen("black"));}<br>
	 * <img src="./doc-files/line(50,20,pen(black)).png" alt="" >
	 * @param x x-coordinate of end point
	 * @param y y-coordinate of end point
	 * @param pen pen for drawing the outline
	 * @return the line
	 */
	public static Image line(double x, double y, Pen pen) {
		return new Line(x, y, pen);
	}

	/**
	 * {@code Image i = line(50, 20, "red", 0.5);}<br>
	 * <img src="./doc-files/line(50,20,red,0.5).png" alt="" >
	 * @param x x-coordinate of end point
	 * @param y y-coordinate of end point
	 * @param color line color (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @return the line
	 */
	public static Image line(double x, double y, String color, double opacity) {
		return new Line(x, y, pen(color, opacity));
	}
	
	/**
	 * {@code Image i = line(square(40, "yellow"), 0, 20, 40, 40, color(0, 0, 255));}<br>
	 * <img src="./doc-files/line(square(40,yellow),0,20,40,40,color(0,0,255)).png" alt="" >
	 * @param image background image
	 * @param x1 x-coordinate of start point
	 * @param y1 y-coordinate of start point
	 * @param x2 x-coordinate of end point
	 * @param y2 y-coordinate of end point
	 * @param color line color (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the line
	 */
	public static Image line(Image image, double x1, double y1, double x2, double y2, Color color) {
		return new ImageLine(image, x1, y1, x2, y2, pen(color));
	}
	
	/**
	 * {@code Image i = line(square(40, "yellow"), 0, 20, 40, 40, pen("blue", 3));}<br>
	 * <img src="./doc-files/line(square(40,yellow),0,20,40,40,pen(blue,3)).png" alt="" >
	 * @param image background image
	 * @param x1 x-coordinate of start point
	 * @param y1 y-coordinate of start point
	 * @param x2 x-coordinate of end point
	 * @param y2 y-coordinate of end point
	 * @param pen pen pen for drawing the line
	 * @return the line
	 */
	public static Image line(Image image, double x1, double y1, double x2, double y2, Pen pen) {
		return new ImageLine(image, x1, y1, x2, y2, pen);
	}
	
	/**
	 * {@code Image i = line(square(40, "yellow"), 0, 20, 40, 40, "blue");}<br>
	 * <img src="./doc-files/line(square(40,yellow),0,20,40,40,blue).png" alt="" >
	 * @param image background image
	 * @param x1 x-coordinate of start point
	 * @param y1 y-coordinate of start point
	 * @param x2 x-coordinate of end point
	 * @param y2 y-coordinate of end point
	 * @param color line color (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the line
	 */
	public static Image line(Image image, double x1, double y1, double x2, double y2, String color) {
		return new ImageLine(image, x1, y1, x2, y2, pen(color));
	}
	
	/**
	 * {@code Image i = line(square(40, "yellow"), 0, 20, 40, 40, "blue", 0.5);}<br>
	 * <img src="./doc-files/line(square(40,yellow),0,20,40,40,blue,0.5).png" alt="" >
	 * @param image background image
	 * @param x1 x-coordinate of start point
	 * @param y1 y-coordinate of start point
	 * @param x2 x-coordinate of end point
	 * @param y2 y-coordinate of end point
	 * @param color line color (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @return the line
	 */
	public static Image line(Image image, double x1, double y1, double x2, double y2, String color, double opacity) {
		return new ImageLine(image, x1, y1, x2, y2, pen(color, opacity));
	}

	/**
	 * {@code Image i = line(20, 20, 60, 40, "blue", square(40, "yellow"));}<br>
	 * <img src="./doc-files/line(20,20,60,40,blue,square(40,yellow)).png" alt="" >
	 * @param x1 x-coordinate of start point
	 * @param y1 y-coordinate of start point
	 * @param x2 x-coordinate of end point
	 * @param y2 y-coordinate of end point
	 * @param color line color (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param image background image
	 * @return the line
	 */
	public static Image line(double x1, double y1, double x2, double y2, String color, Image image) {
		return new ImageLine(x1, y1, x2, y2, pen(color), image);
	}
	
	/**
	 * {@code Image i = line(20, 20, 60, 40, "blue", 0.5, square(40, "yellow"));}<br>
	 * <img src="./doc-files/line(20,20,60,40,blue,0.5,square(40,yellow)).png" alt="" >
	 * @param x1 x-coordinate of start point
	 * @param y1 y-coordinate of start point
	 * @param x2 x-coordinate of end point
	 * @param y2 y-coordinate of end point
	 * @param color line color (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @param image background image
	 * @return the line
	 */
	public static Image line(double x1, double y1, double x2, double y2, String color, double opacity, Image image) {
		return new ImageLine(x1, y1, x2, y2, pen(color, opacity), image);
	}

	/**
	 * {@code Image i = triangle(50, color(255, 0, 0));}<br>
	 * <img src="./doc-files/triangle(50,color(255,0,0)).png" alt="" >
	 * @param length side length
	 * @param fillColor color for filling the interior
	 * @return the triangle
	 */
	public static Image triangle(double length, Color fillColor) {
		return new Triangle(length, fillColor, null);
	}

	/**
	 * {@code Image i = triangle(50, color(255, 0, 0), pen("black"));}<br>
	 * <img src="./doc-files/triangle(50,color(255,0,0),pen(black)).png" alt="" >
	 * @param length side length
	 * @param fillColor color for filling the interior
	 * @param pen pen for drawing the outline
	 * @return the triangle
	 */
	public static Image triangle(double length, Color fillColor, Pen pen) {
		return new Triangle(length, fillColor, pen);
	}

	/**
	 * {@code Image i = triangle(50, pen("black"));}<br>
	 * <img src="./doc-files/triangle(50,pen(black)).png" alt="" >
	 * @param length side length
	 * @param pen pen for drawing the outline
	 * @return the triangle
	 */
	public static Image triangle(double length, Pen pen) {
		return new Triangle(length, null, pen);
	}

	/**
	 * {@code Image i = triangle(50, "red");}<br>
	 * <img src="./doc-files/triangle(50,red).png" alt="" >
	 * @param length side length
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the triangle
	 */
	public static Image triangle(double length, String fillColor) {
		return new Triangle(length, color(fillColor), null);
	}

	/**
	 * {@code Image i = triangle(50, "red", pen("black", 3));}<br>
	 * <img src="./doc-files/triangle(50,red,pen(black,3)).png" alt="" >
	 * @param length side length
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the triangle
	 */
	public static Image triangle(double length, String fillColor, Pen pen) {
		return new Triangle(length, color(fillColor), pen);
	}

	/**
	 * {@code Image i = triangle(50, "red", 0.5);}<br>
	 * <img src="./doc-files/triangle(50,red,0.5).png" alt="" >
	 * @param length side length
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @return the triangle
	 */
	public static Image triangle(double length, String fillColor, double opacity) {
		return new Triangle(length, color(fillColor, opacity), null);
	}

	/**
	 * {@code Image i = triangle(50, "red", 0.5, pen("black"));}<br>
	 * <img src="./doc-files/triangle(50,red,0.5,pen(black)).png" alt="" >
	 * @param length side length
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @param pen pen for drawing the outline
	 * @return the triangle
	 */
	public static Image triangle(double length, String fillColor, double opacity, Pen pen) {
		return new Triangle(length, color(fillColor, opacity), pen);
	}

	/**
	 * {@code Image i = rightTriangle(50, 30, "red");}<br>
	 * <img src="./doc-files/rightTriangle(50,30,red).png" alt="" >
	 * @param width the base width
	 * @param height the height
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the triangle
	 */
	public static Image rightTriangle(double width, double height, String fillColor) {
		return new RightTriangle(width, height, color(fillColor), null);
	}

	/**
	 * {@code Image i = rightTriangle(50, 30, pen("black"));}<br>
	 * <img src="./doc-files/rightTriangle(50,30,pen(black)).png" alt="" >
	 * @param width the base width
	 * @param height the height
	 * @param pen pen for drawing the outline
	 * @return the triangle
	 */
	public static Image rightTriangle(double width, double height, Pen pen) {
		return new RightTriangle(width, height, null, pen);
	}

	/**
	 * {@code Image i = rightTriangle(50, 30, "red", pen("black"));}<br>
	 * <img src="./doc-files/rightTriangle(50,30,red,pen(black)).png" alt="" >
	 * @param width the base width
	 * @param height the height
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the triangle
	 */
	public static Image rightTriangle(double width, double height, String fillColor, Pen pen) {
		return new RightTriangle(width, height, color(fillColor), pen);
	}

	/**
	 * {@code Image i = rightTriangle(50, 30, "red", 0.5, pen("black"));}<br>
	 * <img src="./doc-files/rightTriangle(50,30,red,0.5,pen(black)).png" alt="" >
	 * @param width the base width
	 * @param height the height
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @param pen pen for drawing the outline
	 * @return the triangle
	 */
	public static Image rightTriangle(double width, double height, String fillColor, double opacity, Pen pen) {
		return new RightTriangle(width, height, color(fillColor, opacity), pen);
	}
	
	/**
	 * {@code Image i = isoscelesTriangle(50, 30, "red");}<br>
	 * <img src="./doc-files/isoscelesTriangle(50,30,red).png" alt="" >
	 * @param length side length
	 * @param alpha opening angle
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the triangle
	 */
	public static Image isoscelesTriangle(double length, double alpha, String fillColor) {
		return new IsoscelesTriangle(length, alpha, color(fillColor), null);
	}

	/**
	 * {@code Image i = isoscelesTriangle(50, 30, "red", pen("black"));}<br>
	 * <img src="./doc-files/isoscelesTriangle(50,30,red,pen(black)).png" alt="" >
	 * @param length side length
	 * @param alpha opening angle
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the triangle
	 */
	public static Image isoscelesTriangle(double length, double alpha, String fillColor, Pen pen) {
		return new IsoscelesTriangle(length, alpha, color(fillColor), pen);
	}

	/**
	 * {@code Image i = isoscelesTriangle(50, 30, color(255, 0, 0), pen("black"));}<br>
	 * <img src="./doc-files/isoscelesTriangle(50,30,color(255,0,0),pen(black)).png" alt="" >
	 * @param length side length
	 * @param alpha opening angle
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the triangle
	 */
	public static Image isoscelesTriangle(double length, double alpha, Color fillColor, Pen pen) {
		return new IsoscelesTriangle(length, alpha, fillColor, pen);
	}

	/**
	 * {@code Image i = isoscelesTriangle(50, 30, pen("black"));}<br>
	 * <img src="./doc-files/isoscelesTriangle(50,30,pen(black)).png" alt="" >
	 * @param length side length
	 * @param alpha opening angle
	 * @param pen pen for drawing the outline
	 * @return the triangle
	 */
	public static Image isoscelesTriangle(double length, double alpha, Pen pen) {
		return new IsoscelesTriangle(length, alpha, null, pen);
	}

	/**
	 * {@code Image i = star(25, "red");}<br>
	 * <img src="./doc-files/star(25,red).png" alt="" >
	 * @param radius radius
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the star
	 */
	public static Image star(double radius, String fillColor) {
		return new Star(radius, color(fillColor), null);
	}

	/**
	 * {@code Image i = star(25, "red", pen("black"));}<br>
	 * <img src="./doc-files/star(25,red,pen(black)).png" alt="" >
	 * @param radius radius
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the star
	 */
	public static Image star(double radius, String fillColor, Pen pen) {
		return new Star(radius, color(fillColor), pen);
	}

	/**
	 * {@code Image i = star(25, pen("black"));}<br>
	 * <img src="./doc-files/star(25,pen(black)).png" alt="" >
	 * @param radius radius
	 * @param pen pen for drawing the outline
	 * @return the star
	 */
	public static Image star(double radius, Pen pen) {
		return new Star(radius, null, pen);
	}

	/**
	 * {@code Image i = star(25.0, 10, 3, "red");}<br>
	 * <img src="./doc-files/star(25.0,10,3,red).png" alt="" >
	 * @param radius radius
	 * @param sides number of sides
	 * @param steps connect every steps-th spike
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the star
	 */
	public static Image star(double radius, int sides, int steps, String fillColor) {
		return new StarPolygon(radius, sides, steps, color(fillColor), null);
	}

	/**
	 * {@code Image i = star(25.0, 10, 3, "red", pen("black"));}<br>
	 * <img src="./doc-files/star(25.0,10,3,red,pen(black)).png" alt="" >
	 * @param radius radius
	 * @param sides number of sides
	 * @param steps connect every steps-th spike
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the star
	 */
	public static Image star(double radius, int sides, int steps, String fillColor, Pen pen) {
		return new StarPolygon(radius, sides, steps, color(fillColor), pen);
	}

	/**
	 * {@code Image i = star(25.0, 10, 3, pen("black"));}<br>
	 * <img src="./doc-files/star(25.0,10,3,pen(black)).png" alt="" >
	 * @param radius radius
	 * @param sides number of sides
	 * @param steps connect every steps-th spike
	 * @param pen pen for drawing the outline
	 * @return the star
	 */
	public static Image star(double radius, int sides, int steps, Pen pen) {
		return new StarPolygon(radius, sides, steps, null, pen);
	}

	/**
	 * {@code Image i = star(25.0, 10, 3, color(255, 0, 0), pen("black"));}<br>
	 * <img src="./doc-files/star(25.0,10,3,color(255,0,0),pen(black)).png" alt="" >
	 * @param radius radius
	 * @param sides number of sides
	 * @param steps connect every steps-th spike
	 * @param fillColor color for filling the interior
	 * @param pen pen for drawing the outline
	 * @return the star
	 */
	public static Image star(double radius, int sides, int steps, Color fillColor, Pen pen) {
		return new StarPolygon(radius, sides, steps, fillColor, pen);
	}

	/**
	 * {@code Image i = star(19, 18.0, 25.0, "red");}<br>
	 * <img src="./doc-files/star(19,18.0,25.0,red).png" alt="" >
	 * @param spikes number of spikes
	 * @param innerRadius inner star radius
	 * @param outerRadius outer star radius
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the star
	 */
	public static Image star(int spikes, double innerRadius, double outerRadius, String fillColor) {
		return new StarRadial(spikes, innerRadius, outerRadius, color(fillColor), null);
	}
	
	/**
	 * {@code Image i = star(19, 18.0, 25.0, "red", pen("black"));}<br>
	 * <img src="./doc-files/star(19,18.0,25.0,red,pen(black)).png" alt="" >
	 * @param spikes number of spikes
	 * @param innerRadius inner star radius
	 * @param outerRadius outer star radius
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the star
	 */
	public static Image star(int spikes, double innerRadius, double outerRadius, String fillColor, Pen pen) {
		return new StarRadial(spikes, innerRadius, outerRadius, color(fillColor), pen);
	}
	
	/**
	 * {@code Image i = star(19, 18.0, 25.0, color(255, 0, 0), pen("black"));}<br>
	 * <img src="./doc-files/star(19,18.0,25.0,color(255,0,0),pen(black)).png" alt="" >
	 * @param spikes number of spikes
	 * @param innerRadius inner star radius
	 * @param outerRadius outer star radius
	 * @param fillColor color for filling the interior
	 * @param pen pen for drawing the outline
	 * @return the star
	 */
	public static Image star(int spikes, double innerRadius, double outerRadius, Color fillColor, Pen pen) {
		return new StarRadial(spikes, innerRadius, outerRadius, fillColor, pen);
	}
	
	/**
	 * {@code Image i = star(19, 18.0, 25.0, pen("black"));}<br>
	 * <img src="./doc-files/star(19,18.0,25.0,pen(black)).png" alt="" >
	 * @param spikes number of spikes
	 * @param innerRadius inner star radius
	 * @param outerRadius outer star radius
	 * @param pen pen for drawing the outline
	 * @return the star
	 */
	public static Image star(int spikes, double innerRadius, double outerRadius, Pen pen) {
		return new StarRadial(spikes, innerRadius, outerRadius, null, pen);
	}
	
	/**
	 * {@code Image i = polygon(array(0.0, -10, 30, 0, 60, -5, 20, 10), "red", pen("black"));}<br>
	 * <img src="./doc-files/polygon(array(0.0,-10,30,0,60,-5,20,10),red,pen(black)).png" alt="" >
	 * @param points a sequence of (x, y) points
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the polygon
	 */
	public static Image polygon(double[] points, String fillColor, Pen pen) {
		return new Polygon(points, color(fillColor), pen);
	}
	
	/**
	 * {@code Image i = polygon(array(0.0, -10, 30, 0, 60, -5, 20, 10), pen("black"));}<br>
	 * <img src="./doc-files/polygon(array(0.0,-10,30,0,60,-5,20,10),pen(black)).png" alt="" >
	 * @param points a sequence of (x, y) points
	 * @param pen pen for drawing the outline
	 * @return the polygon
	 */
	public static Image polygon(double[] points, Pen pen) {
		return new Polygon(points, null, pen);
	}
	
	/**
	 * {@code Image i = polygon(array(0.0, -10, 30, 0, 60, -5, 20, 10), "red");}<br>
	 * <img src="./doc-files/polygon(array(0.0,-10,30,0,60,-5,20,10),red).png" alt="" >
	 * @param points a sequence of (x, y) points
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the polygon
	 */
	public static Image polygon(double[] points, String fillColor) {
		return new Polygon(points, color(fillColor), null);
	}
	
	/**
	 * {@code Image i = polygon(array(0.0, -10, 30, 0, 60, -5, 20, 10), "red", 0.5, pen("black"));}<br>
	 * <img src="./doc-files/polygon(array(0.0,-10,30,0,60,-5,20,10),red,0.5,pen(black)).png" alt="" >
	 * @param points a sequence of (x, y) points
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @param pen pen for drawing the outline
	 * @return the polygon
	 */
	public static Image polygon(double[] points, String fillColor, double opacity, Pen pen) {
		return new Polygon(points, color(fillColor, opacity), pen);
	}
	
	/**
	 * {@code Image i = polygon(array(0.0, -10, 30, 0, 60, -5, 20, 10), "red", 0.5);}<br>
	 * <img src="./doc-files/polygon(array(0.0,-10,30,0,60,-5,20,10,0.5),red).png" alt="" >
	 * @param points a sequence of (x, y) points
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @return the polygon
	 */
	public static Image polygon(double[] points, String fillColor, double opacity) {
		return new Polygon(points, color(fillColor, opacity), null);
	}
	
	/**
	 * {@code Image i = polygon(rectangle(60, 20, "lightblue"), array(0.0, -10, 30, 0, 60, -5, 20, 10), "red");}<br>
	 * <img src="./doc-files/polygon(rectangle(60,20,lightblue),array(0.0,-10,30,0,60,-5,20,10),red).png" alt="" >
	 * @param image background image
	 * @param points a sequence of (x, y) points
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the polygon
	 */
	public static Image polygon(Image image, double[] points, String fillColor) {
		return new ImagePolygon(image, points, color(fillColor), null);
	}

	/**
	 * {@code Image i = polyline(array(0.0, -10, 30, 0, 60, -5, 20, 10), "red", pen("black"));}<br>
	 * <img src="./doc-files/polyline(array(0.0,-10,30,0,60,-5,20,10),red,pen(black)).png" alt="" >
	 * @param points a sequence of (x, y) points
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the polyline
	 */
	public static Image polyline(double[] points, String fillColor, Pen pen) {
		return new Polyline(points, color(fillColor), pen);
	}
	
	/**
	 * {@code Image i = polyline(array(0.0, -10, 30, 0, 60, -5, 20, 10), "red");}<br>
	 * <img src="./doc-files/polyline(array(0.0,-10,30,0,60,-5,20,10),red).png" alt="" >
	 * @param points a sequence of (x, y) points
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the polyline
	 */
	public static Image polyline(double[] points, String fillColor) {
		return new Polyline(points, null, pen(fillColor));
	}
	
	/**
	 * {@code Image i = polyline(array(0.0, -10, 30, 0, 60, -5, 20, 10), pen("black"));}<br>
	 * <img src="./doc-files/polyline(array(0.0,-10,30,0,60,-5,20,10),pen(black)).png" alt="" >
	 * @param points a sequence of (x, y) points
	 * @param pen pen for drawing the outline
	 * @return the polyline
	 */
	public static Image polyline(double[] points, Pen pen) {
		return new Polyline(points, null, pen);
	}

	/**
	 * {@code Image i = polyline(rectangle(60, 20, "lightblue"), array(0.0, -10, 30, 0, 60, -5, 20, 10), "red");}<br>
	 * <img src="./doc-files/polyline(rectangle(60,20,lightblue),array(0.0,-10,30,0,60,-5,20,10),red).png" alt="" >
	 * @param image background image
	 * @param points a sequence of (x, y) points
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the polyline
	 */
	public static Image polyline(Image image, double[] points, String fillColor) {
		return new ImagePolyline(image, points, null, pen(fillColor));
	}

	/**
	 * {@code Image i = text("hello", 36, "red");}<br>
	 * <img src="./doc-files/text(hello,36,red).png" alt="" >
	 * @param string the text string
	 * @param fontSize the font size
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the text
	 */
	public static Image text(String string, double fontSize, String fillColor) {
		return new Text(string, fontSize, color(fillColor), null, 0, TextAlignment.LEFT);
	}
	
	public static Image text(String string, double fontSize, Color fillColor) {
		return new Text(string, fontSize, fillColor, null, 0, TextAlignment.LEFT);
	}
	
	/**
	 * {@code Image i = text("hello", 36, "red", pen("black"));}<br>
	 * <img src="./doc-files/text(hello,36,red,pen(black)).png" alt="" >
	 * @param string the text string
	 * @param fontSize the font size
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the text
	 */
	public static Image text(String string, double fontSize, String fillColor, Pen pen) {
		return new Text(string, fontSize, color(fillColor), pen, 0, TextAlignment.LEFT);
	}
	
	/**
	 * {@code Image i = text("hello", 36, pen("black"));}<br>
	 * <img src="./doc-files/text(hello,36,pen(black)).png" alt="" >
	 * @param string the text string
	 * @param fontSize the font size
	 * @param pen pen for drawing the outline
	 * @return the text
	 */
	public static Image text(String string, double fontSize, Pen pen) {
		return new Text(string, fontSize, null, pen, 0, TextAlignment.LEFT);
	}
	
	/**
	 * {@code Image i = text("hello", "Consolas", 36, "red");}<br>
	 * <img src="./doc-files/text(hello,Consolas,36,red).png" alt="" >
	 * @param string the text string
	 * @param fontName the name of the font
	 * @param fontSize the font size
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the text
	 */
	public static Image text(String string, String fontName, double fontSize, String fillColor) {
		return new Text(string, fontName, fontSize, color(fillColor), null, 0, TextAlignment.LEFT);
	}
	
	/**
	 * {@code Image i = text("hello", "Consolas", 36, "red", pen("black"));}<br>
	 * <img src="./doc-files/text(hello,Consolas,36,red,pen(black)).png" alt="" >
	 * @param string the text string
	 * @param fontName the name of the font
	 * @param fontSize the font size
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the text
	 */
	public static Image text(String string, String fontName, double fontSize, String fillColor, Pen pen) {
		return new Text(string, fontName, fontSize, color(fillColor), pen, 0, TextAlignment.LEFT);
	}
	
	/**
	 * {@code Image i = text("hello", "Consolas", 36, pen("black"));}<br>
	 * <img src="./doc-files/text(hello,Consolas,36,pen(black)).png" alt="" >
	 * @param string the text string
	 * @param fontName the name of the font
	 * @param fontSize the font size
	 * @param pen pen for drawing the outline
	 * @return the text
	 */
	public static Image text(String string, String fontName, double fontSize, Pen pen) {
		return new Text(string, fontName, fontSize, null, pen, 0, TextAlignment.LEFT);
	}
	
	/**
	 * Load a bitmap image (png, gif, or jpg) from the given location. The 
	 * bitmap may be located in the local file system or on the Web.
	 * {@code Image i = bitmap("http://www.uni-hannover.de/fileadmin/t3luhtemplate/header/luh-logo.gif");}<br>
	 * <img src="./doc-files/bitmap(luh-logo.gif).png" alt="" >
	 * @param url the location of the image file (png, gif, or jpg).
	 * @return the loaded image
	 */
	public static Image bitmap(String url) {
		return new Bitmap(url);
	}
	
	/**
	 * Create a 1-pixel wide pen of the given color.
	 * @param color the color (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the pen
	 */
	public static Pen pen(String color) {
		return new Pen(color);
	}

	/**
	 * Create a 1-pixel wide pen of the given color.
	 * @param color the color
	 * @return the pen
	 */
	public static Pen pen(Color color) {
		return new Pen(color);
	}

	/**
	 * Create pen of the given color and width.
	 * @param color the color (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param width pen width
	 * @return the pen
	 */
	public static Pen pen(String color, double width) {
		return new Pen(color, width);
	}

	/**
	 * Create pen of the given color and width.
	 * @param color the color
	 * @param width pen width
	 * @return the pen
	 */
	public static Pen pen(Color color, double width) {
		return new Pen(color, width);
	}

	/**
	 * Create pen of the given color, width, and stroke type. The following stroke types are possible:
	 * <ul>
	 * <li>StrokeType.CENTERED (default: pen is centered on shape boundary)
	 * <li>StrokeType.INSIDE (pen draws inside shape boundary)
	 * <li>StrokeType.OUTSIDE (pen draws outside of shape boundary)
	 * </ul>
	 * 
	 * @param color the color (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param width pen width
	 * @param type stroke type
	 * @return the pen
	 */
	public static Pen pen(String color, double width, StrokeType type) {
		return new Pen(color, width, type);
	}

	/**
	 * Create pen of the given color, width, and stroke type. The following stroke types are possible:
	 * <ul>
	 * <li>StrokeType.CENTERED (default: pen is centered on shape boundary)
	 * <li>StrokeType.INSIDE (pen draws inside shape boundary)
	 * <li>StrokeType.OUTSIDE (pen draws outside of shape boundary)
	 * </ul>
	 * 
	 * @param color the color
	 * @param width pen width
	 * @param type stroke type
	 * @return the pen
	 */
	public static Pen pen(Color color, double width, StrokeType type) {
		return new Pen(color, width, type);
	}

	/**
	 * Create pen of the given color, width, and stroke type. The following stroke types are possible:
	 * <ul>
	 * <li>StrokeType.CENTERED (default: pen is centered on shape boundary)
	 * <li>StrokeType.INSIDE (pen draws inside shape boundary)
	 * <li>StrokeType.OUTSIDE (pen draws outside of shape boundary)
	 * </ul>
	 * 
	 * These line endings are possible:
	 * <ul>
	 * <li>StrokeLineCap.SQUARE (default: pen draws half its width beyond end of unclosed shapes)
	 * <li>StrokeLineCap.BUTT (pen does not draw beyond end of unclosed shapes)
	 * <li>StrokeLineCap.ROUND (ends of unclosed shapes are rounded)
	 * </ul>
	 * 
	 * These corners are possible:
	 * <ul>
	 * <li>StrokeLineJoin.MITER (default: extends outside edges of segments)
	 * <li>StrokeLineJoin.BEVEL (joins outside corners of segments by straight edges)
	 * <li>StrokeLineJoin.ROUND (joins outside edges at a radius of half the pen width)
	 * </ul>
	 * 
	 * @param color the color
	 * @param width pen width
	 * @param type determines where the shape draws
	 * @param cap determines how ends of lines are drawn
	 * @param join determines how corners are drawn
	 * @return the pen
	 */
	public static Pen pen(Color color, double width, StrokeType type, StrokeLineCap cap, StrokeLineJoin join) {
		return new Pen(color, width, type, cap, join);
	}

	/**
	 * Create pen of the given color, width, and stroke type. The following stroke types are possible:
	 * <ul>
	 * <li>StrokeType.CENTERED (default: pen is centered on shape boundary)
	 * <li>StrokeType.INSIDE (pen draws inside shape boundary)
	 * <li>StrokeType.OUTSIDE (pen draws outside of shape boundary)
	 * </ul>
	 * 
	 * These line endings are possible:
	 * <ul>
	 * <li>StrokeLineCap.SQUARE (default: pen draws half its width beyond end of unclosed shapes)
	 * <li>StrokeLineCap.BUTT (pen does not draw beyond end of unclosed shapes)
	 * <li>StrokeLineCap.ROUND (ends of unclosed shapes are rounded)
	 * </ul>
	 * 
	 * These corners are possible:
	 * <ul>
	 * <li>StrokeLineJoin.MITER (default: extends outside edges of segments)
	 * <li>StrokeLineJoin.BEVEL (joins outside corners of segments by straight edges)
	 * <li>StrokeLineJoin.ROUND (joins outside edges at a radius of half the pen width)
	 * </ul>
	 * 
	 * @param color the color (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param width pen width
	 * @param type determines where the shape draws
	 * @param cap determines how ends of lines are drawn
	 * @param join determines how corners are drawn
	 * @return the pen
	 */
	public static Pen pen(String color, double width, StrokeType type, StrokeLineCap cap, StrokeLineJoin join) {
		return new Pen(color, width, type, cap, join);
	}

//	 * Put the images next to each other, vertically centered w.r.t to each other:<br>
	/**
	 * {@code Image i = beside(circle(25, "red"), circle(12.5, "green"));}<br>
	 * <img src="./doc-files/beside(circle(25,red),circle(12.5,green)).png" alt="" >
	 * @param images the images to process
	 * @return the result
	 */
	public static Image beside(Image... images) {
		return beside("center", images);
	}
	
	/**
	 * {@code Image i = beside("top", circle(25, "red"), circle(12.5, "green"));}<br>
	 * <img src="./doc-files/beside(top,circle(25,red),circle(12.5,green)).png" alt="" ><br>
	 * {@code Image i = beside("center", circle(25, "red"), circle(12.5, "green"));}<br>
	 * <img src="./doc-files/beside(center,circle(25,red),circle(12.5,green)).png" alt="" ><br>
	 * {@code Image i = beside("bottom", circle(25, "red"), circle(12.5, "green"));}<br>
	 * <img src="./doc-files/beside(bottom,circle(25,red),circle(12.5,green)).png" alt="" >
	 * @param align vertical alignment: top, middle, center, bottom
	 * @param images the images to process
	 * @return the result
	 */
	public static Image beside(String align, Image... images) {
		Group g = new Group();
		for (Image image : images) {
			g.add(image, g.width, 0);
		}
		if (null != align) switch (align) {
			case "middle":
			case "center":
				for (Child c : g.children) {
					c.y = (g.height - c.height) / 2.0;
				}	break;
			case "bottom":
				for (Child c : g.children) {
					c.y = g.height - c.height;
				}	break;
		}
		return g;
	}
	
	/**
	 * Put some of the images of an array next to each other.
	 * @param images the images to process
	 * @param start start index (inclusive)
	 * @param end end index (exclusive)
	 * @return the images of the range next to each other
	 */
	public static Image beside(Image[] images, int start, int end) {
		Image[] sub = new Image[end - start];
		System.arraycopy(images, start, sub, 0, end - start);
		return beside("center", sub);
	}
	
	/**
	 * Put some of the images of an array next to each other using the given alignment.
	 * @param align vertical alignment: top, middle, center, bottom
	 * @param images the images to process
	 * @param start start index (inclusive)
	 * @param end end index (exclusive)
	 * @return the images of the range next to each other
	 */
	public static Image beside(String align, Image[] images, int start, int end) {
		Image[] sub = new Image[end - start];
		System.arraycopy(images, start, sub, 0, end - start);
		return beside(align, sub);
	}
	
	/**
	 * {@code Image i = above(circle(25, "red"), circle(12.5, "green"));}<br>
	 * <img src="./doc-files/above(circle(25,red),circle(12.5,green)).png" alt="" >
	 * @param images the images to process
	 * @return the result
	 */
	public static Image above(Image... images) {
		return above("center", images);
	}
	
	/**
	 * {@code Image i = above("left", circle(25, "red"), circle(12.5, "green"));}<br>
	 * <img src="./doc-files/above(left,circle(25,red),circle(12.5,green)).png" alt="" ><br>
	 * {@code Image i = above("center", circle(25, "red"), circle(12.5, "green"));}<br>
	 * <img src="./doc-files/above(center,circle(25,red),circle(12.5,green)).png" alt="" ><br>
	 * {@code Image i = above("right", circle(25, "red"), circle(12.5, "green"));}<br>
	 * <img src="./doc-files/above(right,circle(25,red),circle(12.5,green)).png" alt="" >
	 * @param align horizontal alignment: left, middle, center, right
	 * @param images the images to process
	 * @return the result
	 */
	public static Image above(String align, Image... images) {
		Group g = new Group();
		for (Image image : images) {
			g.add(image, 0, g.height);
		}
		if (null != align) switch (align) {
			case "middle":
			case "center":
				for (Child c : g.children) {
					c.x = (g.width - c.width) / 2.0;
				}	break;
			case "right":
				for (Child c : g.children) {
					c.x = g.width - c.width;
				}	break;
		}
		return g;
	}
	
	/**
	 * Put some of the images of an array above each other.
	 * @param images the images to process
	 * @param start start index (inclusive)
	 * @param end end index (exclusive)
	 * @return the images of the range above each other
	 */
	public static Image above(Image[] images, int start, int end) {
		Image[] sub = new Image[end - start];
		System.arraycopy(images, start, sub, 0, end - start);
		return above("center", sub);
	}
	
	/**
	 * Put some of the images of an array above each other using the given alignment.
	 * @param align horizontal alignment: left, middle, center, right
	 * @param images the images to process
	 * @param start start index (inclusive)
	 * @param end end index (exclusive)
	 * @return the images of the range above each other
	 */
	public static Image above(String align, Image[] images, int start, int end) {
		Image[] sub = new Image[end - start];
		System.arraycopy(images, start, sub, 0, end - start);
		return above(align, sub);
	}
	
	/**
	 * {@code Image i = overlay(circle(12.5, "green"), circle(25, "red"));}<br>
	 * <img src="./doc-files/overlay(circle(12.5,green),circle(25,red)).png" alt="" >
	 * @param images the images to process
	 * @return the overlaid images
	 */
	public static Image overlay(Image... images) {
		return overlay("center", "center", images);
	}
	
	/**
	 * {@code Image i = overlay("left", "top", circle(12.5, "green"), circle(25, "red"));}<br>
	 * <img src="./doc-files/overlay(left,top,circle(12.5,green),circle(25,red)).png" alt="" ><br>
	 * {@code Image i = overlay("right", "center", circle(12.5, "green"), circle(25, "red"));}<br>
	 * <img src="./doc-files/overlay(right,center,circle(12.5,green),circle(25,red)).png" alt="" ><br>
	 * {@code Image i = overlay("right", "bottom", circle(12.5, "green"), circle(25, "red"));}<br>
	 * <img src="./doc-files/overlay(circle(right,bottom,12.5,green),circle(25,red)).png" alt="" ><br>
	 * @param xAlign horizontal alignment: left, middle, center, right
	 * @param yAlign vertical alignment: top, middle, center, bottom
	 * @param images the images to process
	 * @return the overlaid images
	 */
	public static Image overlay(String xAlign, String yAlign, Image... images) {
		Group g = new Group();
		for (int i = images.length - 1; i >= 0; i--) {
			Image image = images[i];
			g.add(image, 0, 0);
		}
		if (null != xAlign) switch (xAlign) {
			case "center":
			case "middle":
				for (Child c : g.children) {
					c.x = (g.width - c.width) / 2.0;
				}	break;
			case "right":
				for (Child c : g.children) {
					c.x = g.width - c.width;
				}	break;
		}
		if (null != yAlign) switch (yAlign) {
			case "center":
			case "middle":
				for (Child c : g.children) {
					c.y = (g.height - c.height) / 2.0;
				}	break;
			case "bottom":
				for (Child c : g.children) {
					c.y = g.height - c.height;
				}	break;
		}
		return g;
	}
		
	/**
	 * {@code Image i = overlay(20, 10, square(40, "green"), square(40, "red"));}<br>
	 * <img src="./doc-files/overlay(20,10,square(40,green),square(40,red)).png" alt="" >
	 * @param dx shift between images in x-direction
	 * @param dy shift between images in y-direction
	 * @param images the images to process
	 * @return the overlaid images
	 */
	public static Image overlay(double dx, double dy, Image... images) {
		return overlay("center", "center", dx, dy, images);
	}

	/**
	 * {@code Image i = overlay("left", "center", 10, 0, square(20, "green"), square(40, "red"));}<br>
	 * <img src="./doc-files/overlay(left,center,10,0,square(20,green),square(40,red)).png" alt="" >
	 * @param xAlign horizontal alignment: left, middle, center, right
	 * @param yAlign vertical alignment: top, middle, center, bottom
	 * @param dx shift between images in x-direction
	 * @param dy shift between images in x-direction
	 * @param images the images to process
	 * @return the overlaid images
	 */
	public static Image overlay(String xAlign, String yAlign, double dx, double dy, Image... images) {
		Group g = new Group();
		for (int i = images.length - 1; i >= 0; i--) {
			g.add(images[i], 0, 0);
		}
		double x = 0.0, y = 0.0; // position of next image
		
		if (null != xAlign) switch (xAlign) {
			case "left":
				for (Child c : g.children) {
					c.x = x;
					x -= dx;
				}	break;
			case "center":
			case "middle":
				for (Child c : g.children) {
					c.x = x - c.width / 2.0;
					x -= dx;
				}	break;
			case "right":
				for (Child c : g.children) {
					c.x = x - c.width;
					x -= dx;
			}	break;
		}

		if (null != yAlign) switch (yAlign) {
			case "top":
				for (Child c : g.children) {
					c.y = y;
					y -= dy;
				}	break;
			case "center":
			case "middle":
				for (Child c : g.children) {
					c.y = y - c.height / 2.0;
					y -= dy;
				}	break;
			case "bottom":
				for (Child c : g.children) {
					c.y = y - c.height;
					y -= dy;
			}	break;
		}
		
		int n = g.children.size();
		if (n > 0) {
			Child c = g.get(0);
			double x1 = c.x; // bounding box
			double y1 = c.y;
			double x2 = c.x + c.width;
			double y2 = c.y + c.height;
			for (int i = 1; i < n; i++) {
				c = g.get(i);
				x1 = Math.min(x1, c.x);
				y1 = Math.min(y1, c.y);
				x2 = Math.max(x2, c.x + c.width);
				y2 = Math.max(y2, c.y + c.height);
			}
			for (int i = 0; i < n; i++) {
				c = g.get(i);
				c.x -= x1;
				c.y -= y1;
			}
			g.width = x2 - x1;
			g.height = y2 - y1;
		}
		return g;
	}

	/**
	 * {@code Image i = underlay(square(40, "red"), square(20, "green"));}<br>
	 * <img src="./doc-files/underlay(square(40,red),square(20,green)).png" alt="" >
	 * @param images the images to process
	 * @return the overlaid images
	 */
	public static Image underlay(Image... images) {
		return underlay("center", "center", images);
	}
	
	/**
	 * {@code Image i = underlay("left", "center", square(40, "red"), square(20, "green"));}<br>
	 * <img src="./doc-files/underlay(left,center,square(40,red),square(20,green)).png" alt="" >
	 * @param xAlign horizontal alignment: left, middle, center, right
	 * @param yAlign vertical alignment: top, middle, center, bottom
	 * @param images the images to process
	 * @return the underlaid images
	 */
	public static Image underlay(String xAlign, String yAlign, Image... images) {
		Group g = new Group();
		for (Image image : images) {
			g.add(image, 0, 0);
		}
		if (null != xAlign) switch (xAlign) {
			case "center":
			case "middle":
				for (Child c : g.children) {
					c.x = (g.width - c.width) / 2.0;
				}	break;
			case "right":
				for (Child c : g.children) {
					c.x = g.width - c.width;
				}	break;
		}
		if (null != yAlign) switch (yAlign) {
			case "center":
			case "middle":
				for (Child c : g.children) {
					c.y = (g.height - c.height) / 2.0;
				}	break;
			case "bottom":
				for (Child c : g.children) {
					c.y = g.height - c.height;
				}	break;
		}
		return g;
	}

	/**
	 * {@code Image i = underlay(-20, 0, square(40, "red"), square(20, "green"));}<br>
	 * <img src="./doc-files/underlay(-20,0,square(40,red),square(20,green)).png" alt="" >
	 * @param dx shift between images in x-direction
	 * @param dy shift between images in y-direction
	 * @param images the images to process
	 * @return the underlaid images
	 */
	public static Image underlay(double dx, double dy, Image... images) {
		return underlay("center", "center", dx, dy, images);
	}

	/**
	 * {@code Image i = underlay("left", "center", -10, 0, square(40, "red"), square(20, "green"));}<br>
	 * <img src="./doc-files/underlay(left,center,-10,0,square(40,red),square(20,green)).png" alt="" >
	 * @param xAlign horizontal alignment: left, middle, center, right
	 * @param yAlign vertical alignment: top, middle, center, bottom
	 * @param dx shift between images in x-direction
	 * @param dy shift between images in y-direction
	 * @param images the images to process
	 * @return the underlaid images
	 */
	public static Image underlay(String xAlign, String yAlign, double dx, double dy, Image... images) {
		Group g = new Group();
		for (Image image : images) {
			g.add(image, 0, 0);
		}
		double x = 0.0, y = 0.0; // position of next image
		
		if (null != xAlign) switch (xAlign) {
			case "left":
				for (Child c : g.children) {
					c.x = x;
					x += dx;
				}	break;
			case "center":
			case "middle":
				for (Child c : g.children) {
					c.x = x - c.width / 2.0;
					x += dx;
				}	break;
			case "right":
				for (Child c : g.children) {
					c.x = x - c.width;
					x += dx;
			}	break;
		}

		if (null != yAlign) switch (yAlign) {
			case "top":
				for (Child c : g.children) {
					c.y = y;
					y += dy;
				}	break;
			case "center":
			case "middle":
				for (Child c : g.children) {
					c.y = y - c.height / 2.0;
					y += dy;
				}	break;
			case "bottom":
				for (Child c : g.children) {
					c.y = y - c.height;
					y += dy;
			}	break;
		}
		
		int n = g.children.size();
		if (n > 0) {
			Child c = g.get(0);
			double x1 = c.x; // bounding box
			double y1 = c.y;
			double x2 = c.x + c.width;
			double y2 = c.y + c.height;
			for (int i = 1; i < n; i++) {
				c = g.get(i);
				x1 = Math.min(x1, c.x);
				y1 = Math.min(y1, c.y);
				x2 = Math.max(x2, c.x + c.width);
				y2 = Math.max(y2, c.y + c.height);
			}
			for (int i = 0; i < n; i++) {
				c = g.get(i);
				c.x -= x1;
				c.y -= y1;
			}
			g.width = x2 - x1;
			g.height = y2 - y1;
		}
		return g;
	}

	/**
	 * {@code Image i = rotate(30, rectangle(50, 20, "red"));}<br>
	 * <img src="./doc-files/rotate(30,rectangle(50,20,red)).png" alt="" >
	 * @param angle rotation angle (in degrees, counterclockwise)
	 * @param image the image to rotate
	 * @return the rotated image
	 */
	public static Image rotate(double angle, Image image) {
		return new Group(image, angle);
	}
	
	/**
	 * {@code Image i = scale(0.5, rectangle(50, 20, "red"));}<br>
	 * <img src="./doc-files/scale(0.5,rectangle(50,20,red)).png" alt="" >
	 * @param factor scale factor
	 * @param image the image to scale
	 * @return the scaled image
	 */
	public static Image scale(double factor, Image image) {
		return scale(factor, factor, image);
	}

	/**
	 * {@code Image i = scale(0.2, 0.5, rectangle(50, 20, "red"));}<br>
	 * <img src="./doc-files/scale(0.2,0.5,rectangle(50,20,red)).png" alt="" >
	 * @param xFactor scale factor in x-direction
	 * @param yFactor scale factor in y-direction
	 * @param image the image to scale
	 * @return the scaled image
	 */
	public static Image scale(double xFactor, double yFactor, Image image) {
		return new Group(image, xFactor, yFactor);
	}
	
	/**
	 * Save the image in png format under the given name. The name may include 
	 * the path. Overwrites existing file of the same name. 
	 * @param i image to save
	 * @param fileName name of the file to create.
	 * @return true if the image was successfully saved, false otherwise
	 */
	public static boolean save(Image i, String fileName) {
		return i.save(fileName);
	}

	/*
	Image crop(double x, double y, double width, double height, Image img) {
		Image img2 = img.copy();
		img2.crop = new Rect(x, y, width, height);
/
		if (true) {
			Image cx = circle(100, "red");
			Image rx = rectangle(100, 100, "green");
			Shape s = Shape.intersect((Shape)(rx.render()), (Shape)(cx.render()));
			s.setFill(color("red"));
			root.getChildren().add(s);
		}
/		
		return img2;
	}
	*/

	/**
	 * Arrange the given images in a two-dimensional grid.
	 * @param images to arrange
	 * @return the grid
	 */
	public static Image grid(Image[][] images) {
		int nRows = images.length;
		int nCols = images[0].length;
		double maxWidth = 0;
		double maxHeight = 0;
		for (int row = 0; row < nRows; row++) {
			for (int col = 0; col < nCols; col++) {
				Image image = images[row][col];
				maxWidth = Math.max(maxWidth, image.width);
				maxHeight = Math.max(maxHeight, image.height);
			}
		}
		
		Group g = new Group();
		for (int row = 0; row < nRows; row++) {
			for (int col = 0; col < nCols; col++) {
				Image image = images[row][col];
				g.add(image, col * maxWidth, row * maxHeight);
			}
		}
		return g;
	}
		
	/**
	 * {@code Image i = arc(20, 45, 270, "red");}<br>
	 * <img src="./doc-files/arc(20,45,270,red).png" alt="" >
	 * @param radius radius
	 * @param startAngle start angle
	 * @param lengthAngle length angle
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @return the ellipse
	 */
	public static Image arc(double radius, double startAngle, double lengthAngle, String fillColor) {
		return new Arc(radius, startAngle, lengthAngle, color(fillColor), null);
	}
	
	/**
	 * {@code Image i = arc(20, 45, 270, pen("black"));}<br>
	 * <img src="./doc-files/arc(20,45,270,pen(black)).png" alt="" >
	 * @param radius radius
	 * @param startAngle start angle
	 * @param lengthAngle length angle
	 * @param pen pen for drawing the outline
	 * @return the ellipse
	 */
	public static Image arc(double radius, double startAngle, double lengthAngle, Pen pen) {
		return new Arc(radius, startAngle, lengthAngle, null, pen);
	}
	
	/**
	 * {@code Image i = arc(20, 45, 270, "red", pen("black"));}<br>
	 * <img src="./doc-files/arc(20,45,270,red,pen(black)).png" alt="" >
	 * @param radius radius
	 * @param startAngle start angle
	 * @param lengthAngle length angle
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param pen pen for drawing the outline
	 * @return the ellipse
	 */
	public static Image arc(double radius, double startAngle, double lengthAngle, String fillColor, Pen pen) {
		return new Arc(radius, startAngle, lengthAngle, color(fillColor), pen);
	}
	
	/**
	 * {@code Image i = arc(20, 45, 270, "red", 0.5, pen("black"));}<br>
	 * <img src="./doc-files/arc(20,45,270,red,0.5,pen(black)).png" alt="" >
	 * @param radius radius
	 * @param startAngle start angle
	 * @param lengthAngle length angle
	 * @param fillColor color for filling the interior (<a href="http://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html">list of color names</a>)
	 * @param opacity color may be fully transparent (0.0) to fully opaque (1.0)
	 * @param pen pen for drawing the outline
	 * @return the ellipse
	 */
	public static Image arc(double radius, double startAngle, double lengthAngle, String fillColor, double opacity, Pen pen) {
		return new Arc(radius, startAngle, lengthAngle, color(fillColor, opacity), pen);
	}
	
}
