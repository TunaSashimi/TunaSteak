package com.tunasteak.listener

import android.view.View
import androidx.databinding.ViewDataBinding

/**
 * @author Tunasashimi
 * @date 2020-01-17 11:57
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
interface OnItemClickListener<B : ViewDataBinding?> {
    fun onItemClick(v: View?, position: Int, binding: B)
}