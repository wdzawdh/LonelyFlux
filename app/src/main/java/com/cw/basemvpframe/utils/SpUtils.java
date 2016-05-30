package com.cw.basemvpframe.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SpUtils {

	private static final String FILE_URL="config";
	private static SharedPreferences sp;

	/**
	 * 在sp中存放String键值对
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void putString(Context context,String key,String value){
		if(sp==null){
			sp=context.getSharedPreferences(FILE_URL, 0);
		}
		Editor edit = sp.edit();
		edit.putString(key, value);
		edit.apply();
	}

	/**
	 * 在sp中存放Boolean键值对
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void putBoolean(Context context,String key,Boolean value){
		if(sp==null){
			sp=context.getSharedPreferences(FILE_URL, 0);
		}
		Editor edit = sp.edit();
		edit.putBoolean(key, value);
		edit.apply();
	}

	/**
	 * 在sp中存放Int键值对
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void putInt(Context context,String key,int value){
		if(sp==null){
			sp=context.getSharedPreferences(FILE_URL, 0);
		}
		Editor edit = sp.edit();
		edit.putInt(key, value);
		edit.apply();
	}
	
	/**
	 * 通过String键取值
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static  String getString(Context context,String key,String defValue){
		if(sp==null){
			sp=context.getSharedPreferences(FILE_URL, 0);
		}
		return sp.getString(key, defValue);
	}
	/**
	 * 通过Boolean键取值
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static  Boolean getBoolean(Context context,String key,Boolean defValue){
		if(sp==null){
			sp=context.getSharedPreferences(FILE_URL, 0);
		}
		return sp.getBoolean(key, defValue);
	}
	/**
	 * 通过int键取值
	 * @param context
	 * @param key
	 * @param defValue
	 * @return
	 */
	public static  int getInt(Context context,String key,int defValue){
		if(sp==null){
			sp=context.getSharedPreferences(FILE_URL, 0);
		}
		return sp.getInt(key, defValue);
	}
}
