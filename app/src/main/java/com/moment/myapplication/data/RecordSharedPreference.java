package com.moment.myapplication.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.moment.myapplication.bean.RecordData;

public class RecordSharedPreference {

    public SharedPreferences getSharedPreferences(Context context, long id) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(String.valueOf(id), Context.MODE_PRIVATE);
        return sharedPreferences;
    }

    public RecordData getRecordData(SharedPreferences sharedPreferences) {
        RecordData recordData = null;
        recordData.setId(sharedPreferences.getLong("id", 0));
        recordData.setRecord(sharedPreferences.getString("record", null));
        recordData.setTime(sharedPreferences.getString("time", null));
        return recordData;
    }

}
