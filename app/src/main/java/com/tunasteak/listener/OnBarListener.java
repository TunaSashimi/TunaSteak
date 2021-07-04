package com.tunasteak.listener;

import android.graphics.drawable.Drawable;

/**
 * @author Tunasashimi
 * @date 2020-01-17 12:00
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
public interface OnBarListener {
    Drawable getDrawableLeft();

    Drawable getDrawableRight();

    String getTextLeft();

    String getTextRight();

    String getTextCenter();
}
