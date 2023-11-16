package com.qs.sharedcode.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

public final class AppUtils {

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    private AppUtils() {
        throw new IllegalStateException(getClass().getName());
    }

    public static void showToast(Context context, String message, int length) {
        if (Toast.LENGTH_LONG == length) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        } else if (Toast.LENGTH_SHORT == length) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    public static void hideKeyboardFragment(Context context, View view) {
        final InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static double decimalFormat(double value) {

        NumberFormat numberFormat = NumberFormat.getInstance();
        try {
            Number number = numberFormat.parse("" + value);
            if (number != null) {
                value = number.doubleValue();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            String convert = decimalFormat.format(value);
            return Double.parseDouble(convert);
        } catch (NumberFormatException e) {
            String sValue = String.valueOf(value);
            if (sValue.contains(",")) {
                sValue = sValue.replaceAll(",", ".");
                String convert = decimalFormat.format(sValue);
                return Double.parseDouble(convert);
            } else {
                String convert = decimalFormat.format(sValue);
                return Double.parseDouble(convert);
            }
        } catch (IllegalArgumentException e) {
            return value;
        }
    }

    public static String showBigDecimal(double value) {
        BigDecimal a = BigDecimal.valueOf(value);
        return decimalFormat.format(a);
    }

}
