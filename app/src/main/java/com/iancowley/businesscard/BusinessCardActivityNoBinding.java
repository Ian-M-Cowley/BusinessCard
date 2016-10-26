package com.iancowley.businesscard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by iancowley on 10/24/16.
 */

public class BusinessCardActivityNoBinding extends AppCompatActivity {

    private Toolbar toolbar;
    private View mobilePhoneLayout;
    private View workPhoneLayout;
    private View personalEmailLayout;
    private View workEmailLayout;
    private TextView mobilePhone;
    private TextView workPhone;
    private ImageView workPhoneIcon;
    private TextView personalEmail;
    private TextView workEmail;
    private ImageView workEmailIcon;

    private BusinessCard businessCard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_card);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        mobilePhoneLayout = findViewById(R.id.layout_mobile_phone);
        workPhoneLayout = findViewById(R.id.layout_work_phone);
        personalEmailLayout = findViewById(R.id.layout_personal_email);
        workEmailLayout = findViewById(R.id.layout_work_email);

        mobilePhone = (TextView) findViewById(R.id.text_mobile_phone);
        workPhone = (TextView) findViewById(R.id.text_work_phone);
        workPhoneIcon = (ImageView) findViewById(R.id.image_work_phone);

        personalEmail = (TextView) findViewById(R.id.text_personal_email);
        workEmail = (TextView) findViewById(R.id.text_email_work);
        workEmailIcon = (ImageView) findViewById(R.id.image_work_email);

        businessCard = new BusinessCard.Builder()
                .firstName("Ian")
                .lastName("Cowley")
                .mobilePhone("972.838.6504")
                .workPhone("555.555.5555")
                .personalEmail("ian.m.cowley15@gmail.com")
                .workEmail("ian@planoly.com")
                .build();

        toolbar.setTitle(businessCard.firstName + " " + businessCard.lastName);
        setSupportActionBar(toolbar);

        mobilePhone.setText(businessCard.mobilePhone);
        workPhone.setText(businessCard.workPhone);
        personalEmail.setText(businessCard.personalEmail);
        workEmail.setText(businessCard.workEmail);

        mobilePhoneLayout.setVisibility(TextUtils.isEmpty(businessCard.mobilePhone) ? View.GONE : View.VISIBLE);
        workPhoneLayout.setVisibility(TextUtils.isEmpty(businessCard.workPhone) ? View.GONE : View.VISIBLE);
        personalEmailLayout.setVisibility(TextUtils.isEmpty(businessCard.personalEmail) ? View.GONE : View.VISIBLE);
        workEmailLayout.setVisibility(TextUtils.isEmpty(businessCard.workEmail) ? View.GONE : View.VISIBLE);

        workPhoneIcon.setVisibility(TextUtils.isEmpty(businessCard.mobilePhone) ? View.VISIBLE : View.GONE);
        workEmailIcon.setVisibility(TextUtils.isEmpty(businessCard.personalEmail) ? View.VISIBLE : View.GONE);
    }
}
