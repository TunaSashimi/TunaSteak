package com.tunasteak.activity;

import android.view.View;

import com.tunasteak.R;
import com.tunasteak.databinding.ActivityExpandableListViewBinding;
import com.tunasteak.model.ExpandableListViewModel;
import com.tunasteak.model.TBindingModel;

public class ExpandableListViewBindingActivity extends TBindingActivity<ActivityExpandableListViewBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_expandable_list_view;
    }

    @Override
    protected TBindingModel getModel() {
        return new ExpandableListViewModel(binding, getIntent());
    }

    @Override
    public void onInit() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
    }
}


