package com.yangxvhao.demo.proxy.videoState;

import com.yangxvhao.demo.proxy.statemachine.State;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by yangxvhao on 17-8-30.
 */
@Slf4j
public abstract class VideoState extends State<VideoStateEnum,VideoStateEvent,VideoStateEntity> {
    protected VideoState(VideoStateEnum state) {
        super(state);
    }

    @Override
    public void run(VideoStateEntity entity, VideoStateEvent event) {
        log.info("第 {} 台电视机，状态为：{}",entity.getId(),VideoStateEnum.getNameByValue(entity.getStatus()));
    }
}
