package com.francoiszhao.playing_cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources({
		@PropertySource("application.properties"),
		@PropertySource("application-local.properties")
})
@SpringBootApplication
public class PlayingCardsApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlayingCardsApplication.class, args);
	}
}
