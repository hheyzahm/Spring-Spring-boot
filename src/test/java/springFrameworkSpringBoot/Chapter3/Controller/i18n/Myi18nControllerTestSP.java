package springFrameworkSpringBoot.Chapter3.Controller.i18n;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import springFrameworkSpringBoot.Chapter3.Controller.i18N.Myi18nController;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("ES")
@SpringBootTest
class Myi18nControllerTestSP {

    @Autowired
    Myi18nController myi18nController;

    @Test
    void sayHello_i18n() {
        System.out.println(myi18nController.sayHello_i18n());
    }
}