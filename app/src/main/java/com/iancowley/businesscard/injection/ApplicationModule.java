package com.iancowley.businesscard.injection;

import android.app.Application;
import android.content.Context;

import com.iancowley.businesscard.ColorSettings;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by iancowley on 11/3/16.
 */

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public PropertiesReader providePropertyReader(Context context) {
        return new PropertiesReader(context);
    }

    @Provides
    @Singleton
    public ColorSettings provideColorSettings(Context context) {
        return new ColorSettings(context);
    }
}
