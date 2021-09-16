package com.moment.myapplication;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.moment.myapplication.bean.Chat;
import com.moment.myapplication.bean.ChatData;
import com.moment.myapplication.bean.ContactData;
import com.moment.myapplication.dao.ChatDao;
import com.moment.myapplication.data.ChatDatabase;
import com.moment.myapplication.pager.ChatPager;
import com.moment.myapplication.pager.ContactPager;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int READY_FOR_FLASH = 1000;
    private TextView mTitleName;
    private ViewPager mVpMain;
    /**
     * 用来存放四个View
     */
    private List<View> viewContainer = new ArrayList<>();
    private RadioGroup mRgMain;


    ChatDatabase chatDatabase;
    ChatDao chatDao;
    ContactPager contactPager;
    mHandler handler = new mHandler();
    ChatPager chatPager;
    private List<ContactData> contactDataList = new ArrayList<>();
    private List<Chat> chatList = new ArrayList<>();
    private List<ChatData> chatDataList = new ArrayList<>();

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
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatDao.insertChat(new Chat(1267, "wbbaa", null));
                contactDataList.add(new ContactData(1267, "wbbaa", null));
                contactPager.contactAdapter.setContactDataArrayList(contactDataList);
                contactPager.contactAdapter.notifyDataSetChanged();
                contactPager.mLvItemPager.setAdapter(contactPager.contactAdapter);
                View view = contactPager.initView();
                viewContainer.set(1, view);
                handler.sendEmptyMessage(READY_FOR_FLASH);
            }
        });

        chatDatabase = Room.databaseBuilder(this, ChatDatabase.class, "chat_database")
                .allowMainThreadQueries()
                .build();
        chatDao = chatDatabase.getChatDao();
        chatList = chatDao.getChatList();
        /**
         * 初始化四个页面
         */
        initialization();

        new Thread(new Runnable() {
            @Override
            public void run() {
                View viewPager0 = getChatView(chatList);
                viewContainer.set(0,viewPager0);
                handler.sendEmptyMessage(READY_FOR_FLASH);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                View viewPager1 = getContactView(chatList);
                viewContainer.set(1,viewPager1);
                handler.sendEmptyMessage(READY_FOR_FLASH);
            }
        }).start();

        mVpMainSetAdapter();
        mVpMainAddOnPageChangeListener();
    }

    /**
     * 初始化页面
     */
    private void initialization() {
        TextView textView = new TextView(this);
        textView.setText("Loading...");
        TextView textView1 = new TextView(this);
        textView1.setText("Loading...");
        TextView textView2 = new TextView(this);
        textView2.setText("Loading...");
        TextView textView3 = new TextView(this);
        textView3.setText("Loading...");
        viewContainer.add(textView);
        viewContainer.add(textView1);
        viewContainer.add(textView2);
        viewContainer.add(textView3);
    }

    /**
     * 获取聊天列表界面
     * @param chatList
     * @return 聊天列表界面
     */
    private View getChatView(List<Chat> chatList) {
        for (int i = 0; i < chatList.size(); i++) {
            SharedPreferences sharedPreferences = getSharedPreferences(String.valueOf(chatList.get(i).getId()), Context.MODE_PRIVATE);
            chatDataList.add(new ChatData(chatList.get(i).getId(),
                    chatList.get(i).getContactName(),
                    chatList.get(i).getImageSrc(),
                    sharedPreferences.getString("record", "null"),
                    sharedPreferences.getString("time", "null")));
//            if (chatDataList.get(i).getRecord() == null) {
//                chatDataList.remove(i);
//            }
            Log.d(TAG, "getChatView: " + chatDataList.get(i).getRecord());
        }
        chatPager = new ChatPager(this, chatDataList);
        View chatView = chatPager.initView();
        return chatView;
    }

    /**
     * 获取联系人列表页面
     * @param chatList
     * @return 联系人列表页面
     */
    private View getContactView(List<Chat> chatList) {
        for (int i = 0; i < chatList.size(); i++) {
            contactDataList.add(new ContactData(chatList.get(i).getId(),
                    chatList.get(i).getContactName(),
                    chatList.get(i).getImageSrc()));
        }
        contactPager = new ContactPager(this, contactDataList);
        View contactView = contactPager.initView();
        return contactView;
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

    class mHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
            switch (msg.what) {
                case READY_FOR_FLASH:
                    mVpMain.getAdapter().notifyDataSetChanged();
                    mVpMain.setAdapter(mVpMain.getAdapter());
                    chatPager.mLvItemPager.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                            intent.putExtra("id", chatDataList.get(position).getId());
                            intent.putExtra("contactName", chatDataList.get(position).getContactName());
                            intent.putExtra("imageSrc", chatDataList.get(position).getImageSrc());
//                            startActivityForResult(intent, 1101);
                            startActivity(intent);
                        }
                    });
                    break;
                default:
                    Log.d(TAG, "handleMessage: Wrong" + msg.what);
            }
        }
    }

}

