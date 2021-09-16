package com.moment.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIvBack;
    private TextView mTvChatContactName;
    private EditText mEtChat;
    private ImageView mIvAddPicture;
    private ImageView mIvSend;
    private ListView mLvChatRecord;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mIvBack = findViewById(R.id.iv_back);
        mTvChatContactName = findViewById(R.id.tv_chat_contact_name);
        mEtChat = findViewById(R.id.et_chat);
        mIvAddPicture = findViewById(R.id.iv_add_picture);
        mIvSend = findViewById(R.id.iv_send);
        mLvChatRecord = findViewById(R.id.lv_chat_record);
        mIvBack.setOnClickListener(this);

        String contactName = getIntent().getStringExtra("contactName");
        long id = getIntent().getLongExtra("id", 0);
        String imageSrc = getIntent().getStringExtra("imageSrc");








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
