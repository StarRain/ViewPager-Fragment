package com.example.demo.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demo.R;
import com.example.demo.widget.BadgeView;
import com.example.demo.widget.LabelView;
import com.example.demo.widget.LabelView.Gravity;

public class AFragment extends Fragment {
	private TextView mTextView;
	// 气泡
	private BadgeView mBadgeView;
	// 标签
	private LabelView mLabelView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_a, null);
		initView(view);
		return view;
	}

	private void initView(View view) {
		mTextView = (TextView) view.findViewById(R.id.text_a);
		// 气泡
		mBadgeView = new BadgeView(getActivity(), mTextView);
		mBadgeView.setText("99+");
		mBadgeView.setBadgeBackgroundColor(Color.RED);
		mBadgeView.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
		mBadgeView.setBadgeMargin(10, 10);
		mBadgeView.show();
		
		// 标签
		mLabelView = new LabelView(getActivity());
		mLabelView.setText("Top");
		mLabelView.setBackgroundColor(Color.RED);
		mLabelView.setTargetView(mTextView, 5, Gravity.LEFT_TOP);
	}
}
