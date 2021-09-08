package com.moment.myapplication.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.moment.myapplication.bean.Chat;
import com.moment.myapplication.dao.ChatDao;

@Database(entities = { Chat.class }, version = 1)
public abstract class ChatDatabase extends RoomDatabase {
    public abstract ChatDao chatDao();
    private static final String DB_NAME = "ChatDataBase.db";
    private static volatile ChatDatabase instance;

    static synchronized ChatDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static ChatDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                ChatDatabase.class,
                DB_NAME
        ).build();
    }

}
