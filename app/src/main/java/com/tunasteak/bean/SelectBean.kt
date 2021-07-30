package com.tunasteak.bean

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableBoolean

/**
 * @author TunaSashimi
 * @date 2020-04-11 23:42
 * @Copyright 2020 TunaSashimi. All rights reserved.
 * @Description
 */
class SelectBean : BaseObservable() {
    @JvmField
    var select = ObservableBoolean()
}