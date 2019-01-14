package com.example.loaddemo;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;

public class LoadActivity extends Activity {

	private TextView version;
	private ImageView splash;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_load); 
		version = (TextView) findViewById(R.id.version);
		version.setText("版本号："+getAppVersionName(this));
		splash = (ImageView) findViewById(R.id.splash_loading_item);
		initAnim();
	}
	private void initAnim() {
		// TODO 自动生成的方法存根
		Animation translate = AnimationUtils.loadAnimation(LoadActivity.this,
				R.anim.splash);

		translate.setAnimationListener(new AnimationListener() {
			
			public void onAnimationStart(Animation animation) {
				// TODO 自动生成的方法存根
				
			}
			
			public void onAnimationRepeat(Animation animation) {
				// TODO 自动生成的方法存根
				
			}
			
			public void onAnimationEnd(Animation animation) {
				// TODO 自动生成的方法存根
				startNewAct();
			}

			private void startNewAct() {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(LoadActivity.this,MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		splash.setAnimation(translate);
	}
	//获取版本号
	public static String getAppVersionName(Context context) {  
	    String versionName = "";  
	    int versioncode = -1; 
	    try {  
	        PackageManager pm = context.getPackageManager();  
	        PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);  
	        versionName = pi.versionName;  
	        versioncode = pi.versionCode;
	        if (versionName == null || versionName.length() <= 0) {  
	            return "";  
	        }  
	    } catch (Exception e) {  
	        Log.e("VersionInfo", "Exception", e);  
	    }  
	    return versionName;  
	} 
}
