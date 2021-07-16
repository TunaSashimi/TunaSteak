package com.tunasteak.model;

import android.content.Intent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.tunasteak.activity.ExpandableListViewBindingActivity;
import com.tunasteak.adapter.TBindingExpandableListAdapter;
import com.tunasteak.bean.HeroBean;
import com.tunasteak.bean.ProfessionBean;
import com.tunasteak.data.BindingData;
import com.tunasteak.demo.R;
import com.tunasteak.demo.databinding.ActivityExpandableListViewBinding;
import com.tunasteak.demo.databinding.ActivityExpandableListViewItem01Binding;
import com.tunasteak.listener.OnChildCountListener;
import com.tunasteak.listener.OnChildListener;
import com.tunasteak.listener.OnItemChildClickListener;
import com.tunasteak.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ViewDataBinding;

/**
 * @author Tunasashimi
 * @date 2020-01-19 15:42
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
public class ExpandableListViewModel extends TBindingModel<ActivityExpandableListViewBinding> implements OnItemClickListener<ActivityExpandableListViewItem01Binding> {
    private ExpandableListViewBindingActivity activity;

    public ExpandableListViewModel(ActivityExpandableListViewBinding binding, Intent intent) {
        super(binding);
        this.binding = binding;
        this.activity = (ExpandableListViewBindingActivity) binding.getRoot().getContext();
        initData(intent);
    }

    @Override
    public void onItemClick(View v, int position, ActivityExpandableListViewItem01Binding binding) {
    }

    protected void initData(Intent intent) {

    }

    public void change() {
        //
        String[] professionArray = {"射手", "辅助", "坦克", "法师"};
        String[][] hreoArray = {
                {"孙尚香", "后羿", "马可波罗", "狄仁杰"},
                {"孙膑", "蔡文姬", "鬼谷子", "杨玉环"},
                {"张飞", "廉颇", "牛魔", "项羽"},
                {"诸葛亮", "王昭君", "安琪拉", "干将"}
        };

        //
        List<ProfessionBean> professionBeanList = new ArrayList();
        ProfessionBean professionBeanShooter = new ProfessionBean();
        ProfessionBean professionBeanAssist = new ProfessionBean();
        ProfessionBean professionBeanTank = new ProfessionBean();
        ProfessionBean professionBeanMage = new ProfessionBean();
        professionBeanList.add(professionBeanShooter);
        professionBeanList.add(professionBeanAssist);
        professionBeanList.add(professionBeanTank);
        professionBeanList.add(professionBeanMage);

        //
        for (int i = 0; i < professionArray.length; i++) {
            ProfessionBean professionBean = professionBeanList.get(i);
            professionBean.name = professionArray[i];
            for (int j = 0; j < hreoArray[i].length; j++) {
                HeroBean heroBean = new HeroBean(hreoArray[i][j]);
                professionBean.heroBeanList.add(heroBean);
            }
        }

        //
        BindingData.getInstance().setPrefessionBeanList(professionBeanList);
    }

    //
    @BindingAdapter({"data"})
    public static void setData(final ExpandableListView expandableListView, final List<ProfessionBean> professionBeanList) {
        if (professionBeanList != null && professionBeanList.size() > 0) {
            TBindingExpandableListAdapter tBindingExpandableListAdapter = new TBindingExpandableListAdapter(professionBeanList,
                    R.layout.activity_expandable_list_view_item01,
                    R.layout.activity_expandable_list_view_item02,
                    new OnChildCountListener() {
                        @Override
                        public int getChildCount(int groupPosition) {
                            return professionBeanList.get(groupPosition).heroBeanList.size();
                        }
                    },
                    new OnChildListener() {
                        @Override
                        public Object getChild(int groupPosition, int childPosition) {
                            return professionBeanList.get(groupPosition).heroBeanList.get(childPosition);
                        }
                    },
                    new OnItemClickListener() {
                        @Override
                        public void onItemClick(View v, int position, ViewDataBinding binding) {

                        }
                    },
                    new OnItemChildClickListener() {
                        @Override
                        public void onItemChildClick(View v, int groupPosition, int childPosition, ViewDataBinding binding) {
                            Toast.makeText(v.getContext(), "groupPosition==>" + groupPosition + "childPosition==>" + childPosition, Toast.LENGTH_SHORT).show();
                        }
                    }
            );
            expandableListView.setAdapter(tBindingExpandableListAdapter);
            //
            expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                @Override
                public void onGroupExpand(int groupPosition) {
                    int count = professionBeanList.size();
                    for (int i = 0; i < count; i++) {
                        if (i != groupPosition) {
                            expandableListView.collapseGroup(i);
                        }
                    }
                }
            });
            //
            expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                @Override
                public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                    return false;
                }
            });
        }
    }
}
