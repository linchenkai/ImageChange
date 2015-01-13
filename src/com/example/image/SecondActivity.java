package com.example.image;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;
import android.content.Intent;


public class SecondActivity extends Activity{
	private ImageSwitcher imageSwitcher;
	private int i;
	private int[] imageId=new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03};
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		imageSwitcher=(ImageSwitcher)findViewById(R.id.imageSwitcher1);		 
        imageSwitcher.setFactory(new ViewFactory() {                 
			public View makeView(){      
				ImageView imageView=new ImageView(SecondActivity.this); 
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); 
				imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
						LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				return imageView;
			}			
	});		
        Button up=(Button)findViewById(R.id.button1);
		Button down=(Button)findViewById(R.id.button2);
		Button back=(Button)findViewById(R.id.back);
		final Intent intent=getIntent();		
		i=intent.getIntExtra("index",0);
		imageSwitcher.setImageResource(imageId[i]);
		up.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(i>0){
					i--;
				}else{
					i=imageId.length-1;
				}
				imageSwitcher.setImageResource(imageId[i]);								
			}
		});
		down.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(i<imageId.length-1){
					i++;
				}else{
					i=0;
				}
				imageSwitcher.setImageResource(imageId[i]);				
			}
		});
	//	back.setOnClickListener(new OnClickListener() {
			
		//	@Override
		//	public void onClick(View v) {
		//		setResult(0x717,intent);
		//		finish();				
		//	}
		//});		
	}
}
