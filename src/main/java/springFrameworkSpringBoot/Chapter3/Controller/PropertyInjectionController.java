package springFrameworkSpringBoot.Chapter3.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import springFrameworkSpringBoot.Chapter3.services.GreetingService;

/**
 * @Created 15 03 2023 - 4:26 PM
 * @Author Hazeem Hassan
 */

public class PropertyInjectionController {

    GreetingService greetingService;

    public String sayHelloFromPropertyController(){
        return "Executing from Property Injection Controller Class.\n"+greetingService.sayGreeting();
    }
}
