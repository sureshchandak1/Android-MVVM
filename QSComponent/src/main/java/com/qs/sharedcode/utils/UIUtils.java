package com.qs.sharedcode.utils;

import android.content.Context;
import android.graphics.Typeface;

import com.qs.sharedcode.widgets.FontCache;

public class UIUtils {

    public static Typeface getFont(Context context, int mTextStyle) {
        switch (mTextStyle) {
            case 0:
                return FontCache.getNunitoSansRegular(context);
            case 1:
                return FontCache.getNunitoSansLight(context);
            case 2:
                return FontCache.getNunitoSansSemiBold(context);
            case 3:
                return FontCache.getNunitoSansBold(context);
            case 4:
                return FontCache.getNunitoSansExtraBold(context);
            default:
                return FontCache.getNunitoSansRegular(context);
        }
    }
}
