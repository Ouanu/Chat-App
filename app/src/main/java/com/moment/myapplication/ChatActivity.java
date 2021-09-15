package com.moment.myapplication;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {
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
    }
}
