package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = "com.deneme")
@EntityScan(basePackages = "com.deneme.model")
<<<<<<< HEAD
@EnableJpaRepositories(basePackages = "com.deneme.repository")
=======
@EnableJpaRepositories(basePackages = "com.deneme")
>>>>>>> 50df5cca0f15ebaaf642d658819d99b87fd7485f
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
