package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.http.entity.ContentType;
import org.springframework.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

/**
 * @author yangxvhao
 * @date 18-6-28.
 */
public class HttpUtils {

    public static <T> T getModelFromRequest(HttpServletRequest request, Class<T> type) {
        /**
         * 只有Content-type是application/x-www-form-urlencoded时
         * request.getParameterMap()才有值
         * application/json要从request.getInputStream()获取
         */
        T result = null;
        if (request.getMethod().equalsIgnoreCase(HttpMethod.POST.name())) {
            if (request.getContentType().equalsIgnoreCase(ContentType.APPLICATION_FORM_URLENCODED.getMimeType())) {
                JSONObject jsonObject = new JSONObject();
                request.getParameterMap().forEach((s, strings) -> {
                    jsonObject.put(s, strings);
                });
                result = JSON.parseObject(jsonObject.toJSONString(), type);
            }
            if (request.getContentType().equalsIgnoreCase(ContentType.APPLICATION_JSON.getMimeType())) {
                String body = null;
                try {
                    body = IOUtils.toString(request.getInputStream(), request.getCharacterEncoding());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                result = JSON.parseObject(body, type);
            }
        } else if (request.getMethod().equalsIgnoreCase(HttpMethod.GET.name())) {
            result = JSON.parseObject(getRequestBody(request.getQueryString()), type);
        }
        validate(result);
        return result;
    }

    /**
     * get方法获取参数
     * @param data
     * @return
     */
    public static String getRequestBody(String data) {
        JSONObject jsonObject = new JSONObject();
        return Optional.ofNullable(data).map(s -> {
            for (String s1 : s.split("&")) {
                jsonObject.put(s1.split("=")[0], s1.split("=")[1]);
            }
            return jsonObject;
        }).get().toJSONString();
    }
    
    public static <T> void validate(T object){
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> constraintValidators  = validator.validate(object);
        constraintValidators.forEach(tConstraintViolation -> {
            tConstraintViolation.getMessage();
        });
    }
}
