package com.shinektvnet.vod.animation;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.shinektvnet.vod.MyApplication;
import com.shinektvnet.vod.util.KtvLog;

import static com.shinektvnet.vod.MainActivity.mFragmentClickable;

/**
 * Created by hrblaoj on 2019/6/26.
 */

public class MyAnimation implements ICreateAnimation{

    public static ICreateAnimation iMyCreateAnimation = new MyAnimation();
    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter && nextAnim != 0) {
            KtvLog.d("onCreateAnimation 111 nextAnim is " + nextAnim);
            Animation anim = AnimationUtils.loadAnimation(MyApplication.getInstance().getApplicationContext(), nextAnim);
            anim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
//                    KtvLog.d("onAnimationStart");
                    mFragmentClickable = false;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    KtvLog.d("onAnimationEnd");
                    mFragmentClickable = true;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
//                    KtvLog.d("onAnimationRepeat");
                }
            });

            return anim;
        }
        else {
//            KtvLog.d("onCreateAnimation 222");
        }

        return null;
    }

    public static void setiMyCreateAnimation(ICreateAnimation i){
        iMyCreateAnimation = i;
    }
}
