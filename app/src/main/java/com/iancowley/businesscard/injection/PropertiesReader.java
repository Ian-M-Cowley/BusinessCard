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

    public static final String PROPERTY_FIRST_NAME = "firstName";
    public static final String PROPERTY_LAST_NAME = "lastName";
    public static final String PROPERTY_MOBILE_PHONE = "mobilePhone";
    public static final String PROPERTY_WORK_PHONE = "workPhone";
    public static final String PROPERTY_PERSONAL_EMAIL = "personalEmail";
    public static final String PROPERTY_WORK_EMAIL = "workEmail";
    public static final String PROPERTY_TITLE = "title";
    public static final String PROPERTY_QR_CODE_INFO = "qrCodeInfo";

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
