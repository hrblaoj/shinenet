package com.shinektvnet.vod.fragment;

import android.support.v4.app.Fragment;

import com.shinektvnet.vod.viewmanger.ViewProduct;
import com.shinektvnet.vod.viewmanger.ViewFactory;

/**
 * Created by hrblaoj on 2019/6/20.
 */

public abstract class FragmentFactory <  T extends Fragment>{

    public  T  create(Class< T > clz) {
        Fragment fragmentProduct = null;
        try {
            fragmentProduct = (Fragment) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T) fragmentProduct;
    }

    abstract public FragmentFactory add(Class<T>  clz);
}
