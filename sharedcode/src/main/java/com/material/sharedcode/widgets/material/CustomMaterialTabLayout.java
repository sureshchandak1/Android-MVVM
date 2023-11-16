package com.material.sharedcode.widgets.material;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;
import com.material.sharedcode.R;
import com.material.sharedcode.utils.UIUtils;

public class CustomMaterialTabLayout extends TabLayout {

    private int tabFont = 2;

    public CustomMaterialTabLayout(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public CustomMaterialTabLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomMaterialTabLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
                    R.styleable.CustomMaterialTabLayout, 0, 0);
            try {
                tabFont = typedArray.getInteger(R.styleable.CustomMaterialTabLayout_text_font, 2);
            } finally {
                typedArray.recycle();
            }
        }
    }

    @Override
    public void addTab(@NonNull Tab tab) {
        super.addTab(tab);

        ViewGroup mainView = (ViewGroup) getChildAt(0);
        if (mainView != null) {
            ViewGroup tabView = (ViewGroup) mainView.getChildAt(tab.getPosition());
            if (tabView != null) {
                int tabChildCount = tabView.getChildCount();
                for (int i = 0; i < tabChildCount; i++) {
                    View tabViewChild = tabView.getChildAt(i);
                    if (tabViewChild instanceof TextView) {
                        ((TextView) tabViewChild).setTypeface(UIUtils.getFont(getContext(), tabFont), Typeface.NORMAL);
                    }
                }
            }
        }
    }

    public void text_font(int textFont) {
        tabFont = textFont;
    }

}
