package structure.java22.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication(scanBasePackages = {"structure.java22.api"}, exclude = {UserDetailsServiceAutoConfiguration.class})
@EnableJpaRepositories(basePackages = {"structure.java22.api"})
@EntityScan(basePackages = {"structure.java22.api"})
public class StructureJava22ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StructureJava22ApiApplication.class, args);
    }
}
