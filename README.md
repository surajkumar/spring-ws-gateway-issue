This repository contains a small reproduction to the issue raised in spring-cloud-gatway. 

https://github.com/spring-cloud/spring-cloud-gateway/issues/3044

The program must be started in the following order:

1. discovery
2. websocket
3. api-gateway

By default, the gateway will bind to 8080. The websocket will bind
to port 80 and discovery is bound to port 8761. 

You can use a client such as https://www.postman.com/ to connect to the web socket.

The following examples are available:

A working version without the load balancer:

`ws://localhost:8080/websocket-good`

The failing scenario using the load balancer:

`ws://localhost:8080/websocket-bad`

