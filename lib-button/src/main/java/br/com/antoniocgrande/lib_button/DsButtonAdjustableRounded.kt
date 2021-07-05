package br.com.antoniocgrande.lib_button

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.util.AttributeSet
import android.util.StateSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton

class DsButtonAdjustableRounded @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatButton
    (context, attrs, defStyleAttr) {

    companion object {
        private const val DEFAULT_RADIUS = 0F
    }

    private var radius: Float = DEFAULT_RADIUS
        set(value) {
            field = value
            applyStyle()
        }

    init {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.DsButtonRounded, defStyleAttr, 0)

        radius = ta.getFloat(R.styleable.DsButtonRounded_radius, DEFAULT_RADIUS)
        ta.recycle()

        setPadding(40, 0, 40, 0)
        gravity = Gravity.CENTER
        isAllCaps = true
        applyStyle()
    }

    private fun applyStyle() {
        background = getSelectorDrawable(context, radius)
    }

}

fun getSelectorDrawable(context: Context, radius: Float) = StateListDrawable().apply {
    addState(intArrayOf(android.R.attr.state_enabled), createNormalDrawable(context, radius))
    addState(StateSet.WILD_CARD, createDisabledDrawable(context, radius))
}

@SuppressLint("ResourceAsColor")
fun createNormalDrawable(context: Context, radius: Float) = GradientDrawable().apply {
    setColor(context.resources.getColor(R.color.enable_solid))
    setStroke(1, context.resources.getColor(R.color.enable_stoke))
    cornerRadius = radius
}

@SuppressLint("ResourceAsColor")
fun createDisabledDrawable(context: Context, radius: Float) = GradientDrawable().apply {
    setColor(context.resources.getColor(R.color.disable_solid))
    setStroke(1, context.resources.getColor(R.color.disable_stoke))
    cornerRadius = radius
}