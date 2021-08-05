package com.tunasteak.activity

import android.view.View
import com.tunasteak.activity.TBindingActivity
import com.tunasteak.demo.R
import com.tunasteak.model.TBindingModel
import com.tunasteak.bean.SelectBean
import com.tunasteak.demo.databinding.ActivityTwoWayBindingBinding

/**
 * @author TunaSashimi
 * @date 2020-04-12 20:30
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
class TwoWayBindingActivity : TBindingActivity<ActivityTwoWayBindingBinding?>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_two_way_binding
    }

    override fun getModel(): TBindingModel<*>? {
        return null
    }

    override fun getData(): Any? {
        return null
    }

    override fun onInit() {
        val selectBean = SelectBean()
        binding!!.bean = selectBean
        selectBean.select.set(true)
    }

    override fun onClick(v: View) {}
}