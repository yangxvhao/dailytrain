package com.yangxvhao.demo.videoState;

import com.yangxvhao.demo.statemachine.State;
import com.yangxvhao.demo.statemachine.StateMachine;
import com.yangxvhao.demo.utils.ClassUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangxvhao on 17-8-30.
 */
public class VideoStateMachine extends StateMachine<VideoStateEnum,VideoStateEvent,VideoStateEntity> {
    @Override
    protected List<State<VideoStateEnum, VideoStateEvent, VideoStateEntity>> initState() {
        List<Class<?>> stateList = new ArrayList<>();
        List<State<VideoStateEnum, VideoStateEvent, VideoStateEntity>> states = new ArrayList<>();
        try {
            stateList = ClassUtil.getAllAssignedClass(VideoState.class);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        stateList.forEach(state -> {
            try {
                State state1 = state.asSubclass(VideoState.class).newInstance();
                states.add(state1);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return states;
    }
}
