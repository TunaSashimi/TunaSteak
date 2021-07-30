package com.tunasteak.model;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.tunasteak.activity.GridViewBindingActivity;
import com.tunasteak.adapter.TBindingAdapter;
import com.tunasteak.bean.PersonBean;
import com.tunasteak.demo.R;
import com.tunasteak.demo.databinding.ActivityGridViewBinding;
import com.tunasteak.demo.databinding.ActivityGridViewItemBinding;
import com.tunasteak.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tunasashimi
 * @date 2020-01-19 15:42
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
public class GridViewModel extends TBindingModel<ActivityGridViewBinding> implements OnItemClickListener<ActivityGridViewItemBinding> {
    private GridViewBindingActivity activity;
    private TBindingAdapter tBindingAdapter;
    //
    public List<PersonBean> personBeanList = new ArrayList();

    public GridViewModel(ActivityGridViewBinding binding, Intent intent) {
        super(binding);
        this.binding = binding;
        this.activity = (GridViewBindingActivity) binding.getRoot().getContext();
        initData(intent);
    }

    @Override
    public void onItemClick(View v, int position, ActivityGridViewItemBinding binding) {
        switch (v.getId()) {
            case R.id.tvName:
            case R.id.tViewAge:
                Toast.makeText(activity, "position==>" + position, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    protected void initData(Intent intent) {
        personBeanList.add(new PersonBean("张三", 25, false));
        personBeanList.add(new PersonBean("李四", 26, false));
        personBeanList.add(new PersonBean("王五", 27, false));
        personBeanList.add(new PersonBean("赵六", 28, false));

        personBeanList.add(new PersonBean("孙七", 29, true));
        personBeanList.add(new PersonBean("周八", 30, true));
        personBeanList.add(new PersonBean("吴九", 31, true));
        personBeanList.add(new PersonBean("郑十", 32, true));

        //
        tBindingAdapter = new TBindingAdapter(personBeanList, R.layout.activity_grid_view_item, this);
        binding.setAdapter(tBindingAdapter);
    }

    public void change() {
        for (int i = 0; i < personBeanList.size(); i++) {
            PersonBean personBean = personBeanList.get(i);
            if (personBean.getAge() == 25) {
                personBean.setAge(26);
            } else {
                personBean.setAge(25);
            }
        }
        binding.setAdapter(tBindingAdapter);
    }
}
