package com.timesheetapp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/**
 * Created by Najeeb.Idrees on 14-Mar-17.
 */


public class PreferencesManager
{

	public static final String PREFERENCES_FILE = "TS-Timesheet-PreferenceFile";

	public static String PROJECT = "project";
	public static String ACTIVITY = "activity";

	private static PreferencesManager sInstance;
	private final SharedPreferences mPref;

	private PreferencesManager(@NonNull Context context, String fileName)
	{
		mPref = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
	}

	public static synchronized void initializeInstance(@NonNull Context context, String fileName)
	{
		if (sInstance == null)
		{
			sInstance = new PreferencesManager(context, fileName);
		}
	}

	public static synchronized PreferencesManager getInstance()
	{
		if (sInstance == null)
		{
			throw new IllegalStateException(PreferencesManager.class.getSimpleName() +
					" is not initialized, call initializeInstance(..) method first.");
		}
		return sInstance;
	}

	public void setStringValue(String key, String value)
	{
		mPref.edit()
				.putString(key, value)
				.apply();
	}

	public void setIntValue(String key, int value)
	{
		mPref.edit()
				.putInt(key, value)
				.apply();
	}

	public void setBooleanValue(String key, boolean value)
	{
		mPref.edit()
				.putBoolean(key, value)
				.apply();
	}

	//	public void setObject(String key, Object value)
	//	{
	//		Gson gson = new Gson();
	//		String json = gson.toJson(value);
	//		mPref.edit().putString(key, json).apply();
	//	}

	public String getStringValue(String key)
	{
		return mPref.getString(key, "");
	}

	public int getIntValue(String key)
	{
		return mPref.getInt(key, 0);
	}

	public boolean getBooleanValue(String key)
	{
		return mPref.getBoolean(key, false);
	}

	public boolean getBooleanValueDefaultTrue(String key)
	{
		return mPref.getBoolean(key, true);
	}

	//	public <T> Object getObject(String key, @NonNull Class<T> objectClass)
	//	{
	//		Gson gson = new Gson();
	//		String json = mPref.getString(key, "");
	//		return gson.fromJson(json, objectClass);
	//	}

	public void remove(String key)
	{
		mPref.edit()
				.remove(key)
				.apply();
	}

	public boolean clear()
	{
		return mPref.edit()
				.clear()
				.commit();
	}
}