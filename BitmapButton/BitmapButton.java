package com.example.pkiop.mybutton;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class BitmapButton extends AppCompatButton {
    public BitmapButton(Context context) {
        super(context);
        init(context);
    }

    public BitmapButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    private void init(Context context){
        setBackgroundResource(R.drawable.bitmap_button_normal);

        float textSize = getResources().getDimension(R.dimen.text_size);
        setTextSize(textSize);
        setTextColor(Color.WHITE);
    }

    @Override // 매우 중요한 메소드
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        switch(action){
            case MotionEvent.ACTION_DOWN: // 아래로
                setBackgroundResource(R.drawable.bitmap_button_clicked);
                break;
            case MotionEvent.ACTION_UP:
                setBackgroundResource(R.drawable.bitmap_button_normal);
                break;
        }

        invalidate();

        return true;
    }
}
