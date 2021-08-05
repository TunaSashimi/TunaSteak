package com.tunasteak.activity

import android.view.View
import com.tunasteak.demo.R
import com.tunasteak.demo.databinding.ActivityRecyclerViewBinding
import com.tunasteak.model.TBindingModel
import com.tunasteak.model.RecyclerViewModel

class RecyclerViewBindingActivity : TBindingActivity<ActivityRecyclerViewBinding?>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_recycler_view
    }

    override fun getModel(): TBindingModel<*> {
        return RecyclerViewModel(binding, intent)
    }

    override fun getData(): Any? {
        return null
    }

    override fun onInit() {}
    override fun onClick(v: View) {}
}