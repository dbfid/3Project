package com.example.a3projecttest7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class maintest extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedlnstanceState){
        super.onCreate(savedlnstanceState);
        setContentView(R.layout.maintest);

        final Button rankingButton = (Button) findViewById(R.id.rankingButton);
        final Button teacherButton = (Button) findViewById(R.id.teacherButton);
        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice);

        rankingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE);
                rankingButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                teacherButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ranking());
                fragmentTransaction.commit();
            }
        });

        teacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.GONE);
                rankingButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                teacherButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new teacher());
                fragmentTransaction.commit();
            }
        });
    }

}
