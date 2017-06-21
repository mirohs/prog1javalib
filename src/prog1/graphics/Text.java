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

import javafx.geometry.Bounds;
import javafx.geometry.VPos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * Text in a certain size, color, and font.
 *
 * @author michaelrohs
 */
class Text extends Shape {

    private final String string;
    private final javafx.scene.text.Font font;
    private final double wrappingWidth;
    private final TextAlignment alignment;

    public Text(ApplicationBase app, String string, double fontSize, Color color, Pen pen,
            double wrappingWidth, TextAlignment alignment) {
        super(app, 0, 0, color, pen);
        this.string = string;
        this.wrappingWidth = wrappingWidth;
        this.alignment = alignment;

        javafx.scene.text.Text text = new javafx.scene.text.Text(string);
        font = new javafx.scene.text.Font(fontSize);
        text.setFont(font);
        text.setTextOrigin(VPos.TOP);
        text.setWrappingWidth(wrappingWidth);
        text.setTextAlignment(alignment);
		// render(text);

		// System.out.println(text.getBoundsInLocal());
        // System.out.println(text.getBoundsInParent());
        Bounds bounds = text.getBoundsInLocal();
        width = bounds.getWidth();
        height = bounds.getHeight();
    }

    public Text(ApplicationBase app, String string, String fontName, double fontSize, Color color, Pen pen,
            double wrappingWidth, TextAlignment alignment) {
        super(app, 0, 0, color, pen);
        this.string = string;
        this.wrappingWidth = wrappingWidth;
        this.alignment = alignment;

        javafx.scene.text.Text text = new javafx.scene.text.Text(string);
        font = new javafx.scene.text.Font(fontName, fontSize);
        text.setFont(font);
        text.setTextOrigin(VPos.TOP);
        text.setWrappingWidth(wrappingWidth);
        text.setTextAlignment(alignment);
		// render(text);

		// System.out.println(text.getBoundsInLocal());
        // System.out.println(text.getBoundsInParent());
        Bounds bounds = text.getBoundsInLocal();
        width = bounds.getWidth();
        height = bounds.getHeight();
    }

    public Text(ApplicationBase app, String string, Font font, Color color, Pen pen,
            double wrappingWidth, TextAlignment alignment) {
        super(app, 0, 0, color, pen);
        this.string = string;
        this.wrappingWidth = wrappingWidth;
        this.alignment = alignment;

        javafx.scene.text.Text text = new javafx.scene.text.Text(string);
        this.font = font;
        text.setFont(font);
        text.setTextOrigin(VPos.TOP);
        text.setWrappingWidth(wrappingWidth);
        text.setTextAlignment(alignment);
		// render(text);

		// System.out.println(text.getBoundsInLocal());
        // System.out.println(text.getBoundsInParent());
        Bounds bounds = text.getBoundsInLocal();
        width = bounds.getWidth();
        height = bounds.getHeight();
    }

    @Override
    protected javafx.scene.Node render() {
        javafx.scene.text.Text text = new javafx.scene.text.Text(string);
        text.setFont(font);
        text.setTextOrigin(VPos.TOP);
        text.setWrappingWidth(wrappingWidth);
        text.setTextAlignment(alignment);

//		text.setLayoutX(width);
//		text.setLayoutY(width);
//		text.setTranslateX(width);
//		text.setTranslateY(width);
//		text.setX(width);
//		text.setY(width);
//		text.getBoundsInLocal();
//		text.getBoundsInParent();
//		text.getLayoutBounds();
//		text.getWrappingWidth();
//		text.getLineSpacing();
//		text.getBaselineOffset();
//		text.getLayoutX();
//		text.getLayoutY();
//		text.getTranslateX();
//		text.getTranslateY();
//		text.getX();
//		text.getY();
        return render(text);
    }

}
