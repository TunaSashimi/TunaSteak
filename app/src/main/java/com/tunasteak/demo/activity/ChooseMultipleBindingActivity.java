package com.tunasteak.demo.activity;

import android.view.View;

import com.tunasteak.activity.TBindingActivity;
import com.tunasteak.demo.R;
import com.tunasteak.demo.databinding.ActivityChooseMultipleBinding;
import com.tunasteak.demo.model.ChooseMultipleModel;
import com.tunasteak.model.TBindingModel;

public class ChooseMultipleBindingActivity extends TBindingActivity<ActivityChooseMultipleBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_choose_multiple;
    }

    @Override
    protected TBindingModel getModel() {
        return new ChooseMultipleModel(binding, getIntent());
    }

    @Override
    public void onInit() {

    }

    @Override
    public void onClick(View v) {
    }
}


