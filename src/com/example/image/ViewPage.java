package com.example.image;

import android.app.Activity;
import android.util.Log;
import android.view.*;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.app.*;
import android.content.*;
import android.os.*;
import android.support.v4.*;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.content.Intent;
import android.os.Bundle;

public class ViewPage extends Activity {
	private ViewPager viewPager;
	private int[] imageId;
	private int currentPage;                    //当前页数
	private ViewGroup container;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewpage);

		viewPager = (ViewPager) findViewById(R.id.viewpager1);
		imageId = new int[] { R.drawable.img01, R.drawable.img02,
				R.drawable.img03 };	
		
		PagerAdapter adapter = new PagerAdapter() {

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return imageId.length;
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;            //一定要这样写
			}

			public Object instantiateItem(ViewGroup container, int position) {
		
				ImageView im = new ImageView(ViewPage.this);
				im.setImageResource(imageId[position]);
				container.addView(im,0);
				return im;
			}

			@Override
			public void destroyItem(ViewGroup container, int position,Object object) {
				
				ImageView im = new ImageView(ViewPage.this);
				im.setImageResource(imageId[position]);
				container.removeView(im);
			}

		};
		viewPager.setAdapter(adapter);

		final Intent intent = getIntent();
		int index = intent.getIntExtra("index", 0);
		
		viewPager.setCurrentItem(index);
		
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {      //翻页

			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub

			}

			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			public void onPageScrollStateChanged(int position) {
				// TODO Auto-generated method stub
				currentPage = position;

			}
		});
		Button back=(Button)findViewById(R.id.back);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setResult(0x717,intent);
				finish();
			}
		});
	}
}
