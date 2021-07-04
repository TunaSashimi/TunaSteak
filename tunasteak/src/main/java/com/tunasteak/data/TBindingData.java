package com.tunasteak.data;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

/**
 * @author Tunasashimi
 * @date 2019-06-29 21:00
 * @Copyright 2019 TunaSashimi. All rights reserved.
 * @Description
 */
public class TBindingData {
    private TBindingData() {
    }

    private static TBindingData instance = new TBindingData();

    public static TBindingData getInstance() {
        return instance;
    }

    private ObservableBoolean chooseAll = new ObservableBoolean(false);

    public ObservableBoolean getChooseAll() {
        return chooseAll;
    }

    public void setChooseAll(Boolean chooseAll) {
        this.chooseAll.set(chooseAll);
    }

    private ObservableInt chooseIndex = new ObservableInt(-1);

    public ObservableInt getChooseIndex() {
        return chooseIndex;
    }

    public void setChooseIndex(int chooseIndex) {
        this.chooseIndex.set(chooseIndex);
    }

    //必须起跟类库中一样的类名和包名把需要增加的属性加在下面
    private ObservableField<String> dataShow = new ObservableField();

    public ObservableField<String> getDataShow() {
        return dataShow;
    }

    public void setDataShow(String dataShow) {
        this.dataShow.set(dataShow);
    }

    private ObservableBoolean dataSelect = new ObservableBoolean();

    public ObservableBoolean getDataSelect() {
        return dataSelect;
    }

    public void setDataSelect(boolean dataSelect) {
        this.dataSelect.set(dataSelect);
    }
}