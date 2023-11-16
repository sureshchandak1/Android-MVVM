package com.material.sharedcode.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.material.sharedcode.R;

public class CustomDatePicker extends DatePicker {

    private static final int SPINNER_COUNT = 3;
    private final String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    private final NumberPicker mSpinnerYear;
    private final NumberPicker mSpinnerMonth;
    private final NumberPicker mSpinnerDay;
    private final LinearLayout mLayout;

    public CustomDatePicker(Context context) {
        this(context, null, 0);
        init(context, null);
    }

    public CustomDatePicker(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init(context, attrs);
    }

    public CustomDatePicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final int idYear = Resources.getSystem().getIdentifier("year", "id", "android");
        final int idMonth = Resources.getSystem().getIdentifier("month", "id", "android");
        final int idDay = Resources.getSystem().getIdentifier("day", "id", "android");
        final int idLayout = Resources.getSystem().getIdentifier("pickers", "id", "android");

        mSpinnerYear = findViewById(idYear);
        mSpinnerMonth = findViewById(idMonth);
        mSpinnerDay = findViewById(idDay);
        mLayout = findViewById(idLayout);

        mLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        mSpinnerMonth.setDisplayedValues(months);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setOnDateChangedListener(onDateChangedListener);
        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs,
                    R.styleable.CustomDatePicker, 0, 0);
            if (typedArray != null) {
                try {
                    setDateOrder(typedArray);
                } finally {
                    typedArray.recycle();
                }
            }
        }
    }

    private void setDateOrder(TypedArray typedArray) {
        String order = typedArray.getString(R.styleable.CustomDatePicker_dateOrder);
        setDateOrder(order.toCharArray());
    }

    private void setDateOrder(char[] orders) {

        mLayout.removeAllViews();
        for (int i = 0; i < SPINNER_COUNT; i++) {
            switch (orders[i]) {
                case 'y':
                    mLayout.addView(mSpinnerYear);
                    setImeOptions(mSpinnerYear, i);
                    break;
                case 'm':
                    mLayout.addView(mSpinnerMonth);
                    setImeOptions(mSpinnerMonth, i);
                    break;
                case 'd':
                    mLayout.addView(mSpinnerDay);
                    setImeOptions(mSpinnerDay, i);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid char[] ymdOrder");
            }
        }
    }

    private void setImeOptions(NumberPicker spinner, int spinnerIndex) {
        final int imeOptions;
        if (spinnerIndex < SPINNER_COUNT - 1) {
            imeOptions = EditorInfo.IME_ACTION_NEXT;
        }
        else {
            imeOptions = EditorInfo.IME_ACTION_DONE;
        }
        int idPickerInput = Resources.getSystem().getIdentifier("numberpicker_input", "id", "android");
        TextView input = spinner.findViewById(idPickerInput);
        input.setImeOptions(imeOptions);
    }

    private final OnDateChangedListener onDateChangedListener = new OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mSpinnerMonth.setDisplayedValues(months);
        }
    };

}
