package com.tunasteak.activity

import android.view.View
import com.tunasteak.activity.TBindingActivity
import com.tunasteak.demo.R
import com.tunasteak.demo.databinding.ActivityChooseSingleBinding
import com.tunasteak.model.TBindingModel
import com.tunasteak.model.ChooseSingleModel

class ChooseSingleBindingActivity : TBindingActivity<ActivityChooseSingleBinding?>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_choose_single
    }

    override fun getModel(): TBindingModel<*> {
        return ChooseSingleModel(binding, intent)
    }

    override fun getData(): Any? {
        return null
    }

    override fun onInit() {}
    override fun onClick(v: View) {}
}