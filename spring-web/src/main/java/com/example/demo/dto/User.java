package com.example.demo.dto;

import com.example.demo.valid.First;
import com.example.demo.valid.Second;
import lombok.Data;
import lombok.ToString;
import okhttp3.*;
import org.apache.commons.io.IOUtils;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * @author yangxvhao
 * @date 18-6-19.
 */
@Data
@ToString
public class User {
    @NotEmpty
    private String name;
    
    @NotNull(groups = First.class, message = "年龄不能为空")
    @Max(groups = Second.class, value = 100, message = "年龄最大不能超过100")
    private Integer age;
    
    @Valid
    @NotNull(groups = Second.class, message = "职业信息不能为空")
    private Job job;

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "policyNo=805112018650110001321&cinsuredName=%E7%8E%8B%E9%A3%9E&insuredCardNo=620802199105294272&comCode=65000000&confirmNo=1376");
        Request request = new Request.Builder()
                .url("http://claim.chinalife-p.com.cn/claimCarFlow/flow.do?actionType=query")
                .post(body)
                .addHeader("Cache-Control", "no-cache")
                .addHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36")
                .addHeader("Origin", "http://claim.chinalife-p.com.cn")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                .addHeader("Referer", "http://claim.chinalife-p.com.cn/claimCarFlow/flow.do")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7")
                .addHeader("Postman-Token", "d150b46b-8788-4869-b979-76be33e4c2d8")
                .build();

        try {
            Response response = client.newCall(request).execute();
            System.out.println(IOUtils.toString(response.body().byteStream(), "GBK"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
