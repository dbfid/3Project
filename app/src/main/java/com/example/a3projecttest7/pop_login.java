package com.example.a3projecttest7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

public class pop_login  extends Activity {

    RequestQueue requestQueue; // 통로
    StringRequest stringRequest; // 그릇
    EditText edtext1, edtext2;
    String loginID =""; //?

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // 팝업창 조절
        super.onCreate(savedInstanceState);
        // 필요없는거 지워주는거
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.pop_login);
        DisplayMetrics dm = new DisplayMetrics(); //창크기조절
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.widthPixels;
        getWindow().setLayout((int) (width * 0.5), (int) (height * 0.6));

        edtext1 = findViewById(R.id.edtext3);
        edtext2 = findViewById(R.id.edtext4);

/*        // 로그인 완료 버튼
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pop_login.this, shortsentence.class));
            }
        });*/

        // 데이터 이동
        // 1. requestQueue세팅!
        requestQueue = Volley.newRequestQueue(pop_login.this);

        // 2. url세팅
        String url = "http://221.156.243.239:8077/kid/LoginServlet";

        // 3. stringRequest세팅
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //트루인지 펄스인지 확인하는곳
                if(response.equals("true")){
                    loginID = edtext1.getText().toString();
                    // 토스트 메세지
                    //Toast.makeText(getApplicationContext(),loginID+"님 환영합니다", Toast.LENGTH_SHORT).show();
                    // a:페이지 이동을 위해 Intent 준비 후
                    Intent intent = new Intent(pop_login.this, Education.class);
                    // a:현재 로그인한 id 값을 저장해서
                    intent.putExtra("loginID", loginID);
                    // 가자
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "아이디를 확인하세요", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> data = new HashMap<>();
                // key, velus 여기에 맞는 모든것을 보내준다
                // id와 pw 각각 전송하기!
                data.put("id", edtext1.getText().toString());
                data.put("pw", edtext2.getText().toString());

                return data;
            }
        };

        // 4. stringRequest에 tag달기
        stringRequest.setTag("login");

        // 5. requestQueue에 StringRequest전송하기!
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestQueue.add(stringRequest);
            }
        });
    }
}


