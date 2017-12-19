package com.yangxvhao.demo.videoState;

import com.yangxvhao.demo.statemachine.StateEvent;

/**
 * Created by yangxvhao on 17-8-30.
 */
public enum  VideoStateEvent implements StateEvent {

    /**
     * 播放
     */
    PLAYING,

    /**
     * 暂停
     */
    PAUSE,

    /**
     * 停止
     */
    STOP,

    /**
     * 重新播放
     */
    RESET_PLAY


}
