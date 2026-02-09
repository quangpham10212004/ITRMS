package com.robin.itrms.config;

import java.time.LocalDateTime;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.robin.itrms.entity.User;
import com.robin.itrms.repository.UserRepository;

@Configuration
public class DataInitializer {
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(DataInitializer.class);
	@Bean
    CommandLineRunner initUser(UserRepository userRepo) {
        return args -> {
            User u1 = new User(
                "quang",
                "123456",
                "quang@gmail.com",
                "0123456789",
                LocalDateTime.of(2004, 10, 21, 0, 0),
                "MEMBER",
                "ACTIVE"
            );
            User u2 = new User(
                    "admin",
                    "123456",
                    "admin@gmail.com",
                    "0123456879",
                    LocalDateTime.of(2004, 10, 21, 0, 0),
                    "ADMIN",
                    "ACTIVE"
                );

            log.info("Preloading:..."+userRepo.save(u1));;
            log.info("Preloading:..."+userRepo.save(u2));;

        };
    }
}
