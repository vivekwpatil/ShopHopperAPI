package be.ing.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@ComponentScan
public class ShopHopperApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ShopHopperApplication.class, args);
    }

}
