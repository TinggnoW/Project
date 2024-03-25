package com.fsse2401.Project.data.user.entity;

import com.fsse2401.Project.data.user.domain.FirebaseUserData;
import jakarta.persistence.*;

@Entity
@Table(name="User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    @Column(name="FireBase_Uid",nullable = false)
    private String firebaseUid;

    @Column(name="Email",nullable = false)
    private String email;

    public UserEntity() {

    }

    public UserEntity(FirebaseUserData data) {
        this.firebaseUid = data.getFirebasedUid();
        this.email = data.getEmail();
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirebaseUid() {
        return firebaseUid;
    }

    public void setFirebaseUid(String firebaseUid) {
        this.firebaseUid = firebaseUid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
