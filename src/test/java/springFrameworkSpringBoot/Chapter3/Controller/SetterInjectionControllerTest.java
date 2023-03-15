package springFrameworkSpringBoot.Chapter3.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springFrameworkSpringBoot.Chapter3.services.GreetingServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SetterInjectionControllerTest {

    @Autowired
    SetterInjectionController setterInjectionController;
  /*  @BeforeEach
    void setUp() {
        setterInjectionController=new SetterInjectionController();
        setterInjectionController.setGreetingService(new GreetingServiceImpl());
    }
*/
    @Test
    void sayHelloFromSetterController() {
        System.out.println(setterInjectionController.sayHelloFromSetterController());
    }
}