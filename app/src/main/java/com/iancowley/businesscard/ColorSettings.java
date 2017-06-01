package com.iancowley.businesscard;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.ColorInt;

/**
 * Created by iancowley on 12/19/16.
 */

public class ColorSettings extends BaseObservable {

    private static final String PREFS_FILE = "com.iancowley.businesscard.ColorSettingsPrefs";
    private static final String PREF_PRIMARY_DARK = "primaryDark";
    private static final String PREF_PRIMARY = "primary";
    private static final String PREF_ACCENT = "accent";

    private int primaryDarkColor;
    private int primaryColor;
    private int accentColor;

    private SharedPreferences preferences;

    public ColorSettings(Context context) {
        preferences = context.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        primaryDarkColor = preferences.getInt(PREF_PRIMARY_DARK, context.getResources().getColor(R.color.colorPrimaryDark));
        primaryColor = preferences.getInt(PREF_PRIMARY, context.getResources().getColor(R.color.colorPrimary));
        accentColor = preferences.getInt(PREF_ACCENT, context.getResources().getColor(R.color.colorAccent));
    }

    @Bindable
    public @ColorInt int getPrimaryDarkColor() {
        return primaryDarkColor;
    }

    public void setPrimaryDarkColor(@ColorInt int primaryDarkColor) {
        this.primaryDarkColor = primaryDarkColor;
        preferences.edit().putInt(PREF_PRIMARY_DARK, this.primaryDarkColor).apply();
        notifyPropertyChanged(BR.primaryDarkColor);
    }

    @Bindable
    public @ColorInt int getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(@ColorInt int primaryColor) {
        this.primaryColor = primaryColor;
        preferences.edit().putInt(PREF_PRIMARY, this.primaryColor).apply();
        notifyPropertyChanged(BR.primaryColor);
    }

    @Bindable
    public @ColorInt int getAccentColor() {
        return accentColor;
    }

    public void setAccentColor(@ColorInt int accentColor) {
        this.accentColor = accentColor;
        preferences.edit().putInt(PREF_ACCENT, this.accentColor).apply();
        notifyPropertyChanged(BR.accentColor);
    }
}
