package com.fsse2401.Project.data.user.domain;

import com.fsse2401.Project.data.user.entity.UserEntity;

public class UserResponseData {
    private int uid;
    private String email;
    private String firebaseuid;

    public UserResponseData(UserEntity entity) {
        this.uid = entity.getUid();
        this.email = entity.getEmail(); ;
        this.firebaseuid = entity.getFirebaseUid();
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirebaseuid() {
        return firebaseuid;
    }

    public void setFirebaseuid(String firebaseuid) {
        this.firebaseuid = firebaseuid;
    }
}
