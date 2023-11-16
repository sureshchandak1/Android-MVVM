package com.qs.sharedcode.widgets.material;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputLayout;
import com.qs.sharedcode.R;
import com.qs.sharedcode.utils.UIUtils;

public class CustomTextInputLayout extends TextInputLayout {

    public CustomTextInputLayout(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public CustomTextInputLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomTextInputLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
                    R.styleable.CustomTextInputLayout, 0, 0);
            try {
                setFont(typedArray);
            } finally {
                typedArray.recycle();
            }
        }
    }

    private void setFont(TypedArray typedArray) {
        int textFont = typedArray.getInteger(R.styleable.CustomTextInputLayout_text_font, 0);
        setTypeface(UIUtils.getFont(getContext(), textFont));
    }
}
