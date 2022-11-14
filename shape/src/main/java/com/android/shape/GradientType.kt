package com.android.shape

import android.graphics.drawable.GradientDrawable
import androidx.annotation.IntDef
import com.android.shape.GradientType.Companion.LINEAR_GRADIENT
import com.android.shape.GradientType.Companion.RADIAL_GRADIENT
import com.android.shape.GradientType.Companion.SWEEP_GRADIENT
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Created by weishl on 2022/1/11
 *
 */
@IntDef(LINEAR_GRADIENT, RADIAL_GRADIENT, SWEEP_GRADIENT)
@Retention(RetentionPolicy.RUNTIME)
annotation class GradientType {
    companion object {
        const val LINEAR_GRADIENT = GradientDrawable.LINEAR_GRADIENT
        const val RADIAL_GRADIENT = GradientDrawable.RADIAL_GRADIENT
        const val SWEEP_GRADIENT = GradientDrawable.SWEEP_GRADIENT
    }
}