package com.moment.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.moment.myapplication.R;
import com.moment.myapplication.bean.ChatRecordData;

import java.util.List;

public class ChatRecordAdapter extends BaseAdapter {
    private Context context;
    private List<ChatRecordData> recordDataList;

    public ChatRecordAdapter(Context context, List<ChatRecordData> recordDataList) {
        this.context = context;
        this.recordDataList = recordDataList;
    }

    @Override
    public int getCount() {
        return recordDataList.size();
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
            if (recordDataList.get(position).getId() == 1000) {
                convertView = View.inflate(context, R.layout.item_from_me, null);
            } else {
                convertView = View.inflate(context, R.layout.item_from_it, null);
            }
            viewHolder = new ViewHolder();
            viewHolder.textView = convertView.findViewById(R.id.tv_record);
            viewHolder.imageView = convertView.findViewById(R.id.iv_icon);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    class ViewHolder {
        TextView textView;
        ImageView imageView;
    }
}
