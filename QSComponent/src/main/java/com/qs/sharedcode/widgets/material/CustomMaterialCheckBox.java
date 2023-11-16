package com.qs.sharedcode.widgets.material;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.checkbox.MaterialCheckBox;
import com.qs.sharedcode.R;
import com.qs.sharedcode.utils.UIUtils;

public class CustomMaterialCheckBox extends MaterialCheckBox {

    public CustomMaterialCheckBox(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public CustomMaterialCheckBox(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomMaterialCheckBox(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
                    R.styleable.CustomMaterialCheckBox, 0, 0);
            if (typedArray != null) {
                try {
                    setFont(typedArray);
                } finally {
                    typedArray.recycle();
                }
            }
        }
    }

    private void setFont(TypedArray typedArray) {
        int textFont = typedArray.getInteger(R.styleable.CustomMaterialCheckBox_text_font, 0);
        setTypeface(UIUtils.getFont(getContext(), textFont));
    }
}
