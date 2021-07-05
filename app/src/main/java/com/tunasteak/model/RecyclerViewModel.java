package com.tunasteak.model;

import android.content.Intent;
import android.view.View;
import com.tunasteak.activity.RecyclerViewBindingActivity;
import com.tunasteak.adapter.TBindingRecycler;
import com.tunasteak.demo.R;
import com.tunasteak.demo.databinding.ActivityRecyclerViewBinding;
import com.tunasteak.demo.databinding.ActivityRecyclerViewItemBinding;
import com.tunasteak.itemDecoration.RecyclerItemDecoration;
import com.tunasteak.listener.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.DefaultItemAnimator;

/**
 * @author Tunasashimi
 * @date 2020-01-19 15:42
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
public class RecyclerViewModel extends TBindingModel<ActivityRecyclerViewBinding> implements OnItemClickListener<ActivityRecyclerViewItemBinding> {
    private RecyclerViewBindingActivity activity;
    private TBindingRecycler tBindingRecycler;
    //
    private List<String> dataList = new ArrayList();

    public RecyclerViewModel(ActivityRecyclerViewBinding binding, Intent intent) {
        super(binding);
        this.binding = binding;
        this.activity = (RecyclerViewBindingActivity) binding.getRoot().getContext();
        initData(intent);
    }

    @Override
    public void onItemClick(View v, int position, ActivityRecyclerViewItemBinding binding) {
    }

    protected void initData(Intent intent) {
        for (int i = 'A'; i < 'Z'; i++) {
            dataList.add("" + (char) i);
        }

        //
        tBindingRecycler = new TBindingRecycler(dataList, R.layout.activity_recycler_view_item, this);
        binding.setAdapter(tBindingRecycler);

        //Item间的间隔
        binding.recyclerView.addItemDecoration(new RecyclerItemDecoration(activity));
        //Item删减动画
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
