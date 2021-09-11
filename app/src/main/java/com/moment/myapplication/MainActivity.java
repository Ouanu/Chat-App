package com.moment.myapplication;


import android.annotation.SuppressLint;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.moment.myapplication.bean.Chat;

import com.moment.myapplication.module.ChatViewModule;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int REFLASH_CHATPAGER = 1;
    private TextView mTitleName;
    private ViewPager mVpMain;
    /**
     * 用来存放四个View
     */
    private List<View> viewContainer = new ArrayList<>();
    private RadioGroup mRgMain;
    private static final int READYFORGETMESSAGE = 1000;
    private mHandler handler = new mHandler();

    ChatViewModule chatViewModule = new ChatViewModule();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitleName = findViewById(R.id.title_name);
        ImageButton mBtnSearch = findViewById(R.id.btn_search);
        ImageButton mBtnAdd = findViewById(R.id.btn_add);
        mVpMain = findViewById(R.id.vp_main);
        mRgMain = findViewById(R.id.rg_main);

        mRgMain.setOnCheckedChangeListener(new MainOnCheckedChangeListener());
        mRgMain.check(R.id.rb_chat);

        handler.sendEmptyMessage(READYFORGETMESSAGE);


        mBtnAdd.setOnClickListener(v -> {
            chatViewModule.getChatDao().insertChat(new Chat(12345, R.drawable.ic_atm_fill,
                    "zhang", "WUlala", "12:23"));
            chatViewModule.updateListView();
            Objects.requireNonNull(mVpMain.getAdapter()).notifyDataSetChanged();
            mVpMain.setAdapter(mVpMain.getAdapter());
        });


        mVpMainSetAdapter();
        mVpMainAddOnPageChangeListener();
    }

    /**
     * 获取所有View
     * 构建ViewPager
     */
    private void mVpMainSetAdapter() {
        mVpMain.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return viewContainer.size();
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(viewContainer.get(position));
                return viewContainer.get(position);
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @Override
            public int getItemPosition(@NonNull Object object) {
                return super.getItemPosition(object);
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });
    }

    /**
     * 顾名思义
     */
    private void mVpMainAddOnPageChangeListener() {
        mVpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                mRgMain.check(mRgMain.getChildAt(position).getId());
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 让子线程构建聊天总界面
     */
    private void getChatPagerThread() {
        new Thread(() -> {
            Log.d(TAG, "run: " + "runnable ++++++++++++");
            chatViewModule.buildChatPager(MainActivity.this);
            handler.sendEmptyMessage(REFLASH_CHATPAGER);
        }).start();
    }

    /**
     * 获得RadioGroup所有选项
     * 根据选择切换页面
     * 以及更改标题
     */
    private class MainOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                default:
                    int whichPager = 0;
                    mVpMain.setCurrentItem(whichPager);
                    mTitleName.setText("Chat");
                    break;
                case R.id.rb_contact:
                    whichPager = 1;
                    mVpMain.setCurrentItem(whichPager);
                    mTitleName.setText("联系人");
                    break;
                case R.id.rb_found:
                    whichPager = 2;
                    mVpMain.setCurrentItem(whichPager);
                    mTitleName.setText("朋友圈");
                    break;
                case R.id.rb_me:
                    whichPager = 3;
                    mVpMain.setCurrentItem(whichPager);
                    mTitleName.setText("我");
                    break;
            }
        }
    }


    /**
     * 主要是根据指令负责增删改查数据库操作
     * 顺带构建页面view
     */
    @SuppressLint("HandlerLeak")
    class mHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
            switch (msg.what) {
                case READYFORGETMESSAGE:
                    getChatPagerThread();
                    handler.removeMessages(READYFORGETMESSAGE);
                    break;
                case REFLASH_CHATPAGER:
                    View view = chatViewModule.getView();
//                    viewContainer.remove(0);
                    viewContainer.add(0, view);
                    Objects.requireNonNull(mVpMain.getAdapter()).notifyDataSetChanged();
                    mVpMain.setAdapter(mVpMain.getAdapter());
                    handler.removeMessages(REFLASH_CHATPAGER);
                    Log.d(TAG, "handleMessage: IGOTMESSAGE");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + msg.what);
            }
        }
    }
}

