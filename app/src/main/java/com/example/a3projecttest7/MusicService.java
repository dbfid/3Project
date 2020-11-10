package com.example.a3projecttest7;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {
    MediaPlayer mp3;
    public MusicService() {
    }




    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        // 서비스가 호출될 때마다 실행
        Log.d("test", "서비스의 onStartCommand");
        mp3.start(); // 노래 시작
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        // 서비스가 종료될 때 실행
        mp3.stop(); // 음악 종료
        Log.d("test", "서비스의 onDestroy");


    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 서비스에서 가장 먼저 호출됨(최초에 한번만)
        Log.d("test", "서비스의 onCreate");
        mp3 = MediaPlayer.create(this, R.raw.music);
        mp3.setLooping(false); // 반복재생
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");


    }
}
