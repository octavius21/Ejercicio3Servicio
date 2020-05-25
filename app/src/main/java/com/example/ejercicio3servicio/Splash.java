package com.example.ejercicio3servicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //mp= MediaPlayer.create(this,R.);
        //mp.start();
        Thread timer= new Thread(){
            public void run(){
                try{
                    sleep(2000);//38200

                }catch(Exception e){

                }finally {
                    Intent intent= new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
    @Override
    protected void onStart(){
        super.onStart();
    }
    @Override
    protected void onResume(){
        //cuando se va y vuelve el usuario para que permanezca la info
        super.onResume();
    }
    @Override
    protected  void onPause(){
        super.onPause();
       // mp.pause();
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        //mp.start();
    }
    @Override
    protected  void onStop(){
        super.onStop();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
