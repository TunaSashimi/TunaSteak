package com.tunasteak.fragment;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tunasteak.BR;
import com.tunasteak.data.TBindingData;
import com.tunasteak.listener.OnBarListener;
import com.tunasteak.listener.OnInitListener;
import com.tunasteak.listener.OnLoadListener;
import com.tunasteak.model.TBindingModel;
import com.tunasushi.view.TView;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * @author TunaSashimi
 * @date 2020-02-20 21:35
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
public abstract class TBindingFragment<B extends ViewDataBinding> extends Fragment implements OnBarListener, OnInitListener, OnLoadListener, TView.OnClickListener {
    protected B binding;
    protected View contentView;

    protected abstract int getLayoutId();

    protected abstract TBindingModel getModel();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        int layoutId = getLayoutId();
        if (contentView == null) {
            try {
                binding = DataBindingUtil.inflate(inflater, layoutId, container, false);
                contentView = binding.getRoot();
                TBindingModel tBindingModel = getModel();
                //
                binding.setVariable(BR.model, tBindingModel);
                binding.setVariable(BR.onBarListener, this);
                binding.setVariable(BR.model, tBindingModel);
                binding.setVariable(BR.data, TBindingData.getInstance());
                binding.setVariable(BR.onClickListener, this);
                //
                binding.executePendingBindings();
            } catch (NoClassDefFoundError e) {
                contentView = inflater.inflate(layoutId, container, false);
            }
            if (contentView != null) {
                contentView.setClickable(true);
                onInit();
            }
        }
        return contentView;
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

    //
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            onVisible();
        } else {
            onInVisible();
        }
    }

    //
    protected void onVisible() {
    }

    //
    protected void onInVisible() {
    }

    //
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisible() && isVisibleToUser && contentView != null) {
            //懒加载机制,在fragment可见时再去加载数据
            onLoad();
        } else {
            super.setUserVisibleHint(isVisibleToUser);
        }
    }

}
