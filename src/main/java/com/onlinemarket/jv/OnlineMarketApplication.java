package com.onlinemarket.jv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "Api",          // ← контроллеры
        "Application",  // ← сервисы и репозитории
        "Domain"})

public class OnlineMarketApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(OnlineMarketApplication.class, args);
    }

}
