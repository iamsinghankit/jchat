package com.github.jchat.server.user;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author iamsinghankit
 */
@Document("users")
public record User(@Indexed(unique = true) String username, String name, String mobileNo, String email) {
}
