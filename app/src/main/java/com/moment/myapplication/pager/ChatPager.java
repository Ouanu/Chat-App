package com.moment.myapplication.pager;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.moment.myapplication.R;
import com.moment.myapplication.adapter.ChatAdapter;
import com.moment.myapplication.data.ChatData;
import java.util.ArrayList;

public class ChatPager{

    private final static String TAG = "ChatPager";

    private ListView mLvItemPager;
    private Context context;
    private ArrayList<ChatData> chatDataList;

    public ChatPager(Context context, ArrayList<ChatData> chatDataList) {
        this.context = context;
        this.chatDataList = chatDataList;
    }

    public View initView() {
        View view = View.inflate(context, R.layout.item_pager, null);
        mLvItemPager = view.findViewById(R.id.lv_item_pager);
        ChatAdapter chatAdapter = new ChatAdapter(context, chatDataList);
        mLvItemPager.setAdapter(chatAdapter);
        return view;
    }

}
