/*
   Copyright (c) 2017 Ahome' Innovation Technologies. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.ait.lienzo.client.core.shape;

import java.util.List;

import com.ait.lienzo.client.core.Attribute;
import com.ait.lienzo.client.core.Context2D;
import com.ait.lienzo.client.core.types.BoundingBox;
import com.ait.lienzo.shared.core.types.ShapeType;
import jsinterop.annotations.JsProperty;

/**
 * Circle with a radius. The center point is set via the X,Y attributes.
 */
public class Circle extends Shape<Circle> {

    @JsProperty
    private double radius;

    /**
     * Constructor. Creates an instance of a circle.
     *
     * @param radius
     */
    public Circle(final double radius) {
        super(ShapeType.CIRCLE);

        setRadius(radius);
    }

    @Override
    public BoundingBox getBoundingBox() {
        final double radius = getRadius();

        return BoundingBox.fromDoubles(0 - radius, 0 - radius, radius, radius);
    }

    /**
     * Draws this circle
     *
     * @param context the {@link Context2D} used to draw this circle.
     */
    @Override
    protected boolean prepare(final Context2D context, final double alpha) {
        final double r = getRadius();

        if (r > 0) {
            context.beginPath();

            context.arc(0, 0, r, 0, Math.PI * 2, true);

            context.closePath();

            return true;
        }
        return false;
    }

    @Override
    protected boolean doStrokeExtraProperties() {
        return false;
    }

    /**
     * Sets this circle's radius.
     *
     * @param radius
     * @return this Circle
     */
    public Circle setRadius(final double radius) {
        this.radius = radius;

        return this;
    }

    /**
     * Gets this circle's radius.
     *
     * @return double
     */
    public double getRadius() {
        return this.radius;
    }

    @Override
    public List<Attribute> getBoundingBoxAttributes() {
        return asAttributes(Attribute.RADIUS);
    }
}
