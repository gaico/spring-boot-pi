package nl.gas.pi.springbootpi.pi;

import java.util.HashMap;
import java.util.Map;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Created by Gaico on 9/22/2018.
 */
public class GpioService {

    private final GpioController gpioControler;
    private final Map<Integer, GpioPinDigitalOutput> pins;
    private GpioService gpioService;

    public GpioService(){
       this.gpioControler = GpioFactory.getInstance();
       this.pins = new HashMap<>();
        pins.put(0,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_00, "MyLED0", PinState.LOW));

       //pins.put(1,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED1", PinState.LOW));
       pins.put(2,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED2", PinState.LOW));
       pins.put(3,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_03, "MyLED3", PinState.LOW));
       pins.put(4,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLED4", PinState.LOW));
       pins.put(5,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_05, "MyLED5", PinState.LOW));

        pins.put(6,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_06, "MyLED6", PinState.LOW));
        pins.put(7,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_07, "MyLED7", PinState.LOW));
        //pins.put(8,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_08, "MyLED8", PinState.LOW));
        //pins.put(9,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_09, "MyLED9", PinState.LOW));
        pins.put(10,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_10, "MyLED10", PinState.LOW));

        pins.put(11,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_11, "MyLED11", PinState.LOW));
        pins.put(12,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_12, "MyLED12", PinState.LOW));
        pins.put(13,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_13, "MyLED13", PinState.LOW));
        pins.put(14,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_14, "MyLED14", PinState.LOW));
        pins.put(15,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_15, "MyLED15", PinState.LOW));
        pins.put(16,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_16, "MyLED16", PinState.LOW));
        pins.put(17,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_17, "MyLED17", PinState.LOW));
        //pins.put(18,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_18, "MyLED18", PinState.LOW));
        pins.put(19,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_19, "MyLED19", PinState.LOW));
        pins.put(20,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_20, "MyLED20", PinState.LOW));

        pins.put(21,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_21, "MyLED21", PinState.LOW));
        pins.put(22,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_22, "MyLED22", PinState.LOW));
        //pins.put(23,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_23, "MyLED23", PinState.LOW));
        //pins.put(24,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_24, "MyLED24", PinState.LOW));
        pins.put(25,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_25, "MyLED25", PinState.LOW));
        //pins.put(26,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_26, "MyLED26", PinState.LOW));
        pins.put(27,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_27, "MyLED27", PinState.LOW));
        pins.put(28,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_28, "MyLED28", PinState.LOW));
        pins.put(29,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_29, "MyLED29", PinState.LOW));
        //pins.put(30,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_30, "MyLED30", PinState.LOW));

        //pins.put(31,gpioControler.provisionDigitalOutputPin(RaspiPin.GPIO_31, "MyLED31", PinState.LOW));
    }

    public void toggle(int pinNumber){
        checkPin(pinNumber);
        System.out.println("Toggle pin: " + pinNumber);
        pins.get(Integer.valueOf(pinNumber)).toggle();
        System.out.println("Toggled pin: " + pinNumber);
    }

    public void high(int pinNumber) {
        checkPin(pinNumber);
        System.out.println("On pin: " + pinNumber);
        GpioPinDigitalOutput out = pins.get(Integer.valueOf(pinNumber));
        out.high();
        System.out.println("On pin done: " + pinNumber);
    }

    public void low(int pinNumber) {
        checkPin(pinNumber);
        System.out.println("Off pin: " + pinNumber);
        GpioPinDigitalOutput out = pins.get(Integer.valueOf(pinNumber));
        out.low();
        System.out.println("Off pin done: " + pinNumber);
    }

    public void checkPin(int pinNumber){
        if(!pins.containsKey(Integer.valueOf(pinNumber))){
            throw new IllegalArgumentException("Pin " + pinNumber + " not available.");
        }
    }

    public void test() throws InterruptedException {
        for(Integer i: pins.keySet()){

            high(i);
            Thread.sleep(1000);
            low(i);
        }
    }
}
