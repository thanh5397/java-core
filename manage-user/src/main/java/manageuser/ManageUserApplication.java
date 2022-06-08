package manageuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import manageuser.utils.MessageSource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ManageUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageUserApplication.class, args);
	}
}
