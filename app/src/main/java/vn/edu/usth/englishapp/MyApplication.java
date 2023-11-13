package vn.edu.usth.englishapp;

import android.app.Application;
import android.content.Intent;

import vn.edu.usth.englishapp.notify.MyService;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Khởi động dịch vụ
        startService(new Intent(this, MyService.class));
    }
}