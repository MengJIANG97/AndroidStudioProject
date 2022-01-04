package com.example.designpattern.mvvm.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.designpattern.BR;

/**
 * 动态更新机制
 * 根据Model实体类的内容来动态更新UI
 * 对应类(Observable)的动态更新
 */
public class ObSwordsman extends BaseObservable {
    private String name;
    private String level;

    public ObSwordsman(String name, String level) {
        this.name = name;
        this.level = level;
    }

    /**
     * 在getter()方法中使用@Bindable注解
     * 该注解让该方法在BR中生成相应的字段
     *
     * @return
     */
    @Bindable
    public String getLevel() {
        return level;
    }

    @Bindable
    public String getName() {
        return name;
    }

    /**
     * 在setter()方法中通知更新
     *
     * @param level
     */
    public void setLevel(String level) {
        this.level = level;
        /*
         * 通知更新，BR为编译的时候生成的类
         * notifyPropertyChanged()方法通知系统BR这个字段的数据发生了
         * 变化并更新UI
         */
        notifyPropertyChanged(BR.level);
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
