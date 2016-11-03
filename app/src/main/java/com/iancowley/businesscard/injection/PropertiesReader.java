package com.iancowley.businesscard.injection;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by iancowley on 11/3/16.
 */

public class PropertiesReader {

    protected Properties properties;

    public PropertiesReader(Context context) {
        properties = new Properties();
        AssetManager assetManager = context.getAssets();
        try {
            InputStream inputStream = assetManager.open("card_config.properties");
            properties.load(inputStream);
        } catch (IOException ioe) {
            // TODO: Handle properties file missing.
        }
    }

    public @NonNull String getProperty(String key) {
        if (properties == null) {
            return "";
        }
        return properties.getProperty(key);
    }
}
