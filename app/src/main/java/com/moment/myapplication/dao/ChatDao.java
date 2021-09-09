package com.moment.myapplication.dao;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.moment.myapplication.bean.Chat;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ChatDao {

    @Insert
    void insertChat(Chat chat);

    @Insert
    void insertAllChats(Chat... chats);

    @Update
    void updateChat(Chat chat);

    @Update
    void updateAllChat(Chat... chats);

    @Delete
    void deleteChats(Chat... chats);

    @Query("DELETE FROM Chat")
    void deleteAllChats();

    @Query("SELECT * FROM chat")
    LiveData<List<Chat>> getChatList();

    @Query("SELECT * FROM chat")
    List<Chat> getAllChatList();

    @Query("SELECT * FROM chat WHERE contactName= :contactName")
    Chat getChatByContactName(String contactName);

}
