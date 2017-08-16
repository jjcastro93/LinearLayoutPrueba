package com.example.admin.prueba;

import android.content.Context;
import android.widget.AbsSpinner;

/**
 * Created by admin on 15/08/2017.
 */

public class MySpinner extends AbsSpinner {
    public MySpinner(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
