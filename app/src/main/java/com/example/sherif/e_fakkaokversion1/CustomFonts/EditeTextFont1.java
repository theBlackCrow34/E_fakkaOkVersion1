package com.example.sherif.e_fakkaokversion1.CustomFonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditeTextFont1 extends android.support.v7.widget.AppCompatEditText {
    public EditeTextFont1(Context context) {
        super(context);
        init();
    }

    public EditeTextFont1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditeTextFont1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Another America.ttf");
            setTypeface(tf);
        }
    }
}
