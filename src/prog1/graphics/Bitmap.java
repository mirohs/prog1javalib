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

/**
 * A bitmap from a file (jpg, png, or gif).
 *
 * @author michaelrohs
 */
class Bitmap extends Image {

    private final javafx.scene.image.Image image;

    public Bitmap(String url) {
        super(0, 0);
        image = new javafx.scene.image.Image(url, false);
//		System.out.printf("image: %f, %f\n", image.getWidth(), image.getHeight());
        width = image.getWidth();
        height = image.getHeight();
    }

    @Override
    protected javafx.scene.Node render() {
        return new javafx.scene.image.ImageView(image);
    }

}
