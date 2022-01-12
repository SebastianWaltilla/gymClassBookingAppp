package com.example.gymClassBooking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Users {

    // Ill know this class is a bit weird, but ill
    // dont know a better way to inject secrets
    // right now (and to be able to push code to github).
    // At work, we use Vault or kubernetes
    // to store secrets. Vault is really nice :)

    @Value("${user.sebastian.userName}")
    String user1;

    @Value("${user.sebastian.password}")
    String user1p;

    @Value("${user.matilda.userName}")
    String user2;

    @Value("${user.matilda.password}")
    String user2p;

    public String[] getUsers(String user){

        if (user.equals("SEBASTIAN")) {
            return new String[]{user1, user1p};
        }
        if (user.equals("MATILDA")) {
            return new String[]{user2, user2p};
        }
        return null;
    }
}
