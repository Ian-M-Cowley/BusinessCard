package com.iancowley.businesscard;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.iancowley.businesscard.databinding.ActivityBusinessCardBinding;

public class BusinessCardActivity extends AppCompatActivity {

    private BusinessCard businessCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityBusinessCardBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_business_card);

        businessCard = new BusinessCard.Builder()
                .firstName("Ian")
                .lastName("Cowley")
                .mobilePhone("972.838.6504")
                .workPhone("555.555.5555")
                .personalEmail("ian.m.cowley15@gmail.com")
                .workEmail("ian@planoly.com")
                .build();

        binding.toolbar.setTitle(String.format("%s %s", businessCard.firstName, businessCard.lastName));
        setSupportActionBar(binding.toolbar);


        binding.setBusinessCard(businessCard);
    }
}
