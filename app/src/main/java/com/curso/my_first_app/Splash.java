package com.curso.my_first_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 210206561 on 18/02/2017.
 */

public class Splash  extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.splash);

        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
             try {
                 sleep(3500);
             }catch (InterruptedException e){
                 e.printStackTrace();
             }finally{
                 Intent intent = new Intent(Splash.this, MainActivity.class);
                 startActivity(intent);
                 finish();
             }

            }
        };thread.start();
    }

}
