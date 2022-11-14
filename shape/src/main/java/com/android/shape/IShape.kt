package com.android.shape

import android.graphics.drawable.GradientDrawable

interface IShape {

    fun setStyle(@ShapeStyle shape: Int): IShape

    fun shapeGradient(): ShapeGradient

    fun shapeSize(): ShapeSize

    fun shapeCorners(): ShapeCorners

    fun shapeSolid(): ShapeSolid

    fun shapeStroke(): ShapeStroke

    fun getShape(): GradientDrawable
}