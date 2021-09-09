package com.moment.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.moment.myapplication.R;
import com.moment.myapplication.bean.Chat;
import com.moment.myapplication.data.ChatData;


import java.util.ArrayList;
import java.util.List;

/**
 * 构造Chat Item样式
 */
public class ChatAdapter extends BaseAdapter {

    private Context context;
    private List<Chat> chatDataArrayList = new ArrayList<>();

    public ChatAdapter(Context context, List<Chat> chatDataArrayList) {
        this.context = context;
        this.chatDataArrayList = chatDataArrayList;
    }

    @Override
    public int getCount() {
        return chatDataArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_chat_pager, null);
            viewHolder = new ViewHolder();
            viewHolder.icon = convertView.findViewById(R.id.iv_icon);
            viewHolder.contactName = convertView.findViewById(R.id.tv_name);
            viewHolder.contactRecord = convertView.findViewById(R.id.tv_record);
            viewHolder.time = convertView.findViewById(R.id.tv_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.icon.setImageResource(chatDataArrayList.get(position).getImageUri());
        viewHolder.contactName.setText(chatDataArrayList.get(position).getContactName());
        viewHolder.contactRecord.setText(chatDataArrayList.get(position).getRecode());
        viewHolder.time.setText(chatDataArrayList.get(position).getDate());

        return convertView;
    }
    class ViewHolder {
        ImageView icon;
        TextView contactName;
        TextView contactRecord;
        TextView time;
    }
}

