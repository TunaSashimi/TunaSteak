package com.tunasteak.activity;

import android.view.View;

import com.tunasteak.R;
import com.tunasteak.databinding.ActivityChooseMultipleBinding;
import com.tunasteak.model.ChooseMultipleModel;
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


