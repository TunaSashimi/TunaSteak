package com.tunasteak.activity;

import android.view.View;

import com.tunasteak.R;
import com.tunasteak.databinding.ActivityChooseSingleBinding;
import com.tunasteak.model.ChooseSingleModel;
import com.tunasteak.model.TBindingModel;

public class ChooseSingleBindingActivity extends TBindingActivity<ActivityChooseSingleBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_choose_single;
    }

    @Override
    protected TBindingModel getModel() {
        return new ChooseSingleModel(binding, getIntent());
    }

    @Override
    public void onInit() {

    }

    @Override
    public void onClick(View v) {
    }
}


