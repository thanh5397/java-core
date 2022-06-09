package manageuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"manageuser"})
@EnableJpaRepositories("manageuser.repository")
public class ManageUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageUserApplication.class, args);
	}
}
