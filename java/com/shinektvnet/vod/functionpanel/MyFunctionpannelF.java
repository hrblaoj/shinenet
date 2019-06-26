package com.shinektvnet.vod.functionpanel;

import com.shinektvnet.vod.viewmanger.ViewFactory;
import com.shinektvnet.vod.viewmanger.ViewProduct;

/**
 * Created by hrblaoj on 2019/6/19.
 */

public class MyFunctionpannelF extends ViewFactory {
    @Override
    public <T extends ViewProduct> T create(Class<T> clz) {
        return (T) new MyFunctionpannelP();
    }
}
