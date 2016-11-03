package com.iancowley.businesscard;

import android.app.Application;

import com.iancowley.businesscard.injection.ApplicationComponent;
import com.iancowley.businesscard.injection.ApplicationModule;
import com.iancowley.businesscard.injection.DaggerApplicationComponent;

/**
 * Created by iancowley on 11/3/16.
 */

public class BusinessCardApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }


    public ApplicationComponent getComponent() {
        return component;
    }
}
