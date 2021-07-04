package com.tunasteak.model;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;


import com.tunasteak.R;
import com.tunasteak.activity.ChooseSingleBindingActivity;
import com.tunasteak.adapter.TBindingAdapter;
import com.tunasteak.bean.ChooseBean;
import com.tunasteak.data.TBindingData;
import com.tunasteak.databinding.ActivityChooseSingleBinding;
import com.tunasteak.databinding.ActivityChooseSingleItemBinding;
import com.tunasteak.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tunasashimi
 * @date 2020-01-19 15:42
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
public class ChooseSingleModel extends TBindingModel<ActivityChooseSingleBinding> implements OnItemClickListener<ActivityChooseSingleItemBinding> {
    private ChooseSingleBindingActivity activity;
    public List<ChooseBean> chooseBeanList = new ArrayList();

    public ChooseSingleModel(ActivityChooseSingleBinding binding, Intent intent) {
        super(binding);
        this.binding = binding;
        this.activity = (ChooseSingleBindingActivity) binding.getRoot().getContext();
        initData(intent);
    }

    @Override
    public void onItemClick(View v, int position, ActivityChooseSingleItemBinding binding) {

        //
        Toast.makeText(v.getContext(), "position==>" + position, Toast.LENGTH_SHORT).show();

        switch (v.getId()) {
            case R.id.tViewSelect:
                TBindingData bindingData = TBindingData.getInstance();
                int index = bindingData.getChooseIndex().get();
                if (position != index) {
                    bindingData.setChooseIndex(position);
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
        binding.setAdapter(new TBindingAdapter(chooseBeanList, R.layout.activity_choose_single_item, this));
    }
}
