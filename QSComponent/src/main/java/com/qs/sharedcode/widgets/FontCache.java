package com.qs.sharedcode.widgets;

import android.content.Context;
import android.graphics.Typeface;

public class FontCache {

    private static Typeface nunitoSansRegular, nunitoSansLight, nunitoSansSemiBold, nunitoSansBold, nunitoSansExtraBold;

    public static Typeface getNunitoSansRegular(Context context) {
        if (nunitoSansRegular == null) {
            nunitoSansRegular = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/NunitoSans-Regular.ttf");
        }
        return nunitoSansRegular;
    }

    public static Typeface getNunitoSansLight(Context context) {
        if (nunitoSansLight == null) {
            nunitoSansLight = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/NunitoSans-Light.ttf");
        }
        return nunitoSansLight;
    }

    public static Typeface getNunitoSansSemiBold(Context context) {
        if (nunitoSansSemiBold == null) {
            nunitoSansSemiBold = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/NunitoSans-SemiBold.ttf");
        }
        return nunitoSansSemiBold;
    }

    public static Typeface getNunitoSansBold(Context context) {
        if (nunitoSansBold == null) {
            nunitoSansBold = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/NunitoSans-Bold.ttf");
        }
        return nunitoSansBold;
    }

    public static Typeface getNunitoSansExtraBold(Context context) {
        if (nunitoSansExtraBold == null) {
            nunitoSansExtraBold = Typeface.createFromAsset(context.getResources()
                    .getAssets(), "fonts/NunitoSans-ExtraBold.ttf");
        }
        return nunitoSansExtraBold;
    }
}
