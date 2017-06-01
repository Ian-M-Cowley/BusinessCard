package com.iancowley.businesscard.injection;

import com.iancowley.businesscard.BusinessCardActivity;
import com.iancowley.businesscard.BusinessCardApplication;
import com.iancowley.businesscard.SettingsActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by iancowley on 11/3/16.
 */

@Singleton
@Component(modules = { ApplicationModule.class })
public interface ApplicationComponent {
    void inject(BusinessCardApplication target);
    void inject(BusinessCardActivity target);
    void inject(SettingsActivity target);
}
