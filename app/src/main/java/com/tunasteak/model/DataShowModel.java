package com.tunasteak.model;

import android.content.Intent;
import com.tunasteak.activity.DataShowBindingActivity;
import com.tunasteak.demo.databinding.ActivityDataShowBinding;

/**
 * @author Tunasashimi
 * @date 2020-01-19 15:42
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
public class DataShowModel extends TBindingModel<ActivityDataShowBinding>{
    private DataShowBindingActivity activity;

    public DataShowModel(ActivityDataShowBinding binding, Intent intent) {
        super(binding);
        this.binding = binding;
        this.activity = (DataShowBindingActivity) binding.getRoot().getContext();
        initData(intent);
    }

    protected void initData(Intent intent) {
    }
}
