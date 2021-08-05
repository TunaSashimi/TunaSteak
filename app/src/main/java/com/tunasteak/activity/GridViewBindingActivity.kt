package com.tunasteak.activity

import android.view.View
import com.tunasteak.activity.TBindingActivity
import com.tunasteak.demo.R
import com.tunasteak.demo.databinding.ActivityGridViewBinding
import com.tunasteak.model.TBindingModel
import com.tunasteak.model.GridViewModel

class GridViewBindingActivity : TBindingActivity<ActivityGridViewBinding?>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_grid_view
    }

    override fun getModel(): TBindingModel<*> {
        return GridViewModel(binding, intent)
    }

    override fun getData(): Any? {
        return null
    }

    override fun onInit() {}
    override fun onClick(v: View) {}
}