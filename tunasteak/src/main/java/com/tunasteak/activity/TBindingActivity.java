package com.tunasteak.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.tunasteak.BR;
import com.tunasteak.listener.OnBarListener;
import com.tunasteak.listener.OnInitListener;
import com.tunasteak.model.TBindingModel;
import com.tunasushi.view.TView;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * @author Tunasashimi
 * @date 2020-01-17 11:44
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
public abstract class TBindingActivity<B extends ViewDataBinding> extends Activity implements OnBarListener, OnInitListener, TView.OnClickListener {
    protected B binding;
    protected View contentView;

    protected abstract int getLayoutId();

    protected abstract TBindingModel getModel();

    protected abstract Object getData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("1.0.04");

        //Data related
        onBinding();

        //Appearance related
        onInit();
    }

    private void onBinding() {
        int layoutId = getLayoutId();
        if (layoutId == 0) {
            return;
        }
        try {
            binding = DataBindingUtil.setContentView(this, layoutId);
            if (binding != null) {
                contentView = binding.getRoot();
                //
                binding.setVariable(BR.model, getModel());
                binding.setVariable(BR.data, getData());
                //
                binding.setVariable(BR.onBarListener, this);
                binding.setVariable(BR.onClickListener, this);
                //
                binding.executePendingBindings();
            } else {
                contentView = LayoutInflater.from(this).inflate(layoutId, null);
                setContentView(contentView);
            }
        } catch (NoClassDefFoundError e) {
            contentView = LayoutInflater.from(this).inflate(layoutId, null);
            setContentView(contentView);
        }
    }


    @Override
    public Drawable getDrawableLeft() {
        return null;
    }

    @Override
    public Drawable getDrawableRight() {
        return null;
    }

    @Override
    public String getTextCenter() {
        return null;
    }

    @Override
    public String getTextLeft() {
        return null;
    }

    @Override
    public String getTextRight() {
        return null;
    }
}
