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
		mBadgeView = new BadgeView(getActivity(), mTextView); // 初始化气泡，并指定目标组件
		mBadgeView.setText("99+");// 设置气泡显示的内容
		mBadgeView.setBadgeBackgroundColor(Color.RED);// 设置气泡颜色
		mBadgeView.setBadgePosition(BadgeView.POSITION_TOP_RIGHT); // 设置气泡位置
		mBadgeView.setBadgeMargin(10, 10); // 设置气泡的外边距
		mBadgeView.show();// 显示气泡
		
		// 标签
		mLabelView = new LabelView(getActivity());// 初始化标签
		mLabelView.setText("Top");// 设置标签显示的内容
		mLabelView.setBackgroundColor(Color.RED);// 设置标签颜色
		mLabelView.setTargetView(mTextView, 5, Gravity.LEFT_TOP);// 设置目标组件，距离和位置
	}
}
