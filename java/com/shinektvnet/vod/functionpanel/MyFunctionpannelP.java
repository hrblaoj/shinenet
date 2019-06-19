package com.shinektvnet.vod.functionpanel;

import android.view.LayoutInflater;
import android.view.View;

import com.shinektvnet.vod.MyApplication;
import com.shinektvnet.vod.R;

/**
 * Created by hrblaoj on 2019/6/19.
 */

public class MyFunctionpannelP extends FunctionpanelProduct{

    @Override
    public int getId() {
        return R.layout.functionpanel;
    }

    @Override
    public View getView() {

        myView = LayoutInflater.from(MyApplication.getInstance()).inflate(R.layout.functionpanel,null);
        return myView;
    }

    public MyFunctionpannelP(){

    }
}
