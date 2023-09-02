package org.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServer;

public class HttpServerVerticle extends AbstractVerticle {

    @Override
    public void start(Promise promise) {
        HttpServer server = vertx.createHttpServer();

        server.webSocketHandler(socket -> {

            System.out.println("Incoming connection on web socket");

            socket.closeHandler(handler -> System.out.println("Connection closed"));

            socket.handler(buffer -> System.out.println("Server received data over web socket"));

        });

        server.listen(80, res -> {
            if (res.succeeded()) {
                promise.complete();
            } else {
                promise.fail(res.cause());
            }
        });
    }
}