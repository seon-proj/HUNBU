package io.hunsu.hunbu;

import org.jooq.conf.Settings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HunbuApplication {

	public static void main(String[] args) {
		SpringApplication.run(HunbuApplication.class, args);
	}

	@Bean
	public Settings settings () {
		return new Settings().withRenderFormatted(true);
	}
}
