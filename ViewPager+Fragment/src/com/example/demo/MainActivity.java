package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.demo.fragment.AFragment;
import com.example.demo.fragment.BFragment;
import com.example.demo.fragment.CFragment;

public class MainActivity extends FragmentActivity {
	private final HashMap<Integer, String> mTabMap = new HashMap<Integer, String>();
	private final List<TextView> mTab = new ArrayList<TextView>();
	private TextView mTabA, mTabB, mTabC;
	private AFragment mAFragment;
	private BFragment mBFragment;
	private CFragment mCFragment;

	private ViewPager mViewPager;
	private final List<Fragment> mFragments = new ArrayList<Fragment>();
	private final OnPageChangeListener mOnPageChangeListener = new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int index) {
			updateTab(index);
		}
		
		@Override
		public void onPageScrolled(int index, float id, int position) {
		}
		
		@Override
		public void onPageScrollStateChanged(int index) {
			
		}
	};

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tab_a:
			mViewPager.setCurrentItem(0);
			break;
		case R.id.tab_b:
			mViewPager.setCurrentItem(1);
			break;
		case R.id.tab_c:
			mViewPager.setCurrentItem(2);
			break;
		default:
			break;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initViews();
		initFragment();
		initViewPager();
		mViewPager.setCurrentItem(0);
	}

	private void initViewPager() {
		mViewPager = (ViewPager) findViewById(R.id.fragment_container);
		mViewPager.setAdapter(new ABCViewPagerAdapter(getSupportFragmentManager()));
		mViewPager.setOnPageChangeListener(mOnPageChangeListener);
	}

	private void initViews() {
		mTabA = (TextView) findViewById(R.id.tab_a);
		mTabB = (TextView) findViewById(R.id.tab_b);
		mTabC = (TextView) findViewById(R.id.tab_c);
		mTab.add(mTabA);
		mTab.add(mTabB);
		mTab.add(mTabC);
		mTabMap.put(0, "#abcdef");
		mTabMap.put(1, "#fedcba");
		mTabMap.put(2, "#defabc");
	}

	private void initFragment() {
		mAFragment = new AFragment();
		mBFragment = new BFragment();
		mCFragment = new CFragment();
		mFragments.add(mAFragment);
		mFragments.add(mBFragment);
		mFragments.add(mCFragment);
	}



	private void updateTab(int tabIndex){
		for (int i = 0; i < mTab.size(); i++) {
			if(i == tabIndex){
				mTab.get(i).setBackgroundColor(Color.parseColor(mTabMap.get(i)));
			} else {
				mTab.get(i).setBackgroundColor(Color.parseColor("#FFFFFF"));
			}
		}
	}
	
	class ABCViewPagerAdapter extends FragmentPagerAdapter{

		public ABCViewPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int index) {
			return mFragments.get(index);
		}

		@Override
		public int getCount() {
			return mFragments.size();
		}
	}
}
