package com.example.serializableparcelable;

import java.io.Serializable;

/**
 * Serializabale接口是一个空接口
 * 具体的序列化与反序列化操作是由ObjectOutputStream和ObjectInputStream完成的
 * 内部采用java的反射机制，在运行时判断类的serialVersionUID来验证版本一致性的
 * 进行反序列化时，
 * JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，
 * 如果相同就认为是一致的，可以进行反序列化，
 * 否则就会出现序列化版本不一致的异常，所以相比之下消耗一定的性能，开销比较大。
 *
 */
public class User implements Serializable {
    private static final long serialVersionUID = 5459584623637090823L;
    private String username;
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

