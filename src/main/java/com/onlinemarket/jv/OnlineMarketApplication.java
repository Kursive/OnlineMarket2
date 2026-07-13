package com.onlinemarket.jv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "Api",          // ← контроллеры
        "Application",  // ← сервисы и репозитории
        "Domain"})
@EnableJpaRepositories(basePackages = "Application.Interfaces")
@EntityScan(basePackages = "Domain")

public class OnlineMarketApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(OnlineMarketApplication.class, args);
    }

}
