package com.android.shape

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.View

class ShapeImpl(private val context: Context) : IShape {

    private val mDrawable by lazy(LazyThreadSafetyMode.NONE) {
        GradientDrawable()
    }

    override fun setStyle(@ShapeStyle shape: Int): IShape {
        mDrawable.shape = shape
        return this
    }

    override fun shapeGradient(): ShapeGradient {
        return ShapeGradient(this)
    }

    override fun shapeSize(): ShapeSize {
        return ShapeSize(this)
    }

    override fun shapeCorners(): ShapeCorners {
        return ShapeCorners(this)
    }

    override fun shapeSolid(): ShapeSolid {
        return ShapeSolid(context,this)
    }

    override fun shapeStroke(): ShapeStroke {
        return ShapeStroke(context, this)
    }

    override fun getShape(): GradientDrawable {
        return mDrawable
    }

    fun into(view: View) {
        view.background = getShape()
    }
}