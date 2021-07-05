package com.tunasteak.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tunasteak.BR;
import com.tunasteak.data.TBindingData;
import com.tunasteak.listener.OnItemClickListener;
import com.tunasushi.view.TView;
import java.util.List;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * @author Tunasashimi
 * @date 2019-06-29 21:00
 * @Copyright 2019 TunaSashimi. All rights reserved.
 * @Description
 */
public class TBindingAdapter extends BaseAdapter {
    protected List list;
    protected int itemId;
    protected int layoutId;
    protected OnItemClickListener onItemClickListener;

    /**
     * Need to disable the parameterless constructor!
     */
    private TBindingAdapter() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public TBindingAdapter(List list, int layoutId, OnItemClickListener onItemClickListener) {
        this.list = list;
        this.itemId = BR.bean;
        this.layoutId = layoutId;
        this.onItemClickListener = onItemClickListener;
    }

    public TBindingAdapter(List list, int itemId, int layoutId, OnItemClickListener onItemClickListener) {
        this.list = list;
        this.itemId = itemId;
        this.layoutId = layoutId;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewDataBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }
        TView.OnClickListener onClickListener = new TView.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v, position, binding);
            }
        };
        //
        binding.setVariable(itemId, list.get(position));
        binding.setVariable(BR.size, list.size());
        binding.setVariable(BR.position, position);
        binding.setVariable(BR.data, TBindingData.getInstance());
        binding.setVariable(BR.onClickListener, onClickListener);
        //
        binding.executePendingBindings();
        return binding.getRoot();
    }
}
