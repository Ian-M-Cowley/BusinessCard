package com.iancowley.businesscard;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.iancowley.businesscard.databinding.ActivitySettingsBinding;

import javax.inject.Inject;

public class SettingsActivity extends AppCompatActivity {

    @Inject ColorSettings colorSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BusinessCardApplication)getApplication()).getComponent().inject(this);

        ActivitySettingsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_settings);


        binding.setColorSettings(colorSettings);
        binding.toolbar.setTitle(R.string.settings);
        setSupportActionBar(binding.toolbar);

        binding.buttonPrimaryDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorSettings.setPrimaryDarkColor(getResources().getColor(R.color.blue));
            }
        });

        binding.buttonPrimary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                colorSettings.setPrimaryColor(getResources().getColor(R.color.blue));
            }
        });

        binding.buttonAccent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                colorSettings.setAccentColor(getResources().getColor(R.color.blue));
            }
        });
    }
}
