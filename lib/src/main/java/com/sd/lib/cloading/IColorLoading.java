package com.sd.lib.cloading;

public interface IColorLoading
{
    /**
     * 设置颜色数组
     *
     * @param colors
     */
    void setColors(int[] colors);

    /**
     * 设置动画时长，默认1000毫秒
     *
     * @param duration
     */
    void setDuration(long duration);

    /**
     * 开始动画
     */
    void start();

    /**
     * 停止动画
     */
    void stop();
}
