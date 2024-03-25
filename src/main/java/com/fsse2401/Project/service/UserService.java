package com.fsse2401.Project.service;

import com.fsse2401.Project.data.user.domain.FirebaseUserData;
import com.fsse2401.Project.data.user.entity.UserEntity;
import com.fsse2401.Project.repository.UserRepository;

import java.util.Optional;

public interface UserService {
    UserEntity getEntityByFirebaseUserData (FirebaseUserData firebaseUserData);
}
