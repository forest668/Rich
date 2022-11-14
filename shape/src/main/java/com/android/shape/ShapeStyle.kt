package com.android.shape

import android.graphics.drawable.GradientDrawable
import androidx.annotation.IntDef

/**
 * Created by weishl on 2022/01/10
 *
 */
@Retention(AnnotationRetention.RUNTIME)
@IntDef(ShapeStyle.RECTANGLE,ShapeStyle.OVAL,ShapeStyle.LINE,ShapeStyle.RING)
@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class ShapeStyle {

    companion object {
        /**
         * Shape is a rectangle, possibly with rounded corners
         */
        const val RECTANGLE = GradientDrawable.RECTANGLE

        /**
         * Shape is an ellipse
         */
        const val OVAL = GradientDrawable.OVAL

        /**
         * Shape is a line
         */
        const val LINE = GradientDrawable.LINE

        /**
         * Shape is a ring.
         */
        const val RING = GradientDrawable.RING
    }
}
