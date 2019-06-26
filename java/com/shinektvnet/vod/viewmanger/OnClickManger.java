package com.shinektvnet.vod.viewmanger;

import android.view.View;

/**
 * Created by hrblaoj on 2019/6/20.
 */

public class OnClickManger implements ViewIterateThrough.impViewIterateThrough {
    View.OnClickListener onClickListener;
    @Override
    public void viewDo(View view) {
        if(null != view.getTag())
            view.setOnClickListener(onClickListener);
    }

    @Override
    public void viewGroupDo(View view) {
        if(null != view.getTag())
            view.setOnClickListener(onClickListener);
    }

//    public void set(View.OnClickListener o){
//        onClickListener = o;
//    }

    public OnClickManger(View.OnClickListener o){
        onClickListener = o;
    }
}
