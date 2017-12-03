package com.mj.pkshi.tools;

import android.content.SharedPreferences;

import com.mj.pkshi.App;

/**
 * Created by xinru on 2017/12/2.
 */

public class PrefreshHelper {

    private static SharedPreferences sharedPreferences;

    static {
        sharedPreferences = App.get().getSharedPreferences("mj", 0);
    }

    public static void save(String key, String value){
        sharedPreferences.edit().putString(key, value).apply();
    }

    public static String get(String key){
        return sharedPreferences.getString(key, "");
    }
}
