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

import javafx.collections.ObservableList;
import javafx.scene.transform.Transform;

/**
 * A group of {@link Child} elements.
 *
 * @author michaelrohs
 */
public class ClippedGroup extends Group {

    private final ApplicationBase app;

    /**
     * Create an empty group.
     */
    public ClippedGroup(ApplicationBase app) {
        super(app);
        this.app = app;
    }

    /**
     * Create a rotation group (a group with a single child and the specified
     * rotation).
     *
     * @param image the image to be rotated
     * @param angle the rotation angle (in degrees, counterclockwise)
     */
    public ClippedGroup(ApplicationBase app, Image image, double angle) { // todo: introduce class RotationGroup?
        super(app, image, angle);
        this.app = app;
//        Child c = new Child(image, 0, 0);
//        c.rotate(angle);
//        width = c.width;
//        height = c.height;
//        children.add(c);
    }

    /**
     * Create a scale group (a group with a single child and the specified
     * scaling).
     *
     * @param image the image to be scaled
     * @param xFactor scaling in x-direction
     * @param yFactor scaling in y-direction
     */
    public ClippedGroup(ApplicationBase app, Image image, double xFactor, double yFactor) {
        super(app, image, xFactor, yFactor);
        this.app = app;
//        Child c = new Child(image, 0, 0);
//        c.scale(xFactor, yFactor);
//        width = c.width;
//        height = c.height;
//        children.add(c);
    }

    @Override
    public Rect boundingBox(Transform t) {
//        System.out.println("ClippedGroup::boundingBox:");
        double x1 = Double.POSITIVE_INFINITY;
        double y1 = Double.POSITIVE_INFINITY;
        double x2 = Double.NEGATIVE_INFINITY;
        double y2 = Double.NEGATIVE_INFINITY;
        if (children.size() > 0) {
            Child c = children.get(0); // child 0 defines bounding box
            Transform tr = Transform.rotate(-c.angle, 0, 0);
            Transform tt = Transform.translate(c.x, c.y);
            Transform ts = Transform.scale(c.xScale, c.yScale);
            Rect r = c.image.boundingBox(t.createConcatenation(tt).createConcatenation(tr).createConcatenation(ts));
            x1 = Math.min(x1, r.x);
            y1 = Math.min(y1, r.y);
            x2 = Math.max(x2, r.x + r.width);
            y2 = Math.max(y2, r.y + r.height);
//            System.out.println("r.width = " + r.width + ", r.height = " + r.height);
        }
        return new Rect(x1, y1, x2 - x1, y2 - y1);
    }

//    public Point childCenter(int... indices) {
//        int n = indices.length;
//        if (n <= 0) {
//            return new Point(width / 2.0, height / 2.0);
//        }
//        // assert: indices.length >= 1
//        double x = 0, y = 0;
//        Child c = get(indices[0]);
//        for (int j = 1; j < n; j++) {
//            x += c.x; // todo: incomplete: need to consider rotation and scaling
//            y += c.y;
//            if (!(c.image instanceof ClippedGroup)) {
//                return new Point(x + c.width / 2.0, y + c.height / 2.0);
//            }
//            c = ((ClippedGroup) c.image).get(indices[j]);
//        }
//        x += c.x + c.width / 2.0;
//        y += c.y + c.height / 2.0;
//        return new Point(x, y);
//    }

    @Override
    protected javafx.scene.Node render() {
//		System.out.println("<Group>");
        javafx.scene.Group jfxNode = new javafx.scene.Group();
        ObservableList<javafx.scene.Node> jfxNodeChildren = jfxNode.getChildren();
//		jfxNodeChildren.add(new javafx.scene.shape.Rectangle(width, height, new Color(0, 0, 1, 0.1)));
        
        // first child defines clip
        if (children.size() > 0) {
            Child c = children.get(0);
            javafx.scene.Node cfx = c.render();
            jfxNode.setClip(cfx);
        }
        for (Child c : children) {
            jfxNodeChildren.add(c.render());
        }
//		jfxNode.setLayoutX(0);
//		jfxNode.setLayoutY(0);
//		System.out.println("  layoutBounds: " + jfxNode.getLayoutBounds());
//		System.out.println("  boundsInLocal: " + jfxNode.getBoundsInLocal());
//		System.out.println("  boundsInParent: " + jfxNode.getBoundsInParent());
//		System.out.printf("  translateXY: %f, %f\n", jfxNode.getTranslateX(), jfxNode.getTranslateY());
//		System.out.println("</Group>");

        if (pressFunction != null) {
            jfxNode.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_PRESSED, (javafx.scene.input.MouseEvent e) -> {
//				System.out.println("group press");
                pressFunction.apply(new MouseEvent(e), pressFunctionTarget);
                e.consume();
                app.draw();
            });
        }
        if (releaseFunction != null) {
            jfxNode.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_RELEASED, (javafx.scene.input.MouseEvent e) -> {
//				System.out.println("group release");
                releaseFunction.apply(new MouseEvent(e), releaseFunctionTarget);
                e.consume();
                app.draw();
            });
        }
        if (moveFunction != null) {
            jfxNode.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_MOVED, (javafx.scene.input.MouseEvent e) -> {
                moveFunction.apply(new MouseEvent(e), moveFunctionTarget);
                e.consume();
                app.draw();
            });
        }
        if (dragFunction != null) {
            jfxNode.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_DRAGGED, (javafx.scene.input.MouseEvent e) -> {
                dragFunction.apply(new MouseEvent(e), dragFunctionTarget);
                e.consume();
                app.draw();
            });
        }

        return jfxNode;
    }

    @Override
    protected String toString(String indent) {
        StringBuilder sb = new StringBuilder(indent);
        sb.append(String.format("<ClippedGroup width=\"%.1f\" height=\"%.1f\">\n", width, height));
        for (Child n : children) {
            sb.append(n.toString(indent + "  "));
        }
        sb.append(indent);
        sb.append("</ClippedGroup>\n");
        return sb.toString();

    }

}
