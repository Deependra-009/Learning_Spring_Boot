package com.api.redis.models;

import lombok.*;

import java.io.Serializable;


public class User implements Serializable {

    private String userID;
    private String name;

    public String getUserID() {
        return userID;
    }

}
