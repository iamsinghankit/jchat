package com.github.jchat.server.user;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * @author iamsinghankit
 */
public interface UserRepository extends ReactiveMongoRepository<User, String> {


    Mono<Void> deleteByUsername(String username);
}
