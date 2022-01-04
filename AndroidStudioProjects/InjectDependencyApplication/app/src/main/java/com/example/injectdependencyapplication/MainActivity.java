package com.example.injectdependencyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindViews({R.id.button1})//绑定多个控件id
    List<Button> buttons;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.tv_text)//绑定控件
    TextView tv_text;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        tv_text.setText("InjectDependency");
        buttons.get(0).setText("ButterKnife");
    }

    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.button1)//对点击事件进行监听
    public void showToast() {
        Intent intent = new Intent(this, ButterKnifeActivity.class);
        startActivity(intent);
    }
}