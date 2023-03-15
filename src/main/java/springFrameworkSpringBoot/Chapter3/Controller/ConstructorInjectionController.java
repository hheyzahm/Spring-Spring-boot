package springFrameworkSpringBoot.Chapter3.Controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import springFrameworkSpringBoot.Chapter3.services.GreetingService;

/**
 * @Created 15 03 2023 - 4:42 PM
 * @Author Hazeem Hassan
 */

public class ConstructorInjectionController {
    private final GreetingService greetingService;


    public ConstructorInjectionController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHelloFromConstructorController(){
        return "Executing from Constructor Injection Controller Class.\n"+greetingService.sayGreeting();
    }
}
