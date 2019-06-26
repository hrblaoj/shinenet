package com.shinektvnet.vod.page;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.shinektvnet.vod.fragment.MyFragmentManger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hrblaoj on 2019/6/21.
 */

public class PageManger {

    public PageManger(){

    }

    private static PageManger mInstance = null;

    private List<PageBuilder> aListPageInfoStack = new ArrayList<>();

    public static synchronized PageManger getInstance(){
        if(mInstance==null){
            mInstance = new PageManger();
        }
        return mInstance;
    }

    public PageBuilder build(){
        PageBuilder q = pop();
        if(null != q)
            q.hide();
        PageBuilder p = new PageBuilder();
        push(p);
        return p;
    }

    public PageBuilder build(int pageNo){
        PageBuilder q = pop();
        if(null != q)
            q.hide();
        PageBuilder p = new PageBuilder(pageNo);
        push(p);
        return p;
    }

    public int getPageNo(){
        int size = aListPageInfoStack.size();
        if(0 == size)
            return 0;
        return aListPageInfoStack.get(size - 1).pageNo;
    }

    public PageManger clear(){
        int size = aListPageInfoStack.size();
        if(0 != size) {
            PageBuilder p = aListPageInfoStack.remove(size - 1);
            p.hide();
        }
        aListPageInfoStack.clear();
        return this;
    }

    public PageBuilder push(PageBuilder p){
        aListPageInfoStack.add(p);
        return p;
    }

    public PageBuilder pop(){
        int size = aListPageInfoStack.size();
        if(0 == size)
            return null;
        PageBuilder p = aListPageInfoStack.get(size - 1 );
        return p;
    }

    public PageBuilder backPage(){
        int size = aListPageInfoStack.size();
        if(1 >= size)
            return null;
        PageBuilder p = aListPageInfoStack.remove(size - 1 );
        p.hide();
        size = aListPageInfoStack.size();
        if(0 == size)
            return null;
        p = aListPageInfoStack.get(size - 1 );
        p.show();
        return p;
    }

    public static class PageBuilder <T extends Parcelable> {
        int pageNo = -1;
        PageManger mPageManger;

        class FragmentInfo {
            Class<Fragment> f;
            Parcelable p;

            public FragmentInfo(Class<Fragment> af, Parcelable ap) {
                f = af;
                p = ap;
            }
        }

        List<FragmentInfo> alistPageBuilde = new ArrayList<>();

        public PageBuilder() {

        }

        public PageBuilder(int no) {
            pageNo = no;
        }

        public PageBuilder addFragment(Class clz, T para) {
            alistPageBuilde.add(new FragmentInfo(clz, para));
            return this;
        }

        public void show(){
            for(FragmentInfo t:alistPageBuilde){
                MyFragmentManger.getInstance(null).show(t.f, t.p);
            }
        }

        public void hide(){
            for(FragmentInfo t:alistPageBuilde){
                MyFragmentManger.getInstance(null).hide(t.f, t.p);
            }
        }


        public void setAnim(MyFragmentManger.AnimInterface i){
            MyFragmentManger.getInstance(null).setAnimInterface(i);
        }
    }
}
