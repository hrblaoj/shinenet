package com.shinektvnet.vod.viewmanger;

/**
 * Created by hrblaoj on 2019/6/19.
 */

public abstract class ViewFactory {
    public abstract <T extends ViewProduct > T create(Class<T> clz);
}
