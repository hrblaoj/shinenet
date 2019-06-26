package com.shinektvnet.vod.functionpanel;

import android.view.LayoutInflater;
import android.view.View;

import com.shinektvnet.vod.MyApplication;
import com.shinektvnet.vod.R;
import com.shinektvnet.vod.fragment.FragmentLanguage;
import com.shinektvnet.vod.fragment.FragmentPageSongList;
import com.shinektvnet.vod.page.PageManger;
import com.shinektvnet.vod.viewmanger.MyViewIterateThrough;
import com.shinektvnet.vod.viewmanger.OnClickManger;
import com.shinektvnet.vod.viewmanger.ViewProduct;

import static com.shinektvnet.vod.page.PageConstants.SELECT_PAGE_NO;

/**
 * Created by hrblaoj on 2019/6/19.
 */

public class MyFunctionpannelP extends ViewProduct {

    @Override
    public int getId() {
        return R.layout.functionpanel;
    }

    @Override
    public View getView() {

        return myView;
    }

    public MyFunctionpannelP(){
        myView = LayoutInflater.from(MyApplication.getInstance()).inflate(R.layout.functionpanel,null);
        new MyViewIterateThrough().add(new OnClickManger(onClick)).iterate(myView);
    }

    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getTag() == null)
                return;

            //if(SELECT_PAGE_NO != PageManger.getInstance().getPageNo())
                PageManger.getInstance().build().addFragment(FragmentPageSongList.class, null).show();
        }
    };
}
