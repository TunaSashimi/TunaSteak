package com.tunasteak.model;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.tunasteak.demo.R;
import com.tunasteak.activity.ChooseMultipleBindingActivity;
import com.tunasteak.adapter.TBindingAdapter;
import com.tunasteak.bean.ChooseBean;
import com.tunasteak.data.TBindingData;
import com.tunasteak.demo.databinding.ActivityChooseMultipleBinding;
import com.tunasteak.demo.databinding.ActivityChooseMultipleItemBinding;
import com.tunasteak.listener.OnItemClickListener;
import com.tunasushi.tuna.TView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tunasashimi
 * @date 2020-01-19 15:42
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
public class ChooseMultipleModel extends TBindingModel<ActivityChooseMultipleBinding> implements OnItemClickListener<ActivityChooseMultipleItemBinding> {
    private ChooseMultipleBindingActivity activity;
    public List<ChooseBean> chooseBeanList = new ArrayList();

    public ChooseMultipleModel(ActivityChooseMultipleBinding binding, Intent intent) {
        super(binding);
        this.binding = binding;
        this.activity = (ChooseMultipleBindingActivity) binding.getRoot().getContext();
        initData(intent);
    }

    @Override
    public void onItemClick(View v, int position, ActivityChooseMultipleItemBinding binding) {
        //
        Toast.makeText(v.getContext(), "position==>" + position, Toast.LENGTH_SHORT).show();

        switch (v.getId()) {
            case R.id.tViewSelect:
                TView t = (TView) v;
                if (t.isSelect()) {
                    //do something
                } else {
                    //do something
                }
                break;
            default:
                break;
        }
    }

    protected void initData(Intent intent) {
        chooseBeanList.add(new ChooseBean("CHOOSE 01"));
        chooseBeanList.add(new ChooseBean("CHOOSE 02"));
        chooseBeanList.add(new ChooseBean("CHOOSE 03"));
        chooseBeanList.add(new ChooseBean("CHOOSE 04"));
        chooseBeanList.add(new ChooseBean("CHOOSE 05"));

        chooseBeanList.add(new ChooseBean("CHOOSE 06"));
        chooseBeanList.add(new ChooseBean("CHOOSE 07"));
        chooseBeanList.add(new ChooseBean("CHOOSE 08"));
        chooseBeanList.add(new ChooseBean("CHOOSE 09"));
        chooseBeanList.add(new ChooseBean("CHOOSE 10"));

        //
        binding.setAdapter(new TBindingAdapter(chooseBeanList, R.layout.activity_choose_multiple_item, this));
    }

    public void chooseAll() {
        TBindingData tBindingData = TBindingData.getInstance();
        tBindingData.setChooseIndex(-1);
        if (tBindingData.getChooseAll().get()) {
            tBindingData.setChooseAll(false);
            //do something
        } else {
            tBindingData.setChooseAll(true);
            //do something
        }
    }
}
