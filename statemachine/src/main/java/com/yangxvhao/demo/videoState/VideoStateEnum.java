package com.yangxvhao.demo.videoState;

import com.yangxvhao.demo.statemachine.StateEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by yangxvhao on 17-8-30.
 */
@AllArgsConstructor
public enum VideoStateEnum implements StateEnum {
    PLAY(1,"播放"),
    PAUSE(2,"暂停"),
    STOP(3,"停止"),
    OTHER(9999,"其他")
    ,;

    @Getter
    private int value;

    @Getter
    private String name;


    public static VideoStateEnum getNameByValue(int value){
        for(VideoStateEnum videoStateEnum : values()){
            if(videoStateEnum.getValue() == value){
                return videoStateEnum;
            }
        }
        return OTHER;
    }
}
