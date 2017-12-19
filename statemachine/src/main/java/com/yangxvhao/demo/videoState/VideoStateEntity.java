package com.yangxvhao.demo.videoState;

import com.yangxvhao.demo.statemachine.StateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by yangxvhao on 17-8-30.
 */
@Data
@AllArgsConstructor
public class VideoStateEntity implements StateEntity {

    private Integer id;

    private Integer status;


}
