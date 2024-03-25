package com.fsse2401.Project.data.user.dto;

import com.fsse2401.Project.data.user.domain.UserResponseData;
import com.fsse2401.Project.data.user.entity.UserEntity;

public class UserResponseDto {
    private int uid;
    private String email;
    private String firebaseuid;

    public UserResponseDto(UserResponseData data) {
        this.uid = data.getUid();
        this.email = data.getEmail(); ;
        this.firebaseuid = data.getFirebaseuid();
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
