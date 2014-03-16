package com.beecub.livewallpaper.console;

import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;

public class ConsoleWallpaper extends WallpaperService {
	public static final String SHARED_PREFS_NAME = "ConsoleWallpaperSettings";
	private final Handler mHandler = new Handler();
	
	
	Context wContext;
	
	public String checkit;
	public String testing= "";
	
	private Context mContext;
	
	private Canvas c;
	
	Main main = new Main();
	
	Handler testHandler = new Handler();
	
		
		
	      
		
	  
	
	@Override
	public void onCreate() {
		
		
		
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		
		
		
		
		
		super.onDestroy();
	}

	@Override
	public Engine onCreateEngine() {
		
		
		
		
		return new TextEngine();
	}

	class TextEngine extends Engine implements
			SharedPreferences.OnSharedPreferenceChangeListener {

		private int mCanvasHeight = 1;
		// private int mCanvasWidth = 1;

		private int mOffsetTop = 100;
		private int mOffsetLeft;

		

		private final Paint mPaint = new Paint();

		private int iTo = 1;
		private int iFrom = 0;
		private String mSpeed = "normal";
		private int iTimes;

		private String mText; 
		private String receivedName;
		
		
		
	
		
		private final Runnable mDrawCube = new Runnable() {
			public void run() {
				
				
				drawFrame();
			}
		};
		private boolean mVisible;

		private SharedPreferences mPrefs;

		TextEngine() {
			Typeface typeface = Typeface.createFromAsset(getAssets(),
					"fonts/Geo-Regular.ttf");
			
			

			final Paint paint = mPaint;

			paint.setTextSize(18);
			paint.setTypeface(typeface);
			paint.setColor(0xff00ff00);
			paint.setAntiAlias(true);

			mPrefs = ConsoleWallpaper.this.getSharedPreferences(
					SHARED_PREFS_NAME, 0);
			mPrefs.registerOnSharedPreferenceChangeListener(this);
			onSharedPreferenceChanged(mPrefs, null);
		}

		public void onSharedPreferenceChanged(SharedPreferences prefs,
				String key) {
			mSpeed = prefs.getString("speed", "normal");
		}

		@Override
		public void onCreate(SurfaceHolder surfaceHolder) {
			super.onCreate(surfaceHolder);
		}

		@Override
		public void onDestroy() {
			super.onDestroy();
			mHandler.removeCallbacks(mDrawCube);
		}

		@Override
		public void onVisibilityChanged(boolean visible) {
			mVisible = visible;
			
			if (visible) {
				drawFrame();
			} else {
				mHandler.removeCallbacks(mDrawCube);
			}
		}

		@Override
		public void onSurfaceChanged(SurfaceHolder holder, int format,
				int width, int height) {
			super.onSurfaceChanged(holder, format, width, height);
			
			
			
			// mCanvasWidth = width;
			mCanvasHeight = height;
			mPaint.setTextSize(width / 30);
			// mOffsetLeft = width / 30;
			mOffsetLeft = 0;
			drawFrame();
		}

		@Override
		public void onSurfaceCreated(SurfaceHolder holder) {
			super.onSurfaceCreated(holder);
		}

		@Override
		public void onSurfaceDestroyed(SurfaceHolder holder) {
			super.onSurfaceDestroyed(holder);
			mVisible = false;
			
			
			
			mHandler.removeCallbacks(mDrawCube);
			
			
		}

		@Override
		public void onOffsetsChanged(float xOffset, float yOffset, float xStep,
				float yStep, int xPixels, int yPixels) {
			drawFrame();
		}

		@SuppressLint("WrongCall")
		public void drawFrame() {
			final SurfaceHolder holder = getSurfaceHolder();
			
			//upDateHandler();

			 c = null;
			try {
				c = holder.lockCanvas();
				if (c != null) {
					// draw something
					onDraw(c);
				}
			} finally {
				if (c != null)
					holder.unlockCanvasAndPost(c);
			}

			// Reschedule the next redraw
			mHandler.removeCallbacks(mDrawCube);
			if (mVisible) {
				mHandler.postDelayed(mDrawCube, 1000 / 25);
			}
		}

		void onDraw(Canvas c) {
			c.save();
			
			
			
			
				upDateHandler();

			//String aa = " Pakistan ";
			
			//testing = "good job";
	        
			
		    	
				
			
			
			mText = "# IMRAN" +testing+ "IMRAN HAMEED # IMRAN HAMEED IMRAN HAMEED # IMRAN HAMEED IMRAN HAMEED # IMRAN HAMEED IMRAN HAMEED # IMRAN HAMEED IMRAN HAMEED # IMRAN HAMEED IMRAN HAMEED # IMRAN HAMEED IMRAN HAMEED # IMRAN HAMEED IMRAN HAMEED # IMRAN HAMEED IMRAN HAMEED # IMRAN HAMEED IMRAN HAMEED # IMRAN HAMEED IMRAN HAMEED # IMRAN HAMEED IMRAN HAMEED # IMRAN HAMEED IMRAN HAMEED IMRAN HAMEED IMRAN HAMEED # IMRAN HAMEED IMRAN HAMEED # IMRAN HAMEED IMRAN HAMEED # IMRAN HAMEED IMRAN HAMEED # IMRAN HAMEED IMRAN HAMEED #";
			
			
			
			// draw
			String text = mText.substring(iFrom, iTo);
			String[] Strings = text.split("#");
			mPaint.setTextSize(40);
			for (int i = 0; i < Strings.length; i++) {
				c.drawText(Strings[i], mOffsetLeft, mOffsetTop, mPaint);
				mOffsetTop += mPaint.getTextSize();
				if (mOffsetTop > mCanvasHeight)
					reset(c);
			}
			iFrom = 0;
			mOffsetTop = 100;

			int t;
			if (mSpeed.equalsIgnoreCase("slow"))
				t = 5;
			else
				t = 1;

			if (iTimes % t == 0) {
				if (mSpeed.equalsIgnoreCase("fast"))
					iTo++;
				iTo++;
				iTimes = 0;
			}
			iTimes++;

			if (iTo > mText.length()) {
				iFrom = 0;
				iTo = 1;
				reset(c);
			}
			c.restore();
			
			
			
		}

		
		
		private void upDateHandler() {
				
			
			/*Timer t = new Timer();
			t.scheduleAtFixedRate(new TimerTask() {

			    @Override
			    public void run() {
			      
			    	
			    	testing = main.testChecking;
			    	//testing = "care free";
			    	
			    	
			    }

			},
			0,
			1000);*/
			
			/*Timer timer;
		    TimerTask refresher;

		              // Initialization code in onCreate or similar:

		              timer = new Timer();    
		              refresher = new TimerTask() {
		                  public void run() {
		                      
		                	  
		                	  testing = main.testChecking;
		                	  
		                  };
		              };
		              // first event immediately,  following after 1 seconds each
		              timer.scheduleAtFixedRate(refresher, 0,100); */
			
			 /*new Handler().postDelayed(new Runnable() {

                 @Override
                 public void run() {
                     
                	 testing = main.testChecking;
                	 

                 }
             }, 100);*/
			
			//Toast.makeText(ConsoleWallpaper.this, main.testChecking, Toast.LENGTH_SHORT).show();
			
			
			
			
			
			
			
			new Thread(new Runnable() {
		        @Override
		        public void run() {
		            while (true) {
		                try {
		                    Thread.sleep(10000);
		                    mHandler.post(new Runnable() {

		                        @Override
		                        public void run() {
		                            
		                        	
		                        	testing = main.testChecking;
		                        	
		                        	
		                        	
		                        	
		                        }
		                    });
		                } catch (Exception e) {
		                    // TODO: handle exception
		                }
		            }
		        }
		    }).start();
			
		}

		 void reset(Canvas c) {
			mOffsetTop = 100;
			Paint paint = new Paint();
			paint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
			c.drawPaint(paint);
		}

	}
	
	
	
	
	
	
}