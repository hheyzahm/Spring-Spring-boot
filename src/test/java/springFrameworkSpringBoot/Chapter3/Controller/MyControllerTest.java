package springFrameworkSpringBoot.Chapter3.Controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyControllerTest {

    @Test
    void sayHelloFromMyController() {
        MyController myController = new MyController();

        System.out.println(myController.sayHelloFromMyController());

    }
}