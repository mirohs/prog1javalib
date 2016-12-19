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

import javafx.scene.transform.Transform;

/**
 * A group child element (an {@link Image} object at a certain position, angle, and scale).
 * @author michaelrohs
 */
public class Child {
	public Image image;
	public double x; // relative to its parent Group
	public double y; // relative to its parent Group
	public double angle; // relative to its parent Group
	public double xScale = 1.0;
	public double yScale = 1.0;
	
	public double width;
	public double height;

	public Child(Image image, double x, double y) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = image.width;
		this.height = image.height;
	}
	
	public void rotate(double a) {
		this.angle = a;

		Transform tr = Transform.rotate(-angle, 0, 0); // todo: potentially add as attributes to avoid recomputation when rendering
		Transform tt = Transform.translate(x, y);
		Transform ts = Transform.scale(xScale, yScale);
		
		Rect bb = image.boundingBox(tt.createConcatenation(tr).createConcatenation(ts));
//		System.out.println("bb = " + bb);

		x = -bb.x;
		y = -bb.y;
		width = bb.width;
		height = bb.height;
	}

	public void scale(double xScale, double yScale) {
		this.xScale = xScale;
		this.yScale = yScale;

		Transform tr = Transform.rotate(-angle, 0, 0); // todo: potentially add as attributes to avoid recomputation when rendering
		Transform tt = Transform.translate(x, y);
		Transform ts = Transform.scale(xScale, yScale);
		
		Rect bb = image.boundingBox(tt.createConcatenation(tr).createConcatenation(ts));
//		System.out.println("bb = " + bb);

		x = -bb.x;
		y = -bb.y;
		width = bb.width;
		height = bb.height;
	}

	protected javafx.scene.Node render() {
		javafx.scene.Node jfxNode = image.render();

//		System.out.println("<Node render>");
//		System.out.println("  " + jfxNode + 
//				", x = " + x + ", y = " + y + 
//				", angle = " + angle + 
//				", xScale = " + xScale+ ", yScale = " + yScale);

//		if (xScale != 1.0 || yScale != 1.0) {
//			jfxNode.setLayoutX(-image.width / 2.0);
//			jfxNode.setLayoutY(-image.height / 2.0);
//			jfxNode.setScaleX(xScale);
//			jfxNode.setScaleY(yScale);
//			jfxNode.setLayoutX(image.width / 2.0);
//			jfxNode.setLayoutY(image.height / 2.0);
//		}

		Transform tr = Transform.rotate(-angle, 0, 0);
		Transform tt = Transform.translate(x, y);
		Transform ts = Transform.scale(xScale, yScale);
		jfxNode.getTransforms().setAll(tt, tr, ts);
		
//		System.out.println("  layoutBounds: " + jfxNode.getLayoutBounds());
//		System.out.println("  boundsInLocal: " + jfxNode.getBoundsInLocal());
//		System.out.println("  boundsInParent: " + jfxNode.getBoundsInParent());
//		System.out.printf("  translateXY: %f, %f\n", jfxNode.getTranslateX(), jfxNode.getTranslateY());
//		System.out.println("</Node render>");
		
		return jfxNode;
	}

	protected String toString(String indent) {
		StringBuilder sb = new StringBuilder(indent);
		sb.append(String.format("<Child x=\"%.1f\" y=\"%.1f\" width=\"%.1f\" height=\"%.1f\" angle=\"%.1f\" xScale=\"%.1f\" yScale=\"%.1f\">\n", 
						x, y, width, height, angle, xScale, yScale));
		sb.append(image.toString(indent + "  "));
		sb.append(indent);
		sb.append("</Child>\n");
		return sb.toString();
		
	}
	
	public Point center() {
		return new Point(x + width / 2.0, y + height / 2.0);
	}

}
