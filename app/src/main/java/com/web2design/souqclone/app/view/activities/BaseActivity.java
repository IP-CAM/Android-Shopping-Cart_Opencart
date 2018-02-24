package com.web2design.souqclone.app.view.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.web2design.souqclone.app.MyContextWrapper;
import com.web2design.souqclone.app.Preferences;

import static com.web2design.souqclone.app.AppConstants.LANGUAGE_KEY;
import static com.web2design.souqclone.app.AppConstants.appContext;

/**
 * Created by SKAFS on 2/22/2018.
 */

public class BaseActivity extends AppCompatActivity {
    
    
    @Override
    protected void attachBaseContext(Context newBase) {
        
        // create or get your new Locale object here.
        String lang = Preferences
                .getSharedPreferenceString(appContext, LANGUAGE_KEY, "ar");
        
        Context context = MyContextWrapper.wrap(newBase, lang);
        super.attachBaseContext(context);
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
