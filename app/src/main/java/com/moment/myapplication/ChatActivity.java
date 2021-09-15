package com.moment.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIvBack;
    private TextView mTvChatContactName;
    private EditText mEtChat;
    private ImageView mIvAddPicture;
    private ImageView mIvSend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mIvBack = findViewById(R.id.iv_back);
        mTvChatContactName = findViewById(R.id.tv_chat_contact_name);
        mEtChat = findViewById(R.id.et_chat);
        mIvAddPicture = findViewById(R.id.iv_add_picture);
        mIvSend = findViewById(R.id.iv_send);

        mIvBack.setOnClickListener(this);

        String contactName = getIntent().getStringExtra("contactName");
        long id = getIntent().getLongExtra("id", 0);

        if (id != 0) {
            mTvChatContactName.setText(contactName);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_back) {
            /**
             * 返回最近一次的聊天记录和时间
             */
            finish();
        } else if (v.getId() == R.id.iv_send) {
            /**
             * 发送信息
             */
        } else if (v.getId() == R.id.iv_add_picture) {
            /**
             * 调用系统图库，选择图片发送
             */
        }

    }
}