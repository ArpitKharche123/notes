package config;

import beans.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"beans","beans2"})
public class AppConfig {

    //Bean Methods
    @Bean
    /*
    Bean Scopes: defines how many beans will get created

    singleton (default): 1 bean for each bean request
    prototype : n beans for n bean requests
     */
    @Scope("prototype")
    Test getTest(){
        return new Test();
    }

}
