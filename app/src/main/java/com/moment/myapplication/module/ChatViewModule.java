package com.moment.myapplication.module;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.room.Room;
import com.moment.myapplication.bean.Chat;
import com.moment.myapplication.dao.ChatDao;
import com.moment.myapplication.data.ChatDatabase;
import com.moment.myapplication.pager.ChatPager;

import java.util.List;

public class ChatViewModule {
    private static final String TAG = "ChatViewModule";
    private View view;
    private ChatDao chatDao;
    private ChatPager chatPager;
    private List<Chat> chatList;

    public void buildChatPager(Context context) {
        ChatDatabase chatDatabase = Room.databaseBuilder(context, ChatDatabase.class, "chat_database")
                .allowMainThreadQueries()
                .build();
        chatDao = chatDatabase.getChatDao();
        chatList = chatDao.getAllChatList();
        chatPager = new ChatPager(context, chatList);
        view = chatPager.initView();

        Log.d(TAG, "buildChatPager: finished ++++++++++");
        chatPager.mLvItemPager.setOnItemClickListener((parent, view, position, id) -> Log.d(TAG, "onItemClick: " + "===================" + position));
    }

    public void updateListView() {
        chatList = chatDao.getAllChatList();
        chatPager.chatAdapter.setChatDataArrayList(chatList);
        chatPager.mLvItemPager.setAdapter(chatPager.chatAdapter);
    }

    public View getView() {
        return view;
    }

    public ChatDao getChatDao() {
        return chatDao;
    }

}
