package config;

import beans.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"beans","beans2"})
public class AppConfig {
    @Bean
    /*
        singleton: only one bean will be created
        prototype: multiple beans will be created
     */
    @Scope("prototype")
    Test getTest(){
        return new Test();
    }
}
