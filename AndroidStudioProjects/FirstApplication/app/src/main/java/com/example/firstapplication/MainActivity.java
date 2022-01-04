package com.example.firstapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.widget.Button;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.btn1)
    Button button;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, MainActivity2.class);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img);
        /*
         * 产生异常
         * Bitmap，本身就已经实现了 Parcelable 是可以支持序列化的。
         * 用 Intent 传输，稍微大一点的图一定会出现 TransactionTooLargeException
         */
        //intent.putExtra("bitmap", bitmap);
        ByteArrayOutputStream byos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byos);
        byte[] bytes = byos.toByteArray();
        intent.putExtra("bitmap", bytes);
        Button intent_btn = findViewById(R.id.intent_btn);
        intent_btn.setOnClickListener(view -> startActivity(intent));

        ButterKnife.bind(this);
        button.setOnClickListener(view ->
                Toast.makeText(this, "Hello Button1", Toast.LENGTH_SHORT)
                        .show());


         


    }
}