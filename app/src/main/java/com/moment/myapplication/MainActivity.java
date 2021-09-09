package com.moment.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.moment.myapplication.bean.Chat;
import com.moment.myapplication.dao.ChatDao;
import com.moment.myapplication.data.ChatData;
import com.moment.myapplication.data.ChatDatabase;
import com.moment.myapplication.data.ContactData;
import com.moment.myapplication.data.FoundsData;
import com.moment.myapplication.pager.ChatPager;
import com.moment.myapplication.pager.ContactPager;
import com.moment.myapplication.pager.FoundsPager;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mTitleName;
    private ImageButton mBtnSearch;
    private ImageButton mBtnAdd;
    //    private RadioButton mRbChat;
//    private RadioButton mRbContact;
//    private RadioButton mRbFound;
//    private RadioButton mRbMe;
    private List<Integer> items = new ArrayList<>();
    private ViewPager mVpMain;
    private ArrayList<View> viewContainer = new ArrayList<>();
    private Fragment fragment;
    private RadioGroup mRgMain;
    private int whichPager;

    private ArrayList<ContactData> contactDataList = new ArrayList<>();
    private ArrayList<FoundsData> foundsDataArrayList = new ArrayList<>();

    Chat chat = new Chat(
            1,
            R.drawable.ic_atm_fill,
            "张六",
            "has",
            "12:33");

    Chat chat1 = new Chat(
            2,
            R.drawable.ic_atm_fill,
            "张六rew",
            "hars",
            "12:fda3");

    Chat chat2 = new Chat(
            3,
            R.drawable.ic_atm_normal,
            "张yi",
            "hasfd",
            "12:43");

    ChatDatabase chatDatabase;
    ChatDao chatDao;
    List<Chat> resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitleName = findViewById(R.id.title_name);
        mBtnSearch = findViewById(R.id.btn_search);
        mBtnAdd = findViewById(R.id.btn_add);
        mVpMain = findViewById(R.id.vp_main);
//        mRbChat = findViewById(R.id.rb_chat);
//        mRbContact = findViewById(R.id.rb_contact);
//        mRbFound = findViewById(R.id.rb_found);
//        mRbMe = findViewById(R.id.rb_me);
        mRgMain = findViewById(R.id.rg_main);

        mRgMain.setOnCheckedChangeListener(new MainOnCheckedChangeListener());
        mRgMain.check(R.id.rb_chat);

        chatDatabase = Room.databaseBuilder(this, ChatDatabase.class, "chat_database")
                .allowMainThreadQueries()
                .build();
        chatDao = chatDatabase.getChatDao();





//        chatDao.insertAllChats(chat, chat1, chat2);


//
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new InsertAsyncTask(chatDao).doInBackground(chat, chat1, chat2);
            }
        });


        contactDataList.add(new ContactData(2131165298, "fdhsajk"));
        contactDataList.add(new ContactData(2131165299, "fdhsajk"));


        LiveData<List<Chat>> chatList = chatDao.getChatList();

//        chatList.observe(this, new Observer<List<Chat>>() {
//            @Override
//            public void onChanged(List<Chat> chats) {
//                ChatPager chatPager = new ChatPager(getApplicationContext(), chats);
//                View view = chatPager.initView();
//                viewContainer.add(view);
//            }
//        });



        ContactPager contactPager = new ContactPager(this, contactDataList);

        View view1 = contactPager.initView();

        Log.d(TAG, "onCreate: ----------" + chatList.getValue());
        resultList = chatDao.getAllChatList();


        ChatPager chatPager = new ChatPager(this, resultList);
        View view = chatPager.initView();
        viewContainer.add(view);

        mTitleName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultList = chatDao.getAllChatList();
                Log.d(TAG, "onClick: ---------" + resultList);
            }
        });

        viewContainer.add(view1);

        FoundsPager foundsPager = new FoundsPager(this, foundsDataArrayList);

        Log.d(TAG, "onCreate: " + viewContainer.size());

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
                super.destroyItem(container, position, object);
                container.removeView((View) object);
            }
        });
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

    private class MainOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                default:
                    whichPager = 0;
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

    static class InsertAsyncTask extends AsyncTask<Chat, Void, Void> {
        private ChatDao chatDao;
        public InsertAsyncTask(ChatDao chatDao) {
            this.chatDao = chatDao;
        }
        @Override
        protected Void doInBackground(Chat... chats) {
            chatDao.insertAllChats(chats);
            return null;
        }
    }


}