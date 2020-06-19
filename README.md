# About
android color loading view

# Gradle
[![](https://jitpack.io/v/zj565061763/color-loading.svg)](https://jitpack.io/#zj565061763/color-loading)

# Screenshot
![](https://github.com/zj565061763/blingbutton/blob/master/screenshot/blingbutton.gif?raw=true)

# Demo
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center_horizontal"
    android:orientation="vertical"
    android:paddingTop="20dp">

    <com.sd.lib.cloading.view.FLinearColorLoadingView
        android:id="@+id/view_loading_horizontal"
        android:layout_width="match_parent"
        android:layout_height="5dp" />

</LinearLayout>
```

```java
public class MainActivity extends AppCompatActivity
{
    private FLinearColorLoadingView view_loading_horizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_loading_horizontal = findViewById(R.id.view_loading_horizontal);

        // 设置动画方向，默认横向
        view_loading_horizontal.setOrientation(FLinearColorLoadingView.ORIENTATION_HORIZONTAL);
        // 设置动画颜色数组
        view_loading_horizontal.setColors(new int[]{Color.parseColor("#D81B60"), Color.parseColor("#03DAC5"), Color.parseColor("#6200EE")});
        // 开始动画
        view_loading_horizontal.start();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        // 停止动画
        view_loading_horizontal.stop();
    }
}
```