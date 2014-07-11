package pl.semacom.payments.config;

import javax.annotation.PostConstruct;

/**
 * Created by Krzysztof on 2014-07-08.
 */

@org.springframework.context.annotation.Configuration
public class Configuration {

    @PostConstruct
    public void init(){
        System.out.println("XXXXXXXXXXXXXXXXXXXXXX WORKS!");
    }

}
