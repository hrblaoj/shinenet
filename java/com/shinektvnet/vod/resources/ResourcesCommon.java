package com.shinektvnet.vod.resources;

import com.shinektvnet.vod.MyApplication;

import static com.shinektvnet.vod.MyApplication.packageNname;

/**
 * Created by hrblaoj on 2019/6/5.
 */

public class ResourcesCommon extends ResourcesManger.BaseResources {
    @Override
    public ResourcesManger.BaseResources init(ResourcesManger.ResourcesPara para){
        resources = MyApplication.getInstance().getResources();
        stringBehavior = new StringBehavior() {
            @Override
            public int stringId(String idname) {
                if (idname == null)
                    return 0;
                if (mStringIdCache.containsKey(idname)) {
                    return mStringIdCache.get(idname);
                } else {
                    int ret = resources.getIdentifier(idname, "string", packctName);
                    if (ret != 0) {
                        mStringIdCache.put(idname, ret);
                    }
                    return ret;

                }
            }

            @Override
            public String getString(String idname) {
                if (idname == null)
                    return "";
                if (idname.equals("")) return "";
                if (mStringCache.containsKey(idname)) {
                    return mStringCache.get(idname);
                } else {
                    int stringid = stringId(idname);
                    if (stringid <= 0) return "";
                    String ret = resources.getString(stringid);
                    mStringCache.put(idname, ret);
                    return ret;
                }
            }
        };

        return this;
    }
    public ResourcesCommon(String packagename) {
        super(packageNname);

    }
}
