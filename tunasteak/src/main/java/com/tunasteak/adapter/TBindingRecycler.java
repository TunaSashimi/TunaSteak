package com.tunasteak.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tunasteak.BR;
import com.tunasteak.data.TBindingChoose;
import com.tunasteak.listener.OnItemClickListener;
import com.tunasushi.view.TView;
import java.util.ArrayList;
import java.util.List;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author TunaSashimi
 * @date 2020-03-03 11:06
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
public class TBindingRecycler extends RecyclerView.Adapter {
    protected List list;
    protected int itemId;
    protected int layoutId;
    protected OnItemClickListener onItemClickListener;

    /**
     * Need to disable the parameterless constructor!
     */
    private TBindingRecycler() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public TBindingRecycler(List list, int layoutId, OnItemClickListener viewOnItemClick) {
        this.list = list;
        this.itemId = BR.bean;
        this.layoutId = layoutId;
        this.onItemClickListener = viewOnItemClick;
        //
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        notifyDataSetChanged();
    }

    public TBindingRecycler(List list, int itemId, int layoutId, OnItemClickListener viewOnItemClick) {
        this.list = list;
        this.itemId = itemId;
        this.layoutId = layoutId;
        this.onItemClickListener = viewOnItemClick;
        //
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId, parent, false);
        return new RecyclerHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ViewDataBinding binding = DataBindingUtil.getBinding(holder.itemView);
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
        binding.setVariable(BR.choose, TBindingChoose.getInstance());
        binding.setVariable(BR.onClickListener, onClickListener);
        //
        binding.executePendingBindings();
    }

    class RecyclerHolder extends RecyclerView.ViewHolder {
        public RecyclerHolder(View itemView) {
            super(itemView);
        }
    }
}