package com.shinektvnet.vod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.shinektvnet.vod.fragment.FragmentFactory;
import com.shinektvnet.vod.fragment.FragmentLanguage;
import com.shinektvnet.vod.fragment.FragmentPageSongList;
import com.shinektvnet.vod.fragment.MyFragmentManger;
import com.shinektvnet.vod.page.PageManger;
import com.shinektvnet.vod.viewmanger.ViewProduct;
import com.shinektvnet.vod.functionpanel.MyFunctionpannelF;
import com.shinektvnet.vod.resources.ResourcesManger;

import me.jessyan.autosize.utils.LogUtils;

import static android.view.KeyEvent.KEYCODE_BACK;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    //test1

    private ViewProduct functionpanelProduct = null;
   // private FragmentFactory fragmentManger = null;
    public PageManger mPageManger = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ResourcesManger.getInstance();
        //ResourcesManger.getInstance().makeExtraResources("com.shinektv.vod.resource", "/sdcard/resource-debug.apk");
        functionpanelProduct = new MyFunctionpannelF().create(null);
        setContentView(functionpanelProduct.getView());
        FragmentFactory fragmentManger = MyFragmentManger.getInstance(this.getSupportFragmentManager());
        fragmentManger
                .add(FragmentLanguage.class)
                .add(FragmentPageSongList.class)
        ;

        mPageManger = PageManger.getInstance();
//        mPageManger.build().addFragment(FragmentLanguage.class, null).addFragment(FragmentPageSongList.class, null).show();
        mPageManger.build().addFragment(FragmentLanguage.class, null).show();



    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        LogUtils.d("event is " + event);
        if(KEYCODE_BACK == event.getKeyCode())
            PageManger.getInstance().backPage();
        //return super.onKeyDown(keyCode, event);
        return true;
    }

    public static boolean mFragmentClickable = true;

    /* 防止fragment动画抖动 */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event){
        if (!mFragmentClickable) {
            return true;
        }
        return super.dispatchTouchEvent(event);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
