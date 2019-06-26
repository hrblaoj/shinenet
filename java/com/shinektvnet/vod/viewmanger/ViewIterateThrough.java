package com.shinektvnet.vod.viewmanger;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by hrblaoj on 2019/6/20.
 */

public abstract class ViewIterateThrough {

    interface impViewIterateThrough{
        void viewDo(View view);
        void viewGroupDo(View view);
    }

    ArrayList <impViewIterateThrough> biewIterateThroughArrayList = new ArrayList<impViewIterateThrough>();
    public abstract void iterate(View view);

    public ViewIterateThrough add(impViewIterateThrough i){
        biewIterateThroughArrayList.add(i);
        return this;
    }
}
