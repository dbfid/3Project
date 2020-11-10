package com.example.a3projecttest7;

import android.content.Intent;
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


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        button = (ImageView) findViewById(R.id.exit);
        button.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();

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

/*        enteringaword = findViewById(R.id.enteringaword);
        enteringaword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://WWW.naver.com"));
                startActivity(intent);
            }
        });*/
    }
}
}