package com.example.uts_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private String user = "uasmobile";
    private String pass = "uasmobilegenap";
    private EditText username,password;
    private TextView tv_alert;
    private Button Login;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_login);
        init();
        setOnClick();
    }
    private void init(){
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        Login = findViewById(R.id.btn_login);
        tv_alert = findViewById(R.id.tv_alert);
    }

    private void setOnClick(){
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempUser = username.getText().toString(), tempPass = password.getText().toString();

                if(tempUser.equals(user) && tempPass.equals(pass)){
                    Intent listLaguIntent = new Intent(LoginActivity.this, SongListActivity.class);
                    startActivity(listLaguIntent);
                }else{
                    tv_alert.setText("Wrong Username or Password");
                }
            }
        });
    }

}
