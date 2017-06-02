package com.iancowley.businesscard;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.iancowley.businesscard.databinding.ActivityBusinessCardBinding;
import com.iancowley.businesscard.injection.PropertiesReader;

import javax.inject.Inject;

import static com.iancowley.businesscard.injection.PropertiesReader.PROPERTY_FIRST_NAME;
import static com.iancowley.businesscard.injection.PropertiesReader.PROPERTY_LAST_NAME;
import static com.iancowley.businesscard.injection.PropertiesReader.PROPERTY_MOBILE_PHONE;
import static com.iancowley.businesscard.injection.PropertiesReader.PROPERTY_PERSONAL_EMAIL;
import static com.iancowley.businesscard.injection.PropertiesReader.PROPERTY_QR_CODE_INFO;
import static com.iancowley.businesscard.injection.PropertiesReader.PROPERTY_TITLE;
import static com.iancowley.businesscard.injection.PropertiesReader.PROPERTY_WORK_EMAIL;
import static com.iancowley.businesscard.injection.PropertiesReader.PROPERTY_WORK_PHONE;

public class BusinessCardActivity extends AppCompatActivity {

    @Inject PropertiesReader propertiesReader;
    @Inject ColorSettings colorSettings;

    private BusinessCard businessCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((BusinessCardApplication)getApplication()).getComponent().inject(this);

        ActivityBusinessCardBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_business_card);
        getWindow().setStatusBarColor(colorSettings.getPrimaryDarkColor());

        businessCard = new BusinessCard.Builder()
                .firstName(propertiesReader.getProperty(PROPERTY_FIRST_NAME))
                .lastName(propertiesReader.getProperty(PROPERTY_LAST_NAME))
                .mobilePhone(propertiesReader.getProperty(PROPERTY_MOBILE_PHONE))
                .workPhone(propertiesReader.getProperty(PROPERTY_WORK_PHONE))
                .personalEmail(propertiesReader.getProperty(PROPERTY_PERSONAL_EMAIL))
                .workEmail(propertiesReader.getProperty(PROPERTY_WORK_EMAIL))
                .title(propertiesReader.getProperty(PROPERTY_TITLE))
                .qrCodeInfo(propertiesReader.getProperty(PROPERTY_QR_CODE_INFO))
                .build();

        binding.setBusinessCard(businessCard);
        binding.setColorSettings(colorSettings);
        setSupportActionBar(binding.toolbar);
    }
}
