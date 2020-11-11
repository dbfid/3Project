package com.example.a3projecttest7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class Setting extends AppCompatActivity {

    private ImageView education_btn , mypage_btn ,setting_btn,musicStart,musicStop;
    private Switch mbt;
    private MediaPlayer mediaPlayer;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);




        education_btn =(ImageView)findViewById(R.id.Education);
        mypage_btn =(ImageView)findViewById(R.id.Mypage);
        setting_btn =(ImageView)findViewById(R.id.Setting);
        musicStart =(ImageView)findViewById(R.id.imageView5);
        musicStop =(ImageView)findViewById(R.id.imageView6);
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mbt = (Switch)findViewById(R.id.musicSwitch);

        musicStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent service = new Intent(getApplicationContext(), MusicService.class);
                service.setPackage("com.example.a3projecttest7");
                stopService(service);
            }
        });


        mbt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(),"music off", Toast.LENGTH_SHORT).show();
                    Intent service = new Intent(getApplicationContext(), MusicService.class);
                    service.setPackage("com.example.a3projecttest7");
                    stopService(service);
                }else{
                    Toast.makeText(getApplicationContext(),"music on", Toast.LENGTH_SHORT).show();
                    Intent service = new Intent(getApplicationContext(), MusicService.class);
                    service.setPackage("com.example.a3projecttest7");
                    startService(service);
                }
            }
        });





        musicStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //노래시작
                Intent service = new Intent(getApplicationContext(), MusicService.class);
                service.setPackage("com.example.a3projecttest7");
                startService(service);
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