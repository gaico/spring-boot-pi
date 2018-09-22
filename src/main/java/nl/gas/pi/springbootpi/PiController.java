package nl.gas.pi.springbootpi;

import nl.gas.pi.springbootpi.pi.GpioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Gaico on 9/22/2018.
 */
@RestController
public class PiController {

    private final GpioService gpioService;

    public PiController(final GpioService gpioService){
        this.gpioService = gpioService;
    }

    @PutMapping(path="/light/{id}/toggle")
    public void toggleLight(@PathVariable int id){
        System.out.println("Light toggle: " + id );
        this.gpioService.toggle(id);
    }

    @PutMapping(path="/light/{id}/off")
    public void offLight(@PathVariable int id){
        System.out.println("Light off: " + id );
        this.gpioService.low(id);
    }

    @PutMapping(path="/light/{id}/on")
    public void onLight(@PathVariable int id){
        System.out.println("Light on: " + id );
        this.gpioService.high(id);
    }

    @GetMapping(path="/light/test")
    public void test() throws InterruptedException {
        System.out.println("Light test");
        this.gpioService.test();
    }

}
