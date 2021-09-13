package com.moment.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "LOGIN_activity";

    private EditText mEtUser;
    private EditText mEtPasswd;
    private Button mBtnRegister;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEtUser = findViewById(R.id.et_user);
        mEtPasswd = findViewById(R.id.et_passwd);
        mBtnRegister = findViewById(R.id.btn_register);
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);
        mBtnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String userName = mEtUser.getText().toString();
        String passwd = mEtPasswd.getText().toString();
        if (v.getId() == R.id.btn_register) {
            Log.d(TAG, "onClick: you click register");
            SharedPreferences sharedPreferences = this.getSharedPreferences("user_data", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            if (!userName.isEmpty() && !passwd.isEmpty()) {
                Log.d(TAG, "onClick: you click register");
                editor.putString(userName, userName);
                editor.putString(passwd, passwd);
                editor.commit();
            } else {
                Toast.makeText(this, "请检查用户名和密码是否正确", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v.getId() == R.id.btn_login) {
            Log.d(TAG, "onClick: you click Login");
            SharedPreferences sharedPreferences = this.getSharedPreferences("user_data", MODE_PRIVATE);
            if (!userName.isEmpty() && !passwd.isEmpty()) {
                String data_userName = sharedPreferences.getString(userName, null);
                String data_passWd = sharedPreferences.getString(passwd, null);
                Log.d(TAG, "data_userName" + data_userName + "data_passWd" + data_passWd);
                Log.d(TAG, "userName" + userName + "passWd" + passwd);
                if (userName.equals(data_userName) && passwd.equals(data_passWd)) {
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                    this.startActivity(new Intent(this, MainActivity.class));
                } else {
                    Toast.makeText(this, "请检查用户名和密码是否正确2", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "请检查用户名和密码是否正确", Toast.LENGTH_SHORT).show();
            }
        }
    }
}