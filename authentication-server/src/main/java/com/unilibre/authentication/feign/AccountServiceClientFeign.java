package com.unilibre.authentication.feign;


import java.beans.Encoder;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unilibre.authentication.model.User;

import feign.Headers;
import feign.form.spring.SpringFormEncoder;

@FeignClient(name = "ACCOUNT-SERVICE")


public interface AccountServiceClientFeign {

    @PostMapping(value = "/account-service", consumes = {"application/json"} )
    User login(@RequestBody Map<String, Object> payload);

    class Configuration {
        @Bean
        SpringFormEncoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {
            return new SpringFormEncoder(new SpringEncoder(converters));
        }
    }
}