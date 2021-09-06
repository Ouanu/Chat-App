package com.moment.myapplication.pager;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.moment.myapplication.R;
import com.moment.myapplication.adapter.ChatAdapter;
import com.moment.myapplication.adapter.ContactAdapter;
import com.moment.myapplication.data.ContactData;

import java.util.ArrayList;

public class ContactPager {
    private Context context;
    private ArrayList<ContactData> contactDataArrayList;
    private ListView mLvItemPager;

    public ContactPager(Context context, ArrayList<ContactData> contactDataArrayList) {
        this.context = context;
        this.contactDataArrayList = contactDataArrayList;
    }

    public View initView() {
        View view = View.inflate(context, R.layout.item_pager, null);
        mLvItemPager = view.findViewById(R.id.lv_item_pager);
        ContactAdapter contactAdapter = new ContactAdapter(context, contactDataArrayList);
        mLvItemPager.setAdapter(contactAdapter);
        return view;
    }

}
