package com.yangxvhao.demo.proxy.statemachine;

import lombok.Data;

/**
 * Created by yangxvhao on 17-8-29.
 */
@Data
public class UnsupportedStateTransition extends RuntimeException {
    private StateEnum stateEnum;

    private StateEvent event;

    public UnsupportedStateTransition(StateEnum stateEnum, StateEvent event){
        super("unsupported state transition");
        this.stateEnum = stateEnum;
        this.event = event;
    }
}
