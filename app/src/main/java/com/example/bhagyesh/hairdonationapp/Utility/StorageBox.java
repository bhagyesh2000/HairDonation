package com.example.bhagyesh.hairdonationapp.Utility;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class StorageBox<T> {
    static StorageBox storageBox;

    public StorageBox() {
    }

    public   boolean putData(Context ctx, String key, T Value ){

        try{
            SharedPreferences preferences= ctx.getSharedPreferences(ctx.getPackageName(), MODE_PRIVATE);

            SharedPreferences.Editor editor= preferences.edit();

            if(Value.getClass().equals(String.class))
            {
                editor.putString(key, (String) Value);
            }
            else if(Value.getClass().equals(Boolean.class))
            {
                editor.putBoolean(key, (Boolean) Value);
            }else if(Value.getClass().equals(Integer.class))
            {
                editor.putInt(key, (Integer) Value);
            }
            editor.apply();

            return true;
        }
        catch (Exception e){
            return false;}
    }


    public  static  String getData(Context ctx,String key) {

        SharedPreferences preferences =ctx.getSharedPreferences(ctx.getPackageName(),Context.MODE_PRIVATE);
        return preferences.getString(key,"");
    }

    public static int getIntegerData(Context ctx, String key) {
        SharedPreferences preferences = ctx.getSharedPreferences(ctx.getPackageName(), Context.MODE_PRIVATE);
        return preferences.getInt(key, 0);
    }

    public  static  boolean getResultData(Context ctx,String key) {
        SharedPreferences preferences =ctx.getSharedPreferences(ctx.getPackageName(),Context.MODE_PRIVATE);
        return preferences.getBoolean(key,false);
    }


    public static  void ClearSharedPref(Context ctx)
    {
        SharedPreferences preferences= ctx.getSharedPreferences(ctx.getPackageName(), MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.clear().apply();
    }
}
