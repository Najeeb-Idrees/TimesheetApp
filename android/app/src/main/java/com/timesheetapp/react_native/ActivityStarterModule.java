package com.timesheetapp.react_native;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeArray;
import com.timesheetapp.ui.LogTimeActivity;
import com.timesheetapp.MainApplication;
import com.timesheetapp.util.Constant;

import javax.annotation.Nonnull;

/**
 * Created by Najeeb.Idrees on 03-Oct-17.
 */

public class ActivityStarterModule extends ReactContextBaseJavaModule
{

	ActivityStarterModule(ReactApplicationContext reactContext)
	{
		super(reactContext);
	}

	/**
	 * @return the name of this module. This will be the name used to {@code require()} this module
	 * from JavaScript.
	 */
	@Override
	public String getName()
	{
		return "ActivityStarter";
	}

	@ReactMethod
	void navigateToExample(String date)
	{
		Activity activity = getCurrentActivity();
		if (activity != null)
		{
			Intent intent = new Intent(activity, LogTimeActivity.class);
			intent.putExtra(Constant.DATE, date);
			activity.startActivity(intent);
		}
	}

	@ReactMethod
	void dialNumber(@Nonnull String number)
	{
		Activity activity = getCurrentActivity();
		if (activity != null)
		{
			Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
			activity.startActivity(intent);
		}
	}

	@ReactMethod
	void getActivityName(@Nonnull Callback callback)
	{
		Activity activity = getCurrentActivity();
		if (activity != null)
		{
			callback.invoke(activity.getClass().getSimpleName());
		}
	}

	@ReactMethod
	void getActivityNameAsPromise(@Nonnull Promise promise)
	{
		Activity activity = getCurrentActivity();
		if (activity != null)
		{
			promise.resolve(activity.getClass().getSimpleName());
		}
	}

	@ReactMethod
	void callJavaScript()
	{
		Activity activity = getCurrentActivity();
		if (activity != null)
		{
			MainApplication application = (MainApplication) activity.getApplication();
			ReactNativeHost reactNativeHost = application.getReactNativeHost();
			ReactInstanceManager reactInstanceManager = reactNativeHost.getReactInstanceManager();
			ReactContext reactContext = reactInstanceManager.getCurrentReactContext();

			if (reactContext != null)
			{
				CatalystInstance catalystInstance = reactContext.getCatalystInstance();
				WritableNativeArray params = new WritableNativeArray();
				params.pushString("Hello, JavaScript!");
				catalystInstance.callFunction("JavaScriptVisibleToJava", "alert", params);
			}
		}
	}
}