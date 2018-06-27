package com.example.demo.annotation;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        /**
         * 只有Content-type是application/x-www-form-urlencoded时
         * request.getParameterMap()才有值
         * application/json要从request.getInputStream()获取
         */
        if (request.getMethod().equalsIgnoreCase(HttpMethod.POST.name())){
            if(request.getContentType().equalsIgnoreCase(ContentType.APPLICATION_FORM_URLENCODED.getMimeType())){
                JSONObject jsonObject = new JSONObject();
                request.getParameterMap().forEach((s, strings) -> {
                    log.info(s,strings);
                    jsonObject.put(s, strings);
                });
                return JSON.parseObject(jsonObject.toJSONString(), methodParameter.getParameterType());
            }
            if(request.getContentType().equalsIgnoreCase(ContentType.APPLICATION_JSON.getMimeType())){
                        
                String body = IOUtils.toString(request.getInputStream(), request.getCharacterEncoding());
                return JSON.parseObject(body, methodParameter.getParameterType());
            }
        }else if(request.getMethod().equalsIgnoreCase(HttpMethod.GET.name())){
            return request.getQueryString();
        }
        
        return modelAndViewContainer.getDefaultModel().get(methodParameter.getParameterName());
    }
}
