package com.example.image;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.content.Intent;
import android.widget.ImageView;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class MainActivity extends Activity {
	private int[] imageId = new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03};
	private int i;	
	final public int CODE = 0x717;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		GridView gridview=(GridView)findViewById(R.id.gridView1);
		String[] title = new String[]{"ͼƬ1","ͼƬ2","ͼƬ3"};
		List<Map<String,Object>> listItem = new ArrayList<Map<String,Object>>();
		
		for(i = 0;i < imageId.length;i++){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("image",imageId[i]);
			map.put("title", title[i]);	
			listItem.add(map);
		}
		
		SimpleAdapter adapter = new SimpleAdapter(this,listItem,
				                                R.layout.items,
				                                new String[]{"title","image"},
				                                new int[]{R.id.title,R.id.imageView1});
		gridview.setAdapter(adapter);
	    
		gridview.setOnItemClickListener(new OnItemClickListener(){
	    	 
	    	public void onItemClick(AdapterView<?> arg0, View arg1, int index, long arg3){
	    		Intent intent = new Intent();
	    		intent.putExtra("index",index);
	    		intent.putExtra("pic",imageId[index]);
	    		intent.setClass(MainActivity.this,ViewPage.class);
	    		startActivityForResult(intent,CODE);
	    		//startActivity(intent);
	    		    	
	    	 }
	    });	    		
		}		
	}

