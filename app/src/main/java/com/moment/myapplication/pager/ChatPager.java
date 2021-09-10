package com.moment.myapplication.pager;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import com.moment.myapplication.R;
import com.moment.myapplication.adapter.ChatAdapter;
import com.moment.myapplication.bean.Chat;
import com.moment.myapplication.data.ChatData;
import java.util.ArrayList;
import java.util.List;

public class ChatPager{

    private final static String TAG = "ChatPager";

    public ListView mLvItemPager;
    private Context context;
    private List<Chat> chatDataList;
    public ChatAdapter chatAdapter;

    public ListView getmLvItemPager() {
        return mLvItemPager;
    }

    public ChatPager(Context context, List<Chat> chatDataList) {
        this.context = context;
        this.chatDataList = chatDataList;
        chatAdapter = new ChatAdapter(context, chatDataList);

    }

    public View initView() {
        View view = View.inflate(context, R.layout.item_pager, null);
        mLvItemPager = view.findViewById(R.id.lv_item_pager);
        mLvItemPager.setAdapter(chatAdapter);
        return view;
    }

    public void updateView(List<Chat> chatDataList) {
        this.chatDataList = chatDataList;
        chatAdapter.notifyDataSetChanged();
        Log.d(TAG, "updateView: " + this.chatDataList.size());
        initView();
    }


}
