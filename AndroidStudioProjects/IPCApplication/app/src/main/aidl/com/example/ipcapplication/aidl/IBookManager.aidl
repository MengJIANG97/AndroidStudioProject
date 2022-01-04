// IBookManager.aidl
package com.example.ipcapplication.aidl;
import com.example.ipcapplication.aidl.Book;

// Declare any non-default types here with import statements

interface IBookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    List<Book> getBookList();//从远程服务端获取图书列表
    void addBook(in Book book);//往图书列表中添加一本书
    //void registerListener(IOnNewBookArrivedListener listener);
    //void unregisterListener(IOnNewBookArrivedListener listener);
}