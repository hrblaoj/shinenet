package com.shinektvnet.vod.viewmanger;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hrblaoj on 2019/6/20.
 */

public class MyViewIterateThrough extends ViewIterateThrough {
    @Override
    public void iterate(View view)
    {
        if (view instanceof ViewGroup) {
            for(impViewIterateThrough t: biewIterateThroughArrayList){
                t.viewGroupDo(view);
            }
            int childCount = ((ViewGroup) view).getChildCount();
            for (int i = 0; i < childCount; i++) {
                iterate(((ViewGroup) view).getChildAt(i));
            }
        }
        else {
            for(impViewIterateThrough t: biewIterateThroughArrayList){
                t.viewDo(view);
            }
        }
    }
}
