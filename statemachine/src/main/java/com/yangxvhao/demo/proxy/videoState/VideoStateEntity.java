package com.yangxvhao.demo.proxy.videoState;

import com.yangxvhao.demo.proxy.statemachine.StateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author yangxvhao
 * @date 17-8-30
 */
@Data
@AllArgsConstructor
public class VideoStateEntity implements StateEntity {

    private Integer id;

    private Integer status;


}
