package com.moment.myapplication.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.moment.myapplication.R;
import com.moment.myapplication.bean.ContactData;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private Context context;
    private List<ContactData> contactDataArrayList;

    public ContactAdapter(Context context, List<ContactData> contactDataArrayList) {
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
//        if (contactDataArrayList.get(position).getImageSrc() == null) {
//            viewHolder.imageView.setImageResource(R.drawable.ic_atm_fill);
//        }else {
//            viewHolder.imageView.setImageURI(Uri.parse(contactDataArrayList.get(position).getImageSrc()));

//        }
        viewHolder.imageView.setImageResource(R.drawable.ic_atm_fill);
        viewHolder.name.setText(contactDataArrayList.get(position).getContactName());

        return convertView;
    }
    public void setContactDataArrayList(List<ContactData> contactDataArrayList) {
        this.contactDataArrayList = contactDataArrayList;
    }
    class ViewHolder {
        private TextView name;
        private ImageView imageView;
    }
}
