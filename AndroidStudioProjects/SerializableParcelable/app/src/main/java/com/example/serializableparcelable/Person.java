package com.example.serializableparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String username;
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public Person(String username) {
        this.username = username;
    }

    public Person(String username, int age) {
        this.username = username;
        this.age = age;
    }

    protected Person(Parcel in) {
        username = in.readString();
        age = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeInt(age);
    }
}
