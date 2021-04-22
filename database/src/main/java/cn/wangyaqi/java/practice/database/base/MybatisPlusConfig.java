package cn.wangyaqi.java.practice.database.base;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {

    //配置MetaObjectHandler
    @Bean
    public ThMetaObjectHandler thMetaObjectHandler() {
        return new ThMetaObjectHandler();
    }
}