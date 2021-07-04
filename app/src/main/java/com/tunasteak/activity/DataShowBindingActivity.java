package com.tunasteak.activity;

import android.view.View;

import com.tunasteak.R;
import com.tunasteak.data.TBindingData;
import com.tunasteak.databinding.ActivityDataShowBinding;
import com.tunasteak.model.TBindingModel;

/**
 * @author TunaSashimi
 * @date 2020-03-11 11:17
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
public class DataShowBindingActivity extends TBindingActivity<ActivityDataShowBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_data_show;
    }

    @Override
    protected TBindingModel getModel() {
        return null;
    }

    @Override
    public void onInit() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                TBindingData tBindingData = TBindingData.getInstance();
                tBindingData.setDataShow("DATA SHOW");
                if (tBindingData.getDataSelect().get()) {
                    tBindingData.setDataSelect(false);
                } else {
                    tBindingData.setDataSelect(true);
                }
                break;
            default:
                break;
        }
    }
}
