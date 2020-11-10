package com.example.a3projecttest7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Setting extends AppCompatActivity {

    private ImageView education_btn;
    private ImageView mypage_btn;
    private ImageView setting_btn;
    private MediaPlayer mediaPlayer;
    private ImageView imageView5;
    private ImageView close;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);




        education_btn =(ImageView)findViewById(R.id.Education);
        mypage_btn =(ImageView)findViewById(R.id.Mypage);
        setting_btn =(ImageView)findViewById(R.id.Setting);
        imageView5 =(ImageView)findViewById(R.id.imageView5);
        close =(ImageView)findViewById(R.id.imageView5);
        mediaPlayer = MediaPlayer.create(this, R.raw.music);


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test", "액티비티-서비스 종료버튼클릭");
                Intent intent = new Intent(
                        getApplicationContext(),//현재제어권자
                        MusicService.class); // 이동할 컴포넌트
                stopService(intent); // 서비스 종료
            }
        });


        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 서비스 시작하기
                Log.d("test", "액티비티-서비스 시작버튼클릭");
                Intent intent = new Intent(
                        getApplicationContext(),//현재제어권자
                        MusicService.class); // 이동할 컴포넌트
                startService(intent); // 서비스 시작
            }
        });





        // 학습메뉴에서 학습버튼 눌렀을 시
        education_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this,Education.class);
                startActivity(intent);
            }
        });
        // 학습메뉴에서 마이페이지 눌렀을 시
        mypage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this,Mypage.class);
                startActivity(intent);
            }
        });
        // 학습메뉴에서 셋팅 눌렀을 시
        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this,Setting.class);
                startActivity(intent);
            }
        });



    }
}