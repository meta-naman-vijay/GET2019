package com.metacube.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
/**
 * 
 * @author Naman
 *
 */
@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class EadSession11AssignmentApplication {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(EadSession11AssignmentApplication.class, args);
	}

}
