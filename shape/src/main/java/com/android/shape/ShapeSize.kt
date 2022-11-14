package com.android.shape

/**
 * Created by weishl on 2022/1/10
 *
 */
class ShapeSize(iShape: IShape): BaseParams(iShape) {

    fun size(width: Int, height: Int): ShapeSize  {
        iShape.getShape().setSize(width, height)
        return this
    }
}