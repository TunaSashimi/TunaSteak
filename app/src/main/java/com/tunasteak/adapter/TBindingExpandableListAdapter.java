package com.tunasteak.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.tunasteak.data.TBindingData;
import com.tunasteak.listener.OnChildCountListener;
import com.tunasteak.listener.OnChildListener;
import com.tunasteak.listener.OnItemChildClickListener;
import com.tunasteak.listener.OnItemClickListener;

import com.tunasushi.tuna.TView;

import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public class TBindingExpandableListAdapter extends BaseExpandableListAdapter {
    private List list;
    protected int itemId01;
    protected int layoutId01;

    protected int itemId02;
    protected int layoutId02;

    protected OnItemClickListener onItemClickListener;
    protected OnItemChildClickListener onItemChildClickListener;

    public OnChildCountListener childCountListener;
    public OnChildListener childListener;

    public TBindingExpandableListAdapter(List list,
                                         int layoutId01, int layoutId02,
                                         OnChildCountListener childCountListener,
                                         OnChildListener childListener,
                                         OnItemClickListener onItemClickListener,
                                         OnItemChildClickListener onItemChildClickListener) {
        this.list = list;
        this.itemId01 = com.tunasteak.BR.bean;
        this.itemId02 = com.tunasteak.BR.bean;
        this.layoutId01 = layoutId01;
        this.layoutId02 = layoutId02;
        this.childCountListener = childCountListener;
        this.childListener = childListener;
        this.onItemClickListener = onItemClickListener;
        this.onItemChildClickListener = onItemChildClickListener;
    }

    public TBindingExpandableListAdapter(List list,
                                         int itemId01, int layoutId01,
                                         int itemId02, int layoutId02,
                                         OnChildCountListener childCountListener,
                                         OnChildListener childListener,
                                         OnItemClickListener onItemClickListener,
                                         OnItemChildClickListener onItemChildClickListener) {
        this.list = list;
        this.itemId01 = itemId01;
        this.itemId02 = itemId02;
        this.layoutId01 = layoutId01;
        this.layoutId02 = layoutId02;
        this.childCountListener = childCountListener;
        this.childListener = childListener;
        this.onItemClickListener = onItemClickListener;
        this.onItemChildClickListener = onItemChildClickListener;
    }

    @Override
    public int getGroupCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        int childrenCount = childCountListener.getChildCount(groupPosition);
        if (childrenCount > 0) {
            return childrenCount;
        } else {
            return 0;
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childListener.getChild(groupPosition, childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final ViewDataBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId01, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }
        TView.OnClickListener onClickListener = new TView.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v, groupPosition, binding);
            }
        };
        //
        binding.setVariable(itemId01, list.get(groupPosition));
        binding.setVariable(com.tunasteak.BR.size, list.size());
        binding.setVariable(com.tunasteak.BR.position, groupPosition);
        binding.setVariable(com.tunasteak.BR.expanded, isExpanded);
        //
        binding.setVariable(com.tunasteak.BR.data, TBindingData.getInstance());
        binding.setVariable(com.tunasushi.BR.onClickListener, onClickListener);
        //
        binding.executePendingBindings();
        return binding.getRoot();
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final ViewDataBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId02, parent, false);
        } else {
            binding = DataBindingUtil.getBinding(convertView);
        }
        TView.OnClickListener onClickListener = new TView.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemChildClickListener.onItemChildClick(v, groupPosition, childPosition, binding);
            }
        };
        //
        binding.setVariable(itemId02, childListener.getChild(groupPosition, childPosition));
        binding.setVariable(com.tunasteak.BR.data, TBindingData.getInstance());
        binding.setVariable(com.tunasushi.BR.onClickListener, onClickListener);
        //
        binding.executePendingBindings();
        return binding.getRoot();
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}