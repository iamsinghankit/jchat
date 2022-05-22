package com.github.jchat.server;

import com.github.jchat.server.user.UserRepository;
import com.github.jchat.server.user.UserService;
import com.salesforce.grpc.contrib.spring.GrpcServerHost;
import io.grpc.BindableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Demonstrates building a gRPC streaming server using Reactor, Reactive-Grpc, grpc-spring, and Spring Boot.
 */
@SpringBootApplication
@Slf4j
public class JChatServer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(JChatServer.class, args);
        Thread.currentThread().join();
    }


    @Bean(initMethod = "start")
    public GrpcServerHost grpcServerHost(@Value("${port}") int port) {
        log.info("Listening for gRPC on port " + port);
        return new GrpcServerHost(port);
    }

    @Bean
    public BindableService hello(UserRepository repo) {
        return new UserService(repo);
    }


}
