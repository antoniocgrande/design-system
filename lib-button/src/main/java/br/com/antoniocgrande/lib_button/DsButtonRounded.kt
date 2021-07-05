package br.com.antoniocgrande.lib_button

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat

class DsButtonRounded @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatButton
    (context, attrs, defStyleAttr) {

    companion object {
        private const val DEFAULT_IS_RADIUS = false
    }

    private var isRounded: Boolean = DEFAULT_IS_RADIUS
        set(value) {
            field = value
            applyStyle()
        }

    init {
        init(context, attrs, defStyleAttr)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.DsButtonRounded2, defStyleAttr, 0)
        isRounded = ta.getBoolean(R.styleable.DsButtonRounded2_isRounded, DEFAULT_IS_RADIUS)

        ta.recycle()

        setPadding(40, 0, 40, 0)
        gravity = Gravity.CENTER
        isAllCaps = true
        applyStyle()
    }

    private fun applyStyle() {
        val styles = Styles(isRounded)
        background = ContextCompat.getDrawable(context, styles.getDrawableRes())
    }

}

data class Styles(private val isRounded: Boolean = false) {

    fun getDrawableRes() = when (isRounded) {
        true -> R.drawable.selector_rounded
        false -> R.drawable.selector_unrounded
    }

}