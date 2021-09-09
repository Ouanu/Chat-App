package com.moment.myapplication;


import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                super.destroyItem(container, position, object);
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