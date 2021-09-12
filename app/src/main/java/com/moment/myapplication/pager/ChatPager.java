package com.moment.myapplication.pager;

import android.content.Context;

import android.view.View;
import android.widget.ListView;
import com.moment.myapplication.R;
import com.moment.myapplication.adapter.ChatAdapter;
import com.moment.myapplication.bean.ChatData;

import java.util.List;

public class ChatPager{


    public ListView mLvItemPager;
    private final Context context;
    public ChatAdapter chatAdapter;


    public ChatPager(Context context, List<ChatData> chatDataList) {
        this.context = context;
        chatAdapter = new ChatAdapter(context, chatDataList);

    }

    public View initView() {
        View view = View.inflate(context, R.layout.item_pager, null);
        mLvItemPager = view.findViewById(R.id.lv_item_pager);
        mLvItemPager.setAdapter(chatAdapter);
        return view;
    }


}
