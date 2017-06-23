package com.daimajia.swipedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.daimajia.swipedemo.adapter.PagerAdapterMeeting;
import com.daimajia.swipedemo.fragments.FragmentComing;
import com.daimajia.swipedemo.fragments.FragmentHosting;
import com.daimajia.swipedemo.fragments.FragmentInvitation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhaoliu on 21/06/2017.
 */

public class ITimeMeetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.meeting_tag_invitation));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.meeting_tag_hosting));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.meeting_tag_coming));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final CusSwipeViewPager viewPager = (CusSwipeViewPager) findViewById(R.id.pager);
        final PagerAdapterMeeting adapter = new PagerAdapterMeeting
                (getSupportFragmentManager(), tabLayout.getTabCount());
        adapter.setmData(initFragments());
        //must be 2, otherwise get performance issue
        viewPager.setOffscreenPageLimit(2);
        viewPager.setSwipeEnable(false);
        viewPager.setSwipingDuration(300);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(),true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private List<Fragment> initFragments(){
        List<Fragment> mData = new ArrayList<>();
        mData.add(new FragmentInvitation());
        mData.add(new FragmentHosting());
        mData.add(new FragmentComing());

        return mData;
    }
}
