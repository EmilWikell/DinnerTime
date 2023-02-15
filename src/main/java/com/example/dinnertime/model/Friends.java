package com.example.dinnertime.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Friends {
    private long user_id;
    private long friend_id;

    public long getUser_id() {
        return user_id;
    }

    public long getFriend_id() {
        return friend_id;
    }
}