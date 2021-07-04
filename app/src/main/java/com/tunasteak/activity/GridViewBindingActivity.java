package com.tunasteak.activity;

import android.view.View;

import com.tunasteak.R;
import com.tunasteak.databinding.ActivityGridViewBinding;
import com.tunasteak.model.GridViewModel;
import com.tunasteak.model.TBindingModel;

public class GridViewBindingActivity extends TBindingActivity<ActivityGridViewBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_grid_view;
    }

    @Override
    protected TBindingModel getModel() {
        return new GridViewModel(binding, getIntent());
    }

    @Override
    public void onInit() {

    }

    @Override
    public void onClick(View v) {
    }
}


