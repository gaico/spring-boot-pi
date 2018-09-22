package nl.gas.pi.springbootpi;

import nl.gas.pi.springbootpi.pi.GpioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Gaico on 9/22/2018.
 */
@Configuration
public class SpringBootPConfig {
    @Bean
    public GpioService  gpioService(){
        return new GpioService();
    }
}
