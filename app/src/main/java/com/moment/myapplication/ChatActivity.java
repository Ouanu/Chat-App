package com.moment.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.moment.myapplication.server.ChatClient;

import java.util.Date;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ChatActivity";
    private ImageView mIvBack;
    private TextView mTvChatContactName;
    private EditText mEtChat;
    private ImageView mIvAddPicture;
    private ImageView mIvSend;
//    private ListView mLvChatRecord;


    private String nowRecord = "";
    private TextView mTvRecord;
    Date date;
    SharedPreferences preferences;
    String recordLastTime = "";
    ChatClient chatClient;

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
        mIvAddPicture.setOnClickListener(this);
        mTvRecord = findViewById(R.id.tv_record);
        chatClient = new ChatClient();
        chatClient.getClient();


        String contactName = getIntent().getStringExtra("contactName");
        long id = getIntent().getLongExtra("id", 0);
        String imageSrc = getIntent().getStringExtra("imageSrc");
        preferences = getSharedPreferences(String.valueOf(id), MODE_PRIVATE);

        recordLastTime = preferences.getString("all", null);

        Log.d(TAG, "=======" + recordLastTime);
        if (recordLastTime == null) {
            mTvRecord.setText("");
        } else {
            mTvRecord.setText(recordLastTime);
        }

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
            preferences.edit();
            finish();
        } else if (v.getId() == R.id.iv_send) {
            String record = mEtChat.getText().toString();
            try {
                chatClient.sendMessage(record);
            } catch (Exception e) {
                System.out.println("Fail to send......");
                e.printStackTrace();
            }
            date = new Date();
            String time = date.toLocaleString();
            recordLastTime += "我" + " " + time + "\n" + record + "\n\n";
            mTvRecord.setText(recordLastTime);
            mTvRecord.setMovementMethod(ScrollingMovementMethod.getInstance());
//            recordLastTime += nowRecord;
            preferences.edit().putString("all", recordLastTime).commit();
            mEtChat.setText("");
        } else if (v.getId() == R.id.iv_add_picture) {
            /**
             * 调用系统图库，选择图片发送
             */
            preferences.edit().clear().commit();
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

    @Override
    public void onBackPressed() {
        preferences.edit().commit();
        super.onBackPressed();
    }
}
