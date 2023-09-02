package org.example;

import io.vertx.core.Vertx;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    InitializingBean startWebSocket() {
        return () -> {
            Vertx vertx = Vertx.vertx();
            vertx.deployVerticle(new HttpServerVerticle(), res -> {
                if(res.succeeded()) {
                    System.out.println("Web socket is online");
                } else {
                    System.out.println("Web socket failed to start: " + res.cause());
                }
            });
        };
    }

}