package com.gmou.api.handler;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by admin on 2017/5/12.
 */
@Component
public class FeignClientErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder delegate = new Default();


    // TODO
    @Override
    public Exception decode(String s, Response response) {
        try {

//            if(response.status() > 500) {
//
//            } else if (response.status() > 400) {
//
//            }

            return new RuntimeException(getStringFromInput(response));
        } catch (IOException e) {
            throw new RuntimeException("读取 response body 失败");
        }
    }

    public static String getStringFromInput(Response response) throws IOException{
        return IOUtils.toString(response.body().asInputStream(), "utf-8");
    }
}
