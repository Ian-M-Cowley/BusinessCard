package com.iancowley.businesscard;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.iancowley.businesscard.databinding.ActivitySettingsBinding;

import javax.inject.Inject;

import static com.iancowley.businesscard.ColorSelectActivity.ACCENT_SELECT;
import static com.iancowley.businesscard.ColorSelectActivity.PRIMARY_DARK_SELECT;
import static com.iancowley.businesscard.ColorSelectActivity.PRIMARY_SELECT;

public class SettingsActivity extends AppCompatActivity {

    @Inject ColorSettings colorSettings;

    public static Intent newIntent(Context caller) {
        return new Intent(caller, SettingsActivity.class);
    }

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
                startActivity(ColorSelectActivity.newIntent(SettingsActivity.this, PRIMARY_DARK_SELECT));
            }
        });

        binding.buttonPrimary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(ColorSelectActivity.newIntent(SettingsActivity.this, PRIMARY_SELECT));
            }
        });

        binding.buttonAccent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(ColorSelectActivity.newIntent(SettingsActivity.this, ACCENT_SELECT));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setStatusBarColor(colorSettings.getPrimaryDarkColor());
    }
}
