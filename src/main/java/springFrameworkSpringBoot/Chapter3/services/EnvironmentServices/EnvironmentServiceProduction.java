package springFrameworkSpringBoot.Chapter3.services.EnvironmentServices;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @Created 16 03 2023 - 12:01 PM
 * @Author Hazeem Hassan
 */
@Profile("prod")
@Service
public class EnvironmentServiceProduction implements EnvironmentService{
    @Override
    public String getEnv() {
        return "prod";
    }
}
