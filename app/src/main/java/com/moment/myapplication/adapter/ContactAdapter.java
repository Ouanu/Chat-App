package com.moment.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.moment.myapplication.R;
import com.moment.myapplication.bean.Contact;
import com.moment.myapplication.data.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private Context context;
    private List<Contact> contactDataArrayList;

    public ContactAdapter(Context context, List<Contact> contactDataArrayList) {
        this.context = context;
        this.contactDataArrayList = contactDataArrayList;
    }


    @Override
    public int getCount() {
        return contactDataArrayList.size();
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
            convertView = View.inflate(context, R.layout.item_contact_pager, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.iv_icon);
            viewHolder.name = convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imageView.setImageResource(contactDataArrayList.get(position).getImageUri());
        viewHolder.name.setText(contactDataArrayList.get(position).getContactName());

        return convertView;
    }

    class ViewHolder {
        private TextView name;
        private ImageView imageView;
    }
}
