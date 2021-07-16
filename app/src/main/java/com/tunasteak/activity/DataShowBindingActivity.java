package com.tunasteak.activity;

import android.view.View;

import com.tunasteak.data.Data;
import com.tunasteak.demo.R;
import com.tunasteak.demo.databinding.ActivityDataShowBinding;
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
    protected Object getData() {
        return Data.getInstance();
    }

    @Override
    public void onInit() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Data bindingData = Data.getInstance();
                bindingData.setDataShow("DATA SHOW");
                if (bindingData.getDataSelect().get()) {
                    bindingData.setDataSelect(false);
                } else {
                    bindingData.setDataSelect(true);
                }
                break;
            default:
                break;
        }
    }
}
