package com.shinektvnet.vod.functionpanel;

/**
 * Created by hrblaoj on 2019/6/19.
 */

public class MyFunctionpannelF implements FunctionpanelFactory {
    @Override
    public FunctionpanelProduct create() {

        return new MyFunctionpannelP();
    }
}
