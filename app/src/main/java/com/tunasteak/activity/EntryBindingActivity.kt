package com.tunasteak.activity

import com.tunasteak.demo.R
import com.tunasteak.model.TBindingModel
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.content.Intent
import android.view.View
import android.widget.ListView
import com.tunasteak.demo.databinding.ActivityEntryBinding
import java.util.ArrayList

class EntryBindingActivity : TBindingActivity<ActivityEntryBinding?>() {
    private val cla = arrayOf<Class<*>>(
        DataShowBindingActivity::class.java,
        TwoWayBindingActivity::class.java,
        ChooseSingleBindingActivity::class.java,
        ChooseMultipleBindingActivity::class.java,
        ExpandableListViewBindingActivity::class.java,
        GridViewBindingActivity::class.java,
        RecyclerViewBindingActivity::class.java
    )

    override fun getLayoutId(): Int {
        return R.layout.activity_entry
    }

    override fun getModel(): TBindingModel<*>? {
        return null
    }

    override fun getData(): Any? {
        return null
    }

    override fun onInit() {
        val stringList: MutableList<String?> = ArrayList()
        for (i in cla.indices) {
            stringList.add(cla[i].simpleName)
        }

        //
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = ArrayAdapter(this, R.layout.activity_entry_item, stringList)
        listView.onItemClickListener = AdapterView.OnItemClickListener { arg0, arg1, arg2, arg3 ->
            startActivity(
                Intent(
                    this@EntryBindingActivity,
                    cla[arg2]
                )
            )
        }
        binding!!.listView.adapter =
            ArrayAdapter(this, R.layout.activity_entry_item, stringList)
        binding!!.listView.onItemClickListener =
            AdapterView.OnItemClickListener { arg0, arg1, arg2, arg3 ->
                startActivity(
                    Intent(
                        this@EntryBindingActivity,
                        cla[arg2]
                    )
                )
            }
    }

    override fun onClick(v: View) {}
}