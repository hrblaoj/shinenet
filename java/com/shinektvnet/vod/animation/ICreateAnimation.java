package com.shinektvnet.vod.animation;

import android.view.animation.Animation;

/**
 * Created by hrblaoj on 2019/6/26.
 */

public interface ICreateAnimation {
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim);
}
