package com.example.serializableparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableActivity extends AppCompatActivity {
    String path = Environment.getExternalStorageDirectory().getAbsoluteFile() + "/" + "user.dat";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serializable);
        storageSerializable();
        getSerializable();
    }

    /**
     * 利用serializable,读取本地的serializable数据
     */
    private void getSerializable() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        File file = new File(path);
        try {
            if (file.exists()) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                User user = (User) ois.readObject();
                Log.d("serializable_user",user.getUsername()+"age:"+user.getAge());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 利用serializable，将对象保存到本地
     */
    private void storageSerializable() {
        User user = new User("Hello World", 24);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            File file = new File(path);
            if (file.createNewFile()) {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(user);
                oos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //在这里做资源的关闭
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}