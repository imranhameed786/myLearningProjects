package com.beecub.livewallpaper.console;

import java.io.IOException;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {

	EditText et;
	Button setWall, btn2, btn3, showWall,startAct;
	TextView tv, tv1;
	String userName = "", filePath = "";
	
	public String testChecking = " A S D F ";
	
	ConsoleWallpaper consol;
	
	WallpaperManager wallManager;
	
	Context mContext;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		consol = new ConsoleWallpaper();
		
		

		et = (EditText) findViewById(R.id.editText1);
		setWall = (Button) findViewById(R.id.button1);
		
		showWall = (Button) findViewById(R.id.button3);
		startAct = (Button) findViewById(R.id.otherwall);
		
		
		
		
		

		startAct.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				try {
					
					testChecking="there u are";
					
				
					
					wallManager = WallpaperManager.getInstance(consol.wContext); 
					wallManager.clear();
					
					Toast.makeText(Main.this, "HI THERE", Toast.LENGTH_SHORT).show();
					
					
					
					
					
					//stopService(new Intent(Main.this, ConsoleWallpaper.class));
					
				} catch (Exception e) {
					
					Log.e("Errorr------> stop wallpaper", e.toString());
				}
				
				
				
			}
		});
		
		

		// imagePath();

		setWall.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				
				

				if (et.length() == 0) {

					et.setHint("Type Something");

				} else if (et.length() != 0) {

					
					try {
						
						//consol.testing = "Im here dear";
						
						
						//consol.clearWallpaper();
						
						consol.testing = "Dear All Here"; 
						
						
						
						
						Intent cw = new Intent();
						cw.setClass(Main.this, ConsoleWallpaper.class);
						cw.putExtra("FilePath","Pakistanihere");
						
					} catch (Exception e) {
						
						Toast.makeText(Main.this, "Checking", Toast.LENGTH_SHORT)
								.show();
						
					}
					
					

					

					et.setText("");

				}
			}
		});

		

		showWall.setOnClickListener(new View.OnClickListener() {

			
			@Override
			public void onClick(View v) {

				/*startActivity(new Intent(
						WallpaperManager.ACTION_LIVE_WALLPAPER_CHOOSER));*/
				
				consol.testing = "Dear All Here"; 
				
				//clearWall();
				
				
				
				consol.testing = "Dear All Here";  
				
				
				//consol.deleteDatabase(userName);
				
				Intent intent = new Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
				intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT, new ComponentName(Main.this, ConsoleWallpaper.class));
				startActivity(intent);
				
				
				

					
				
				
			}
			
			
			
			

			private void clearWall() {
				
				
				
				Bitmap image1;
				
				image1 = BitmapFactory.decodeResource(getResources(),
						R.drawable.imran);
				
				WallpaperManager wpm = WallpaperManager.getInstance(Main.this);
				
				try {
					wpm.setBitmap(image1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		

	}

	

}
