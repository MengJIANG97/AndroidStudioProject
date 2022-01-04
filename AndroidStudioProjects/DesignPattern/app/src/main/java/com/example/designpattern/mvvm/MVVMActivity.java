package com.example.designpattern.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.designpattern.R;
import com.example.designpattern.databinding.ActivityMvvmactivityBinding;
import com.example.designpattern.mvvm.model.ObSwordsman;
import com.example.designpattern.mvvm.model.Swordsman;

import java.util.Date;

/**
 * 在MVVM模式中
 * 当View发生改变时：ViewModel通知Model进行数据更新
 * 当Model发生数据更新时：ViewModel通知View更新
 */

public class MVVMActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_mvvmactivity);
        /*
         * 替代setContentView()
         * ActivityMvvmactivityBinding是系统根据layout文件生成的一个
         * ViewModel类(Binding辅助类)，它包含了布局文件中所有的绑定关系，
         * 并会根据绑定表达式给布局文件赋值
         */
        ActivityMvvmactivityBinding binding = DataBindingUtil.setContentView(
                this, R.layout.activity_mvvmactivity
        );
        Swordsman swordsman = new Swordsman("Hello World", "24");
        binding.setSwordsman(swordsman);
        binding.setTime(new Date());

        /*
         * 根据类动态更新UI
         */
        ObSwordsman obSwordsman = new ObSwordsman("HELLO WORLD", "24");
        binding.setObsworman(obSwordsman);
        binding.btUpdateObswordsman.setOnClickListener(view -> obSwordsman.setName("hello world"));


    }
}