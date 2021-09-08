package com.moment.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.moment.myapplication.data.ChatData;
import com.moment.myapplication.data.ContactData;
import com.moment.myapplication.data.FoundsData;
import com.moment.myapplication.pager.ChatPager;
import com.moment.myapplication.pager.ContactPager;
import com.moment.myapplication.pager.FoundsPager;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mTitleName;
    private ImageButton mBtnSearch;
    private ImageButton mBtnAdd;
//    private RadioButton mRbChat;
//    private RadioButton mRbContact;
//    private RadioButton mRbFound;
//    private RadioButton mRbMe;
    private List<Integer> items = new ArrayList<>();
    private ViewPager mVpMain;
    private ArrayList<View> viewContainer = new ArrayList<>();
    private Fragment fragment;
    private RadioGroup mRgMain;
    private int whichPager;

    private ArrayList<ChatData> chatDataList = new ArrayList<>();
    private ArrayList<ContactData> contactDataList = new ArrayList<>();
    private ArrayList<FoundsData> foundsDataArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatDataList.add(new ChatData(R.drawable.ic_atm_normal, "张三", "hfdasjh", "12:30"));
        chatDataList.add(new ChatData(R.drawable.ic_atm_fill, "张四", "hfda", "12:31"));
        chatDataList.add(new ChatData(R.drawable.ic_atm_normal, "张五", "hfdjh", "12:32"));
        chatDataList.add(new ChatData(R.drawable.ic_atm_normal, "张六", "has", "12:33"));
        chatDataList.add(new ChatData(R.drawable.ic_atm_normal, "张三", "hfdasjh", "12:30"));
        chatDataList.add(new ChatData(R.drawable.ic_atm_fill, "张四", "hfda", "12:31"));
        chatDataList.add(new ChatData(R.drawable.ic_atm_normal, "张五", "hfdjh", "12:32"));
        chatDataList.add(new ChatData(R.drawable.ic_atm_normal, "张六", "has", "12:33"));
        chatDataList.add(new ChatData(R.drawable.ic_atm_normal, "张三", "hfdasjh", "12:30"));
        chatDataList.add(new ChatData(R.drawable.ic_atm_fill, "张四", "hfda", "12:31"));
        chatDataList.add(new ChatData(R.drawable.ic_atm_normal, "张五", "hfdjh", "12:32"));
        chatDataList.add(new ChatData(R.drawable.ic_atm_normal, "张六", "has", "12:33"));
        chatDataList.add(new ChatData(R.drawable.ic_atm_normal, "张三", "hfdasjh", "12:30"));
        chatDataList.add(new ChatData(R.drawable.ic_atm_fill, "张四", "hfda", "12:31"));
        chatDataList.add(new ChatData(R.drawable.ic_atm_normal, "张五", "hfdjh", "12:32"));
        chatDataList.add(new ChatData(R.drawable.ic_atm_normal, "张六", "has", "12:33"));

        contactDataList.add(new ContactData(R.drawable.ic_atm_normal, "张六"));
        contactDataList.add(new ContactData(R.drawable.ic_atm_fill, "张四"));
        contactDataList.add(new ContactData(R.drawable.ic_atm_normal, "张五"));

        foundsDataArrayList.add(new FoundsData(R.drawable.ic_atm_normal, "张六", "has", "12:43"));
        foundsDataArrayList.add(new FoundsData(R.drawable.ic_atm_normal, "张六", "has", R.mipmap.test_picture, "12:56"));
        foundsDataArrayList.add(new FoundsData(R.drawable.ic_atm_fill, "张12", "h654as", "12:33"));
        foundsDataArrayList.add(new FoundsData(R.drawable.ic_atm_normal, "张3", "hhgtredfas", R.mipmap.ic_launcher, "12:35"));
        foundsDataArrayList.add(new FoundsData(R.drawable.ic_atm_fill, "张654", "hhgfdas", "12:33"));
        foundsDataArrayList.add(new FoundsData(R.drawable.ic_atm_normal, "张65", "hrteas", R.mipmap.test_picture, "12:93"));


        mTitleName = findViewById(R.id.title_name);
        mBtnSearch = findViewById(R.id.btn_search);
        mBtnAdd = findViewById(R.id.btn_add);
        mVpMain = findViewById(R.id.vp_main);
//        mRbChat = findViewById(R.id.rb_chat);
//        mRbContact = findViewById(R.id.rb_contact);
//        mRbFound = findViewById(R.id.rb_found);
//        mRbMe = findViewById(R.id.rb_me);
        mRgMain = findViewById(R.id.rg_main);

        mRgMain.setOnCheckedChangeListener(new MainOnCheckedChangeListener());
        mRgMain.check(R.id.rb_chat);

        Log.d(TAG, "onCreate: " + chatDataList.size() + "....." + chatDataList);

        ChatPager chatPager = new ChatPager(this, chatDataList);
        ContactPager contactPager = new ContactPager(this, contactDataList);
        FoundsPager foundsPager = new FoundsPager(this, foundsDataArrayList);

        View view = chatPager.initView();
        View view1 = contactPager.initView();
        View view2 = foundsPager.initView();


        TextView textView4 = new TextView(this);
        textView4.setText("Hello world....");
        viewContainer.add(view);
        viewContainer.add(view1);
        viewContainer.add(view2);
        viewContainer.add(textView4);
        mVpMain.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return viewContainer.size();
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(viewContainer.get(position));
                return viewContainer.get(position);
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @Override
            public int getItemPosition(@NonNull Object object) {
                return super.getItemPosition(object);
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//                super.destroyItem(container, position, object);
                container.removeView((View) object);
            }
        });
        mVpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mRgMain.check(mRgMain.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class MainOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                default:
                    whichPager = 0;
                    mVpMain.setCurrentItem(whichPager);
                    mTitleName.setText("Chat");
                    break;
                case R.id.rb_contact:
                    whichPager = 1;
                    mVpMain.setCurrentItem(whichPager);
                    mTitleName.setText("联系人");
                    break;
                case R.id.rb_found:
                    whichPager = 2;
                    mVpMain.setCurrentItem(whichPager);
                    mTitleName.setText("朋友圈");
                    break;
                case R.id.rb_me:
                    whichPager = 3;
                    mVpMain.setCurrentItem(whichPager);
                    mTitleName.setText("我");
                    break;
            }
        }

    }

}