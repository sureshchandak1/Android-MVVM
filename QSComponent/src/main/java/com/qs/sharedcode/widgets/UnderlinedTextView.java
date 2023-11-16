package com.qs.sharedcode.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.qs.sharedcode.R;
import com.qs.sharedcode.utils.UIUtils;

public class UnderlinedTextView extends AppCompatTextView {

    private Rect mRect;
    private Paint mPaint;
    private int mColor;
    private float mStrokeWidth;
    private float mMarginTop;
    private boolean isAllSelected;
    private int lineNumber;
    private int selectTextEachLine;

    public UnderlinedTextView(Context context) {
        this(context, null, 0);
    }

    public UnderlinedTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UnderlinedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attributeSet, int defStyle) {

        float density = context.getResources().getDisplayMetrics().density;

        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.UnderlinedTextView, defStyle, 0);
        mColor = typedArray.getColor(R.styleable.UnderlinedTextView_underlineColor, 0xFFFF0000);
        mStrokeWidth = typedArray.getDimension(R.styleable.UnderlinedTextView_underlineWidth, density * 2);
        mMarginTop = typedArray.getDimension(R.styleable.UnderlinedTextView_underlineMarginTop, density * 2);
        isAllSelected = typedArray.getBoolean(R.styleable.UnderlinedTextView_underlineIsAll, false);
        lineNumber = typedArray.getInteger(R.styleable.UnderlinedTextView_underlineNoLine, 1);
        selectTextEachLine = typedArray.getInteger(R.styleable.UnderlinedTextView_underlineTextEachLine, 3);
        int textFont = typedArray.getInteger(R.styleable.UnderlinedTextView_text_font, 0);
        setTypeface(UIUtils.getFont(getContext(), textFont));
        typedArray.recycle();

        mRect = new Rect();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mColor); //line mColor
        mPaint.setStrokeWidth(mStrokeWidth);
    }

    public int getUnderLineColor() {
        return mColor;
    }

    public void setUnderLineColor(int mColor) {
        this.mColor = mColor;
        invalidate();
    }

    public float getUnderlineWidth() {
        return mStrokeWidth;
    }

    public void setUnderlineWidth(float mStrokeWidth) {
        this.mStrokeWidth = mStrokeWidth;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int h = (int) (getMeasuredHeight() + mMarginTop);
        setMeasuredDimension(widthMeasureSpec, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        final Layout layout = getLayout();
        float x_start, x_stop;
        int firstCharInLine, lastCharInLine;

        int limit = isAllSelected ? getLineCount() : lineNumber;
        for (int i = 0; i < limit; i++) {
            int baseline = getLineBounds(i, mRect);
            firstCharInLine = layout.getLineStart(i);
            lastCharInLine = layout.getLineEnd(i);

            int textHighlight = isAllSelected ? lastCharInLine - 1 : (firstCharInLine + selectTextEachLine);
            x_start = layout.getPrimaryHorizontal(firstCharInLine);
            x_stop = layout.getPrimaryHorizontal(textHighlight);

            float y = baseline + mStrokeWidth + mMarginTop;
            canvas.drawLine(x_start, y, x_stop, y, mPaint);
        }

        super.onDraw(canvas);
    }
}