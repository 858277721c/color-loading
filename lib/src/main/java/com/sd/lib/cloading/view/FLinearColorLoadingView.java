package com.sd.lib.cloading.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.sd.lib.cloading.FColorLoading;
import com.sd.lib.cloading.IColorLoading;

public class FLinearColorLoadingView extends View implements IColorLoading
{
    /** 横向 */
    public static final int ORIENTATION_HORIZONTAL = 0;
    /** 纵向 */
    public static final int ORIENTATION_VERTICAL = 1;

    private int mColor;
    private float mProgress;
    private int mOrientation = ORIENTATION_HORIZONTAL;

    private final Paint mPaint = new Paint();

    public FLinearColorLoadingView(Context context)
    {
        super(context);
        init();
    }

    public FLinearColorLoadingView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public FLinearColorLoadingView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init()
    {
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    private final FColorLoading mColorLoading = new FColorLoading()
    {
        @Override
        protected void invalidateView()
        {
            invalidate();
        }

        @Override
        protected void onAnimationUpdate(int color, float progress)
        {
            mColor = color;
            mProgress = progress;
            invalidate();
        }
    };

    /**
     * 设置方向
     * <p>
     * {@link #ORIENTATION_HORIZONTAL}
     * <p>
     * {@link #ORIENTATION_VERTICAL}
     *
     * @param orientation
     */
    public void setOrientation(int orientation)
    {
        mOrientation = orientation;
    }

    @Override
    public void setColors(int[] colors)
    {
        mColorLoading.setColors(colors);
    }

    @Override
    public void setDuration(long duration)
    {
        mColorLoading.setDuration(duration);
    }

    @Override
    public void start()
    {
        mColorLoading.start();
    }

    @Override
    public void stop()
    {
        mColorLoading.stop();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        final int width = getWidth();
        final int height = getHeight();
        if (mColor != 0 && width > 0 && height > 0)
        {
            mPaint.setColor(mColor);
            if (mOrientation == ORIENTATION_HORIZONTAL)
            {
                mPaint.setStrokeWidth(height);
                final int startX = (int) ((width - (width * mProgress)) / 2);
                final int stopX = width - startX;
                canvas.drawLine(startX, 0, stopX, 0, mPaint);
            } else
            {
                mPaint.setStrokeWidth(width);
                final int startY = (int) ((height - (height * mProgress)) / 2);
                final int stopY = height - startY;
                canvas.drawLine(0, startY, 0, stopY, mPaint);
            }
        }
    }

    @Override
    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        stop();
    }
}
