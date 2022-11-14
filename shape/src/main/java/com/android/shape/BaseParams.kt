package com.android.shape

import android.graphics.drawable.GradientDrawable
import android.view.View

/**
 * Created by weishl on 2022/1/10
 *
 */
abstract class BaseParams(protected val iShape: IShape) {

    fun then(): IShape {
        return iShape
    }

    fun getShape(): GradientDrawable {
        return iShape.getShape()
    }

    fun into(view: View) {
        view.background = getShape()
    }
}