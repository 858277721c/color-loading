package com.sd.lib.cloading;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Color;

public abstract class FColorLoading implements IColorLoading
{
    private int[] mColors = new int[]{Color.parseColor("#D81B60"), Color.parseColor("#03DAC5"), Color.parseColor("#6200EE")};
    private int mColorIndex;
    private long mDuration = 1000;

    private ValueAnimator mAnimator;

    @Override
    public void setColors(int[] colors)
    {
        mColorIndex = 0;
        mColors = colors;
        invalidateView();
    }

    @Override
    public int getColorCurrent()
    {
        if (mColors == null || mColors.length <= 0)
            return 0;

        return mColors[mColorIndex];
    }

    @Override
    public void setDuration(long duration)
    {
        mDuration = duration;
        if (mAnimator != null)
            mAnimator.setDuration(duration);
    }

    @Override
    public void start()
    {
        if (mColors == null || mColors.length <= 0)
            return;

        if (!getAnimator().isStarted())
            getAnimator().start();
    }

    @Override
    public void stop()
    {
        if (mAnimator != null)
            mAnimator.cancel();
    }

    private boolean nextIndex()
    {
        if (mColors == null || mColors.length <= 0)
            return false;

        final int index = mColorIndex + 1;
        if (index >= mColors.length)
            mColorIndex = 0;
        else
            mColorIndex = index;
        return true;
    }

    private ValueAnimator getAnimator()
    {
        if (mAnimator == null)
        {
            mAnimator = new ValueAnimator();
            mAnimator.setFloatValues(0f, 1.0f);
            mAnimator.setRepeatCount(-1);
            mAnimator.setRepeatMode(ValueAnimator.RESTART);
            mAnimator.setDuration(mDuration);
            mAnimator.addListener(new AnimatorListenerAdapter()
            {
                @Override
                public void onAnimationRepeat(Animator animation)
                {
                    super.onAnimationRepeat(animation);
                    nextIndex();
                }
            });
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
                @Override
                public void onAnimationUpdate(ValueAnimator animation)
                {
                    final int color = getColorCurrent();
                    final float value = (float) animation.getAnimatedValue();
                    FColorLoading.this.onAnimationUpdate(color, value);
                }
            });
        }
        return mAnimator;
    }

    protected abstract void invalidateView();

    protected abstract void onAnimationUpdate(int color, float progress);
}
