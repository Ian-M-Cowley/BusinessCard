package com.iancowley.businesscard;

import android.databinding.BindingAdapter;
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
}
