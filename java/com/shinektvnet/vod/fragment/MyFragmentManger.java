package com.shinektvnet.vod.fragment;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.shinektvnet.vod.R;


import java.util.HashMap;
import java.util.Map;

import static com.shinektvnet.vod.MainActivity.mFragmentClickable;


/**
 * Created by hrblaoj on 2019/6/20.
 */

public class MyFragmentManger extends FragmentFactory {
    private FragmentManager fragmentManager;
    static private Map<Class, Fragment> mapFragment = new HashMap<Class, Fragment>();

    public MyFragmentManger(FragmentManager f) {
        super();
        fragmentManager = f;
    }

    public interface AnimInterface{
        void onAnim(FragmentTransaction f);
    }

    /* 没想好怎么封 */
//    AnimInterface animInterface = new AnimInterface() {
//        @Override
//        public void onAnim(FragmentTransaction f) {
//            f.setCustomAnimations( R.anim.slide_in_bottom, R.anim.slide_out_top, R.anim.slide_in_top, R.anim.slide_out_bottom );
//        }
//    };

    AnimInterface animInterface = null;

    @Override
    public  FragmentFactory add(Class clz){
        Fragment fragment = null;
        fragment = super.create(clz);
        mapFragment.put(clz, fragment);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentLeft_container_rl, fragment);
        fragmentTransaction.hide(fragment);
        fragmentTransaction.commitNow();
        return  this;
    }

    public void setAnimInterface(AnimInterface i){
        animInterface = i;
    }

    public  FragmentFactory show(Class clz, Parcelable p){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.setCustomAnimations( R.anim.slide_in_bottom, R.anim.slide_out_top, R.anim.slide_in_top, R.anim.slide_out_bottom );
        //fragmentTransaction.setCustomAnimations( R.anim.slide_in_top, 0);
        if(null != animInterface) {
            animInterface.onAnim(fragmentTransaction);
        }
        else {
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_top, 0);
        }
        fragmentTransaction.show(mapFragment.get(clz));
        fragmentTransaction.commitNow();
        return this;
    }

    public  FragmentFactory hide(Class clz, Parcelable p){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.setCustomAnimations( R.anim.slide_in_bottom, R.anim.slide_out_top, R.anim.slide_in_top, R.anim.slide_out_bottom );
        //fragmentTransaction.setCustomAnimations( R.anim.slide_in_top, 0);
        if(null != animInterface) {
            animInterface.onAnim(fragmentTransaction);
        }
        else {
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_top, 0);
        }
        fragmentTransaction.hide(mapFragment.get(clz));
        fragmentTransaction.commitNow();
        return this;
    }

    private static MyFragmentManger mInstance = null;

    public static synchronized MyFragmentManger getInstance(FragmentManager f){
        if(null == f && null == mInstance)
            return null;
        if(mInstance==null){
            mInstance = new MyFragmentManger(f);
        }
        return mInstance;
    }
}
