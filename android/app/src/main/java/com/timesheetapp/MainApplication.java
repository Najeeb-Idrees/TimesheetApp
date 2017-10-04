package com.timesheetapp;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.oblador.vectoricons.VectorIconsPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.timesheetapp.model.db.DBAdapter;
import com.timesheetapp.react_native.ActivityStarterReactPackage;
import com.timesheetapp.util.PreferencesManager;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication
{
	public static DBAdapter dbHelper;
	public static PreferencesManager preferencesManager;

	private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this)
	{
		@Override
		public boolean getUseDeveloperSupport()
		{
			return BuildConfig.DEBUG;
		}

		@Override
		protected List<ReactPackage> getPackages()
		{
			return Arrays.<ReactPackage>asList(
					new ActivityStarterReactPackage(), // This is it!
					new MainReactPackage(),
					new VectorIconsPackage()
			);
		}
	};

	@Override
	public ReactNativeHost getReactNativeHost()
	{
		return mReactNativeHost;
	}

	@Override
	public void onCreate()
	{
		super.onCreate();
		SoLoader.init(this, /* native exopackage */ false);


		dbHelper = OpenHelperManager.getHelper(getApplicationContext(), DBAdapter.class);
		dbHelper.getWritableDatabase();

		preferencesManager.initializeInstance(this, PreferencesManager.PREFERENCES_FILE);
		preferencesManager = PreferencesManager.getInstance();
	}
}
