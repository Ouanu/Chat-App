package com.moment.myapplication.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.moment.myapplication.bean.Chat;

import java.util.ArrayList;

@Dao
public interface ChatDao {

    @Query("SELECT * FROM chat")
    ArrayList<Chat> getAll();

    @Query("SELECT * FROM chat WHERE uid IN (:userIds)")
    ArrayList<Chat> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM chat WHERE contactName=:contactName")
    Chat findByName(String contactName);

    @Insert
    void insertAll(Chat... chats);

    @Delete
    void delete(Chat chat);

    @Delete
    void deleteAll(Chat... chats);
}
