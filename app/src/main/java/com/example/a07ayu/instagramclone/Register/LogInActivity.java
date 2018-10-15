package com.example.a07ayu.instagramclone.Register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a07ayu.instagramclone.R;

public class LogInActivity extends AppCompatActivity {
    Button login;
    TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       // setupNavigationIcon();
        //setUpViewPager();
        login = (Button) findViewById(R.id.btn_login);
        register = (TextView) findViewById(R.id.tvSignUp);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogInActivity.this,RegisterActivity.class));
            }
        });

    }

}
