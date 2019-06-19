package com.shinektvnet.vod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shinektvnet.vod.functionpanel.FunctionpanelFactory;
import com.shinektvnet.vod.functionpanel.FunctionpanelProduct;
import com.shinektvnet.vod.functionpanel.MyFunctionpannelF;
import com.shinektvnet.vod.resources.ResourcesManger;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private FunctionpanelProduct functionpanel = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ResourcesManger.getInstance();
        //ResourcesManger.getInstance().makeExtraResources("com.shinektv.vod.resource", "/sdcard/resource-debug.apk");
        functionpanel = new MyFunctionpannelF().create();
        setContentView(functionpanel.getView());

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
