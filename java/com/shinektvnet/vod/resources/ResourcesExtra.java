package com.shinektvnet.vod.resources;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.shinektvnet.vod.MyApplication.packageNname;

/**
 * Created by hrblaoj on 2019/6/5.
 */

public class ResourcesExtra extends ResourcesManger.BaseResources {

    String apkPath;
    public ResourcesManger.BaseResources init(ResourcesManger.ResourcesPara para){
        if(null == para.resources)
            return null;
        apkPath = (String) para.apkPath;
        stringBehavior = new StringBehavior() {
            @Override
            public int stringId(String idname) {
                return 0;
            }

            @Override
            public String getString(String idname) {
                return "";
            }
        };
        AssetManager assetManager = null;
        Method addAssetPath = null;
        try {
            assetManager = AssetManager.class.newInstance();
            addAssetPath = assetManager.getClass().getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assetManager, apkPath);
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }

        resources = new Resources(assetManager, (para.resources).getDisplayMetrics(), para.resources.getConfiguration());
        if(null == resources)
        {
            return null;
        }

        return this;
    }
    public ResourcesExtra(String name){
        super(name);
    }

}
