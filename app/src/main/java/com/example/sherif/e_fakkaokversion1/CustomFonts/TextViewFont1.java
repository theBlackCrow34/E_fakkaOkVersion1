package com.example.sherif.e_fakkaokversion1.CustomFonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class TextViewFont1 extends android.support.v7.widget.AppCompatTextView {

    public TextViewFont1(Context context) {
        super(context);
        init();
    }

    public TextViewFont1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewFont1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Almarai_Font.ttf");
            setTypeface(tf);
        }
    }
}
