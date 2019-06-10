package com.shinektvnet.vod.resources;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.shinektvnet.vod.MyApplication;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import static com.shinektvnet.vod.MyApplication.packageNname;

/**
 * Created by hrblaoj on 2019/5/31.
 */

public class ResourcesManger {
    private Context extraContext = null;
    private BaseResources mResources = null;
    private BaseResources extraResources = null;
    private Context mContext = null;
    private static ResourcesManger mInstance = null;



    public static synchronized ResourcesManger getInstance(){
        if(mInstance==null){
            mInstance = new ResourcesManger();
        }
        return mInstance;
    }

    public ResourcesManger() {
        mContext = MyApplication.getInstance().getApplicationContext();
        mResources = BaseResources.resourcesFactory("common", packageNname, null);
    }



    public void makeExtraResources(String packetname, String apkpath){
        ResourcesPara p = new ResourcesPara(packetname, apkpath, mResources.getResources());
        extraResources = BaseResources.resourcesFactory("extra", packetname, p);
    }

    public String getString(String idname){
//        if(null == extraResources){
//            return mResources.getString(idname);
//        }
//        else {
//            return extraResources.getString(idname);
//        }
        return mResources.getString(idname);
    }

    public Drawable getDrawable(String idname){
        if(null == extraResources){
            return mResources.getDrawable(idname);
        }
        else {
            return extraResources.getDrawable(idname);
        }
    }

    public class ResourcesPara{
        Resources resources;
        String packctName;
        String apkPath;
        public ResourcesPara(String p, String a, Resources r){
            packctName = p;
            apkPath = a;
            resources = r;
        }
    }

    public  static abstract class BaseResources{
        Resources resources;
        String packctName;
        StringBehavior stringBehavior;

        public interface StringBehavior{
            int stringId(String idname);
            String getString(String idname);
        }

        public HashMap<String, String> mStringCache = new HashMap<String,String>();
        public HashMap<String, View> mViewCache = new HashMap<String,View>();
        public HashMap<String, Integer> mIntegerCache = new HashMap<String,Integer>();
        public HashMap<String, Drawable> mDrawableCache = new HashMap<String,Drawable>();
        public HashMap<String, Integer> mColorCache = new HashMap<String,Integer>();
        public HashMap<String, Integer> mIdCache = new HashMap<String,Integer>();
        public HashMap<String, Integer> mConfigCache = new HashMap<String,Integer>();
        public HashMap<String, Integer> mLayoutIdCache = new HashMap<String,Integer>();
        public HashMap<String, Integer> mColorIdCache = new HashMap<String,Integer>();
        public HashMap<String, Integer> mDrawableIdCache = new HashMap<String,Integer>();
        public HashMap<String, Integer> mStringIdCache = new HashMap<String,Integer>();

        public int stringId(String idname){
            return stringBehavior.stringId(idname);
        }

        public String getString(String idname) {
            return stringBehavior.getString(idname);
        }

        public BaseResources(String packctname){
            packctName = packctname;
        }

        public Resources getResources(){
            return resources;
        }

        abstract BaseResources init(ResourcesPara para);

        public static BaseResources resourcesFactory(String type, String packctName, ResourcesPara para){
            if(type.equals("common")){
                return new ResourcesCommon(packctName).init(para);
            }
            else if(type.equals("extra")){
                return new ResourcesExtra(packctName).init(para);
            }
            else {
                return null;
            }
        }

        public int drawableId(String name){
            if(this.mDrawableIdCache.containsKey(name)) {
                return mDrawableIdCache.get(name);
            } else {
                int ret = resources.getIdentifier(name, "drawable", packctName);
                if(ret != 0) {
                    mDrawableIdCache.put(name, ret);
                }
                return ret;
            }
        }

        public Drawable getDrawable(String name) {
            if(this.mDrawableCache.containsKey(name)) {
                return mDrawableCache.get(name);
            } else {
                if(drawableId(name)==0){
                    return null;
                }
                Drawable ret = resources.getDrawable(drawableId(name));
                mDrawableCache.put(name, ret);
                return ret;
            }
        }
    }
}
