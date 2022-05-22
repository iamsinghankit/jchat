package com.github.jchat.server.user;

import com.github.jchat.*;
import com.salesforce.grpc.contrib.spring.GrpcService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import reactor.core.publisher.Mono;

/**
 * @author iamsinghankit
 */
@GrpcService
@RequiredArgsConstructor
public class UserService extends ReactorUserGrpc.UserImplBase {

    private final UserRepository userRepository;


    @Override
    public Mono<UserCreateResponse> create(Mono<UserCreateRequest> request) {
        return request.map(e -> new User(e.getUsername(), e.getName(), e.getMobileNo(), e.getEmail()))
                      .flatMap(e -> userRepository.save(e).map(e1 -> UserCreateResponse.newBuilder()
                                                                                       .setCode(ResponseCode.SUCCESS)
                                                                                       .setMessage("User created successfully")
                                                                                       .build())).onErrorResume(e -> {
                    if (e instanceof DuplicateKeyException)
                        return Mono.just(UserCreateResponse.newBuilder().setCode(ResponseCode.FAILURE)
                                                           .setMessage("Username already taken").build());
                    return Mono.just(UserCreateResponse.newBuilder().setCode(ResponseCode.FAILURE)
                                                       .setMessage(e.getMessage()).build());
                });
    }

    @Override
    public Mono<UserDeleteResponse> delete(Mono<UserDeleteRequest> request) {
        return request.flatMap(e -> userRepository.deleteByUsername(e.getUsername())
                                                  .map(e1 -> UserDeleteResponse.newBuilder()
                                                                               .setCode(ResponseCode.SUCCESS)
                                                                               .setMessage("User deleted successfully")
                                                                               .build()));
    }
}
