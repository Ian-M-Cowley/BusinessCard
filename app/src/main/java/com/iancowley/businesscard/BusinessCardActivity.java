package com.iancowley.businesscard;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.iancowley.businesscard.databinding.ActivityBusinessCardBinding;
import com.iancowley.businesscard.injection.PropertiesReader;

import javax.inject.Inject;

public class BusinessCardActivity extends AppCompatActivity {

    @Inject PropertiesReader propertiesReader;

    private BusinessCard businessCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((BusinessCardApplication)getApplication()).getComponent().inject(this);

        ActivityBusinessCardBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_business_card);

        businessCard = new BusinessCard.Builder()
                .firstName(propertiesReader.getProperty("firstName"))
                .lastName(propertiesReader.getProperty("lastName"))
                .mobilePhone(propertiesReader.getProperty("mobilePhone"))
                .workPhone(propertiesReader.getProperty("workPhone"))
                .personalEmail(propertiesReader.getProperty("personalEmail"))
                .workEmail(propertiesReader.getProperty("workEmail"))
                .title(propertiesReader.getProperty("title"))
                .qrCodeInfo(propertiesReader.getProperty("qrCodeInfo"))
                .build();

        binding.setBusinessCard(businessCard);
        setSupportActionBar(binding.toolbar);
    }
}
