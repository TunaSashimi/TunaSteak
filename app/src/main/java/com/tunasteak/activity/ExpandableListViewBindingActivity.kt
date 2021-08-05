package com.tunasteak.activity

import android.view.View
import com.tunasteak.data.Data
import com.tunasteak.demo.R
import com.tunasteak.demo.databinding.ActivityExpandableListViewBinding
import com.tunasteak.model.TBindingModel
import com.tunasteak.model.ExpandableListViewModel

class ExpandableListViewBindingActivity : TBindingActivity<ActivityExpandableListViewBinding?>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_expandable_list_view
    }

    override fun getModel(): TBindingModel<*> {
        return ExpandableListViewModel(binding, intent)
    }

    override fun getData(): Any {
        return Data.getInstance()
    }

    override fun onInit() {}
    override fun onClick(v: View) {
        when (v.id) {
            else -> {
            }
        }
    }
}