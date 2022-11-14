package com.android.shape

import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt

/**
 * Created by weishl on 2022/1/10
 *
 */
class ShapeGradient(iShape: IShape): BaseParams(iShape) {

    fun angle(orientation: GradientDrawable.Orientation): ShapeGradient {
        iShape.getShape().orientation = orientation
        return this
    }

    fun setCenter(centerX: Float, centerY: Float): ShapeGradient {
        iShape.getShape().setGradientCenter(centerX, centerY)
        return this
    }

    fun gradientRadius(gradientRadius: Float): ShapeGradient {
        iShape.getShape().gradientRadius = gradientRadius
        return this
    }

    fun setColors(@ColorInt colors: IntArray): ShapeGradient{
        iShape.getShape().colors = colors
        return this
    }

    fun useLevel(useLevel: Boolean): ShapeGradient {
        iShape.getShape().useLevel = useLevel
        return this
    }

    fun setType(@GradientType type: Int): ShapeGradient {
        iShape.getShape().gradientType = type
        return this
    }
}