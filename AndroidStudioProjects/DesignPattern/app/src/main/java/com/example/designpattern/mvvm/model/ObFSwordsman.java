package com.example.designpattern.mvvm.model;

import androidx.databinding.ObservableField;

/**
 * 根据字段ObservableField来更新
 */
public class ObFSwordsman {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> level = new ObservableField<>();

    public ObFSwordsman(String name, String level){
        this.name.set(name);
        this.level.set(level);
    }

    public ObservableField<String> getLevel() {
        return level;
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public void setLevel(ObservableField<String> level) {
        this.level = level;
    }
}
