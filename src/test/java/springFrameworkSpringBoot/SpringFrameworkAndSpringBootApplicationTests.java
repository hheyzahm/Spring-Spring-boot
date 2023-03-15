package springFrameworkSpringBoot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import springFrameworkSpringBoot.Chapter3.Controller.MyController;

@SpringBootTest
class SpringFrameworkAndSpringBootApplicationTests {
    //chapter 3 start
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    MyController myController;

    @Test
    void testAutowiredMyController() {
        System.out.println(myController.sayHelloFromMyController());
    }

    @Test
    void getControllerFromCTX() {
        MyController myController = applicationContext.getBean(MyController.class);
        System.out.println("From @Test\ngetControllerFromCTX");
        System.out.println(myController.sayHelloFromMyController());
    }

    //chapter 3 end
    @Test
    void contextLoads() {
    }

}
