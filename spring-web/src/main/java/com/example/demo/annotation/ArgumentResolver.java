package com.example.demo.annotation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.util.HttpUtils;
import jodd.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.protocol.HTTP;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 自定义参数解析器
 * supportsParameter方法确定是否解析
 * resolveArgument方法来按照需要进行解析参数
 * @author yangxvhao
 * @date 18-6-22.
 */
@Slf4j
public class ArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
//        return Arrays.stream(methodParameter.getParameterAnnotations()).anyMatch(annotation -> annotation.annotationType().equals(ParamA.class));
        return methodParameter.getParameterAnnotation(ParamA.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        
        return HttpUtils.getModelFromRequest(nativeWebRequest.getNativeRequest(HttpServletRequest.class), methodParameter.getParameterType());
    }
    
}
