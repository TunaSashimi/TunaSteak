package com.tunasteak.model;

import android.content.Intent;
import com.tunasteak.activity.TLoadBindingActivity;
import com.tunasteak.databinding.ActivityTLoadBinding;

/**
 * @author Tunasashimi
 * @date 2020-01-19 15:42
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
public class TLoadBindingModel extends TBindingModel<ActivityTLoadBinding> {
    private TLoadBindingActivity activity;
    public TLoadBindingModel(ActivityTLoadBinding binding, Intent intent) {
        super(binding);
        this.binding = binding;
        this.activity = (TLoadBindingActivity) binding.getRoot().getContext();
        initData(intent);
    }
    protected void initData(Intent intent) {
    }
    public void start(Class cla) {
        Intent intent = new Intent(activity, cla);
        activity.startActivity(intent);
    }
}
