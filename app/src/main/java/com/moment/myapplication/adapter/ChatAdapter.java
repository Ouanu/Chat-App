package com.moment.myapplication.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.moment.myapplication.R;

import com.moment.myapplication.bean.ChatData;


import java.util.List;

/**
 * 构造Chat Item样式
 */
public class ChatAdapter extends BaseAdapter {

    private final Context context;
    private List<ChatData> chatDataArrayList;

    public ChatAdapter(Context context, List<ChatData> chatDataArrayList) {
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
        Log.d("ChatAdapter", "getCount: " + chatDataArrayList.size());
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

        viewHolder.icon.setImageURI(Uri.parse(chatDataArrayList.get(position).getImageSrc()));
        viewHolder.contactName.setText(chatDataArrayList.get(position).getContactName());
        viewHolder.contactRecord.setText(chatDataArrayList.get(position).getRecord());
        viewHolder.time.setText(chatDataArrayList.get(position).getTime());

        return convertView;
    }
    static class ViewHolder {
        ImageView icon;
        TextView contactName;
        TextView contactRecord;
        TextView time;
    }
}

