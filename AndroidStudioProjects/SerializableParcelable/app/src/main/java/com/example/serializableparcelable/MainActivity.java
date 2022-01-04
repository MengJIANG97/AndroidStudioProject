package com.example.serializableparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button parcel_btn = findViewById(R.id.parcel_btn);
        parcel_btn.setOnClickListener(view -> {
            Intent intent = new Intent(this,ParcelableActivity.class);
            intent.putExtra("person",new Person("Hello World",24));
            startActivity(intent);
        });
    }
}