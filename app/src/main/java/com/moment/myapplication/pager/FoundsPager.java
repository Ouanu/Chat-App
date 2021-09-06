package com.moment.myapplication.pager;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.moment.myapplication.R;
import com.moment.myapplication.adapter.ContactAdapter;
import com.moment.myapplication.adapter.FoundsAdapter;
import com.moment.myapplication.data.ContactData;
import com.moment.myapplication.data.FoundsData;

import java.util.ArrayList;

public class FoundsPager {
    private Context context;
    private ArrayList<FoundsData> foundsDataArrayList;
    private ListView mLvItemPager;

    public FoundsPager(Context context, ArrayList<FoundsData> foundsDataArrayList) {
        this.context = context;
        this.foundsDataArrayList = foundsDataArrayList;
    }

    public View initView() {
        View view = View.inflate(context, R.layout.item_pager, null);
        mLvItemPager = view.findViewById(R.id.lv_item_pager);
        FoundsAdapter foundsAdapter = new FoundsAdapter(context, foundsDataArrayList);
        mLvItemPager.setAdapter(foundsAdapter);
        return view;
    }



}
