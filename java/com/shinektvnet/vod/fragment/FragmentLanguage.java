package com.shinektvnet.vod.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shinektvnet.vod.MyApplication;
import com.shinektvnet.vod.R;

/**
 * Created by hrblaoj on 2019/6/21.
 */


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.shinektvnet.vod.R;
import com.shinektvnet.vod.page.PageManger;
import com.shinektvnet.vod.util.KtvLog;
import com.shinektvnet.vod.viewmanger.MyViewIterateThrough;
import com.shinektvnet.vod.viewmanger.OnClickManger;

import me.jessyan.autosize.utils.LogUtils;

import static com.shinektvnet.vod.MainActivity.mFragmentClickable;
import static com.shinektvnet.vod.page.PageConstants.SELECT_PAGE_NO;

/**
     * 主页
     *
     * @author Administrator
     */

public class FragmentLanguage extends Fragment {

    protected Context mContext;
    View mView;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(mView == null){

            LogUtils.d("onCreateView " + this);
            mView = inflater.inflate(R.layout.fragment_page_lang, container, false);
            mContext = getActivity();

            initView();


        }
        return mView;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim){
//        KtvLog.d("onCreateAnimation");
        if (enter && nextAnim != 0) {
//            KtvLog.d("onCreateAnimation 111 nextAnim is " + nextAnim);
            Animation anim = AnimationUtils.loadAnimation( mContext, nextAnim);
            anim.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
//                    KtvLog.d("onAnimationStart");
                    mFragmentClickable = false;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    // 转场动画结束时，允许Touch事件
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
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    /** 初始化view */
    private void initView(){

        new MyViewIterateThrough().add(new OnClickManger(onClick)).iterate(mView);
    }

    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getTag() == null)
                return;

            KtvLog.d("FragmentLanguageFragmentLanguage");
        }
    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}


