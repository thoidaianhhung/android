package funix.prm.customandroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeView extends androidx.appcompat.widget.AppCompatTextView {
    private String titleText;

    public TimeView(Context context) {
        super(context);
        setTimeView();
    }

    public TimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        final TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.TimeView);
        int count = typedArray.getIndexCount();
        try {
            for (int i = 0; i < count; i++) {
                int attr = typedArray.getIndex(i);
                if (attr == R.styleable.TimeView_title) {
                    titleText = typedArray.getString(attr);
                    setTimeView();
                } else if (attr == R.styleable.TimeView_setColor){
                    boolean color = typedArray.getBoolean(attr, false);
                    if (color) {
                        setShadowLayer(4, 2, 2, Color.rgb(255, 255, 0));
                        setBackgroundColor(Color.rgb(51, 102, 255));
                    } else {
                        setBackgroundColor(Color.RED);
                    }
                }
            }
        } finally {
            typedArray.recycle();
        }
    }

    public TimeView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        setTimeView();
    }

    @SuppressLint("SetTextI18n")
    private void setTimeView() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
        String time = dateFormat.format(Calendar.getInstance().getTime());
        if (titleText != null) {
            setText(time + "\n" + this.titleText);
        } else {
            setText(time);
        }
    }
}
