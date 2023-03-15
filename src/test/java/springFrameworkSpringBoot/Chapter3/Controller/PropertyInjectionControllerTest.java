package springFrameworkSpringBoot.Chapter3.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springFrameworkSpringBoot.Chapter3.services.GreetingServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PropertyInjectionControllerTest {


    @Autowired
    PropertyInjectionController propertyInjectionController;
    /*@BeforeEach
    void setUp() {
        propertyInjectionController=new PropertyInjectionController();
        propertyInjectionController.greetingService=new GreetingServiceImpl();
    }
*/
    @Test
    void sayHelloFromPropertyController() {
        System.out.println(propertyInjectionController.sayHelloFromPropertyController());
    }
}