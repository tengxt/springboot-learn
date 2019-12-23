package com.tengxt.community.provider;

import com.alibaba.fastjson.JSON;
import com.tengxt.community.dto.AccessTokenDTO;
import com.tengxt.community.dto.GithubUserDTO;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {

    /**
     * 获取 access_token
     * @param accessTokenDTO
     * @return
     */
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        // RequestBody.create(请求的参数数据，请求的类型)
        RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO), mediaType);
        // Post to a Server
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            // access_token=56cd8e8ded8b037ca917bfca2bd53476c4d4950d&scope=user&token_type=bearer
            String result = response.body().string();
            if(null != result && !"".equals(result)){
                String access_token = result.split("&")[0].split("=")[1];
                return access_token;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取用户的信息
     * @param access_token
     * @return
     */
    public GithubUserDTO getUser(String access_token){
        OkHttpClient client = new OkHttpClient();
        if(null != access_token && !"".equals(access_token)){
            // Get a URL
            Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token=" + access_token)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String result = response.body().string();
                GithubUserDTO userDTO = JSON.parseObject(result, GithubUserDTO.class);
                return userDTO;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
