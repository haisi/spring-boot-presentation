package ch.fhnw;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
    {
        status: "UP",
        random: {
            status: "ClassName"
        },
        otherIndicator: {
             status: "MethodName"
        }
    }
 */
@Component
public class RandomHealthIndicator implements HealthIndicator{

    @Bean
    public HealthIndicator otherIndicatorHealthIndicator() {
        return () -> {
            return new Random().nextBoolean() ? Health.up().build() : Health.down().status("Use method prefix as key").build();
        };
    }

    @Override
    public Health health() {
        return new Random().nextBoolean() ? Health.up().build() : Health.down().status("Use class prefix as key").build();
    }
}
