package com.yangxvhao.demo.statemachine;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangxvhao on 17-8-30.
 */
@Slf4j
public abstract class StateMachine<S extends StateEnum,E extends StateEvent,O extends StateEntity> {

    private Map<Integer,State<S,E,O>> stateMap;

    public O doWork(O entity,E event){
        /**
         * 1：得到现在状态类
         */
        State state = getStateByValue(entity.getStatus());

        /**
         * 2:更改状态
         */
        S nextState = (S) state.next(entity,event);

        if(nextState != null){
            entity.setStatus(nextState.getValue());

            /**
             * 3:执行操作
             */
            getStateByValue(nextState.getValue()).run(entity,event);
        }

        return entity;
    }

    protected abstract List<State<S,E,O>> initState();

    private State getStateByValue(Integer status) {
        try {
            if(stateMap == null) {
                synchronized (StateMachine.class) {
                    if (stateMap == null) {
                        stateMap = new HashMap<>();
                        List<State<S, E, O>> states = initState();
                        states.forEach(seoState -> {
                            stateMap.put(seoState.getState().getValue(), seoState);
                        });
                    }
                }
            }
        }catch (Exception e){
            log.error("状态初始化出错！");
        }
        return stateMap.get(status);
    }

}
