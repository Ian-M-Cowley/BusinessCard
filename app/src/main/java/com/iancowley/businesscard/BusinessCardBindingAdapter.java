package com.iancowley.businesscard;

import android.content.res.ColorStateList;
import android.databinding.BindingAdapter;
import android.support.annotation.ColorInt;
import android.support.design.widget.FloatingActionButton;
import android.text.TextUtils;
import android.widget.ImageView;

import net.glxn.qrgen.android.QRCode;

/**
 * Created by iancowley on 11/2/16.
 */

public class BusinessCardBindingAdapter {

    @BindingAdapter("qrcode")
    public static void loadQrCode(ImageView view, String codeInfo) {
        if(TextUtils.isEmpty(codeInfo)) {
            return;
        }
        view.setImageBitmap(QRCode.from(codeInfo).bitmap());
    }

    @BindingAdapter("fabBackground")
    public static void setFabBackground(FloatingActionButton fab, @ColorInt int color) {
        fab.setBackgroundTintList(ColorStateList.valueOf(color));
    }

}
