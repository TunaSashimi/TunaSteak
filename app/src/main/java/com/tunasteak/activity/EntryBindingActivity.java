package com.tunasteak.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.tunasteak.demo.R;
import com.tunasteak.demo.databinding.ActivityEntryBinding;
import com.tunasteak.model.TBindingModel;
import java.util.ArrayList;
import java.util.List;

public class EntryBindingActivity extends TBindingActivity<ActivityEntryBinding> {
    private Class<?>[] cla = {
            DataShowBindingActivity.class,
            TwoWayBindingActivity.class,

            ChooseSingleBindingActivity.class,
            ChooseMultipleBindingActivity.class,
            ExpandableListViewBindingActivity.class,
            GridViewBindingActivity.class,
            RecyclerViewBindingActivity.class,

            TLoadBindingActivity.class,
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_entry;
    }

    @Override
    protected TBindingModel getModel() {
        return null;
    }

    @Override
    public void onInit() {
        List<String> stringList = new ArrayList();
        for (int i = 0; i < cla.length; i++) {
            stringList.add(cla[i].getSimpleName());
        }

        //
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter(this, R.layout.activity_entry_item, stringList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                startActivity(new Intent(EntryBindingActivity.this, cla[arg2]));
            }
        });

        binding.listView.setAdapter(new ArrayAdapter(this, R.layout.activity_entry_item, stringList));
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                startActivity(new Intent(EntryBindingActivity.this, cla[arg2]));
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}