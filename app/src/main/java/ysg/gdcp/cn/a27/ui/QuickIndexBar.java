package ysg.gdcp.cn.a27.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/3/23 08:38.
 *  这是一个快速检索的自定义控件
 * @author ysg
 *
 */

public class QuickIndexBar extends View {

    private Paint paint;
    private String[] indexArr = {"A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"};
    private int width;
    private int cellHeight;

    public QuickIndexBar(Context context) {
        super(context);
        init();
    }

    public QuickIndexBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public QuickIndexBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = getMeasuredWidth();
        cellHeight = getMeasuredHeight() / indexArr.length;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float x = width / 2;
        for (int i = 0; i < indexArr.length; i++) {
            float y = cellHeight / 2 + getTextHeight(indexArr[i]) / 2 + i * cellHeight;
            paint.setColor(lastIndex == i ? Color.BLACK : Color.WHITE);
            canvas.drawText(indexArr[i], x, y, paint);
        }
    }

    private int lastIndex = -1;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                float y = event.getY();
                int index = (int) (y / cellHeight);
                if (index != lastIndex) {
                    if (index > 0 && index < indexArr.length) {
                        if (listener != null) {
                            listener.onTouchLetter(indexArr[index]);
                        }
                    }
                }
                lastIndex = index;
                break;
            case MotionEvent.ACTION_UP:
                lastIndex = -1;
                break;
        }
        invalidate();
        return true;
    }

    private onTouchLeteerListener listener;

    public void setOnTouchLeteerListener(onTouchLeteerListener listener) {
        this.listener = listener;
    }

    public interface onTouchLeteerListener {
        void onTouchLetter(String word);
    }

    /**
     * 获取文本的高度
     *
     * @param text 文本
     * @return 高度
     */
    private int getTextHeight(String text) {
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        return bounds.height();
    }
}
