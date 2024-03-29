package com.yangxvhao.demo.proxy.videoState.state;

import com.yangxvhao.demo.proxy.statemachine.UnsupportedStateTransition;
import com.yangxvhao.demo.proxy.videoState.VideoState;
import com.yangxvhao.demo.proxy.videoState.VideoStateEntity;
import com.yangxvhao.demo.proxy.videoState.VideoStateEnum;
import com.yangxvhao.demo.proxy.videoState.VideoStateEvent;

/**
 * Created by yangxvhao on 17-8-30.
 */
public class StopState extends VideoState {
    public StopState() {
        super(VideoStateEnum.STOP);
    }

    @Override
    public VideoStateEnum next(VideoStateEntity entity, VideoStateEvent event) throws UnsupportedStateTransition {
        add(VideoStateEvent.PLAYING,VideoStateEnum.PLAY);
        return super.next(entity, event);
    }
}
