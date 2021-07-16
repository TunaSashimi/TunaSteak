package com.tunasteak.data;

import com.tunasteak.bean.ProfessionBean;

import java.util.List;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

/**
 * @author Tunasashimi
 * @date 2019-06-29 21:00
 * @Copyright 2019 TunaSashimi. All rights reserved.
 * @Description
 */
public class Data {
    private Data() {
    }

    private static Data instance = new Data();

    public static Data getInstance() {
        return instance;
    }

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

    private ObservableField<List<ProfessionBean>> PrefessionBeanList = new ObservableField();

    public ObservableField<List<ProfessionBean>> getPrefessionBeanList() {
        return PrefessionBeanList;
    }

    public void setPrefessionBeanList(List<ProfessionBean> prefessionBeanList) {
        PrefessionBeanList.set(prefessionBeanList);
    }
}