package com.example.serializableparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Parcelable的设计初衷是因为Serializable效率过慢，
 * 为了在程序内不同组件间以及不同Android程序间(AIDL)高效的传输数据而设计，
 * 这些数据仅在内存中存在，Parcelable是通过IBinder通信的消息的载体。
 *
 * Parcelable的性能比Serializable好，在内存开销方面较小，
 * 所以在内存间数据传输时推荐使用Parcelable，如activity间传输数据
 *
 * Parcelable则需要实现writeToParcel、describeContents函数以及静态的CREATOR变量，
 * 实际上就是将如何打包和解包的工作自己来定义，
 * 而序列化的这些操作完全由底层实现。
 */
public class MyParcelable implements Parcelable {
    private int mData;
    private String mStr;

    /**
     * 读数据进行恢复
     * @param in
     */
    protected MyParcelable(Parcel in) {
        mData = in.readInt();
        mStr = in.readString();
    }

    /**
     * 写数据进行保存
     * 将需要持久化的字段保存到一个Parcel对象里面
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mData);
        dest.writeString(mStr);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 用来创建自定义的Parcelable的对象
     * 从Parcel对象中，取出相应的字段，完成对象的恢复过程
     */
    public static final Creator<MyParcelable> CREATOR = new Creator<MyParcelable>() {
        @Override
        public MyParcelable createFromParcel(Parcel in) {
            return new MyParcelable(in);
        }

        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };
}
