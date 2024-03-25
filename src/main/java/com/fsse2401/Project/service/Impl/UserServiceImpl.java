package com.fsse2401.Project.service.Impl;

import com.fsse2401.Project.data.user.domain.FirebaseUserData;
import com.fsse2401.Project.data.user.entity.UserEntity;
import com.fsse2401.Project.repository.UserRepository;
import com.fsse2401.Project.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getEntityByFirebaseUserData(FirebaseUserData firebaseUserData){
//        Optional<UserEntity>userEntityOptional=userRepository.findByFirebaseUid(firebaseUserData.getFirebasedUid());
//        if(userEntityOptional.isEmpty()){
//            UserEntity userEntity = new UserEntity(firebaseUserData);
//            return userRepository.save(userEntity);
//        }else {
//            return userEntityOptional.get();
//        }
       return userRepository.findByFirebaseUid(firebaseUserData.getFirebasedUid()).orElseGet(
               ()->userRepository.save(new UserEntity(firebaseUserData)));
    }
}
