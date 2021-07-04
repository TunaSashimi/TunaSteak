package com.tunasteak.activity;

import android.view.View;

import com.tunasteak.R;
import com.tunasteak.databinding.ActivityTwoWayBindingBinding;
import com.tunasteak.bean.SelectBean;
import com.tunasteak.model.TBindingModel;

/**
 * @author TunaSashimi
 * @date 2020-04-12 20:30
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
public class TwoWayBindingActivity extends TBindingActivity<ActivityTwoWayBindingBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_two_way_binding;
    }

    @Override
    protected TBindingModel getModel() {
        return null;
    }

    @Override
    public void onInit() {
        SelectBean selectBean = new SelectBean();
        binding.setSelect(selectBean);
        selectBean.select.set(true);
    }

    @Override
    public void onClick(View v) {

    }
}
