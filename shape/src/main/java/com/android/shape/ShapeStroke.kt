package com.android.shape

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

/**
 * Created by weishl on 2022/1/10
 *
 */
class ShapeStroke(private val ctx: Context, iShape: IShape): BaseParams(iShape) {

    fun setStroke(dimens: Int, @ColorInt strokeColor: Int): ShapeStroke {
        iShape.getShape().setStroke(dimens, strokeColor)
        return this
    }

    fun setStrokeRes(dimens: Int, @ColorRes strokeColor: Int): ShapeStroke {
        iShape.getShape().setStroke(dimens, ContextCompat.getColor(ctx, strokeColor))
        return this
    }

    fun setStroke(
        dimens: Int,
        @ColorInt strokeColor: Int,
        dashWidth: Float,
        dashGap: Float
    ): ShapeStroke {
        iShape.getShape().setStroke(dimens, strokeColor, dashWidth, dashGap)
        return this
    }

    fun setStrokeRes(
        dimens: Int,
        @ColorRes strokeColor: Int,
        dashWidth: Float,
        dashGap: Float
    ): ShapeStroke {
        iShape.getShape()
            .setStroke(dimens, ContextCompat.getColor(ctx, strokeColor), dashWidth, dashGap)
        return this
    }
}