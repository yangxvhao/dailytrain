package com.yangxvhao.demo.statemachine;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangxvhao on 17-8-29.
 */

/**
 * 状态操作
 * @param <S>
 * @param <E>
 * @param <O>
 */
public abstract class State<S extends StateEnum,E extends StateEvent,O extends StateEntity> {
    /**
     * 状态
     */
    @Getter
    private final S state;

    private final ThreadLocal<Map<StateEvent,S>> eventStateEnumMap = new ThreadLocal<>();

    protected State(S state){
        this.state = state;
    }

    /**
     * 状态转移(出)
     * @param entity 状态拥有者
     * @param event 转移到当前状态时,发生的事件
     * @return
     * @throws UnsupportedStateTransition
     */
    public S next(O entity, E event) throws UnsupportedStateTransition {
        try {
            if (getEventStateEnumMap() != null && getEventStateEnumMap().containsKey(event)) {
                return getEventStateEnumMap().get(event);
            }
            throw new UnsupportedStateTransition(state, event);
        }finally {
            eventStateEnumMap.remove();
        }
    }

    /**
     * 状态进入(入)
     * @param entity 状态拥有者
     * @param event 转移到当前状态时,发生的事件
     */
    public abstract void run(O entity, E event);

    /**
     * 添加事件发生时,下一个状态
     * @param event 事件
     * @param state 状态
     */
    protected void add(StateEvent event,S state){
        if (getEventStateEnumMap() == null){
            eventStateEnumMap.set(new HashMap<>());
        }
        getEventStateEnumMap().put(event,state);
    }

    private Map<StateEvent,S> getEventStateEnumMap(){
        return eventStateEnumMap.get();
    }
}

