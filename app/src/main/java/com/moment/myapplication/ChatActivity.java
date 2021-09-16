package com.moment.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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
//    private ListView mLvChatRecord;


    private String nowRecord = "";
    private TextView mTvRecord;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mIvBack = findViewById(R.id.iv_back);
        mTvChatContactName = findViewById(R.id.tv_chat_contact_name);
        mEtChat = findViewById(R.id.et_chat);
        mIvAddPicture = findViewById(R.id.iv_add_picture);
        mIvSend = findViewById(R.id.iv_send);
//        mLvChatRecord = findViewById(R.id.lv_chat_record);
        mIvBack.setOnClickListener(this);
        mIvSend.setOnClickListener(this);
        mTvRecord = findViewById(R.id.tv_record);


        String contactName = getIntent().getStringExtra("contactName");
        long id = getIntent().getLongExtra("id", 0);
        String imageSrc = getIntent().getStringExtra("imageSrc");

        SharedPreferences sharedPreferences = getSharedPreferences(String.valueOf(id), MODE_PRIVATE);
        sharedPreferences.getString("all", null);


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
            String record = mEtChat.getText().toString();
            nowRecord += "我" + "\n" + record + "\n\n";
            mTvRecord.setText(nowRecord);
            mTvRecord.setMovementMethod(ScrollingMovementMethod.getInstance());
            mEtChat.setText("");
        } else if (v.getId() == R.id.iv_add_picture) {
            /**
             * 调用系统图库，选择图片发送
             */
        }

    }

    class ReadHelper extends SQLiteOpenHelper {
        public ReadHelper(Context context) {
            super(context, "record.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
}
