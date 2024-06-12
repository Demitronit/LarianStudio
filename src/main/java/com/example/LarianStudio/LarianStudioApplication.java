package com.example.LarianStudio;

import com.example.LarianStudio.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LarianStudioApplication {
	public static ApplicationContext context;
	public static User currentUser = null;

	public static void main(String[] args) {
		SpringApplication.run(LarianStudioApplication.class, args);
	}

}
