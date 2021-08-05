package com.tunasteak.activity

import android.view.View
import com.tunasteak.demo.R
import com.tunasteak.demo.databinding.ActivityChooseMultipleBinding
import com.tunasteak.model.TBindingModel
import com.tunasteak.model.ChooseMultipleModel

class ChooseMultipleBindingActivity : TBindingActivity<ActivityChooseMultipleBinding?>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_choose_multiple
    }

    override fun getModel(): TBindingModel<*> {
        return ChooseMultipleModel(binding, intent)
    }

    override fun getData(): Any? {
        return null
    }

    override fun onInit() {}
    override fun onClick(v: View) {}
}