package com.github.jchat.client;



import com.github.jchat.ReactorUserGrpc;
import com.github.jchat.UserCreateRequest;
import com.github.jchat.UserCreateResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.internal.JsonUtil;
import lombok.SneakyThrows;
import reactor.core.publisher.Mono;

/**
 * @author iamsinghankit
 */
public class JChatClient {
    @SneakyThrows
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9999).usePlaintext().build();

       var stub = ReactorUserGrpc.newReactorStub(channel);
        Mono<UserCreateResponse>response = stub.create(UserCreateRequest.newBuilder()
                                                                                       .setUsername("divya")
                                                                                       .setEmail("iamsinghankit@gmail.com")
                                                                                       .setMobileNo("8400244588")
                                                                                       .setName("Ankit")
                                                                                       .build());
        response.subscribe(e-> System.out.println(e.getMessage()));
        System.out.println("Client Done");
        Thread.sleep(5000);

    }
}
