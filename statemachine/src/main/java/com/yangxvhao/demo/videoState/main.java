package com.yangxvhao.demo.videoState;

import com.yangxvhao.demo.statemachine.UnsupportedStateTransition;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by yangxvhao on 17-8-30.
 */
@Slf4j
public class main {
    public static void main(String[] args) {
        VideoStateEntity firstVideo = new VideoStateEntity(1,1);
        VideoStateEntity secondVideo = new VideoStateEntity(2,1);
        VideoStateMachine machine = new VideoStateMachine();
        try {
            machine.doWork(firstVideo,VideoStateEvent.PAUSE);
            machine.doWork(secondVideo,VideoStateEvent.RESET_PLAY);
            machine.doWork(secondVideo,VideoStateEvent.PAUSE);
            machine.doWork(firstVideo,VideoStateEvent.PLAYING);
            machine.doWork(firstVideo,VideoStateEvent.STOP);
            machine.doWork(firstVideo,VideoStateEvent.PAUSE);
        }catch (UnsupportedStateTransition e){
            log.error("不支持的状态改变。");
        }

    }
}
