package com.yangxvhao.demo.proxy.videoState.state;

import com.yangxvhao.demo.proxy.statemachine.UnsupportedStateTransition;
import com.yangxvhao.demo.proxy.videoState.VideoState;
import com.yangxvhao.demo.proxy.videoState.VideoStateEntity;
import com.yangxvhao.demo.proxy.videoState.VideoStateEnum;
import com.yangxvhao.demo.proxy.videoState.VideoStateEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by yangxvhao on 17-8-30.
 */
@Slf4j
public class PlayState extends VideoState {
    public PlayState() {
        super(VideoStateEnum.PLAY);
    }

    @Override
    public VideoStateEnum next(VideoStateEntity entity, VideoStateEvent event) throws UnsupportedStateTransition {
        add(VideoStateEvent.PAUSE,VideoStateEnum.PAUSE);
        add(VideoStateEvent.STOP,VideoStateEnum.STOP);
        add(VideoStateEvent.RESET_PLAY,VideoStateEnum.PLAY);
        return super.next(entity, event);
    }


}
