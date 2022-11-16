package com.android.spannable

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.style.AbsoluteSizeSpan
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import androidx.core.text.toSpannable
import java.lang.ref.WeakReference

class SpannableImpl private constructor() : ISpannable {

    companion object {
        fun get() = SpannableImpl()
    }

    private var mSpannable: Spannable? = null

    private var mCommonParams = arrayOf<String>()

    override fun init(@NonNull text: String): ISpannable {
        mSpannable = text.toSpannable()
        return this
    }

    override fun init(@NonNull context: Context, textRes: Int): ISpannable {
        val text = context.getString(textRes)
        mSpannable = text.toSpannable()
        return this
    }

    override fun init(
        @NonNull context: Context,
        textRes: Int,
        @NonNull vararg text: String
    ): ISpannable {
        val str = context.getString(textRes, *text)
        mSpannable = str.toSpannable()
        return this
    }

    override fun init(spannable: Spannable): ISpannable {
        mSpannable = spannable
        return this
    }

    override fun commonParams(vararg params: String): ISpannable {
        mCommonParams = params.toList().toTypedArray()
        return this
    }

    override fun size(start: Int, end: Int, textSize: Int): ISpannable {
        mSpannable?.setSpan(
            AbsoluteSizeSpan(textSize),
            start,
            end,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return this
    }

    override fun size(textSize: Int, @NonNull vararg params: String): ISpannable {
        try {
            val span = mSpannable ?: return this
            var str = span.toString()
            var originIndex = 0
            var indexParam = ""
            for (i in params.indices) {
                indexParam = params[i]
                val index = str.indexOf(indexParam)
                if (index < 0) {
                    throw IllegalArgumentException("size index = -1")
                }
                originIndex += index
                str = span.substring(index + indexParam.length)
                mSpannable?.setSpan(
                    AbsoluteSizeSpan(textSize),
                    originIndex,
                    originIndex + indexParam.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                originIndex += indexParam.length
            }
        } catch (e: Exception) {
            return this
        }
        return this
    }

    override fun size(textSize: Int): ISpannable {
        return size(textSize, *mCommonParams)
    }

    override fun bold(start: Int, end: Int): ISpannable {
        mSpannable?.setSpan(StyleSpan(Typeface.BOLD), start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        return this
    }

    override fun bold(@NonNull vararg params: String): ISpannable {
        try {
            val span = mSpannable ?: return this
            var str = span.toString()
            var originIndex = 0
            var indexParam = ""
            for (i in params.indices) {
                indexParam = params[i]
                val index = str.indexOf(indexParam)
                if (index < 0) {
                    throw IllegalArgumentException("bold index = -1")
                }
                originIndex += index
                str = str.substring(index + indexParam.length)
                mSpannable?.setSpan(
                    StyleSpan(Typeface.BOLD),
                    originIndex,
                    originIndex + indexParam.length,
                    Spanned.SPAN_INCLUSIVE_EXCLUSIVE
                )
                originIndex += indexParam.length
            }
        } catch (e: Exception) {
            return this
        }

        return this
    }

    override fun bold(): ISpannable {
        return bold(*mCommonParams)
    }

    override fun color(start: Int, end: Int, color: Int): ISpannable {
        mSpannable?.setSpan(
            ForegroundColorSpan(color), start, end,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return this
    }

    override fun color(color: Int, @NonNull vararg params: String): ISpannable {
        try {
            val span = mSpannable ?: return this
            var str = span.toString()
            var originIndex = 0
            var indexParam = ""
            for (i in params.indices) {
                indexParam = params[i]
                val index = str.indexOf(indexParam)
                if (index < 0) {
                    throw IllegalArgumentException("color index = -1")
                }
                originIndex += index
                str = str.substring(index + indexParam.length)
                mSpannable?.setSpan(
                    ForegroundColorSpan(color), originIndex, originIndex + indexParam.length,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                originIndex += indexParam.length
            }
        } catch (e: Exception) {
            return this
        }
        return this
    }

    override fun color(color: Int): ISpannable {
        return color(color, *mCommonParams)
    }

    override fun italic(start: Int, end: Int): ISpannable {
        mSpannable?.setSpan(
            StyleSpan(Typeface.BOLD_ITALIC),
            start,
            end,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
        return this
    }

    override fun italic(@NonNull vararg params: String): ISpannable {
        try {
            val span = mSpannable ?: return this
            var str = span.toString()
            var originIndex = 0
            var indexParam = ""
            for (i in params.indices) {
                indexParam = params[i]
                val index = str.indexOf(indexParam)
                if (index < 0) {
                    throw IllegalArgumentException("italic index = -1")
                }
                originIndex += index
                str = str.substring(index + indexParam.length)
                mSpannable?.setSpan(
                    StyleSpan(Typeface.BOLD_ITALIC),
                    originIndex,
                    originIndex + indexParam.length,
                    Spanned.SPAN_INCLUSIVE_EXCLUSIVE
                )
                originIndex += indexParam.length
            }
        } catch (e: Exception) {
            return this
        }
        return this
    }

    override fun italic(): ISpannable {
        return italic(*mCommonParams)
    }

    override fun clickableSpan(
        @ColorInt color: Int,
        clickableText: String,
        onClick: (() -> Unit)?
    ): ISpannable {
        val weakReference = WeakReference(onClick)
        val span = mSpannable ?: return this
        val index = span.indexOf(clickableText)
        if (index < 0) return this
        span.setSpan(object : ClickableSpan() {
            override fun onClick(view: View) {
                weakReference.get()?.invoke()
            }

            override fun updateDrawState(paint: TextPaint) {
                super.updateDrawState(paint)
                paint.color = color
            }
        }, index, index + clickableText.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        return this
    }

    override fun getSpan(): Spannable {
        return mSpannable ?: SpannableString("")
    }

    override fun into(view: TextView) {
        view.text = getSpan()
    }
}