package com.moment.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.moment.myapplication.R;

import java.util.ArrayList;

public class FoundsAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<FoundsData> foundsDataArrayList;

    public FoundsAdapter(Context context, ArrayList<FoundsData> foundsDataArrayList) {
        this.context = context;
        this.foundsDataArrayList = foundsDataArrayList;
    }

    @Override
    public int getCount() {
        return foundsDataArrayList.size();
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
            convertView = View.inflate(context, R.layout.item_founds_pager, null);
            viewHolder = new ViewHolder();
            viewHolder.icon = convertView.findViewById(R.id.iv_icon);
            viewHolder.name = convertView.findViewById(R.id.tv_name);
            viewHolder.content = convertView.findViewById(R.id.tv_record);
            viewHolder.image = convertView.findViewById(R.id.iv_image);
            viewHolder.time = convertView.findViewById(R.id.tv_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.icon.setImageResource(foundsDataArrayList.get(position).getPath());
        viewHolder.name.setText(foundsDataArrayList.get(position).getName());
        viewHolder.content.setText(foundsDataArrayList.get(position).getContent());
        int image = foundsDataArrayList.get(position).getImage();
        if (image == 0) {
            viewHolder.image.setVisibility(View.GONE);
        } else {
            viewHolder.image.setImageResource(image);
        }
        viewHolder.time.setText(foundsDataArrayList.get(position).getTime());
        return convertView;
    }

    class ViewHolder {
        ImageView icon;
        TextView name;
        TextView content;
        ImageView image;
        TextView time;
    }

}
