package com.tunasteak.model;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import com.tunasushi.view.TLoad;
import androidx.databinding.ViewDataBinding;

/**
 * @author Tunasashimi
 * @date 2020-01-19 15:23
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
public class TBindingModel<B extends ViewDataBinding> {
    //
    protected B binding;
    protected Context context;

    //
    private static TLoad tLoad;
    private static FrameLayout frameLayout;
    private static FrameLayout.LayoutParams frameLayoutParams;

    public TBindingModel(B binding) {
        if (binding != null) {
            this.binding = binding;
            this.context = binding.getRoot().getContext();
        }
    }

    public void showLoading() {
        if (tLoad == null) {
            tLoad = new TLoad(context);
        }
        if (frameLayoutParams == null) {
            frameLayoutParams = new FrameLayout.LayoutParams(200, 200);
            frameLayoutParams.gravity = Gravity.CENTER;
        }
        if (frameLayout == null) {
            frameLayout = (FrameLayout) ((Activity) context).getWindow().getDecorView();
        }
        if (tLoad.getParent() == null) {
            frameLayout.addView(tLoad, frameLayoutParams);
        }
    }

    public void dismissLoading() {
        if (tLoad != null && frameLayoutParams != null && frameLayout != null) {
            frameLayout.removeView(tLoad);
        }
    }

    protected void showMessage() {

    }
}