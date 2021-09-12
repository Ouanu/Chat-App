package com.moment.myapplication.dao;

import androidx.room.*;
import com.moment.myapplication.bean.Chat;

import java.util.List;

@Dao
public interface ChatDao {
    @Query("SELECT * FROM chat")
    List<Chat> getChatList();

    @Insert
    void insertChat(Chat... chats);

    @Update
    void updateChat(Chat... chats);

    @Delete
    void deleteChat(Chat... chats);


}
