package com.iancowley.businesscard;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.iancowley.businesscard.databinding.ActivityColorSelectBinding;

import javax.inject.Inject;

/**
 * Created by iancowley on 6/1/17.
 */

public class ColorSelectActivity extends AppCompatActivity {

    @IntDef({PRIMARY_DARK_SELECT, PRIMARY_SELECT, ACCENT_SELECT})
    public @interface ColorSelectMode {
    }

    public static final int PRIMARY_DARK_SELECT = 0;
    public static final int PRIMARY_SELECT = 1;
    public static final int ACCENT_SELECT = 2;

    private static final String EXTRA_SELECT_MODE = "select_mode";

    @Inject ColorSettings colorSettings;

    private @ColorSelectMode int colorSelectMode;
    private ColorRecyclerAdapter colorRecyclerAdapter;

    public static Intent newIntent(Context caller, @ColorSelectMode int colorSelectMode) {
        Intent intent = new Intent(caller, ColorSelectActivity.class);
        intent.putExtra(EXTRA_SELECT_MODE, colorSelectMode);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BusinessCardApplication) getApplication()).getComponent().inject(this);

        ActivityColorSelectBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_color_select);
        binding.setColorSettings(colorSettings);
        binding.toolbar.setTitle(R.string.select_a_color);
        setSupportActionBar(binding.toolbar);

        getWindow().setStatusBarColor(colorSettings.getPrimaryDarkColor());

        colorSelectMode = getIntent().getIntExtra(EXTRA_SELECT_MODE, 0);
        int[] colors = {};
        int[] textColors = {};
        String[] colorNames = {};

        Resources resources = getResources();
        if (colorSelectMode == PRIMARY_DARK_SELECT) {
            colors = resources.getIntArray(R.array.primary_dark_colors);
            textColors = resources.getIntArray(R.array.primary_dark_text_colors);
            colorNames = resources.getStringArray(R.array.primary_dark_color_names);
        } else if (colorSelectMode == PRIMARY_SELECT) {
            colors = resources.getIntArray(R.array.primary_colors);
            textColors = resources.getIntArray(R.array.primary_text_colors);
            colorNames = resources.getStringArray(R.array.primary_color_names);
        } else if (colorSelectMode == ACCENT_SELECT) {
            colors = resources.getIntArray(R.array.accent_colors);
            textColors = resources.getIntArray(R.array.accent_text_colors);
            colorNames = resources.getStringArray(R.array.accent_color_names);
        }

        colorRecyclerAdapter = new ColorRecyclerAdapter(colors, textColors, colorNames,
                new ColorRecyclerAdapter.ColorRecyclerAdapterListener() {
                    @Override
                    public void onColorSelected(int color) {
                        switch (colorSelectMode) {
                            case PRIMARY_DARK_SELECT:
                                colorSettings.setPrimaryDarkColor(color);
                                getWindow().setStatusBarColor(colorSettings.getPrimaryDarkColor());
                                break;
                            case PRIMARY_SELECT:
                                colorSettings.setPrimaryColor(color);
                                break;
                            case ACCENT_SELECT:
                                colorSettings.setAccentColor(color);
                                break;
                        }
                    }
                });
        binding.colorRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.colorRecycler.setAdapter(colorRecyclerAdapter);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
