package structure.java22.api.core.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final String AUTHORIZATION_HEADER = "Authorization";
	public static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";

	public static void main(String[] args) {
		SpringApplication.run(SwaggerConfig.class, args);
	}


	@Bean
	SecurityConfiguration security() {
		return new SecurityConfiguration("test-app-client-id", "test-app-client-secret", "test-app-realm", "test-app", "", ApiKeyVehicle.HEADER, "Authorization", "," /* scope separator */);
	}

	@Bean
	SecurityScheme apiKey() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swagger Backend").description("Spring REST API").version("0.0.1").build();
	}

}
