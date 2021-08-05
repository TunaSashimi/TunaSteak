package com.tunasteak.activity

import android.view.View
import com.tunasteak.data.Data
import com.tunasteak.demo.R
import com.tunasteak.demo.databinding.ActivityDataShowBinding
import com.tunasteak.model.TBindingModel
import com.tunasteak.model.DataShowModel

/**
 * @author TunaSashimi
 * @date 2020-03-11 11:17
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
class DataShowBindingActivity : TBindingActivity<ActivityDataShowBinding?>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_data_show
    }

    override fun getModel(): TBindingModel<*> {
        return DataShowModel(binding, intent)
    }

    override fun getData(): Any {
        return Data.getInstance()
    }

    override fun onInit() {}
    override fun onClick(v: View) {
        when (v.id) {
            R.id.button -> {
                val bindingData = Data.getInstance()
                bindingData.setDataShow("DATA SHOW")
                if (bindingData.dataSelect.get()) {
                    bindingData.setDataSelect(false)
                } else {
                    bindingData.setDataSelect(true)
                }
            }
            R.id.buttonShowLoading -> model.showLoading()
            R.id.buttonDismissLoading -> model.dismissLoading()
            else -> {
            }
        }
    }
}