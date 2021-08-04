package com.tunasteak.model

import androidx.databinding.ViewDataBinding
import com.tunasushi.view.TLoad
import android.widget.FrameLayout
import android.view.Gravity
import android.app.Activity
import android.content.Context

/**
 * @author Tunasashimi
 * @date 2020-01-19 15:23
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
open class TBindingModel<B : ViewDataBinding?>(binding: B?) {
    //
    @JvmField
    protected var binding: B? = null
    private lateinit var context: Context

    companion object {
        private var tLoad: TLoad? = null
        private var frameLayout: FrameLayout? = null
        private var frameLayoutParams: FrameLayout.LayoutParams? = null
    }

    fun showLoading() {
        if (tLoad == null) {
            tLoad = TLoad(context)
        }
        if (frameLayoutParams == null) {
            frameLayoutParams = FrameLayout.LayoutParams(200, 200)
            frameLayoutParams!!.gravity = Gravity.CENTER
        }
        if (frameLayout == null) {
            frameLayout = (context as Activity?)!!.window.decorView as FrameLayout
        }
        if (tLoad!!.parent == null) {
            frameLayout!!.addView(tLoad, frameLayoutParams)
        }
    }

    fun dismissLoading() {
        if (tLoad != null && frameLayoutParams != null && frameLayout != null) {
            frameLayout!!.removeView(tLoad)
        }
    }

    protected fun showMessage() {}

    init {
        if (binding != null) {
            this.binding = binding
            context = binding.root.context
        }
    }
}