package com.example.a3projecttest7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class shortsentence extends AppCompatActivity {

            private ImageView education_btn;
            private ImageView mypage_btn;
            private ImageView setting_btn;
            private ImageView home;
            private ImageView hos;
            private ImageView shopping;
            private ImageView school;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_shortsentence);


                education_btn =(ImageView)findViewById(R.id.Education);
                mypage_btn =(ImageView)findViewById(R.id.Mypage);
                setting_btn =(ImageView)findViewById(R.id.Setting);
        home =(ImageView)findViewById(R.id.imageView1);
        school =(ImageView)findViewById(R.id.imageView2);
        shopping =(ImageView)findViewById(R.id.imageView3);
        hos =(ImageView)findViewById(R.id.imageView4);

        // 학습메뉴에서 학습버튼 눌렀을 시
        education_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shortsentence.this,Education.class);
                startActivity(intent);
            }
        });
        // 학습메뉴에서 마이페이지 눌렀을 시
        mypage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shortsentence.this,Mypage.class);
                startActivity(intent);
            }
        });
        // 학습메뉴에서 셋팅 눌렀을 시
        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shortsentence.this,Setting.class);
                startActivity(intent);
            }
        });
        //집 눌렀을때
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shortsentence.this, educationpage_home1.class);
                startActivity(intent);
            }
        });
        //학교 눌렀을때
        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shortsentence.this, educationpage_school2.class);
                startActivity(intent);
            }
        });
        //쇼핑 눌렀을때
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shortsentence.this, educationpage_shopping3.class);
                startActivity(intent);
            }
        });
        //병원 눌렀을때
        hos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shortsentence.this, educationpage_hos4.class);
                startActivity(intent);
            }
        });
    }
}