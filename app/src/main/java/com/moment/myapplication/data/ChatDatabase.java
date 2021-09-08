package com.moment.myapplication.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.moment.myapplication.bean.Chat;
import com.moment.myapplication.dao.ChatDao;

@Database(entities = { Chat.class }, version = 1, exportSchema = false)
public abstract class ChatDatabase extends RoomDatabase {
    public abstract ChatDao getChatDao();

}
