package com.shinektvnet.vod.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.shinektvnet.vod.MyApplication;
import com.shinektvnet.vod.R;
import com.shinektvnet.vod.util.KtvLog;
import com.shinektvnet.vod.viewmanger.MyViewIterateThrough;
import com.shinektvnet.vod.viewmanger.OnClickManger;

import static com.shinektvnet.vod.MainActivity.mFragmentClickable;
import static com.shinektvnet.vod.animation.MyAnimation.iMyCreateAnimation;


public class FragmentPageSongList extends Fragment {
    Context mContext;
    View mView;
    public FragmentPageSongList() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach( context );
        mContext = context;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim){
        Animation a = null;
        if(null != (a = iMyCreateAnimation.onCreateAnimation(transit, enter, nextAnim)))
            return a;
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.gemingdiange_page_main, container, false );
        initView();
        return mView;
    }

    private void initView(){

        new MyViewIterateThrough().add(new OnClickManger(onClick)).iterate(mView);
    }

    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getTag() == null)
                return;

            KtvLog.d("FragmentPageSongList");
        }
    };

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        KtvLog.d("onHiddenChanged hidden is " + hidden);
    }
}
