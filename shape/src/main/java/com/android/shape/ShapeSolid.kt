package com.android.shape

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

/**
 * Created by weishl on 2022/1/10
 *
 */
class ShapeSolid(private val ctx: Context, iShape: IShape): BaseParams(iShape) {

    fun color(@ColorInt color: Int): ShapeSolid {
        iShape.getShape().setColor(color)
        return this
    }

    fun colorRes(@ColorRes color: Int): ShapeSolid {
        iShape.getShape().setColor(ContextCompat.getColor(ctx, color))
        return this
    }
}