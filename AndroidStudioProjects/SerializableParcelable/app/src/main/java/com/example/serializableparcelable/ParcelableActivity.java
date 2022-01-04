package com.example.serializableparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ParcelableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);
        Person person = getIntent().getParcelableExtra("person");
        //获取传递过来的数据
    }
}