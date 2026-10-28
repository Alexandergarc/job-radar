package com.aegm.job_radar;

import com.aegm.job_radar.config.TelegramProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class JobRadarApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobRadarApplication.class, args);
	}
	
	@Bean
	CommandLineRunner verificarConfig(TelegramProperties props){
		return args -> {
			System.out.println("El length del token es: " + props.botToken().length());
		};
	}

}
