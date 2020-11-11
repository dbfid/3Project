package com.example.a3projecttest7;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a3projecttest7.R;
import com.google.firebase.auth.FirebaseAuth;

public class Education extends AppCompatActivity implements View.OnClickListener {

    private ImageView button;
    private FirebaseAuth firebaseAuth;
    private ImageView education_btn;
    private ImageView mypage_btn;
    private ImageView setting_btn;
    private ImageView enteringaword;
    private ImageView enteringashortsentence;
    private ImageView enteringalongsentence;
    private ImageView enteringagame;






    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        button = (ImageView) findViewById(R.id.Exit);
        button.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();
        education_btn =(ImageView)findViewById(R.id.Education);
        mypage_btn =(ImageView)findViewById(R.id.Mypage);
        setting_btn =(ImageView)findViewById(R.id.Setting);

        enteringaword =(ImageView)findViewById(R.id.enteringaword);
        enteringashortsentence =(ImageView)findViewById(R.id.enteringashortsentence);
        enteringalongsentence =(ImageView)findViewById(R.id.enteringalongsentence);
        enteringagame =(ImageView)findViewById(R.id.enteringagame);

        Intent service = new Intent(getApplicationContext(), MusicService.class);
        service.setPackage("com.example.a3projecttest7");
        startService(service);



        // 학습메뉴에서 학습버튼 눌렀을 시
        education_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Education.this,Education.class);
                startActivity(intent);
            }
        });
        // 학습메뉴에서 마이페이지 눌렀을 시
        mypage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Education.this,Mypage.class);
                startActivity(intent);
            }
        });
        // 학습메뉴에서 셋팅 눌렀을 시
        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Education.this,Setting.class);
                startActivity(intent);
            }
        });
        // 학습 메뉴에서 단어 눌렀을 시
        enteringaword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Education.this,wordlearning.class);
                startActivity(intent);
            }
        });
        // 짧은문장 눌렀을 시 이동
        enteringashortsentence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Education.this,shortsentence.class);
                startActivity(intent);
            }
        });
        // 긴문장 눌렀을 시 이동
        enteringalongsentence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Education.this,longsentence.class);
                startActivity(intent);
            }
        });

        // 게임 눌렀을 시 이동
        enteringagame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Education.this,educationgame.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onClick(View view) {
        if(view == button)
            firebaseAuth.signOut();
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }

public class Education2 extends AppCompatActivity{

    ImageView enteringaword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        enteringaword = findViewById(R.id.enteringaword);
        enteringaword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://WWW.naver.com"));
                startActivity(intent);
            }
        });
    }
}
}