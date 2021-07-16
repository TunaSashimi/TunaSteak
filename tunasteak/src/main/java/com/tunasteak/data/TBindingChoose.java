package com.tunasteak.data;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;

/**
 * @author Tunasashimi
 * @date 2019-06-29 21:00
 * @Copyright 2019 TunaSashimi. All rights reserved.
 * @Description
 */
public class TBindingChoose {
    private TBindingChoose() {
    }

    private static TBindingChoose instance = new TBindingChoose();

    public static TBindingChoose getInstance() {
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
}