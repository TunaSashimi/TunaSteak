package com.tunasteak.listener

import android.graphics.drawable.Drawable

/**
 * @author Tunasashimi
 * @date 2020-01-17 12:00
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
interface OnBarListener {
    val drawableLeft: Drawable?
    val drawableRight: Drawable?
    val textLeft: String?
    val textRight: String?
    val textCenter: String?
}