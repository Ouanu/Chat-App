package com.moment.myapplication.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


//singleton
@Database(entities = { Chat.class }, version = 1, exportSchema = false)
public abstract class ChatDatabase extends RoomDatabase {
    private static ChatDatabase INSTANCE;
    static synchronized ChatDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ChatDatabase.class, "chat_database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
    public abstract ChatDao getChatDao();

}
