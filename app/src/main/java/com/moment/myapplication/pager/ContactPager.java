package com.moment.myapplication.pager;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.moment.myapplication.R;
import com.moment.myapplication.adapter.ContactAdapter;
import com.moment.myapplication.bean.Contact;
import java.util.List;

public class ContactPager {
    private Context context;
    private List<Contact> contactDataArrayList;
    public ListView mLvItemPager;
    public ContactAdapter contactAdapter;

    public ContactPager(Context context, List<Contact> contactDataArrayList) {
        this.context = context;
        this.contactDataArrayList = contactDataArrayList;
    }

    public View initView() {
        View view = View.inflate(context, R.layout.item_pager, null);
        mLvItemPager = view.findViewById(R.id.lv_item_pager);
        contactAdapter = new ContactAdapter(context, contactDataArrayList);
        mLvItemPager.setAdapter(contactAdapter);
        return view;
    }

}
