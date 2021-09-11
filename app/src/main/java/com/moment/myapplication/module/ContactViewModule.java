package com.moment.myapplication.module;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.room.Room;
import com.moment.myapplication.bean.Chat;
import com.moment.myapplication.bean.Contact;
import com.moment.myapplication.dao.ChatDao;
import com.moment.myapplication.data.ChatDatabase;
import com.moment.myapplication.pager.ChatPager;
import com.moment.myapplication.pager.ContactPager;

import java.util.ArrayList;
import java.util.List;

public class ContactViewModule {
    private static final String TAG = "ChatViewModule";
    private View view;
    private ChatDao chatDao;
    private ContactPager contactPager;
    private List<Contact> contactList = new ArrayList<>();
    private List<Chat> chatList = new ArrayList<>();

    public void buildContactPager(Context context) {
        ChatDatabase chatDatabase = Room.databaseBuilder(context, ChatDatabase.class, "chat_database")
                .allowMainThreadQueries()
                .build();
        chatDao = chatDatabase.getChatDao();
        chatList = chatDao.getAllChatList();
        getContactData();
        contactPager = new ContactPager(context, contactList);
        view = contactPager.initView();

        Log.d(TAG, "buildChatPager: finished ++++++++++");
        contactPager.mLvItemPager.setOnItemClickListener((parent, view, position, id) -> Log.d(TAG, "onItemClick: " + "===================" + position));
    }

    public List<Chat> getChatList() {
        return chatList;
    }

    public void setChatList(List<Chat> chatList) {
        this.chatList = chatList;
    }

    public void updateListView() {
        chatList = chatDao.getAllChatList();
        getContactData();
        contactPager.contactAdapter.setContactDataArrayList(contactList);
        contactPager.mLvItemPager.setAdapter(contactPager.contactAdapter);
    }

    public View getView() {
        return view;
    }

    public ChatDao getChatDao() {
        return chatDao;
    }

    public void getContactData() {
        if (chatList != null && chatList.size() > 0) {
            for (int i = 0; i < chatList.size(); i++) {
                contactList.add(new Contact(chatList.get(i).getId(),
                        chatList.get(i).getImageUri(),
                        chatList.get(i).getContactName()));
            }
        }
    }

}
