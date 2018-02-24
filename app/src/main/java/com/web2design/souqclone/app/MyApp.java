package com.web2design.souqclone.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Log;


import java.util.Locale;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Inzimam Tariq on 1/17/2018.
 */

public class MyApp extends Application {
    
    private Locale locale;
    private static Context context;
    
    public static Context getAppContext() {
        return context;
    }
    
    
    @Override
    public void onCreate() {
        super.onCreate();
        context = getBaseContext();
        
        try {

//            changeLocale();
            
            Configuration config = getApplicationContext().getResources().getConfiguration();
            
            if (isRTL(Locale.getDefault())) {
                Log.e("MyApp", "Changing Calligraphy");
                CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/DroidKufi-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build());
                
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    config.setLayoutDirection(locale);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void changeLocale() {
//        Configuration config;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            config = new Configuration();
//        } else {
//            config = getApplicationContext().getResources().getConfiguration();
//        }
//        String lang = Preferences
//                .getSharedPreferenceString(this, LANGUAGE_KEY, "ar");
//        Log.e("MyApp", "language in MyApp = " + lang);
//
//        locale = new Locale(lang);
//        Locale.setDefault(locale);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            config.setLocale(locale);
//        } else {
//            config.locale = locale;
//        }
//        Log.e("MyApp", "Inside if Language = " + lang);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            getApplicationContext().createConfigurationContext(config);
//            getApplicationContext().getResources().updateConfiguration(config,
//                    getApplicationContext().getResources().getDisplayMetrics());
//        } else {
//            getApplicationContext().getResources().updateConfiguration(config,
//                    getApplicationContext().getResources().getDisplayMetrics());
//
//        }
//    }
    
    
    public static boolean isRTL(Locale locale) {
        final int directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        return directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT ||
                directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
    }

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//
//        if (locale != null) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                newConfig.setLocale(locale);
//            } else {
//                newConfig.locale = locale;
//            }
//            Locale.setDefault(locale);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//                getApplicationContext().createConfigurationContext(newConfig);
//                getApplicationContext().getResources().updateConfiguration(newConfig, getApplicationContext().getResources().getDisplayMetrics());
//            } else {
//                getApplicationContext().getResources().updateConfiguration(newConfig, getApplicationContext().getResources().getDisplayMetrics());
//            }
//        }
//        super.onConfigurationChanged(newConfig);
//    }
    
}
