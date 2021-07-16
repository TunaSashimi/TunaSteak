package com.tunasteak.activity;

import android.view.View;
import com.tunasteak.demo.R;
import com.tunasteak.demo.databinding.ActivityRecyclerViewBinding;
import com.tunasteak.model.RecyclerViewModel;
import com.tunasteak.model.TBindingModel;

public class RecyclerViewBindingActivity extends TBindingActivity<ActivityRecyclerViewBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_recycler_view;
    }

    @Override
    protected TBindingModel getModel() {
        return new RecyclerViewModel(binding, getIntent());
    }

    @Override
    protected Object getData() {
        return null;
    }

    @Override
    public void onInit() {

    }

    @Override
    public void onClick(View v) {
    }
}


