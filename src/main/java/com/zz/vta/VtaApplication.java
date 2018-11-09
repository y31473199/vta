package com.zz.vta;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.zz.vta.front.entity.ProductEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * springboot 应用
 */
@SpringBootApplication
public class VtaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VtaApplication.class, args);
    }

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 创建fastjson对象
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        FastJsonConfig confg = new FastJsonConfig();
        // 设置是否需要格式化
        confg.setSerializerFeatures(SerializerFeature.PrettyFormat);
        converter.setFastJsonConfig(confg);
        return new HttpMessageConverters(converter);
    }


}
